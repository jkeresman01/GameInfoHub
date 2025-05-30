package com.keresman.dao.sql;

import com.keresman.dao.UserRepository;
import com.keresman.model.Role;
import com.keresman.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class SQLUserRepository implements UserRepository {

    private static final String USER_ID = "UserID";
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String PASSWORD_HASH = "PasswordHash";
    private static final String USERNAME = "Username";
    private static final String ROLE_NAME = "RoleName";
    private static final String EMAIL = "Email";
    private static final String CREATED_AT = "CreatedAt";
    private static final String UPDATED_AT = "UpdatedAt";

    private static final String CREATE_USER = "{ CALL uspCreateUser (?,?,?,?,?,?) }";
    private static final String SELECT_USER_WITH_USERNAME = "{ CALL uspSelectUserWithUsername (?) }";

    @Override
    public int createUser(User user) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_USER)) {

            stmt.setString(USERNAME, user.getUsername());
            stmt.setString(FIRST_NAME, user.getFirstName());
            stmt.setString(LAST_NAME, user.getLastName());
            stmt.setString(PASSWORD_HASH, user.getPasswordHash());
            stmt.setString(EMAIL, user.getEmail());
            stmt.registerOutParameter(USER_ID, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(USER_ID);
        }
    }

    @Override
    public void updateUserWithID(int id, User data) throws Exception {

    }

    @Override
    public void deleteUserWithId(int id) throws Exception {

    }

    @Override
    public Optional<User> selectUserWithId(int id) throws Exception {
        return Optional.empty();
    }

    @Override
    public Optional<User> selectUserWithUsername(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_USER_WITH_USERNAME)) {

            stmt.setString(USERNAME, username);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    User user = new User(
                            rs.getInt(USER_ID),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD_HASH),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME),
                            rs.getString(EMAIL),
                            Role.fromString(rs.getString(ROLE_NAME)),
                            rs.getTimestamp(CREATED_AT).toLocalDateTime(),
                            rs.getTimestamp(UPDATED_AT).toLocalDateTime()
                    );
                    return Optional.of(user);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<User> selectUsers() throws Exception {
        return List.of();
    }

    @Override
    public boolean existsUserWithUsername(String username) throws Exception {
        return username.equals("jk");
    }

    @Override
    public boolean existsUserWithEmail(String email) throws Exception {
        return false;
    }

}
