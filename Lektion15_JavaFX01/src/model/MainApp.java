package model;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private TextField txt1;
    private TextField txt2;
    private TextField txt3;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    // Sets the title of the window.
    public void start(Stage stage) {
        stage.setTitle("Test");

        // Creates the content basis (panel) of the window.
        GridPane pane = new GridPane();

        // Initializes the pane (panel).
        initContent(pane);

        // Creates the scene.
        Scene scene = new Scene(pane);

        // Sets the stage's active scene to our newly created scene. (the stage is the
        // outermost layer of the JavaFX GUI stack.
        stage.setScene(scene);

        // Shows our stage.
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));

        pane.setHgap(10);
        pane.setVgap(10);

        txt1 = new TextField();
        pane.add(txt1, 0, 0, 1, 1);

        txt2 = new TextField();
        pane.add(txt2, 1, 0, 1, 1);

        txt3 = new TextField();
        pane.add(txt3, 0, 1, 2, 1);

        Button btn = new Button("Concatenate");
        pane.add(btn, 0, 2, 1, 1);
        btn.setOnAction(event -> btnClick());
    }

    private void btnClick() {
        txt3.setText(txt1.getText() + " " + txt2.getText());
        txt3.setEditable(false);
    }
}
