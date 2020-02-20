package Person;

public class Epost {
    String epost;
    String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean validate(String epost) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (!epost.matches(regex)) {
            return false;
        }
        return true;
    }

    public Epost(String epost){
        if(!epost.matches(regex)){
            throw new IllegalArgumentException("Ugyldig epost");
        }

        this.epost = epost;
    }
}