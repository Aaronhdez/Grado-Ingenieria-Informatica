/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.model.data.db;

import es.ulpgc.gs1.helpers.SQLHelper;
import es.ulpgc.gs1.model.UserData;
import es.ulpgc.gs1.model.data.Session;
import es.ulpgc.gs1.persistence.LoginSystem;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class SQLLoginSystem implements LoginSystem{
    
    private final Session session;

    public SQLLoginSystem(Session currentSession) {
        this.session = currentSession;
    }
    
    @Override
    public boolean login(String username, String password) {
        ArrayList<Object> resultsFromDb = SQLHelper.getUserDataFromDatabase(username);
        if(resultsFromDb == null) return false;
        if(IsAValidUser(resultsFromDb) && passwordIsCorrect(resultsFromDb, password)){
            UserData userData = toUserData(resultsFromDb);
            this.session.setCurrentUserData(userData);
            this.session.setUserInstance(username, userData);
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        this.session.setCurrentUserData(null);
    }
    
    private boolean IsAValidUser(ArrayList<Object> resultsFromDb) {
        return !resultsFromDb.isEmpty();
    }

    private boolean passwordIsCorrect(ArrayList<Object> resultsFromDb, String password) {
        return ((String) resultsFromDb.get(3)).equals(password);    
    }

    private UserData toUserData(ArrayList<Object> resultsFromDb) {
        UserData userData = new UserData();
        userData.setId((String) resultsFromDb.get(0));
        userData.setUsername((String) resultsFromDb.get(1));
        userData.setMail((String) resultsFromDb.get(2));
        userData.setPassword((String) resultsFromDb.get(3));
        userData.setCity((String) resultsFromDb.get(4));
        userData.setType((String) resultsFromDb.get(5));
        return userData;
    }
}
