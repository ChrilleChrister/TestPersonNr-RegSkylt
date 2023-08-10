import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ValidityChecker {
    //private final
    ArrayList<String> dataList;
    ArrayList<ValidityCheck> validityChecks;
    ArrayList<String> notValidList = new ArrayList<>();

    /**
     * Konstruktor
     * @param dataList sätter listan med String objekt.
     * @param checkList sätter listan med Validity Check objekt
     */

    public ValidityChecker(ArrayList<String> dataList, ArrayList<ValidityCheck> checkList){
        this.validityChecks = checkList;
        this.dataList = dataList;
    }


    /**
     * Metod som som kollar om listan med strängar är tom. Om den inte är tom så går den igenom
     * hela listan och kör metoden runValidationChecks på varje strängobjekt i listan.
     * Om listan är tom får man felmeddelande
     * I slutet anropas saveNotValidToLogFile som tar en lista med strängar
     */

    //ternary operator
    public void runDataValidation(){
        if(!dataList.isEmpty()){
            for(String str : dataList){
                runValidationChecks(str);
            }
        } else{
            System.out.println("List of Data to validate is empty");
        }
        saveNotValidToLogFile(notValidList);
    }

    /**
     * Metod som går igenom listan med Validity Check objekt där varje objekt anropar sin isValid metod.
     * Strängen skickas med isValid metod och kontrolleras i if-satsen ifall den är true eller false.
     * Om det är sant så skrivs det ut att den är valid och strängen som skickades med skrivs också ut samt
     * att namnet på validity checken skrivs ut.
     * Om det är falsk så gör den samma sak som står ovan fast med Not Valid och den strängen och tillfällets datum
     * och tid läggs i listan notValidList.
     * @param data är en sträng från listan med alla strängobjekt som ska valideras i Validity Checks
     */

    public void runValidationChecks(String data) {
        boolean isValid;
        for (ValidityCheck check : validityChecks) {
            isValid = check.isValid(data);
            if (isValid) {
                System.out.println("VALID for: " + data + " " + check.getCheckName());
            } else {
                System.out.println("NOT VALID for: " + data + " " + check.getCheckName());
                notValidList.add("NOT VALID! Input: " + data + "  " + java.time.LocalDateTime.now() + "\n");
            }
        }
    }

    /**
     * Metoden gör om listan som skickas in till en sträng.
     * Sedan försöker den att skapa ett filewriter objekt som heter logfile.txt
     * Den kommer skriva in strängen data i logfilen och sedan stängas.
     * Man får meddelande om att det sparas till logfilen
     * Om filewriter objektet inte lykcas så ska fångar den upp IOE
     * och skriver ut ett felmeddelande.
     * @param list tar emot listan notValidList med strängar.
     */
    public void saveNotValidToLogFile(ArrayList<String> list) {
        String data = list.toString();
        try {
            FileWriter fileWriter = new FileWriter("logfile.txt");
            fileWriter.write(data);
            fileWriter.close();
            System.out.println("Failed validations saved to logfile");
        } catch (IOException e) {
            System.out.println("Error occurred. Couldn't save information to logfile");
        }
    }

}
