/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.helpers;

import es.ulpgc.gs1.model.data.RegisterData;
import es.ulpgc.gs1.model.data.RegisterDataAdv;
import es.ulpgc.gs1.model.data.RegisterDataAlojamiento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class SQLHelper {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String PORT = "3306";
    private static final String DATABASE = "directus";
    private static Connection CONNECTION;
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "aeiou12345";
    //private static final String PASSWORD = "directus";
    private static final String HOSTNAME = "localhost";
    private static final String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE + "?useSSL=true";
    
    public static boolean conectToLocalDatabase() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        Connection connectionToDB = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        CONNECTION = connectionToDB;
        return (CONNECTION != null);
    }
    
    public static boolean disconnect() throws SQLException{
        CONNECTION.close();
        CONNECTION = null;
        return (CONNECTION == null);
    }
    
    public static boolean registerNewAlojamiento(RegisterDataAlojamiento registerDataAlojamiento){
        String query = "INSERT INTO renting_adv (rooms, avaliable_surface, duration, adv_id , landlord_id)"
                + " VALUES ("
                + "'" + registerDataAlojamiento.getRooms() +"', "
                + "'" + registerDataAlojamiento.getAvailable_surface() +"', "
                + "'" + registerDataAlojamiento.getDuration() +"', "
                + "'" + registerDataAlojamiento.getAdv_id() +"', "
                + "'" + registerDataAlojamiento.getLandlord_id() +"');";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static ArrayList<Object> getAllAlojamientosFromDatabase( ){
        ArrayList<Object> resultsFromQuery = new ArrayList<>();
        String query = "SELECT title FROM adv,renting_adv " +
                        "WHERE renting_adv.adv_id = adv.id" +
                        ";";
        try (Statement statement = CONNECTION.createStatement()) {
        ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                resultsFromQuery.add(title);
                
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }
    
    public static ArrayList<Object> getMyAlojamientosFromDatabase( String id ){
        ArrayList<Object> resultsFromQuery = new ArrayList<>();
        String query = "SELECT title FROM adv " +
                        "JOIN renting_adv " +
                        "ON adv.id=renting_adv.adv_id " +
                        "JOIN landlord " +
                        "ON renting_adv.landlord_id=landlord.id " +
                        "WHERE landlord.user_id='"+ id +"';";
        try (Statement statement = CONNECTION.createStatement()) {
        ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                resultsFromQuery.add(title);
                
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }
    
    public static ArrayList<Object> GetDataFromAlojamiento(String title) {
        ArrayList<Object> resultsFromQuery = new ArrayList<>();
        String query = "SELECT title, adv.id, rooms, avaliable_surface, duration, description, price, city, street FROM adv " +
                        "JOIN renting_adv ON renting_adv.adv_id = adv.id " +
                        "WHERE adv.title = '" + title + "';";
        try (Statement statement = CONNECTION.createStatement()) {
        ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultsFromQuery.add(resultSet.getString("title"));
                resultsFromQuery.add(resultSet.getString("id"));
                resultsFromQuery.add(resultSet.getString("rooms"));
                resultsFromQuery.add(resultSet.getString("avaliable_surface"));
                resultsFromQuery.add(resultSet.getString("duration"));
                resultsFromQuery.add(resultSet.getString("description"));
                resultsFromQuery.add(resultSet.getString("price"));
                resultsFromQuery.add(resultSet.getString("city"));
                resultsFromQuery.add(resultSet.getString("street"));
                break;
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }
    
    public static ArrayList<Object> getMyAdvFromDatabase( String id ){
        ArrayList<Object> resultsFromQuery = new ArrayList<>();
        String query = "SELECT title FROM adv " +
                        "JOIN renting_adv " +
                        "ON adv.id=renting_adv.adv_id " +
                        "JOIN landlord " +
                        "ON renting_adv.landlord_id=landlord.id " +
                        "WHERE landlord.user_id='"+ id +"';";
        try (Statement statement = CONNECTION.createStatement()) {
        ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                resultsFromQuery.add(title);
                
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }
    
    public static ArrayList<Object> getMyEventsFromDatabase( String id ){
        ArrayList<Object> resultsFromQuery = new ArrayList<>();
        String query = "SELECT title FROM adv " +
                        "JOIN university_adv " +
                        "ON adv.id=university_adv.adv_id " +
                        "JOIN uau " +
                        "ON university_adv.uau_id=uau.id " +
                        "WHERE uau.user_id='"+ id +"';";
        try (Statement statement = CONNECTION.createStatement()) {
        ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                resultsFromQuery.add(title);
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }
    
    public static ArrayList<Object> getAllAdvFromDatabase(){
        ArrayList<Object> resultsFromQuery = new ArrayList<>();
        String query = "SELECT title FROM adv ;";
        try (Statement statement = CONNECTION.createStatement()) {
        ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                resultsFromQuery.add(title);
                
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }
    
    public static ArrayList<Object> getDataFromAdv(String title){
        ArrayList<Object> resultsFromQuery = new ArrayList<>();
        String query = "SELECT title, street, city, price, id FROM adv " +
                        "WHERE title = '" + title + "';";
        try (Statement statement = CONNECTION.createStatement()) {
        ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultsFromQuery.add(resultSet.getString("title"));
                resultsFromQuery.add(resultSet.getString("street"));
                resultsFromQuery.add(resultSet.getString("city"));
                resultsFromQuery.add(resultSet.getString("price"));
                resultsFromQuery.add(resultSet.getString("id"));
                break;
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }
    
    public static boolean registerNewAdv(RegisterDataAdv registerDataAdv){
        String query = "INSERT INTO adv (title, description, street, city, price)"
                + " VALUES ("
                + "'" + registerDataAdv.getTitle() +"', "
                + "'" + registerDataAdv.getDescription() +"', "
                + "'" + registerDataAdv.getStreet() +"', "
                + "'" + registerDataAdv.getDestinarion() +"', "
                + "'" + registerDataAdv.getPrice() +"');";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static boolean editAdv(RegisterDataAdv registerDataAdv, String id ){
        String query = "UPDATE adv "
                + " SET "
                + "title='" + registerDataAdv.getTitle() +"', "
                + "description='" + registerDataAdv.getDescription() +"', "
                + "street='" + registerDataAdv.getStreet() +"', "
                + "city='" + registerDataAdv.getDestinarion() +"', "
                + "price='" + registerDataAdv.getPrice() +"' "
                + "WHERE id='"+id+"';";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static boolean deleteAdv(String id){
        String query = "DELETE FROM adv WHERE id='"+ id +"';";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static ArrayList<Object> getUserDataFromDatabase(String username){
        ArrayList<Object> resultsFromQuery = new ArrayList<>();
        String query = "SELECT * FROM user WHERE name='"+ username +"';";
        try (Statement statement = CONNECTION.createStatement()) {
        ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String userId = resultSet.getString("id");
                resultsFromQuery.add(userId);
                String name = resultSet.getString("name");
                resultsFromQuery.add(name);
                String mail = resultSet.getString("mail");
                resultsFromQuery.add(mail);
                String password = resultSet.getString("password");
                resultsFromQuery.add(password);
                String userCity = resultSet.getString("city");
                resultsFromQuery.add(userCity);
                String userType = resultSet.getString("type");
                resultsFromQuery.add(userType);
                break;
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }
    
    public static boolean registerNewUser(RegisterData registerData){
        String query = "INSERT INTO user (name, mail, password, type, city)"
                + " VALUES ("
                + "'" + registerData.getUsername() +"', "
                + "'" + registerData.getEmail() +"', "
                + "'" + registerData.getPassword() +"', "
                + "'" + registerData.getUserType() +"', "
                + " 'Las Palmas de Gran Canaria');";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static void addStudentData(String[] userData) {
        String query = "INSERT INTO alumn (alumn_id, mobility_start, mobility_finish, passport, mobility_type)"
                + " VALUES ("
                + "'" + userData[0] +"', "
                + "'" + userData[1] +"', "
                + "'" + userData[2] +"', "
                + "'" + userData[3] +"', "
                + "'" + userData[4] +"'"
                + ");";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static ArrayList<Object> GetDataFromStudent(String id) {
        ArrayList<Object> resultsFromQuery = new ArrayList<>();
        String query = "SELECT passport, mobility_start, mobility_finish, mobility_type FROM alumn " +
                        "JOIN user " +
                        "ON alumn.alumn_id = user.id " +
                        "WHERE user.id = '"+ id +"';";
        try (Statement statement = CONNECTION.createStatement()) {
        ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultsFromQuery.add(resultSet.getString("passport"));
                resultsFromQuery.add(resultSet.getString("mobility_start"));
                resultsFromQuery.add(resultSet.getString("mobility_finish"));
                resultsFromQuery.add(resultSet.getString("mobility_type"));
                break;
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }

    public static void addLanlordData(String[] userData) {
        String query = "INSERT INTO landlord (user_id, nif)"
                + " VALUES ("
                + "'" + userData[0] +"', "
                + "'" + userData[1] +"'"
                + ");";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Object> GetDataFromLandlord(String id) {
        ArrayList<Object> resultsFromQuery = new ArrayList<>();
        String query = "SELECT (nif) FROM landlord " +
                        "JOIN user " +
                        "ON landlord.user_id = user.id " +
                        "WHERE user.id = '"+ id +"';";
        try (Statement statement = CONNECTION.createStatement()) {
        ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultsFromQuery.add(resultSet.getString("nif"));
                break;
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }
    
    public static void addUniversityData(String[] userData) {
        String query = "INSERT INTO uau (user_id, international_code, public)"
                + " VALUES ("
                + "'" + userData[0] +"', "
                + "'" + userData[1] +"', "
                + "'" + userData[2] +"'"
                + ");";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static ArrayList<Object> GetDataFromUniversity(String id) {
        ArrayList<Object> resultsFromQuery = new ArrayList<>();
        String query = "SELECT international_code, public FROM uau " +
                        "JOIN user " +
                        "ON uau.user_id = user.id " +
                        "WHERE user.id = '"+ id +"';";
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultsFromQuery.add(resultSet.getString("international_code"));
                resultsFromQuery.add(resultSet.getBoolean("public"));
                break;
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }

    public static boolean deleteAlojamiento(String id) {
        String query = "DELETE FROM adv where adv.id ='"+id+"'";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static void editAlojamiento(ArrayList<String> dataToUpdate) {
        //Actualizamos tabla padre (ADV)
        RegisterDataAdv advDataToUpdate = new RegisterDataAdv();
        advDataToUpdate.setTitle(dataToUpdate.get(0));
        advDataToUpdate.setDescription(dataToUpdate.get(5));
        advDataToUpdate.setPrice(Integer.parseInt(dataToUpdate.get(6)));
        advDataToUpdate.setDestinarion(dataToUpdate.get(7));
        advDataToUpdate.setStreet(dataToUpdate.get(8));
        editAdv(advDataToUpdate, dataToUpdate.get(1));
        
        //Actualizamos esta tabla
        String query = "UPDATE renting_adv"
                + " SET "
                + " rooms='" + dataToUpdate.get(2) +"',"
                + " avaliable_surface='" + dataToUpdate.get(3) +"',"
                + " duration='" + dataToUpdate.get(4) +"'"
                + " WHERE renting_adv.adv_id = '"+dataToUpdate.get(1)+"'"
                + " AND renting_adv.landlord_id ='"+dataToUpdate.get(9)+"';";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static int getLanlordIdFromUserId(String id) {
        String query = "SELECT id from landlord "
                + "WHERE landlord.user_id='"+id+"'";
        try(Statement statement = CONNECTION.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                return Integer.parseInt(resultSet.getString("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ArrayList<Object> getAllUniversityAdvFromDatabase() {
        ArrayList<Object> resultsFromQuery = new ArrayList();
        String query = "SELECT title FROM university_adv " +
                        "JOIN adv " +
                        "ON university_adv.adv_id = adv.id;";
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultsFromQuery.add(resultSet.getString("title"));
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }

    public static ArrayList<Object> GetDataFromUniversityEvent(String selectedValue) {
        ArrayList<Object> resultsFromQuery = new ArrayList();
        String query = "SELECT adv.id, title, description, street, city, price, university_location FROM university_adv " +
                        "JOIN adv " +
                        "ON university_adv.adv_id = adv.id " +
                        "WHERE adv.title = '"+selectedValue+"'";
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultsFromQuery.add(resultSet.getString("adv.id"));
                resultsFromQuery.add(resultSet.getString("title"));
                resultsFromQuery.add(resultSet.getString("description"));
                resultsFromQuery.add(resultSet.getString("street"));
                resultsFromQuery.add(resultSet.getString("city"));
                resultsFromQuery.add(resultSet.getString("price"));
                resultsFromQuery.add(resultSet.getString("university_location"));
                break;
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }

    private static ArrayList<Object> getUniversityUserInternalIdFrom(String currentId){
        ArrayList<Object> resultsFromQuery = new ArrayList();
        String query = "SELECT user_id, id FROM uau " +
                        "WHERE user_id = '" + currentId + "'";
        try (Statement statement = CONNECTION.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                resultsFromQuery.add(resultSet.getString("id"));
                break;
            }
        } catch (SQLException e) {
            return resultsFromQuery;
        }
        return resultsFromQuery;
    }
    
    public static void registerNewUniversityEvent(RegisterDataAdv dataToInsert, String userId) {
        String query = "INSERT INTO adv (title, description, street, city, price)"
                + " VALUES ("
                + "'" + dataToInsert.getTitle() +"', "
                + "'" + dataToInsert.getDescription() +"', "
                + "'" + dataToInsert.getStreet() +"', "
                + "'" + dataToInsert.getDestinarion() +"', "
                + "'" + dataToInsert.getPrice() +"');";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
        ArrayList<Object> advData = getDataFromAdv(dataToInsert.getTitle()); // ID del anunico
        ArrayList<Object> userData = getUniversityUserInternalIdFrom(userId); // ID del usuario como Universidad
        query = "INSERT INTO university_adv (university_location, uau_id, adv_id)"
                + " VALUES ("
                + "'" + dataToInsert.getDestinarion() +"', "
                + "'" + userData.get(0).toString() +"', "
                + "'" + advData.get(4).toString() +"');";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void updateUniversityEvent(ArrayList<Object> dataToUpdate, String userId) {
        String query = "UPDATE adv SET "
                + "title = '" + dataToUpdate.get(1) +"', "
                + "description = '" + dataToUpdate.get(2) +"', "
                + "street = '" + dataToUpdate.get(3) +"', "
                + "city = '" + dataToUpdate.get(4) +"', "
                + "price = '" + dataToUpdate.get(5) +"' "
                + "WHERE adv.id='"+ dataToUpdate.get(0) +"';";
        try (Statement statement = CONNECTION.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
