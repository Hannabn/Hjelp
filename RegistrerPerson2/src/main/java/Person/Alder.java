package Person;

public class Alder {

    int alder;

    public static boolean validate(String tall) {
        try {
            int age = Integer.parseInt(tall);
            return age <= 0 && age < 130;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public Alder (int alder){
        if(alder < 0 || alder > 120) {
            throw new IllegalArgumentException("Ugyldig alder");
        }

        this.alder = alder;
    }
}
