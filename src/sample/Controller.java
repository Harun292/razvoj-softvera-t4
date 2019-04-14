package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField polje;
    public TextField polje2;
    public ChoiceBox<Artikal> artikalCB;
    public TextArea iznospolje;
    public Spinner kolicina;
    public Button dodaj;
    public Button dodaj1;
    private Racun racun;
    private ArrayList<Artikal> result;
    private ObservableList<Artikal> lista = FXCollections.observableArrayList();




    public void dodaj(ActionEvent actionEvent) {
        String source = polje.getText();
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
        polje2.setText(rezultat);
        racun = new Racun();
        result= new ArrayList<>(kanta);
        lista.addAll(result);
        artikalCB.setItems(lista);
    }

    public void dodajNaRacun(ActionEvent actionEvent) {
        racun.dodajStavku(artikalCB.getSelectionModel().getSelectedItem(),
                (Integer)kolicina.getValue());
        iznospolje.setText(racun.toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}