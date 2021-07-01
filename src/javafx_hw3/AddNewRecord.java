package javafx_hw3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class AddNewRecord {

    private TextField txtID, txtFullName;
    private CheckBox chkBox;
    private Button btnDelete;
    private HBox hbox;
    private int ID;
    private EventHandler<ActionEvent> handler, filter;

    public AddNewRecord(int id) {
        this.chkBox = new CheckBox();
        this.chkBox.setPrefHeight(25);

        this.txtID = new TextField();
        this.txtID.setPrefSize(50, 25);

        this.txtFullName = new TextField();
        this.txtFullName.setPrefSize(200, 25);

        this.handler = e1 -> OnDeleteRecord(e1);

        this.btnDelete = new Button("Delete");
        this.btnDelete.setPrefSize(100, 25);
        this.btnDelete.addEventHandler(ActionEvent.ACTION, handler);

        this.hbox = new HBox(chkBox, txtID, txtFullName, btnDelete);
        this.hbox.setSpacing(10);
        this.ID = id;
    }

    public Node GetHBoxNode() {
        return this.hbox;
    }

    public void OnDeleteRecord(ActionEvent e) {
        JavaFx_HW33.root.getChildren().remove(this.hbox);
    }
}
