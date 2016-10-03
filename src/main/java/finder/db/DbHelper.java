package finder.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHelper {
    private static DataSource dataSource;

    public static final String DATA_SOURCE_NAME = "java:/comp/env/jdbc/postgres";

    public static DataSource getDataSource() throws NamingException {
        if (dataSource == null) {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup(DATA_SOURCE_NAME);

        }
        return dataSource;
    }

    public static ResultSet executeQuery(String query) throws NamingException, SQLException {
        DataSource dataSource = getDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public static int executeUpdate(String query) throws NamingException, SQLException {
        DataSource dataSource = getDataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }


}
