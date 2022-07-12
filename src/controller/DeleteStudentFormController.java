package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteStudentFormController {
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

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        try{
            if (SQLUtil.executeUpdate("DELETE FROM Student WHERE student_id=?",txtId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
                clear();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }

        }catch (SQLException | ClassNotFoundException e){

        }
    }
    public void clear() throws SQLException, ClassNotFoundException {
        txtId.clear();
        txtName.clear();
        txtEmail.clear();
        txtContact.clear();
        txtAddress.clear();
        txtNic.clear();
    }
}
