package javafx_hw3;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFx_HW33 extends Application {

    private HBox hbox;
    private Label lblChk, lblID, lblFullName;
    private Separator separator;
    private Button btnAddNew;
    public static VBox root;
    public static ArrayList<AddNewRecord> list;
    private int arrayListIndex, recordIndex;
    private EventHandler<ActionEvent> handler;
    private EventHandler<ActionEvent> filter;

    @Override
    public void init() {
        handler = e -> OnAddNewRecordHandler(e);
        filter = e -> OnAddNewRecordFilter(e);

        lblChk = new Label("✘");

        lblID = new Label("ID\t    ");

        lblFullName = new Label("Full Name\t\t\t\t\t ");

        separator = new Separator();

        btnAddNew = new Button("Add New");
        btnAddNew.setPrefSize(100, 25);
        btnAddNew.setDefaultButton(true);
        btnAddNew.addEventHandler(ActionEvent.ACTION, handler);

        hbox = new HBox(lblChk, lblID, lblFullName, btnAddNew);
        hbox.setSpacing(20);

        root = new VBox(hbox, separator);
        root.setPadding(new Insets(50));
        root.setSpacing(5);

        arrayListIndex = 0;
        recordIndex = 0;
        list = new ArrayList<AddNewRecord>();

    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.addEventFilter(ActionEvent.ACTION, filter);

        for (int i = 0; i < 4; i++) {
            OnAddNewRecordHandler(null);
        }
        Scene scene = new Scene(root);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setWidth(515);
        primaryStage.setHeight(345);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void OnAddNewRecordHandler(ActionEvent e) {
        list.add(new AddNewRecord(arrayListIndex));
        root.getChildren().add(list.get(arrayListIndex).GetHBoxNode());
        arrayListIndex++;
        recordIndex++;
    }

    private void OnAddNewRecordFilter(ActionEvent e) {

        if (e.getSource() instanceof Stage) {
            Stage filteredStage = (Stage) e.getSource();
            if (e.getTarget() instanceof Button) {
                if (((Button) e.getTarget()).getText().equals("Add New")) {
                    if (recordIndex > 5) {
                        filteredStage.setHeight((filteredStage.getHeight()) + 30);
                    }
                } else {
                    if (((Button) e.getTarget()).getText().equals("Delete")) {
                        if (recordIndex > 6) {
                            filteredStage.setHeight(filteredStage.getHeight() - 30);
                            recordIndex--;
                        } else {
                            recordIndex--;
                        }
                    }
                }
            }
        }
    }
}
