package com.keresman.mapper;

import com.keresman.model.Article;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ArticleRowMapper implements RowMapper<Article>{

    @Override
    public Article map(ResultSet rs) throws Exception {
        return new Article(
            rs.getInt("ArticleId"),
            rs.getString("Title"),
            rs.getString("Link"),
            rs.getString("Description"),
            toLocalDateTime(rs.getTimestamp("PublishedDateTime")),
            rs.getString("PicturePath")
        );
    }

    private LocalDateTime toLocalDateTime(Timestamp ts) {
        return ts != null ? ts.toLocalDateTime(): null;
    }       
}
