package ra.bt_jsbc.service;

import ra.bt_jsbc.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements ICategoryService{

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private String jdbcURL = "jdbc:mysql://localhost:3306/adminkit";

    private String jdbcUsername = "root";

    private String jdbcPassword = "Extratuz123";

    private static final String INSERT_USERS_SQL = "INSERT INTO user" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from user where id =?";
    private static final String SELECT_ALL_USERS = "select * from user";
    private static final String DELETE_USERS_SQL = "delete from user where id = ?;";
    private static final String UPDATE_USERS_SQL = "update user set name = ?,email= ?, country =? where id = ?;";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public void insertCategory(Category category) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (
                Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)
        ) {
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getDescripttion());
            preparedStatement.setDate(3, new java.sql.Date(category.getCreatedDate().getTime()));
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Category selectCategory(int id) {
        return null;
    }

    @Override
    public List<Category> selectAllCategory() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Category> category = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (
                Connection connection = getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
        ) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String descripttion = rs.getString("descripttion");
//                String createdDate = rs.getDate("");
                Date createdDate =rs.getDate("createdDate");
                category.add(new Category(id, name, descripttion, createdDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
    }

    @Override
    public boolean deleteCategory(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCategory(Category category) throws SQLException {
        return false;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
