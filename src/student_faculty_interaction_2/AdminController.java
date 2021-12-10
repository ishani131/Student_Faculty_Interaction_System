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
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Ishani
 */
public class AdminController implements Initializable {

    @FXML
    private Button btnaddadm;

    @FXML
    private Button btnaddfac;

    @FXML
    private Button btnaddstd;

    @FXML
    private Button btndeladm;

    @FXML
    private Button btndelfac;

    @FXML
    private Button btndelstd;

    @FXML
    void addAdmin(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("addAdmin.fxml"));
            Scene scene =new Scene(parent);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.setTitle("Add Admin");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AddStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void addFaculty(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("addFaculty.fxml"));
            Scene scene =new Scene(parent);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.setTitle("Add Faculty");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AddStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void addStudent(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("addStudent.fxml"));
            Scene scene =new Scene(parent);
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.setTitle("Add Student");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AddStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
