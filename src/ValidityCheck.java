/**
 * Ett interface som har två metoder
 * Dessa metoder används av klasser som implementerar detta interface.
 */

public interface ValidityCheck {

    boolean isValid(String data);

    String getCheckName();

}
