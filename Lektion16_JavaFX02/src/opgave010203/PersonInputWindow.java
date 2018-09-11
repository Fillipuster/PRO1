package opgave010203;

import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInputWindow extends Stage {

    public PersonInputWindow(String title, Stage owner) {
        initOwner(owner);
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setMinHeight(100);
        setMinWidth(200);
        setResizable(false);

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    private TextField nameTxtF;
    private TextField titleTxtF;
    private CheckBox seniorCBox;
    private Person outPerson = null;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label nameLbl = new Label("Name:");
        pane.add(nameLbl, 0, 0);

        nameTxtF = new TextField();
        pane.add(nameTxtF, 1, 0);

        Label titleLbl = new Label("Title:");
        pane.add(titleLbl, 0, 1);

        titleTxtF = new TextField();
        pane.add(titleTxtF, 1, 1);

        seniorCBox = new CheckBox("Senior");
        pane.add(seniorCBox, 0, 2);

        Button addBtn = new Button("Add Person");
        pane.add(addBtn, 2, 2);
        addBtn.setOnAction(event -> addBtnAction());
    }

    private void addBtnAction() {

        String name = nameTxtF.getText();
        String title = titleTxtF.getText();

        if (name.length() < 1) {
            Dialog<String> dialog = new TextInputDialog();
            dialog.setTitle("Name Input");
            dialog.setHeaderText("What is the name of the person?");
            Optional<String> input = dialog.showAndWait();
            if (input.isPresent()) {
                name = input.get();
            }
        }

        if (title.length() < 1) {
            Dialog<String> dialog = new TextInputDialog();
            dialog.setTitle("Title Input");
            dialog.setHeaderText("What is the title of the person?");
            Optional<String> input = dialog.showAndWait();
            if (input.isPresent()) {
                title = input.get();
            }
        }

        outPerson = new Person((name.length() > 0) ? name : "N/A", (title.length() > 0) ? title : "N/A",
                seniorCBox.isSelected());

        hide();

    }

    public Person getPerson() {
        return outPerson;
    }

}
