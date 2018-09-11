package gui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Kamp;
import model.Service;

public class MainApp extends Application {

    public static void main(String[] args) {
        Service.createSomeObjects();
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Spillerdeltagelse Administration");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private final Controller controller = new Controller();
    private TextField txfSted, txfTid;
    private DatePicker dpDato;
    private Button btnOpret, btnOpdater, btnFil;
    private ListView<Kamp> lvwKampe;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Column #0
        Label lblKampe = new Label("Kampe");
        pane.add(lblKampe, 0, 0);

        lvwKampe = new ListView<>();
        lvwKampe.setOnMouseClicked(event -> controller.lvwKampClick());
        pane.add(lvwKampe, 0, 1, 1, 6);

        // Column #1

        Label lblSted = new Label("Spillested");
        pane.add(lblSted, 1, 1);

        Label lblDato = new Label("Spilledato");
        pane.add(lblDato, 1, 2);

        Label lblTid = new Label("Spilletid");
        pane.add(lblTid, 1, 3);

        // Column #2

        txfSted = new TextField();
        pane.add(txfSted, 2, 1, 2, 1);

        dpDato = new DatePicker();
        pane.add(dpDato, 2, 2, 2, 1);

        txfTid = new TextField();
        pane.add(txfTid, 2, 3, 2, 1);

        btnOpret = new Button("Opret");
        btnOpret.setOnAction(event -> controller.btnOpretAction());
        pane.add(btnOpret, 2, 4);

        btnFil = new Button("Lav Fil");
        btnFil.setOnAction(event -> controller.btnFilAction());
        pane.add(btnFil, 2, 5);

        // Column #3

        btnOpdater = new Button("Opdater");
        btnOpdater.setOnAction(event -> controller.btnOpdaterAction());
        pane.add(btnOpdater, 3, 4);

        controller.update();
    }

    private class Controller {
        public void update() {
            lvwKampe.getItems().removeAll(lvwKampe.getItems());
            lvwKampe.getItems().addAll(Service.getKampe());
            System.out.println(Service.getKampe());
        }

        public void lvwKampClick() {
            Kamp selected = lvwKampe.getSelectionModel().getSelectedItem();
            if (selected != null) {
                txfSted.setText(selected.getSted());
                dpDato.setValue(selected.getDato());
                txfTid.setText(selected.getTid().toString());
            }
        }

        public void btnOpretAction() {
            String sted = txfSted.getText();
            LocalDate dato = dpDato.getValue();
            LocalTime tid = null;
            try {
                tid = LocalTime.parse(txfTid.getText());
            } catch (DateTimeParseException e) {
                System.out.println("Tidsformat ugyldigt. Prøv igen.");
                return;
            }

            Service.createKamp(sted, dato, tid);

            update();
        }

        public void btnOpdaterAction() {
            Kamp selected = lvwKampe.getSelectionModel().getSelectedItem();
            if (selected != null) {
                String sted = txfSted.getText();
                LocalDate dato = dpDato.getValue();
                LocalTime tid = null;
                try {
                    tid = LocalTime.parse(txfTid.getText());
                } catch (DateTimeParseException e) {
                    System.out.println("Tidsformat ugyldigt. Prøv igen.");
                    return;
                }
                Service.updateKamp(selected, sted, dato, tid);
            }

            update();
        }

        public void btnFilAction() {
            Kamp selected = lvwKampe.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.spillerHonorar(selected.getSted());
            }
        }
    }

}
