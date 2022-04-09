/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.model.data;

/**
 *
 * @author Usuario
 */
public class RegisterData {

    private String username;
    private String email;
    private String confirmPassword;
    private String password;
    private String destinarion;
    private String userType;

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email; 
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setDestination(String destinarion) {
        this.destinarion = destinarion;
    }

    public String getDestination() {
        return destinarion;
    }
    
    public void setType(String userType) {
        this.userType = userType;
    }
    
    public String getUserType() {
        return userType;
    }
    
}
