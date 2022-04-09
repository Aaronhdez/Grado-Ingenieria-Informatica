/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Usuario
 */
public class FormatsHelper {
    

    public static boolean checkPassportFormat(String passport) {
        Pattern passportPattern = Pattern.compile("[a-z]{3}[0-9]{6}[a-z]?$");
        Matcher passportMatcher = passportPattern.matcher(passport);
        return passportMatcher.matches();
    }
}
