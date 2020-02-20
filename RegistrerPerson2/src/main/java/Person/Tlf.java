package Person;

public class Tlf {
    String tlf;
    String regex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";

    public static boolean validate(String tlf) {
        String regex = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$";
        if (!tlf.matches(regex)) {
            return false;
        }
        return true;
    }

    public Tlf(String tlf){
        if(!tlf.matches(regex)){
            throw new IllegalArgumentException("Ugyldig tlfnummer");
        }
        this.tlf = tlf;
    }
}
