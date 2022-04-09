package es.ulpgc.hdps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class DisariumTestCases {
    private boolean expected;
    private int number;

    @Parameterized.Parameters(name = "{index}, expected: {0}, number: {1}")
    public static Iterable data(){
        return Arrays.asList(new Object[][]{
                {true, 1},{true, 2},{true, 89}, {false, 200}, {true, 135}
        });
    }

    public DisariumTestCases(boolean expected, int number) {
        this.number = number;
        this.expected = expected;
    }

    @Test
    public void test_IsDisarium(){

    }
}
