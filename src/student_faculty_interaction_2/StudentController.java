/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_faculty_interaction_2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishani
 */
public class StudentController implements Initializable {

    @FXML
    private Button btnask;

    @FXML
    private Button btnprev;

    @FXML
    void askdoubt(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("askDoubt.fxml"));
            Scene scene =new Scene(parent);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.setTitle("Ask Doubts");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void prevdoubts(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("prevDoubts.fxml"));
            Scene scene =new Scene(parent);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.setTitle("Previous Doubts");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
