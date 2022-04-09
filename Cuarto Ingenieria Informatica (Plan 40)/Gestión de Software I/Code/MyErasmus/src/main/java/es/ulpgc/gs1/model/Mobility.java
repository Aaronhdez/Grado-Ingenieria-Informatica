/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.gs1.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Mobility {

    private String programName;
    private Date startDate;
    private Date endDate;
    public Mobility(Date startDate, Date endDate, String programName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.programName = programName.toUpperCase();
    }

    public Mobility(ArrayList<Object> dataFromDB) {
        this.startDate = (Date) dataFromDB.get(0);
        this.endDate = (Date) dataFromDB.get(1);
        this.programName= (String) dataFromDB.get(2);
    }

    public String getProgramName() {
        return programName;
    }

    
    enum ProgramType {
        SICUE, ERASMUS, MUNDUS
    }
    
    boolean checkProgram() {
        for (ProgramType program : ProgramType.values()) {
            if (program.name().equals(programName)) return true;
        }
        return false;
    }
    
    public boolean mobilityIsActive(){
        Date currentDate = Calendar.getInstance().getTime();
        return currentDate.after(startDate) && currentDate.before(endDate);
    }
}
