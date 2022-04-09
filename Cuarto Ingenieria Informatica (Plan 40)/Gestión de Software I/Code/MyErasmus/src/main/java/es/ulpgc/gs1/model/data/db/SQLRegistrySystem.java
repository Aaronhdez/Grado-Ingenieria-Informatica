/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.model.data.db;

import es.ulpgc.gs1.helpers.SQLHelper;
import es.ulpgc.gs1.model.data.RegisterData;
import es.ulpgc.gs1.model.data.RegisterDataAdv;
import es.ulpgc.gs1.model.data.RegisterDataAlojamiento;
import es.ulpgc.gs1.persistence.RegistrySystem;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class SQLRegistrySystem implements RegistrySystem {

    @Override
    public boolean registerAdv(RegisterDataAdv registerData, JDialog parent) {
        String errorMessage = "";
        if(fieldIsEmpty(registerData.getStreet())){
            errorMessage += "Usuario no especificado\n";
        }
        if(errorMessage.isEmpty()){
            SQLHelper.registerNewAdv(registerData);
            return true;
        }
        JOptionPane.showMessageDialog(parent, errorMessage, "Datos Evento Erróneos", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    @Override
    public boolean register(RegisterData registerData, JDialog parent) {
        String errorMessage = "";
        if(usernameIsEmpty(registerData.getUsername())){
            errorMessage += "Usuario no especificado\n";
        }
        if(usernameCompliesWithFormat(registerData.getUsername())){
            errorMessage += "Formato de nombre de usuario incorrecto\n";
        }
        if(usernameExistsInDB(registerData.getUsername())){
            errorMessage += "Ya existe el usuario\n";
        }
        if(!passwordCompliesWithFormat(registerData.getPassword())){
            errorMessage += "La contraseña debe tener:\n"
                    + "- Ocho caracteres\n"
                    + "- Al menos un número\n"
                    + "- Una letra mayúscula y otra minúscula\n"
                    + "- Un caracter especial\n";
        }
        if(!passwordsAreEqual(registerData.getPassword(), registerData.getConfirmPassword())){
            errorMessage += "La contraseñas no coinciden\n";
        }
        if(errorMessage.isEmpty()){
            SQLHelper.registerNewUser(registerData);
            return true;
        }
        JOptionPane.showMessageDialog(parent, errorMessage, "Datos Erróneos", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    private boolean usernameExistsInDB(String username) {
        return !SQLHelper.getUserDataFromDatabase(username).isEmpty();
    }

    private boolean passwordCompliesWithFormat(String newPassword) {
        var complimentPattern = Pattern.compile("[A-Za-z0-9]{8,}");
        Matcher complimentMatcher = complimentPattern.matcher(newPassword);
        return complimentMatcher.matches();
    }

    private boolean passwordsAreEqual(String password, String passwordConfirmation) {
        return password.equals(passwordConfirmation);
    }

    private boolean usernameCompliesWithFormat(String username) {
        var complimentPattern = Pattern.compile("^[a-zA-Z]+[a-zA-Z0-9]{8,}");
        Matcher complimentMatcher = complimentPattern.matcher(username);
        return complimentMatcher.matches();
    }

    private boolean usernameIsEmpty(String name) {
        return (name==null);
    }
    
    private boolean fieldIsEmpty(String name) {
        return (name==null);
    }

    @Override
    public boolean registerAlojamiento(RegisterDataAlojamiento registerDataAlojamiento, JDialog parent) {
        String errorMessage = "";
        if(fieldIsEmpty(Integer.toString(registerDataAlojamiento.getAdv_id()))){
            errorMessage += "No dispone de id de anuncio\n";
        }
        if(errorMessage.isEmpty()){
            SQLHelper.registerNewAlojamiento(registerDataAlojamiento);
            return true;
        }
        JOptionPane.showMessageDialog(parent, errorMessage, "Datos Alojamiento Erróneos", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
}
