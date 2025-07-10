package com.keresman.model;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Arrays;

public class ArticleTransferable implements Transferable {

  public static final DataFlavor ARTICLE_FLAVOUR = new DataFlavor(Article.class, "Article");
  private static final DataFlavor[] SUPPORTED_FLAVORS = {ARTICLE_FLAVOUR};

  private final Article article;

  public ArticleTransferable(Article article) {
    this.article = article;
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
      return article;
    }

    throw new UnsupportedFlavorException(flavor);
  }
}
