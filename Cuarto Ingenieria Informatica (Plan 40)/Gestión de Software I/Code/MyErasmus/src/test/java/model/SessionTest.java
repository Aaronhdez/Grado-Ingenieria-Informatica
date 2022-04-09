/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import es.ulpgc.gs1.model.UserData;
import es.ulpgc.gs1.model.data.Session;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Usuario
 */
public class SessionTest {

    private Session session;
    private UserData userData;
    
    @Before
    public void setUp(){
        this.session = new Session();
        this.userData = session.getCurrentUserData();
    }
    
    @Test
    public void test_if_null_data_is_retrieved_when_session_is_not_started(){
        UserData expected = this.session.getCurrentUserData();
        
        assertEquals(null, expected);
    }
}
