
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> dataToValidate = new ArrayList<>();
        ArrayList<ValidityCheck> checkers = new ArrayList<>();

        //Valid
        dataToValidate.add("19780202-2389");
        dataToValidate.add("197802022389");
        dataToValidate.add("7802022389");
        dataToValidate.add("780202-2389");
        dataToValidate.add("820411-2380");
        dataToValidate.add("KUN123");

        //Ej valid
        dataToValidate.add(null);
        dataToValidate.add(("-80202-2389"));
        dataToValidate.add("20020202-2389111");
        dataToValidate.add("-200202022389");
        dataToValidate.add("200202022389-");
        dataToValidate.add(("AB123"));
        dataToValidate.add(("ABC1A3"));
        dataToValidate.add(("A1CBBB"));
        dataToValidate.add(("ABCBBB1"));
        dataToValidate.add("a22333");


        checkers.add(new NotNull());
        checkers.add(new IsPersonalIdentityNumber());
        checkers.add(new IsCarLicensePlate());
        ValidityChecker checker = new ValidityChecker(dataToValidate, checkers);
        checker.runDataValidation();


    }

}
