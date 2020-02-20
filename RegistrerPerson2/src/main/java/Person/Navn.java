package Person;

public class Navn {

    String navn;
    String regex = "[A-ZÆØÅ][a-zæøå]+ [A-ZÆØÅ][a-zæøå]+";

    public static boolean validate(String navn) {
        String regex = "[A-ZÆØÅ][a-zæøå]+ [A-ZÆØÅ][a-zæøå]+";
        if (!navn.matches(regex)) {
            return false;
        }
        return true;
    }

    public Navn(String navn){
        if(!navn.matches(regex)){
            throw new IllegalArgumentException("Ugyldig navn");
        }

        this.navn = navn;
    }
}