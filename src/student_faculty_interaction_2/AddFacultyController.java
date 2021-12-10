/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_faculty_interaction_2;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ishani
 */
public class AddFacultyController implements Initializable {

    @FXML
    private TextArea address;

    @FXML
    private Button btnaddfac;

    @FXML
    private TextField dept;

    @FXML
    private TextField email;

    @FXML
    private TextField gender;

    @FXML
    private TextField mobno;

    @FXML
    private TextField name;

    @FXML
    private TextField pass;

    @FXML
    private TextField uname;
    
    String query1=null;
    String query2=null;
    Connection connection = dbConnect.getConnect();
    ResultSet resultSet=null;
    PreparedStatement preparedStatement1;
    PreparedStatement preparedStatement2;
    Faculty faculty=null;

    @FXML
    void addfacdb(ActionEvent event) {
        String username = uname.getText();
        String password = pass.getText();
        String stdname = name.getText();
        String emailid = email.getText();
        String department = dept.getText();
        String gendr = gender.getText();
        String addr = address.getText();
        String mobn = mobno.getText();

        if (username.isEmpty() || password.isEmpty() || stdname.isEmpty() || emailid.isEmpty() || department.isEmpty()|| gendr.isEmpty()|| addr.isEmpty()|| mobn.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Enter all fields");

        } else {
            getQuery();
            insert();
            JOptionPane.showMessageDialog(null,"Faculty Info Added");

        }
    }
    
    private void getQuery() {

            query1 = "INSERT INTO `faculty`( `username`,`password`,`Name`,`email_id`,`gender`,`department`,`address`,`mob_no`) VALUES (?,?,?,?,?,?,?,?)";
            query2= "INSERT INTO `loginfac`(`username`,`password`) VALUES(?,?)";
    }
    
    private void insert() {

        try {

            preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setString(1, uname.getText());
            preparedStatement1.setString(2, pass.getText());
            preparedStatement1.setString(3, name.getText());
            preparedStatement1.setString(4, email.getText());
            preparedStatement1.setString(5, dept.getText());
            preparedStatement1.setString(6, gender.getText());
            preparedStatement1.setString(7, address.getText());
            preparedStatement1.setString(8, mobno.getText());
            preparedStatement1.execute();
            
            preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setString(1, uname.getText());
            preparedStatement2.setString(2, pass.getText());
            preparedStatement2.execute();

        } catch (SQLException ex) {
            Logger.getLogger(AddStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
