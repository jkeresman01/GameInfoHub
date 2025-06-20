package com.keresman.model;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ArticlePublishedDateAdapter extends XmlAdapter<String, LocalDate>{

    @Override
    public LocalDate unmarshal(String text) throws Exception {
        return LocalDate.parse(text, Article.DATE_FORMATTER);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return localDate.format(Article.DATE_FORMATTER);
    }

    
}
