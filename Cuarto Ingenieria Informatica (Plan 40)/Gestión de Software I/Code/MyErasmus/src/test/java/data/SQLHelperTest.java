/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import es.ulpgc.gs1.helpers.SQLHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Usuario
 */
public class SQLHelperTest {
    
    @Test
    public void test_if_connection_is_instantiated() throws ClassNotFoundException, SQLException{
        boolean connectionIsInstatiated = SQLHelper.conectToLocalDatabase();
        
        assertTrue(connectionIsInstatiated);
    }
    
    @Test
    public void test_if_connection_is_disconnected_properly() throws ClassNotFoundException, SQLException{
        SQLHelper.conectToLocalDatabase();
        boolean connectionIsDisconnected = SQLHelper.disconnect();
        
        assertTrue(connectionIsDisconnected);
    }
    
    @Test
    public void test_if_user_data_is_retrieved() throws ClassNotFoundException, SQLException{
        SQLHelper.conectToLocalDatabase();
        ArrayList<Object> results = SQLHelper.getUserDataFromDatabase("pepe");
        SQLHelper.disconnect();
        
        assertFalse(results.isEmpty());
    }
}
