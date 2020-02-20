package Person;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class Register implements Serializable {
    private static transient ObservableList<Person> listeAvPersoner = FXCollections.observableArrayList();

    public static ObservableList<Person> getList(){
        return listeAvPersoner;
    }
    public static void add(Person person){
        listeAvPersoner.add(person);
    }
    public static void remove(Person person){
        listeAvPersoner.remove(person);
    }
}
