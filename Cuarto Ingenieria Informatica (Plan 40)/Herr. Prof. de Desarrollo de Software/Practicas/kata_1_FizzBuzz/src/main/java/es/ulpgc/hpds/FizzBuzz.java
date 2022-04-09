package es.ulpgc.hpds;

public class FizzBuzz {
    public String value(int value) {
        String res = "";
        res = (isFizz(value)) ? "Fizz" : res;
        res = (isBuzz(value)) ? "Buzz" : res;
        res = (isFizzBuzz(value)) ? "FizzBuzz" : res;
        return (hasChanged(res)) ? value+res : res;
    }

    private boolean hasChanged(String res) {
        return res.equals("");
    }

    private boolean isFizz(int value){
        return value % 3 == 0;
    }

    private boolean isBuzz(int value){
        return value % 5 == 0;
    }

    private boolean isFizzBuzz(int value){
        return (isFizz(value) && isBuzz(value));
    }
}
