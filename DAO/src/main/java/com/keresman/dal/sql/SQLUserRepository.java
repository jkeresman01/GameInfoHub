package com.keresman.dal.sql;

import com.keresman.dal.UserRepository;
import com.keresman.mapper.UserRowMapper;
import com.keresman.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class SQLUserRepository implements UserRepository {

    private static final String USER_ID = "UserID";
    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String PASSWORD_HASH = "PasswordHash";
    private static final String USERNAME = "Username";
    private static final String EMAIL = "Email";
    private static final String GENDER = "Gender";
    private static final String PICTURE_PATH = "PicturePath";

    private static final String EXISTS = "Exists";

    private static final String CREATE_USER = "{ CALL uspCreateUser (?,?,?,?,?,?,?,?) }";
    private static final String UPDATE_USER = "{ CALL uspUpdateUserWithId (?,?,?,?,?,?,?) }";
    private static final String DELETE_USER = "{ CALL uspDeleteUserWithId (?) }";
    private static final String SELECT_USER_BY_ID = "{ CALL uspSelectUserWithId (?) }";
    private static final String SELECT_USER_BY_USERNAME = "{ CALL uspSelectUserWithUsername (?) }";
    private static final String SELECT_ALL_USERS = "{ CALL uspSelectAllUsers }";
    private static final String EXISTS_BY_USERNAME = "{ CALL uspExistsUserWithUsername (?, ?) }";
    private static final String EXISTS_BY_EMAIL = "{ CALL uspExistsUserWithEmail (?, ?) }";
    private static final String ACTIVATE_USER_BY_ID = "{ CALL uspActivateProfileForUserWithId(?) }";
    private static final String DEACTIVATE_USER_BY_ID = "{ CALL uspDeactivateProfileForUserWithId(?) }";
    private static final String DELETE_ALL = "{ CALL uspDeleteAllUsers }";

    private final UserRowMapper userRowMapper = new UserRowMapper();

    @Override
    public int save(User user) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_USER)) {

            stmt.setString(USERNAME, user.getUsername());
            stmt.setString(FIRST_NAME, user.getFirstName());
            stmt.setString(LAST_NAME, user.getLastName());
            stmt.setString(PASSWORD_HASH, user.getPasswordHash());
            stmt.setString(EMAIL, user.getEmail());
            stmt.setString(PICTURE_PATH, user.getPicturePath());
            stmt.setString(GENDER, user.getGender());
            stmt.registerOutParameter(USER_ID, Types.INTEGER);

            stmt.executeUpdate();
            return stmt.getInt(USER_ID);
        }
    }

    @Override
    public void updateById(int id, User user) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_USER)) {
            stmt.setInt(USER_ID, id);
            stmt.setString(USERNAME, user.getUsername());
            stmt.setString(FIRST_NAME, user.getFirstName());
            stmt.setString(LAST_NAME, user.getLastName());
            stmt.setString(PASSWORD_HASH, user.getPasswordHash());
            stmt.setString(PICTURE_PATH, user.getPicturePath());
            stmt.setString(EMAIL, user.getEmail());
            stmt.setString(PICTURE_PATH, user.getPicturePath());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteById(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_USER)) {
            stmt.setInt(USER_ID, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Optional<User> findById(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_USER_BY_ID)) {
            stmt.setInt(USER_ID, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(userRowMapper.map(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_USER_BY_USERNAME)) {

            stmt.setString(USERNAME, username);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(userRowMapper.map(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() throws Exception {
        List<User> users = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_ALL_USERS); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(userRowMapper.map(rs));
            }
        }

        return users;
    }

    @Override
    public boolean existsByUsername(String username) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(EXISTS_BY_USERNAME)) {

            stmt.setString(USERNAME, username);
            stmt.registerOutParameter(EXISTS, Types.BIT);

            stmt.execute();
            return stmt.getBoolean(EXISTS);
        }
    }

    @Override
    public boolean existsByEmail(String email) throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();

        try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(EXISTS_BY_EMAIL)) {

            stmt.setString(EMAIL, email);
            stmt.registerOutParameter(EXISTS, Types.BIT);

            stmt.execute();
            return stmt.getBoolean(EXISTS);
        }
    }

    @Override
    public void activateById(int id) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(ACTIVATE_USER_BY_ID)) {

            stmt.setInt(USER_ID, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void deactivateById(int id) throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(DEACTIVATE_USER_BY_ID)) {

            stmt.setInt(USER_ID, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteAll() throws Exception {
        try (Connection con = DataSourceSingleton.getInstance().getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL)) {
            stmt.executeUpdate();
        }
    }

}
