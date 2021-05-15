package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {
    
    private String user = "postgres";
    private String password = "1234";
    
    public Connection getConnection() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aps?useTimezone=true&serverTimezone=America/Sao_Paulo", user, password);
        return con;
    }    
}
