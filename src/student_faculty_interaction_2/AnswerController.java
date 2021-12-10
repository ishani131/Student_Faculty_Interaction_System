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
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ishani
 */
public class AnswerController implements Initializable {

    @FXML
    private TextArea ansfield;

    @FXML
    private Button btnsubmit;
    
    String query1=null;
    Connection connection = dbConnect.getConnect();
    ResultSet resultSet=null;
    PreparedStatement preparedStatement1;
    admin admin=null;

    @FXML
    void submit(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        data u = (data) stage.getUserData();
        System.out.println(u.getUname());
        try {

            preparedStatement1 = connection.prepareStatement("UPDATE `doubts` SET `answer` = ?,`status` = ? WHERE username=? ");
            preparedStatement1.setString(1, ansfield.getText());
            preparedStatement1.setString(2, "Solved");
            preparedStatement1.setString(3, u.getUname());
            preparedStatement1.execute();
            JOptionPane.showMessageDialog(null,"Query answered");

        } catch (SQLException ex) {
            Logger.getLogger(AddStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
