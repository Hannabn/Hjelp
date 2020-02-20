package Person;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {

    private SimpleStringProperty navn;
    private SimpleIntegerProperty alder;
    private SimpleStringProperty dato;
    private SimpleStringProperty epost;
    private SimpleStringProperty tlf;


    public Person(String navn, int alder, String dato, String epost, String tlf) {
        if(alder < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.navn = new SimpleStringProperty(navn);
        this.alder = new SimpleIntegerProperty(alder);
        this.dato = new SimpleStringProperty(dato);
        this.epost = new SimpleStringProperty(epost);
        this.tlf = new SimpleStringProperty(tlf);
    }

    public String getNavn() { return navn.get(); }

    public void setNavn(String navn) { this.navn.set(navn); }

    public int getAlder() { return alder.get(); }


    public void setAlder(int alder) {
        if(alder < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.alder.set(alder);
    }

    public String getDato() { return dato.get(); }

    public void setDato(String dato) { this.dato.set(dato); }

    public String getEpost() { return epost.get(); }


    public void setEpost(String epost) { this.epost.set(epost); }

    public String getTlf() { return tlf.get(); }

    public void setTlf(String tlf) { this.tlf.set(tlf); }


}