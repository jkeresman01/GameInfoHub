package com.keresman.utilities;

import com.keresman.factory.URLConnectionFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public final class FileUtils {

  private static final String UPLOAD = "Upload";
  private static final String SAVE = "Save";
  private static final String TEXT_DOCUMENTS = "Text documents (*.txt)";
  private static final String TXT = "txt";
  private static final String DOT = ".";

  private FileUtils() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  public static Optional<File> uploadFile(String description, String... extensions) {
    JFileChooser chooser = createFileChooser(description, extensions, UPLOAD);
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      File selectedFile = chooser.getSelectedFile();
      return isExtensionAllowed(selectedFile, extensions)
          ? Optional.of(selectedFile)
          : Optional.empty();
    }
    return Optional.empty();
  }

  public static Optional<String> loadTextFromFile() throws IOException {
    JFileChooser chooser = createFileChooser(TEXT_DOCUMENTS, TXT, UPLOAD);
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      return Optional.of(new String(Files.readAllBytes(chooser.getSelectedFile().toPath())));
    }
    return Optional.empty();
  }

  public static Optional<File> saveTextInFile(String text, Optional<File> optFile)
      throws IOException {
    Optional<File> fileToSave = optFile.isPresent() ? optFile : chooseSaveFile();
    if (fileToSave.isPresent()) {
      Files.write(fileToSave.get().toPath(), text.getBytes());
    }
    return fileToSave;
  }

  public static void copy(String source, String destination) throws IOException {
    createDirHierarchy(destination);
    Files.copy(Paths.get(source), Paths.get(destination));
  }

  public static void copyFromUrl(String sourceUrl, String destination) throws IOException {
    createDirHierarchy(destination);
    HttpURLConnection connection = URLConnectionFactory.getHttpUrlConnection(sourceUrl);
    try (InputStream inputStream = connection.getInputStream()) {
      Files.copy(inputStream, Paths.get(destination));
    }
  }

  public static boolean filenameHasExtension(String filename, int length) {
    int dotIndex = filename.lastIndexOf(DOT);
    return dotIndex != -1 && filename.substring(dotIndex + 1).length() == length;
  }

  private static JFileChooser createFileChooser(
      String description, String extension, String title) {
    return createFileChooser(description, new String[] {extension}, title);
  }

  private static JFileChooser createFileChooser(
      String description, String[] extensions, String title) {
    JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    chooser.setFileFilter(new FileNameExtensionFilter(description, extensions));
    chooser.setDialogTitle(title);
    chooser.setApproveButtonText(title);
    chooser.setApproveButtonToolTipText(title);
    return chooser;
  }

  private static boolean isExtensionAllowed(File file, String[] extensions) {
    String name = file.getName();
    int dotIndex = name.lastIndexOf(DOT);
    if (dotIndex == -1) {
      return false;
    }
    String ext = name.substring(dotIndex + 1).toLowerCase();
    return Arrays.asList(extensions).contains(ext);
  }

  private static void createDirHierarchy(String destination) throws IOException {
    String dirPath = destination.substring(0, destination.lastIndexOf(File.separator));
    if (!Files.exists(Paths.get(dirPath))) {
      Files.createDirectories(Paths.get(dirPath));
    }
  }

  private static Optional<File> chooseSaveFile() {
    JFileChooser chooser = createFileChooser(TEXT_DOCUMENTS, TXT, SAVE);
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      File selectedFile = chooser.getSelectedFile();
      if (!selectedFile.toString().endsWith(DOT + TXT)) {
        selectedFile = new File(selectedFile + DOT + TXT);
      }
      return Optional.of(selectedFile);
    }
    return Optional.empty();
  }
}
