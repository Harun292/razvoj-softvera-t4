package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextArea sourceField;
    public TextArea destinationField;
    public ChoiceBox<Artikal> artikalChoiceBox;
    public TextArea iznosArea;
    public Spinner kolicinaSpinner;
    private Racun racun;
    private ArrayList<Artikal> result;
    private ObservableList<Artikal> lista = FXCollections.observableArrayList();




    public void dodaj(ActionEvent actionEvent) {
        String source = sourceField.getText();
        String[] artikli = source.split("\n");
        ArrayList<Artikal> kanta = new ArrayList<>();
        for (String element : artikli) {
            kanta.add(new Artikal(element));
        }
        kanta = Artikal.izbaciDuplikate(kanta);
        String rezultat = "";
        for (Artikal element : kanta) {
            rezultat += element + "\n";
        }
        destinationField.setText(rezultat);
        racun = new Racun();
        result= new ArrayList<>(kanta);
        lista.addAll(result);
        artikalChoiceBox.setItems(lista);
    }

    public void dodajNaRacun(ActionEvent actionEvent) {
        racun.dodajStavku(artikalChoiceBox.getSelectionModel().getSelectedItem(),
                (Integer) kolicinaSpinner.getValue());
        iznosArea.setText(racun.toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}