package controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class DashboardFormController {

    public AnchorPane dashboard;

    public void addOnAction(ActionEvent actionEvent) throws IOException {
        setUi("manage-student-form");
    }

    public void deleteOnAction(ActionEvent actionEvent) throws IOException {
        setUi("delete-student-form");
    }

    public void updateOnAction(ActionEvent actionEvent) throws IOException {
        setUi("update-student-form");
    }

    public void loadAllOnAction(ActionEvent actionEvent) throws IOException {
        setUi("all-student-form");
    }
    private void setUi(String URI) throws IOException {
        Parent parent  =FXMLLoader.load(getClass().getResource("../view/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }

}
