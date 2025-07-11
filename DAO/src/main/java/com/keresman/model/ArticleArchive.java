package com.keresman.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "articlearchive")
@XmlAccessorType(XmlAccessType.FIELD)
public final class ArticleArchive {

  @XmlElementWrapper
  @XmlElement(name = "article")
  private List<Article> articles;

  public ArticleArchive() {}

  public ArticleArchive(List<Article> articles) {
    this.articles = articles;
  }

  public List<Article> getArticles() {
    return new ArrayList<>(this.articles);
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
  }
}
