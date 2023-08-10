import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class IsPersonalIdentityNumber implements ValidityCheck {

    /**
     * Tar emot en sträng som kontrolleras för null och format för personnr. Sedan anropas andra metoder
     * som hjälper till att räkna ut ifall ett personnr är giltigt eller inte.
     *
     * @param data strängen som ska kontrolleras i metoden som skickats från ValidityChecker
     * @return sant eller falskt
     */
    @Override
    public boolean isValid(String data) {
        if (data == null) {
            return false;
        } else {
            if (!checkFormatAndDigits(data)) {
                return false;
            }
            // kan lägga till en if sats här för att kolla om längden inte är 10.
            String parsedPsn = makePsnTenDigits(data);
            int controlNumber = Integer.parseInt(parsedPsn.substring(parsedPsn.length() - 1));
            //ternary operator
            if (calculatePotentialCtrNbr(parsedPsn) == controlNumber) {
                return true;
            } else {
                return false;
            }
        }
    }


    /**
     * Tar emot en tolkad sträng där den utför olika uträkningar för att returnera en enda int
     * som sedan används i isValid metoden.
     *
     * @param parsedPsn sträng från isValid metoden
     * @return en int representation
     */
    public int calculatePotentialCtrNbr(String parsedPsn) {
        String parsedPsnNoCtrlNr = parsedPsn.substring(0, parsedPsn.length() - 1);
        int counter = 0;
        int total = 0;
        int numberCalculatedOn;
        int temp;

        for (int i = 0; i < parsedPsnNoCtrlNr.length(); i++) {
            numberCalculatedOn = Integer.parseInt(String.valueOf(parsedPsnNoCtrlNr.charAt(i)));
            if (counter % 2 == 0) {
                int holder = numberCalculatedOn * 2;
                if (holder > 9) {
                    total += (holder % 10) + 1;
                } else {
                    total += holder;
                }
            } else {
                total += numberCalculatedOn;
            }
            counter++;
        }
        temp = total % 10;
        temp = 10 - temp;
        temp = temp % 10;
        return temp;
    }


    /**
     * Tar emot en sträng och tar bort eventuella siffror om det börjar på 19 och 20. Tar även bort bindestrecket
     *
     * @param data datasträng från isValid-metoden
     * @return en sträng representation på 10 i längd
     */


    // datalängden borde ha kollats innan denna metod kallas. Se rad 21
    public String makePsnTenDigits(String data) {
        if (data.length() != 10) {
            while (data.contains("-")) {
                data = data.replace("-", "");
            }
            if (data.startsWith("20") || data.startsWith("19")) {
                data = data.substring(2);
            }
        }
        return data;
    }


    /**
     * Tar emot en sträng och kontrollerar så att formatet på strängen matchar det som regex
     * strängen säger att det ska vara.
     *
     * @param data datasträng från isValid-metoden
     * @return sant eller falskt
     */
    public boolean checkFormatAndDigits(String data) {
        String regex = "^(19|20)?[0-9]{6}[-]?[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);

        //returnera bara matcher.matches()
        if (matcher.matches()) {
            return true;
        }
        return false;

    }

    @Override
    public String getCheckName() {
        return "IsPersonalIdentityNumber Validity Check";
    }
}
