package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static String URL = "jdbc:mysql://localhost:3306/banco_union";
    private static String USER = "campus2023";
    private static String PASSWORD = "campus2023";

    private static Connection connection;

    private DBconnection (){}
    // REQ: PATRONES DE DISEÑO
    public static Connection getConnection() throws SQLException {
        if (connection ==  null || connection.isClosed()){
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection succesfully");
        }
        return connection;
    }
}
