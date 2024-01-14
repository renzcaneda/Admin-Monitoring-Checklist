/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package General;
import java.sql.*;

/**
 *
 * @author jetro
 */
public class ConnectionProvider {
    
       private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
       private String dbConnectionURL = "jdbc:mysql://localhost:3306/attendance";
       private String dbUsername = "root";
       private String dbPassword = "";
        
    
    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public String getDbConnectionURL() {
        return dbConnectionURL;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }
   
    
}