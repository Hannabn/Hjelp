package programutvikling;

import Person.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;
import Person.Register;

public class PrimaryController implements Initializable {

    @FXML
    private TableColumn<Person, String> navnDataColumn;

    @FXML
    private TableColumn<Person, Integer> alderDataColumn;

    @FXML
    private TableColumn<Person, String> fodselDataColumn;

    @FXML
    private TableColumn<Person, String> epostDataColumn;

    @FXML
    private TableColumn<Person, String> tlfDataColumn;

    @FXML
    TextField txtNavn, txtAlder, txtDato, txtEpost, txtTelefon;

    @FXML
    TableView<Person> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Visning
        navnDataColumn.setCellValueFactory(new PropertyValueFactory<>("navn"));
        alderDataColumn.setCellValueFactory(new PropertyValueFactory<>("alder"));
        fodselDataColumn.setCellValueFactory(new PropertyValueFactory<>("dato"));
        epostDataColumn.setCellValueFactory(new PropertyValueFactory<>("epost"));
        tlfDataColumn.setCellValueFactory(new PropertyValueFactory<>("tlf"));

        tableView.setItems(Register.getList());

        //For editing:
        navnDataColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        alderDataColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        fodselDataColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        epostDataColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        tlfDataColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.setEditable(true);
    }

    @FXML
    private void visRegistrete() {
        Person obj = createDataModelObjectFromGUI();

        if(obj != null) {
            resetTxtFields();
            Register.add(obj);
        }
    }

    boolean infoStemmer = true;

    private Person createDataModelObjectFromGUI() {
        String navn = txtNavn.getText();
        String fodsel = txtDato.getText();
        String epost = txtEpost.getText();
        String tlf = txtTelefon.getText();

        String dagData = "";
        String manedData = "";
        String arData = "";

        try {
            dagData = fodsel.substring(0,1);
            manedData = fodsel.substring(3,4);
            arData = fodsel.substring(6,9);
        }

        catch (StringIndexOutOfBoundsException e) {
            txtDato.setText("Du må skrive på riktig format");
        }

        int alder = 0;

        try {
            int dag = Integer.parseInt(dagData);
        }
        catch (IllegalArgumentException e){
            txtDato.setText("Du må skrive et gyldig heltall til dag");
            infoStemmer = false;
        }

        try {
            int maned = Integer.parseInt(manedData);
        }
        catch (IllegalArgumentException e){
            txtDato.setText("Du må skrive et gyldig heltall til maned");
            infoStemmer = false;
        }

        try {
            int ar = Integer.parseInt(arData);
        }
        catch (IllegalArgumentException e){
            txtDato.setText("Du må skrive et gyldig heltall til år");
            infoStemmer = false;
        }


        try {
            alder = Integer.parseInt(txtAlder.getText());
        } catch (IllegalArgumentException e) {
            txtAlder.setText("Du må skrive et gyldig heltall på alder");
            infoStemmer = false;
        }

        if(infoStemmer){
            Person nyPerson = new Person(navn, alder, fodsel, epost, tlf);
            return nyPerson;
        }

        else {
            return null;
        }
    }

    private void resetTxtFields() {
        txtNavn.setText("");
        txtAlder.setText("");
        txtDato.setText("");
        txtEpost.setText("");
        txtTelefon.setText("");
    }

    public void tlfDataEdited(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void epostDataEdited(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void fodselDataEdited(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void alderDataEdited(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void navnDataEdited(TableColumn.CellEditEvent cellEditEvent) {
    }

}
