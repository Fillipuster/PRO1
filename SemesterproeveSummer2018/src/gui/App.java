package gui;

import java.time.LocalDate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.PraktikVirksomhed;
import service.Service;
import storage.Storage;

public class App extends Application {

    public static void initialize() {
        Service.initStorage();

        PraktikVirksomhed v = Storage.getPraktikVirksomheds().get(0);

        System.out.println("Tester for virksomhed: " + v.getNavn());
        System.out.println();
        System.out.println("Skriver kontrakt-fil...");
        v.skrivTilFilKontrakter();
        System.out.println("Kontrakt-fil skrevet.");
        System.out.println();
        System.out.println("Kontrakter (usorteret):");
        System.out.println(v.getPraktikKontrakts());
        System.out.println();
        System.out.println("Kontrakter (sorteret):");
        System.out.println(v.sorterKontrakter());
        System.out.println();
        LocalDate testStart = LocalDate.of(2018, 2, 1);
        LocalDate testSlut = LocalDate.of(2018, 7, 1);
        System.out.println("Antal ugentlige timer mellem " + testStart + " og " + testSlut + ":");
        System.out.println(v.getTotalAntalugentligeTimerIPeriode(testStart, testSlut));
        System.out.println();
        System.out.println("Mest eftertragtet virksomhed i semester 5:");
        System.out.println(Service.getEftertragtetSemesterVirksomhed(5));
        System.out.println();
    }

    public static void main(String[] args) {
        initialize();
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Administration af Praktikvirksomheder");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private Controller controller = new Controller();
    private TextField txfNavn, txfFeedback, txfKontakt;
    private Button btnAdd, btnUpdate;
    private ListView<PraktikVirksomhed> lvwVirksomheds;

    public void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Column #0
        controller.dymo(pane, 0, 1, "Navn:");
        controller.dymo(pane, 0, 2, "Feedback:");
        controller.dymo(pane, 0, 3, "Kontakt:");

        btnAdd = new Button("Add");
        btnAdd.setOnAction(event -> controller.btnAddAction());
        pane.add(btnAdd, 0, 4);

        btnUpdate = new Button("Update");
        btnUpdate.setOnAction(event -> controller.btnUpdateAction());
        pane.add(btnUpdate, 0, 5);

        // Column #1
        controller.dymo(pane, 1, 0, "Praktikvirksomhed:");

        txfNavn = new TextField("Navn");
        pane.add(txfNavn, 1, 1);

        txfFeedback = new TextField("Feedback");
        pane.add(txfFeedback, 1, 2);

        txfKontakt = new TextField("Kontakt");
        pane.add(txfKontakt, 1, 3);

        // Column #2
        controller.dymo(pane, 2, 0, "Praktikvirksomheder:");

        lvwVirksomheds = new ListView<>();
        pane.add(lvwVirksomheds, 2, 1, 1, 6);
        controller.lvwVirksomhedsUpdate();
        lvwVirksomheds.setOnMouseClicked(event -> controller.lvwVirksomhedsClick());
    }

    private class Controller {
        public Label dymo(GridPane pane, int x, int y, String text) {
            Label lbl = new Label(text);
            pane.add(lbl, x, y);

            return lbl;
        }

        public void btnAddAction() {
            Service.createPraktikVirksomhed(txfNavn.getText(), txfFeedback.getText(), txfKontakt.getText());
            lvwVirksomhedsUpdate();
        }

        public void btnUpdateAction() {
            PraktikVirksomhed selected = lvwVirksomheds.getSelectionModel().getSelectedItem();

            if (selected != null) {
                Service.updatePraktikVirksomhed(selected, txfNavn.getText(), txfFeedback.getText(),
                        txfKontakt.getText());
                lvwVirksomhedsUpdate();
            }
        }

        public void lvwVirksomhedsUpdate() {
            int selected = lvwVirksomheds.getSelectionModel().getSelectedIndex();

            lvwVirksomheds.getItems().removeAll(lvwVirksomheds.getItems());
            lvwVirksomheds.getItems().setAll(Storage.getPraktikVirksomheds());

            lvwVirksomheds.getSelectionModel().select(selected);
        }

        public void lvwVirksomhedsClick() {
            PraktikVirksomhed selected = lvwVirksomheds.getSelectionModel().getSelectedItem();

            if (selected != null) {
                txfNavn.setText(selected.getNavn());
                txfFeedback.setText(selected.getFeedback());
                txfKontakt.setText(selected.getKontaktPerson());
            }
        }
    }

}
