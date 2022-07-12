package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import module.Student;
import util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllStudentFormController {
    public TableView<Student> tblAllStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colNic;

    public void initialize() throws SQLException, ClassNotFoundException {
        colId.setCellFactory(new PropertyValueFactory<>("student_id"));
        colName.setCellFactory(new PropertyValueFactory<>("student_name"));
        colEmail.setCellFactory(new PropertyValueFactory<>("email"));
        colContact.setCellFactory(new PropertyValueFactory<>("contact"));
        colAddress.setCellFactory(new PropertyValueFactory<>("address"));
        colNic.setCellFactory(new PropertyValueFactory<>("nic"));

        loadAllStudent();
    }

    private void loadAllStudent() throws SQLException, ClassNotFoundException {
        ResultSet result = SQLUtil.executeQuery("SELECT * FROM Student");
        ObservableList<Student> obList = FXCollections.observableArrayList();

        while (result.next()){
            obList.add(
                    new Student(
                            result.getString("student_id"),
                            result.getString("student_name"),
                            result.getString("email"),
                            result.getString("contact"),
                            result.getString("address"),
                            result.getString("nic")
                    )
            );
        }
        tblAllStudent.setItems(obList);

    }

}
