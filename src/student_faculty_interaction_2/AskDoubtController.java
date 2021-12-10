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
public class AskDoubtController implements Initializable {

    @FXML
    private Button btnsubmit;

    @FXML
    private TextField sub;

    @FXML
    private TextField uname;
    
    @FXML
    private TextArea doubt;

    
    String query1=null;
    Connection connection = dbConnect.getConnect();
    ResultSet resultSet=null;
    PreparedStatement preparedStatement1;
    PreparedStatement preparedStatement2;
    admin admin=null;
    
    @FXML
    void submit(ActionEvent event) {
        String username = uname.getText();
        String subj = sub.getText();
        String doubts = doubt.getText();
        
        if (username.isEmpty() || subj.isEmpty() || doubts.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Enter all fields");

        } else {
            getQuery();
            insert();
            JOptionPane.showMessageDialog(null,"Query Sent to Faculty");

        }
    }
    
    private void getQuery() {

            query1 = "INSERT INTO `doubts`( `username`,`subject`,`query`,`answer`,`status`) VALUES (?,?,?,?,?)";
    }
    
    private void insert() {

        try {

            preparedStatement1 = connection.prepareStatement(query1);
            preparedStatement1.setString(1, uname.getText());
            preparedStatement1.setString(2, sub.getText());
            preparedStatement1.setString(3, doubt.getText());
            preparedStatement1.setString(4, "Null");
            preparedStatement1.setString(5, "Pending");
            preparedStatement1.execute();
            

        } catch (SQLException ex) {
            Logger.getLogger(AddStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
