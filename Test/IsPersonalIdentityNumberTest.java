import org.junit.Test;

import static org.junit.Assert.*;

public class IsPersonalIdentityNumberTest {


    private boolean result;
    private ValidityCheck check = new IsPersonalIdentityNumber();

    @Test
    public void objectIsNull() {
        result = check.isValid(null);
        assertFalse(result);
    }

    @Test
    public void objectStringIsWrongFormat() {
        String psnTest1 = "--8877-2211";
        result = check.isValid(psnTest1);
        assertFalse(result);
    }

    @Test
    public void testFourOfTheMostCommonFormatsOfPsn() {
        String psnTest2 = "19780202-2389";
        String psnTest3 = "197802022389";
        String psnTest4 = "780202-2389";
        String psnTest5 = "7802022389";
        result = check.isValid(psnTest2);
        assertTrue(result);
        result = check.isValid(psnTest3);
        assertTrue(result);
        result = check.isValid(psnTest4);
        assertTrue(result);
        result = check.isValid(psnTest5);
        assertTrue(result);
    }

    @Test
    public void testPSN(){
        String psnTest = "19920807-2257";
        String test2 = "19920430-5543";
        result = check.isValid(psnTest);
        assertFalse(result);
        result = check.isValid(test2);
        assertFalse(result);
    }

}