/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import es.ulpgc.gs1.model.Alumno;
import es.ulpgc.gs1.model.Mobility;
import es.ulpgc.gs1.model.UserData;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Usuario
 */
public class AlumnoTest {

    private Alumno alumno;
    @Before
    public void SetUp(){
        UserData userData = new UserData("pepe","pepe@pepe","12345","ciudad","student");
        this.alumno = new Alumno(userData);
        Date startDate = new GregorianCalendar(2021, Calendar.SEPTEMBER, 10).getTime();
        Date endDate = new GregorianCalendar(2022, Calendar.JUNE, 22).getTime();
        this.alumno.setMobility(new Mobility(startDate,endDate,"ERASMUS"));
        this.alumno.setPassport("AAA000111");
    }
    
    @Test
    public void test_if_student_is_equal_to_another_student(){
        Alumno alumno2 = new Alumno(new UserData("pepe","pepe@pepe","12345","ciudad","student"));
        
        assertEquals(this.alumno, alumno2);
    }
    
    @Test
    public void test_if_student_is_in_a_mobility_program(){
        boolean onMobility = this.alumno.isOnMobility();
        
        assertTrue(onMobility);
    }
    
    @Test
    public void test_if_the_student_passport_has_correct_format(){
        boolean correctFormat = this.alumno.passportIsOnCorrectFormat();
        
        assertTrue(correctFormat);
    }
    @Test
    public void test_if_the_mobility_program_is_valid_(){
        boolean validMobility = this.alumno.mobiltyProgramIsValid();
        assertTrue(validMobility);
    }
}
