/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_faculty_interaction_2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Ishani
 */
public class LoginController implements Initializable {
       @FXML
    private Button btnloginadm;

    @FXML
    private Button btnloginfac;

    @FXML
    private Button btnloginstd;

    @FXML
    private PasswordField txtpass;

    @FXML
    private TextField txtuname;
    
    Connection con = dbConnect.getConnect();
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    void loginadm(ActionEvent event) {
        String uname= txtuname.getText();
        String pass = txtpass.getText();
        
        if(uname.equals("") && pass.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Username or Password Blank");
        }
        else
        {
            try {
                pst=con.prepareStatement("select * from loginadm where username=? and password=?");
                
                pst.setString(1, uname);
                pst.setString(2, pass);
                
                rs= pst.executeQuery();
                
                if(rs.next())
                {
                    try {
                        Parent parent = FXMLLoader.load(getClass().getResource("Admin.fxml"));
                        Scene scene =new Scene(parent);
                        Stage stage= new Stage();
                        stage.setScene(scene);
                        stage.setTitle("Admin");
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Login Failed! Username or Password Incorrect.");
                    txtuname.setText("");
                    txtpass.setText("");
                    txtuname.requestFocus();
                }
                
                
            } 
            catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @FXML
    void loginfac(ActionEvent event) {
         String uname= txtuname.getText();
        String pass = txtpass.getText();
        
        if(uname.equals("") && pass.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Username or Password Blank");
        }
        else
        {
            try {
                pst=con.prepareStatement("select * from loginfac where username=? and password=?");
                
                pst.setString(1, uname);
                pst.setString(2, pass);
                
                rs= pst.executeQuery();
                
                if(rs.next())
                {
                     try {
                        Parent parent = FXMLLoader.load(getClass().getResource("Faculty.fxml"));
                        Scene scene =new Scene(parent);
                        Stage stage= new Stage();
                        stage.setScene(scene);
                        stage.setTitle("Faculty");
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Login Failed! Username or Password Incorrect.");
                    txtuname.setText("");
                    txtpass.setText("");
                    txtuname.requestFocus();
                }
                
                
            } 
            catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @FXML
    void loginstd(ActionEvent event) {
         String uname= txtuname.getText();
        String pass = txtpass.getText();
        
        if(uname.equals("") && pass.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Username or Password Blank");
        }
        else
        {
            try {
                pst=con.prepareStatement("select * from loginstd where username=? and password=?");
                
                pst.setString(1, uname);
                pst.setString(2, pass);
                
                rs= pst.executeQuery();
                
                if(rs.next())
                {
                     try {
                        Parent parent = FXMLLoader.load(getClass().getResource("Student.fxml"));
                        Scene scene =new Scene(parent);
                        Stage stage= new Stage();
                        stage.setScene(scene);
                        stage.setTitle("Student");
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Login Failed! Username or Password Incorrect.");
                    txtuname.setText("");
                    txtpass.setText("");
                    txtuname.requestFocus();
                }
                
                
            } 
            catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
