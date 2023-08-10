/**
 * Klass som kontrollerar att strängobjektet som skickas in i metoden returnerar sant eller falskt
 */

public class NotNull implements ValidityCheck {

// ternary operator istället
    @Override
    public boolean isValid(String data) {
        if (data == null) {
            return false;
        }
        return true;
    }

    @Override
    public String getCheckName() {
        return "NotNull Validity Check";
    }
}
