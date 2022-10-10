/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import entity.Comment;
import entity.Ticket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class DataHelper {

    private static String generateIdForTicket(int ticketIndex) {
        String result = "TICK" + setFormatForNextId(ticketIndex+"");
        return result;
    }

    private static String setFormatForNextId(String nextId) {
        String maxLimit = "100000";
        while(nextId.length() < maxLimit.length()){
            nextId = "0"+nextId;
        }
        return nextId;
    }
    
    public static String generateDate(){
        String pattern = "dd/MM/yyyy";
        return new SimpleDateFormat(pattern).format(new Date());
    }
}
