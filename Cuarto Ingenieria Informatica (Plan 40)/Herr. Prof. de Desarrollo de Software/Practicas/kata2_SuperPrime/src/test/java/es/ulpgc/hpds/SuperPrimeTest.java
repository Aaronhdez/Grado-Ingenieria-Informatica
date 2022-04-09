package es.ulpgc.hpds;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuperPrimeTest {

    SuperPrimeProcessor processor;

    @Before
    public void setup(){
        this.processor = new SuperPrimeProcessor();
    }

    @Test
    public void testing_if_value_is_prime_for_prime_numbers() {
        assertTrue(processor.isPrime(1));
        assertTrue(processor.isPrime(2));
        assertTrue(processor.isPrime(3));
        assertTrue(processor.isPrime(5));
        assertTrue(processor.isPrime(7));
        assertTrue(processor.isPrime(11));
        assertTrue(processor.isPrime(13));
    }

    @Test
    public void testing_if_value_is_prime_for_non_prime_numbers(){
        assertFalse(processor.isPrime(4));
        assertFalse(processor.isPrime(6));
        assertFalse(processor.isPrime(8));
        assertFalse(processor.isPrime(9));
        assertFalse(processor.isPrime(10));
        assertFalse(processor.isPrime(12));
        assertFalse(processor.isPrime(14));
        assertFalse(processor.isPrime(15));
        assertFalse(processor.isPrime(16));
    }

    @Test
    public void testing_if_inverted_value_is_palindrome_for_palidromic_numbers(){
        assertTrue(processor.isPalindrome(2));
        assertTrue(processor.isPalindrome(22));
        assertTrue(processor.isPalindrome(222));
        assertTrue(processor.isPalindrome(22222));
        assertTrue(processor.isPalindrome(2222222));
        assertTrue(processor.isPalindrome(232));
        assertTrue(processor.isPalindrome(23332));
        assertTrue(processor.isPalindrome(334454433));
    }

    @Test
    public void testing_if_inverted_value_is_prime_for_non_palidromic_numbers(){
        assertFalse(processor.isPalindrome(23));
        assertFalse(processor.isPalindrome(243));
        assertFalse(processor.isPalindrome(2443));
        assertFalse(processor.isPalindrome(2215));
        assertFalse(processor.isPalindrome(24567));
        assertFalse(processor.isPalindrome(124212));
        assertFalse(processor.isPalindrome(221423434));
    }

    @Test
    public void testing_reversed_values_for_different_numbers(){
        assertEquals(1, processor.reversedIntValue(1));
        assertEquals(12, processor.reversedIntValue(21));
        assertEquals(123, processor.reversedIntValue(321));
        assertEquals(1234, processor.reversedIntValue(4321));
        assertEquals(12345, processor.reversedIntValue(54321));
        assertEquals(12346, processor.reversedIntValue(64321));
        assertEquals(324536, processor.reversedIntValue(635423));
        assertEquals(2543, processor.reversedIntValue(3452));
        assertEquals(235235, processor.reversedIntValue(532532));
    }

    @Test
    public void testing_for_prime_and_superPrime_numbers(){
        assertTrue(processor.isSuperPrime(13));
        assertTrue(processor.isSuperPrime(17));
        assertTrue(processor.isSuperPrime(31));
        assertTrue(processor.isSuperPrime(71));
        assertTrue(processor.isSuperPrime(73));
    }

    @Test
    public void testing_for_prime_and_non_superPrime_numbers(){
        assertFalse(processor.isSuperPrime(2));
        assertFalse(processor.isSuperPrime(3));
        assertFalse(processor.isSuperPrime(3));
        assertFalse(processor.isSuperPrime(7));
        assertFalse(processor.isSuperPrime(9));
        assertFalse(processor.isSuperPrime(11));
        assertFalse(processor.isSuperPrime(29));
        assertFalse(processor.isSuperPrime(41));
    }

    @Test
    public void testing_boundaries_correctness(){
        assertFalse(processor.intervalsNotAccepted(1,1));
        assertFalse(processor.intervalsNotAccepted(1,4));
        assertTrue(processor.intervalsNotAccepted(6,5));
        assertTrue(processor.intervalsNotAccepted(-6,5));
        assertTrue(processor.intervalsNotAccepted(6,-5));
    }

    @Test
    public void testing_super_prime_numbers_found_on_several_accepted_intervals(){
        assertEquals("[0, 0]", processor.analizeSuperPrime(1,3));
        assertEquals("[0, 0]", processor.analizeSuperPrime(1,11));
        assertEquals("[1, 13]", processor.analizeSuperPrime(1,13));
        assertEquals("[3, 61]", processor.analizeSuperPrime(1, 31));
        assertEquals("[8, 418]", processor.analizeSuperPrime(2, 100));
        assertEquals("[4, 39762]", processor.analizeSuperPrime(9900, 10000));
        assertEquals("[0, 0]", processor.analizeSuperPrime(501, 599));

        assertEquals("[1, 13]", processor.analizeSuperPrime(13,13));
        assertEquals("[1, 13]", processor.analizeSuperPrime(13,14));
        assertEquals("[1, 13]", processor.analizeSuperPrime(12,14));

        assertEquals("[1, 71]", processor.analizeSuperPrime(71,71));
        assertEquals("[1, 71]", processor.analizeSuperPrime(71,72));
        assertEquals("[1, 71]", processor.analizeSuperPrime(70,72));
    }

    @Test
    public void testing_super_prime_numbers_found_on_unaccepted_intervals(){
        assertEquals("[0, 0]", processor.analizeSuperPrime(-1,3));
        assertEquals("[0, 0]", processor.analizeSuperPrime(1,-11));
        assertEquals("[0, 0]", processor.analizeSuperPrime(3,-1));
        assertEquals("[0, 0]", processor.analizeSuperPrime(3,1));
    }
}
