package com.keresman.dal.sql;

import com.keresman.mapper.CommentRowMapper;
import com.keresman.mapper.RowMapper;
import com.keresman.model.Comment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import com.keresman.dal.CommentRepository;

public class SQLCommentRepository implements CommentRepository {

    private static final String COMMENT_ID = "CommentId";
    private static final String TITLE = "Title";
    private static final String CONTENT = "Content";
    private static final String USER_ID = "UserId";
    private static final String GAME_ID = "GameId";

    private static final String INSERT_COMMENT = "{ CALL uspInsertComment(?, ?, ?, ?, ?) }";
    private static final String SELECT_BY_GAME_ID = "{ CALL uspSelectCommentsByGameId(?) }";

    private final RowMapper<Comment> commentRowMapper = new CommentRowMapper();

    @Override
    public int save(Comment comment, int userId, int gameId) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(INSERT_COMMENT)) {

            stmt.setString(TITLE, comment.getTitle());
            stmt.setString(CONTENT, comment.getContent());
            stmt.setInt(USER_ID, userId);
            stmt.setInt(GAME_ID, gameId);
            stmt.registerOutParameter(COMMENT_ID, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(COMMENT_ID);
        }
    }

    @Override
    public List<Comment> findByGameId(int gameId) throws Exception {
        List<Comment> comments = new ArrayList<>();
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(SELECT_BY_GAME_ID)) {

            stmt.setInt(GAME_ID, gameId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    comments.add(commentRowMapper.map(rs));
                }
            }
        }
        return comments;
    }

    @Override
    public void deleteAll() throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall("{ CALL uspDeleteAllComments }")) {
            stmt.executeUpdate();
        }
    }

}
