package user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/basetest";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "1111";
    private Connection connection = null;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        if (connection == null) {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        }
        return connection;
    }

    public List<User> executeQuery(String sql) {
        List<User> userList = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = mapObject(resultSet);
                userList.add(user);
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public int executeUpdate(String sql, User user) {
        int row = 0;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getName());
            statement.setLong(3, user.getAge());
            statement.setString(4, String.valueOf(user.getRole()));
            statement.setString(5, user.getPassword());
            row = statement.executeUpdate();
            System.out.println(row + " - count row affected");
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public User mapObject(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setLogin(resultSet.getString("LOGIN"));
        user.setName(resultSet.getString("NAME"));
        user.setAge(resultSet.getInt("AGE"));
        user.setRole(UserRole.valueOf(resultSet.getString("ROLE")));
        user.setPassword(resultSet.getString("PASSWORD"));
        return user;
    }
}
