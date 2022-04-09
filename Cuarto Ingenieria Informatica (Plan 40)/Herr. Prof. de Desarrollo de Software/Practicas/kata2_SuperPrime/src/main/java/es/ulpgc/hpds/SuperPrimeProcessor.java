package es.ulpgc.hpds;

public class SuperPrimeProcessor {

    public SuperPrimeProcessor() {
    }

    public String analizeSuperPrime(int lowerBound, int upperBound) {
        if (intervalsNotAccepted(lowerBound, upperBound)) {
            return "[0, 0]";
        }
        int superPrimesSum = 0;
        int superPrimesFound = 0;
        for (int i = lowerBound; i <= upperBound; i++) {
            if (isSuperPrime(i)) {
                superPrimesSum += i;
                superPrimesFound++;
            }
            ;
        }
        return "[" + superPrimesFound + ", " + superPrimesSum + "]";
    }

    public boolean isSuperPrime(int value) {
        return (isPrime(value) && !isPalindrome(value) && isPrime(reversedIntValue(value)));
    }

    public boolean isPrime(int value){
        for (int i = 2; i<value; i++){
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(int value){
        String valueAsText = value+"";
        int valueLength = valueAsText.length();
        int middle = (valueLength)/2;

        for (int i = 0, j = valueLength-1; i < middle; i++, j--){
            if(valueAsText.charAt(i) != valueAsText.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public int reversedIntValue(int value){
        String reversedAsText = "";
        int valueLength = (value+"").length();
        for (int i = valueLength-1; i>=0; i--){
            reversedAsText += (value+"").charAt(i);
        }
        return Integer.parseInt(reversedAsText);
    }

    public boolean intervalsNotAccepted(int lowerBound, int upperBound){
        return (lowerBound < 0 || upperBound < lowerBound || upperBound < 0);
    }
}
