package databaseconnection;

import com.sun.deploy.security.SelectableSecurityManager;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class DatabaseConnect {

    String username = "postgres";
    String password = "123";

    public String getUrl1() {
        String url;
        Scanner sc = new Scanner(System.in);
        url = "jdbc:postgresql://localhost:5432/dvdrental";
        return url;
    }
    public String getUrl2() {
        String url;
        Scanner sc = new Scanner(System.in);
        url = "jdbc:postgresql://localhost:5432/practice";
        return url;
    }

    Statement statement;

    public DatabaseConnect() throws IOException {
    }

    public Connection connectDB () throws SQLException {
        String url1=getUrl1();
        String url2=getUrl2();

        Connection connection = DriverManager.getConnection(url1, username, password);
        Connection connection2 = DriverManager.getConnection(url2, username, password);
        return connection;
    }

    public ResultSet executeSelectQuery(String query) throws IOException, SQLException {
        Statement statement = connectDB().createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public void processResultSet(String query, String col1, String col2, String col3) throws IOException, SQLException {
        ResultSet resultSet = executeSelectQuery(query);

        while(resultSet.next()) {
            System.out.println(resultSet.getString(col1) + "            " +resultSet.getString(col2) + "            "
                    +  resultSet.getString(col3));
        }
    }
}


