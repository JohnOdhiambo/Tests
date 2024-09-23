import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLPreparedStatementExample {
    public static void main(String[] args) {
        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/testdatabase";
        String dbUser = "root";
        String dbPassword = "password";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establishing the connection
            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // SQL query with placeholders for parameters
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

            // Create the prepared statement
            preparedStatement = connection.prepareStatement(sql);

            // Set the parameters in the query (index starts from 1)
            preparedStatement.setString(1, "john_doe");  // First parameter
            preparedStatement.setString(2, "secure_password");  // Second parameter

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("Username: " + resultSet.getString("username"));
                System.out.println("Email: " + resultSet.getString("email"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
