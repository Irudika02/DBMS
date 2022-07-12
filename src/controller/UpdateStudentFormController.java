package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import module.Student;
import util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateStudentFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtNic;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        ResultSet result = null;
        try {
            result = SQLUtil.executeQuery("SELECT * FROM Student WHERE student_id=?",txtId.getText());
            if (result.next()) {
                txtName.setText(result.getString(2));
                txtEmail.setText(result.getString(3));
                txtContact.setText(result.getString(4));
                txtAddress.setText(result.getString(5));
                txtNic.setText(result.getString(6));

            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Student s = new Student(
                txtId.getText(),txtName.getText(),txtEmail.getText(),txtContact.getText(),txtAddress.getText(),txtNic.getText()
        );

        try {
            boolean update = SQLUtil.executeUpdate("UPDATE Student SET student_name = ?,email =? ,contact =?,address =?, nic =? WHERE student_id =?",s.getStudent_name(),s.getEmail(),s.getContact(),s.getAddress(),s.getNic(),s.getStudent_id());
            if (update){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            }else{
            new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
