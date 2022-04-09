/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.db;

import es.ulpgc.gs1.model.data.Session;
import es.ulpgc.gs1.helpers.SQLHelper;
import es.ulpgc.gs1.model.data.db.SQLLoginSystem;
import es.ulpgc.gs1.persistence.LoginSystem;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Usuario
 */
public class SQLLoginSystemTest {

    private LoginSystem loginSystem;
    
    @Before
    public void setUp(){
        this.loginSystem = new SQLLoginSystem(new Session());
    }
    
    @Test
    public void test_if_user_exists() throws ClassNotFoundException, SQLException{
            SQLHelper.conectToLocalDatabase();
            boolean expected = loginSystem.login("pepe", "aeiou12345");
            SQLHelper.disconnect();
            
            Assert.assertTrue(expected);
    }
    
    @Test
    public void test_if_user_does_not_exists() throws ClassNotFoundException, SQLException{
            SQLHelper.conectToLocalDatabase();
            boolean expected = loginSystem.login("pepe2", "aeiou12345");
            SQLHelper.disconnect();
            
            Assert.assertFalse(expected);
    }
}
