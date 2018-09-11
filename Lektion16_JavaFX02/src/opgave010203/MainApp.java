package opgave010203;

import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person List App");
        GridPane pane = new GridPane();
        initContent(pane);

        personWindow = new PersonInputWindow("Person Information", stage);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private ArrayList<Person> people = new ArrayList<>();
    private ListView<String> peopleLView;
    private final Controller controller = new Controller();
    private PersonInputWindow personWindow;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label peopleLbl = new Label("People:");
        pane.add(peopleLbl, 0, 0);

        peopleLView = new ListView<>();
        pane.add(peopleLView, 0, 1);

        Button addBtn = new Button("Add Person");
        pane.add(addBtn, 2, 2);

        addBtn.setOnAction(event -> controller.addBtnAction());
    }

    private class Controller {
        public void addBtnAction() {
            personWindow.showAndWait();
            if (personWindow.getPerson() != null) {
                Person pers = personWindow.getPerson();
                people.add(pers);
                peopleLView.getItems().add(pers.toString());
            }
        }
    }

}
