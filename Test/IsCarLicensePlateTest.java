import org.junit.Test;

import static org.junit.Assert.*;

public class IsCarLicensePlateTest {

    //bättre namn convention på alla tester

    private ValidityCheck check = new IsCarLicensePlate();
    boolean result;

    @Test
    public void objectIsNull() {
        result = check.isValid(null);
        assertFalse(result);
    }

    @Test
    public void ObjectStringLengthShorterThanSix(){
        String test = "BA222";
        result = check.isValid(test);
        assertFalse(result);
    }

    @Test
    public void objectStringLengthLongerThanSix(){
        String test1 = "BAC1331";
        result = check.isValid(test1);
        assertFalse(result);
    }

    @Test
    public void objectStringFirstThreeNotLetters(){
        String test2 = "B2C133";
        result = check.isValid(test2);
        assertFalse(result);
    }
    @Test
    public void objectStringLastThreeNotDigits(){
        String test3 = "BAC1B3";
        result = check.isValid(test3);
        assertFalse(result);
    }

    @Test
    public void validCarLicensePlate(){
        String test4 = "MAC852";
        result = check.isValid(test4);
        assertTrue(result);
    }

    @Test
    public void validCarLicensePlateWithÖÄÅ(){
        String test5 = "ÅBÖ852";
        result = check.isValid(test5);
        assertTrue(result);
    }

    @Test
    public void ObjectCarLicensePlateWithSmallLetters(){
        String test6 = "mac851";
        result = check.isValid(test6);
        assertFalse(result);
    }
}