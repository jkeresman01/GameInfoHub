package com.keresman.utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public final class IconUtils {

  private IconUtils() {
    // Suppresses default constructor, ensuring non-instantiability.
  }

  public static ImageIcon createIcon(File file, int width, int height) throws IOException {
    BufferedImage bufferedImage = ImageIO.read(file);
    Image image = bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    return new ImageIcon(image);
  }
}
