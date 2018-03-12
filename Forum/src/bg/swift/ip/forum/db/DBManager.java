package bg.swift.ip.forum.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager implements AutoCloseable {

    static String URL = "jdbc:mysql://localhost:3306/forum?useSSL=false";
    static String USERNAME = "root";
    static String PASSWORD = "597505";





    Connection conn = null;


    public Connection getConnection() throws SQLException {

        return open();
    }

    public Connection open() throws SQLException {
        if (conn == null) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return conn;
    }


    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
            conn = null;
        }
    }
}


