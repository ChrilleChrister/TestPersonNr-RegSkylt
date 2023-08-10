import org.junit.Test;

import static org.junit.Assert.*;

public class NotNullTest {

    private ValidityCheck check = new NotNull();
    boolean result;

    @Test
    public void objectIsNull(){
        result = check.isValid(null);
        assertFalse(result);
    }
    @Test
    public void objectIsNotNull(){
        String test1 = "Hello World!";
        result = check.isValid(test1);
        assertTrue(result);
    }





}