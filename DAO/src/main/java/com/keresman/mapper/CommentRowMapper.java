package com.keresman.mapper;

import com.keresman.model.Comment;
import java.sql.ResultSet;

public class CommentRowMapper implements RowMapper<Comment> {

    @Override
    public Comment map(ResultSet rs) throws Exception {
        return new Comment(
                rs.getInt("Id"),
                rs.getString("Title"),
                rs.getString("Content")
        );
    }
}
