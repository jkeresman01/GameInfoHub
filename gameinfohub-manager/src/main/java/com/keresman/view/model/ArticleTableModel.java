package com.keresman.view.model;

import com.keresman.model.Article;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ArticleTableModel extends AbstractTableModel {

  private static final String[] COLUMS = {"Id", "Title", "Link", "Published date", "Picture Path"};

  private List<Article> articles;

  public ArticleTableModel(List<Article> articles) {
    setArticles(articles);
  }

  @Override
  public int getRowCount() {
    return articles.size();
  }

  @Override
  public int getColumnCount() {
    return COLUMS.length;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    Article article = articles.get(rowIndex);

    return switch (columnIndex) {
      case 0 -> article.getArticleId();
      case 1 -> article.getTitle();
      case 2 -> article.getLink();
      case 3 -> article.getPublishedDateTime();
      case 4 -> article.getPicturePath();
      default -> null;
    };
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
    fireTableDataChanged();
  }

  @Override
  public String getColumnName(int column) {
    return COLUMS[column];
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    if (columnIndex == 0) {
      return Integer.class;
    }

    return super.getColumnClass(columnIndex);
  }
}
