import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsCarLicensePlate implements ValidityCheck {


    /**
     * Tar in en sträng som kontrolleras för null och längd. Sedan delas strängen upp i två delar.
     * Vardera del skickas sedan in i två olika metoder. Sedan kontrolleras båda metoderna om de är sanna eller falska.
     * @param data strängen som ska kontrolleras i metoden som skickats från ValidityChecker
     * @return sant eller falskt
     */


    @Override
    public boolean isValid(String data) {
        if (data == null) {
            return false;
        } else {
            if(data.length() != 6 ){
                return false;
            }
            if (checkLettersCarLicensePlate(data.substring(0, 3)) && checkDigitsCarLicensePlate(data.substring(3, 6))) {
                return true;
            } else {
                return false;
            }
        }
    }

    // använda sig av regex uttryck som i den andra valideraren för personnr. Och som även tar hänsyn till att den sista siffran idag kan vara en bokstav.

    /**
     * Metod som kontrollerar om data består av bokstäver och att de är uppercase.
     * @param data tar emot en sträng från isValid metoden.
     * @return sant eller falskt
     */
    public boolean checkLettersCarLicensePlate(String data) {
        char[] chars = data.toCharArray();
        for (char ch: chars) {
            if (!Character.isUpperCase(ch) || !Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metod som kontrollerar om data består av siffror.
     * @param data tar emot en sträng från isValid metoden.
     * @return sant eller falskt
     */
    public boolean checkDigitsCarLicensePlate(String data) {
        char[] chars = data.toCharArray();
        for (char ch : chars) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String getCheckName() {
        return "IsCarLicensePlate Validity Check";
    }
}
