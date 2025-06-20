package com.keresman.service;

import com.keresman.dal.ArticleRepository;
import com.keresman.model.Article;
import com.keresman.validator.Result;
import java.util.List;

public class ArticleService {

    private final ArticleRepository articleRepository;
    
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Result<List<Article>> getAllArticles() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
