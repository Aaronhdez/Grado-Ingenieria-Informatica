/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.model;
/**
 *
 * @author Usuario
 */
public class Universidad extends Usuario {

    private boolean status;
    private String internationalCode;

    public Universidad(UserData userData) {
        super(userData);
    }

    public boolean isPublic() {
        return status;
    }

    public String getInternationalCode() {
        return internationalCode;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setInternationalCode(String internationalCode) {
        this.internationalCode = internationalCode;
    }
}
