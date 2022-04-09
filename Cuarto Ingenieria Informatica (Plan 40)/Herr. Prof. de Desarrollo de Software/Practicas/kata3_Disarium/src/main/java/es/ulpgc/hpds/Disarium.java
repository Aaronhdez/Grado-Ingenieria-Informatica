package es.ulpgc.hpds;

import java.util.ArrayList;
import java.util.List;

public class Disarium {

    public List<Integer> calculateDisarium(int lower, int upper) {
        return new ArrayList<>();
    }

    public boolean isDisarium(int numberToTest) {
        String intParsedToString = String.valueOf(numberToTest);
        int result = getSumOfNumbersPowedToTheirNextPosition(intParsedToString);
        return result == numberToTest;
    }

    private int getSumOfNumbersPowedToTheirNextPosition(String intParsedToString) {
        int result = 0;
        for (int position = 0; position < intParsedToString.length(); position++){
            result += (int) Math.pow(Double.valueOf(intParsedToString.substring(position, position + 1)), position + 1);
        }
        return result;
    }
}
