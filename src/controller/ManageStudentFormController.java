package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import module.Student;
import util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageStudentFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtNic;

    public void initialize() throws SQLException, ClassNotFoundException {
        getId();
    }
    public void  getId() throws SQLException, ClassNotFoundException {
        ResultSet pet = SQLUtil.executeQuery("SELECT student_id FROM Student ORDER BY student_id DESC LIMIT 1");
        if (pet.next()){
            String r = pet.getString("student_id");
            int co = r.length();
            String txt = r.substring(0,3);
            String num = r.substring(3,co);
            int n = Integer.parseInt(num);
            n++;
            String snum = Integer.toString(n);
            String fxt = txt + snum;
            txtId.setText(fxt);
        }else{
            txtId.setText("S001");
        }
    }
    public void btnSaveOnAction(ActionEvent actionEvent) {
        Student s = new Student(
          txtId.getText(),txtName.getText(),txtEmail.getText(),txtContact.getText(),txtAddress.getText(),txtNic.getText()
        );
        try {
            if (SQLUtil.executeUpdate("INSERT INTO Student VALUES (?,?,?,?,?,?)",s.getStudent_id(),s.getStudent_name(),s.getEmail(),s.getContact(),s.getAddress(),s.getNic())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
                clear();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    public void clear() throws SQLException, ClassNotFoundException {
        txtId.clear();
        txtName.clear();
        txtEmail.clear();
        txtContact.clear();
        txtAddress.clear();
        txtNic.clear();
        getId();
    }
}
