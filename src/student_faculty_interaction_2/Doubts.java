/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_faculty_interaction_2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Ishani
 */
public class Doubts {
    String username;
    String subject;
    String doubt;
    Button button;

    public Doubts(String username, String subject, String doubt) {
        this.username = username;
        this.subject = subject;
        this.doubt = doubt;
        this.button = new Button("Answer");
        
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDoubt() {
        return doubt;
    }

    public void setDoubt(String doubt) {
        this.doubt = doubt;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    
    
}