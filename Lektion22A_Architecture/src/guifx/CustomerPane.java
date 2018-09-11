package guifx;

import java.util.ArrayList;

import application.model.Customer;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CustomerPane extends GridPane {
    private TextField txfName, txfAge;
    private ListView<Customer> lvwCustomers;

    public CustomerPane() {
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);
        setGridLinesVisible(false);

        Label lblCustomers = new Label("Customers");
        this.add(lblCustomers, 0, 0);

        lvwCustomers = new ListView<>();
        this.add(lvwCustomers, 0, 1, 1, 5);
        lvwCustomers.setPrefWidth(200);
        lvwCustomers.setPrefHeight(200);
        lvwCustomers.getItems().setAll(initAllCustomerList());
        ChangeListener<Customer> listener = (ov, oldCustomer, newCustomer) -> selectedCustomerChanged();
        lvwCustomers.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblName = new Label("Name:");
        this.add(lblName, 0, 2);

        txfName = new TextField();
        this.add(txfName, 0, 3);
        txfName.setEditable(false);

        Label lblAge = new Label("Age:");
        this.add(lblAge, 0, 4);

        txfAge = new TextField();
        this.add(txfAge, 0, 5);
        txfAge.setEditable(false);

        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Create");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> createAction());

        Button btnUpdate = new Button("Update");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> updateAction());

        Button btnDelete = new Button("Delete");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> deleteAction());

        if (lvwCustomers.getItems().size() > 0) {
            lvwCustomers.getSelectionModel().select(0);
        }
    }

    // TODO/WIP Where we left off...
    private void createAction() {
        // TODO: Implement - draw from EmployeePane.
    }

    private void updateAction() {
        // TODO: Implement - draw from EmployeePane.
    }

    private void deleteAction() {
        // TODO: Implement - draw from EmployeePane.
    }

    private ArrayList<Customer> initAllCustomerList() {
        ArrayList<Customer> list = new ArrayList<>();
        for (Customer customer : Service.getCustomers()) {
            list.add(customer);
        }
        return list;
    }

    private void selectedCustomerChanged() {
        updateControls();
    }

    public void updateControls() {
        Customer customer = lvwCustomers.getSelectionModel().getSelectedItem();
        if (customer != null) {
            txfName.setText(customer.getName());
            txfAge.setText("" + customer.getAge());
        } else {
            txfName.clear();
            txfAge.clear();
        }
    }
}
