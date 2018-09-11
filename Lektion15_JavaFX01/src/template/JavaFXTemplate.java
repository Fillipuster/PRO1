package template;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFXTemplate extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Template");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        // Enable to show grid lines:
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));

        pane.setVgap(10);
        pane.setHgap(10);

        Button btn = new Button("Hello World!");
        pane.add(btn, 0, 0, 1, 1);
        btn.setOnAction(event -> btnClick());
    }

    private void btnClick() {
        System.out.println("Hello World!");
    }

}
