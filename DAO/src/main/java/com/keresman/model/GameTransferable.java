package com.keresman.model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Arrays;

public class GameTransferable implements Transferable {

  public static final DataFlavor GAME_FLAVOUR = new DataFlavor(Game.class, "Game");
  private static final DataFlavor[] SUPPORTED_FLAVORS = {GAME_FLAVOUR};

  private final Game game;

  public GameTransferable(Game game) {
    this.game = game;
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
      return game;
    }

    throw new UnsupportedFlavorException(flavor);
  }
}
