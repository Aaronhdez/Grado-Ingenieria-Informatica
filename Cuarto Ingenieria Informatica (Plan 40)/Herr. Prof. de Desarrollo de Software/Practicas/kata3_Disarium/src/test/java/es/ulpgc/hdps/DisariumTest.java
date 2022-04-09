package es.ulpgc.hdps;

import es.ulpgc.hpds.Disarium;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DisariumTest {

    private Disarium disarium;

    @Before
    public void setUp(){
        this.disarium = new Disarium();
    }

    @Test
    public void test_Disarium_between_0_150(){
        //Given
        Integer [] disariumBetween0aAnd150 = {0,1,2,3,4,5,6,7,8,9,89,135};
        List<Integer> listOfNumbersToTest = Arrays.asList(disariumBetween0aAnd150);

        //Do
        List<Integer> result = this.disarium.calculateDisarium(0,150);

        //Assert
        assertEquals(true, result.equals(disariumBetween0aAnd150));
    }

    @Test
    public void test_Disarium_between_151_550(){
        //Given
        Integer [] disariumBetween0aAnd150 = {175,518};
        List<Integer> listOfNumbersToTest = Arrays.asList(disariumBetween0aAnd150);

        //Do
        List<Integer> result = this.disarium.calculateDisarium(175,518);

        //Assert
        assertEquals(true, result.equals(disariumBetween0aAnd150));
    }

    @Test
    public void return_true_if_number_1_is_disarium(){
        Integer intToBeTested = 1;

        assertEquals(true, this.disarium.isDisarium(intToBeTested));
    }

    @Test
    public void return_true_if_number_2_is_disarium(){
        Integer intToBeTested = 2;

        assertEquals(true, this.disarium.isDisarium(intToBeTested));
    }

    @Test
    public void return_true_if_number_89_is_disarium(){
        Integer intToBeTested = 89;

        assertEquals(true, this.disarium.isDisarium(intToBeTested));
    }

}
