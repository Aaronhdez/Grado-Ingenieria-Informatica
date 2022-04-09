package es.ulpgc.hpds;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    // Mock FizzBuzz instance
    private FizzBuzz guineaPig;

    /**
     * Set Up of testing processes
     */

    @Before
    public void SetUp(){
        this.guineaPig = new FizzBuzz();
    }

    /**
     * - Rules to test
     *   - i%3 = 0 Fizz
     *   - i%5 = 0 Buzz
     *   - i%3 && i%5 = 0 FizzBuzz
     *   - Others = "i"
     */

    @Test
    public void testing_return_1_for_1(){
        assertEquals("1", this.guineaPig.value(1));
    }

    @Test
    public void testing_return_2_for_2(){
        assertEquals("2", this.guineaPig.value(2));
    }

    @Test
    public void testing_Fizz_for_value_3(){
        assertEquals("Fizz", this.guineaPig.value(3));
    }

    @Test
    public void testing_Buzz_for_value_5(){
        assertEquals("Buzz", this.guineaPig.value(5));
    }

    @Test
    public void testing_Fizz_for_value_9(){
        assertEquals("Fizz", this.guineaPig.value(9));
    }

    @Test
    public void testing_FizzBuzz_for_value_30(){
        assertEquals("FizzBuzz", this.guineaPig.value(30));
    }

    @Test
    public void testing_FizzBuzz_for_value_15(){
        assertEquals("FizzBuzz", this.guineaPig.value(15));
    }
}
