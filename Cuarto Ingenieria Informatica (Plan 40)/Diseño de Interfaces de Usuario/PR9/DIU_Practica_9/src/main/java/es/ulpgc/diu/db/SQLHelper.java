/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.diu.db;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import org.apache.ibatis.jdbc.ScriptRunner;

/**
 *
 * @author Usuario
 */

public class SQLHelper {
    
    public String driver = "com.mysql.cj.jdbc.Driver";
    public String port = "3306";
    
    public String localUsername = "root";
    public String localPassword = "aeiou12345";
    public String localDatabase = "PRUEBA";
    public String localHostname = "localhost";
    public String localUrl = "jdbc:mysql://" + localHostname + ":" + port + "/" + localDatabase + "?useSSL=true";
    
    public String username = "estudiante-DIU";
    public String password = "Diu_2021_22";
    public String database = "DIU_BD";
    public String hostname = "i7-lab5.dis.ulpgc.es";
    public String url = "jdbc:mysql://" + localHostname + ":" + port + "/" + localDatabase + "?useSSL=true";
    
    public Connection conectToLocalDatabase() throws SQLException, ClassNotFoundException{
        Class.forName(driver);
        Connection connectionToDB = DriverManager.getConnection(localUrl, localUsername, localPassword);
        return connectionToDB;
    }
    
    public void getTablesFromLocalDatabase() throws SQLException, ClassNotFoundException{
        Connection connectionToDB = this.conectToLocalDatabase();
        DatabaseMetaData md = connectionToDB.getMetaData();
        String[] types = {"TABLE"};
        ResultSet rs = md.getTables(null, null, "%", types);
        while (rs.next()) {
            String nombreTabla = rs.getString("TABLE_NAME");
            System.out.println("Tabla: " + nombreTabla);
            ResultSet rs2 = md.getColumns(null, null, nombreTabla, null);
            while (rs2.next()) {
            String nombreCampo = rs2.getString("COLUMN_NAME");
            System.out.println(" Campo: " + nombreCampo);
            }
        }
        connectionToDB.close();
    }

    public Connection conectToLocalDatabase(String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection connectionToDB = DriverManager.getConnection(localUrl, user, password);
        return connectionToDB;
    }

    public Connection conectToLocalFileDatabase(String user, String password) throws ClassNotFoundException, SQLException, FileNotFoundException {
        Class.forName(driver);
        Connection connectionToDB = DriverManager.getConnection(localUrl, user, password);
        ScriptRunner scriptRunner = new ScriptRunner(connectionToDB);
        ClassLoader classLoader = getClass().getClassLoader();
        Reader sqlReader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("pruebaDB.sql"), StandardCharsets.UTF_8));
        scriptRunner.runScript(sqlReader);
        return connectionToDB;
    }
    
    public Connection conectToRemoteDatabase(String user, String password) throws SQLException, ClassNotFoundException{
        Class.forName(driver);
        Connection connectionToDB = DriverManager.getConnection(url, username, password);
        return connectionToDB;
    }
    
    public static ArrayList<Object> queryTablesData(Connection connection, String tableName) {
        ArrayList<Object> results = new ArrayList<>();
        String query = "SELECT COLUMN_NAME " +
                "FROM INFORMATION_SCHEMA.COLUMNS " +
                "WHERE TABLE_SCHEMA='PRUEBA' " +
                "AND TABLE_NAME='"+ tableName +"' ;";
        try (Statement stmt = connection.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String field = rs.getString("COLUMN_NAME");
                results.add(field);
            }
        } catch (SQLException e) {
        }
        return results;
    }

    public ArrayList<Object> launchQuery(Connection connection, String query) {
        ArrayList<Object> results = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String tableName = rs.getString("Tables_in_PRUEBA");
                results.add(tableName);
            }
        } catch (SQLException e) {
            
        }
        return results;
    }
}
