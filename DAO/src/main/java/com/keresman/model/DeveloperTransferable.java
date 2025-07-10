package com.keresman.model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Arrays;

public class DeveloperTransferable implements Transferable {

  public static final DataFlavor DEVELOPER_FLAVOUR = new DataFlavor(Developer.class, "Developer");
  private static final DataFlavor[] SUPPORTED_FLAVORS = {DEVELOPER_FLAVOUR};

  private final Developer developer;

  public DeveloperTransferable(Developer developer) {
    this.developer = developer;
  }

  @Override
  public DataFlavor[] getTransferDataFlavors() {
    return SUPPORTED_FLAVORS;
  }

  @Override
  public boolean isDataFlavorSupported(DataFlavor flavor) {
    return Arrays.stream(SUPPORTED_FLAVORS).anyMatch(f -> f.equals(flavor));
  }

  @Override
  public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
    if (isDataFlavorSupported(flavor)) {
      return developer;
    }

    throw new UnsupportedFlavorException(flavor);
  }
}
