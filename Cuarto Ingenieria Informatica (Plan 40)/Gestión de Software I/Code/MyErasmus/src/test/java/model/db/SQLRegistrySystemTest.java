/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.db;

import es.ulpgc.gs1.model.data.RegisterDataAdv;
import es.ulpgc.gs1.helpers.SQLHelper;
import es.ulpgc.gs1.model.data.RegisterData;
import es.ulpgc.gs1.model.data.db.SQLRegistrySystem;
import es.ulpgc.gs1.persistence.RegistrySystem;
import java.sql.SQLException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Usuario
 */
public class SQLRegistrySystemTest {
    @Test
    public void test_if_user_is_created_into_db() throws SQLException, ClassNotFoundException{
        SQLHelper.conectToLocalDatabase();
        RegisterData dummyRegistry = new RegisterData();
        dummyRegistry.setUsername("pepe2");
        dummyRegistry.setEmail("pepe2@gmail.com");
        dummyRegistry.setPassword("uoiea12345");
        dummyRegistry.setConfirmPassword("uoiea12345");
        dummyRegistry.setType("student");
        dummyRegistry.setDestination("huehue");
        RegistrySystem registrySystem = new SQLRegistrySystem();
        boolean expected = registrySystem.register(dummyRegistry, null);
        SQLHelper.disconnect();
        
        assertTrue(expected);
    }
}
