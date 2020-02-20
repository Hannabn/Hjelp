package Person;

public class Fodselsdato {
    int dag;
    int maned;
    int ar;

    public Fodselsdato (int dag, int maned, int ar){

        if (dag <= 0 || dag > 31){
            throw new IllegalArgumentException("Ugyldig dag");
        }

        if(maned >= 1 && maned <=7 && maned%2 == 0 && (dag <= 0 || dag > 30)){
            throw new IllegalArgumentException("Ugyldig dag eller måned");
        }

        if(maned >= 1 && maned <=7 && maned%2 != 0 && (dag <= 0 || dag > 31)){
            throw new IllegalArgumentException("Ugyldig dag eller måned");
        }

        if(maned >= 8 && maned <=12 && maned%2 == 0 && (dag <= 0 || dag > 31)){
            throw new IllegalArgumentException("Ugyldig dag eller måned");
        }

        if(maned >= 8 && maned <=12 && maned%2 != 0 && (dag <= 0 || dag > 30)){
            throw new IllegalArgumentException("Ugyldig dag eller måned");
        }

        if(maned == 2 && (dag <= 0 || dag > 29) ){
            throw new IllegalArgumentException("Ugyldig dag");
        }


        if (maned <= 0 || maned > 12){
            throw new IllegalArgumentException("Ugyldig måned");
        }

        if (ar <= 1900 || ar > 2020){
            throw new IllegalArgumentException("Ugyldig år");
        }

        this.dag = dag;
        this.maned = maned;
        this.ar = ar;
    }
}
