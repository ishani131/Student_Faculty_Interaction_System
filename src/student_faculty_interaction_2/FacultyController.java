/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_faculty_interaction_2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ishani
 */
public class FacultyController implements Initializable {

    @FXML
    private TableView<Doubts> facultyTable;

    @FXML
    private TableColumn<Doubts, String> answerCol;

    @FXML
    private TableColumn<Doubts, String> queryCol;

    @FXML
    private TableColumn<Doubts, String> subCol;

    @FXML
    private TableColumn<Doubts, String> unameCol;


    String query = null;
    Connection connection = dbConnect.getConnect();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Student student = null;

    ObservableList<Doubts> doubtList = FXCollections.observableArrayList();

    ArrayList<String> answerlist = new ArrayList<String>();

    public void handleButtonAction(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("Answer.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Add Answer");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            ResultSet resultSet = connection.createStatement().executeQuery("select * from doubts where status=\"Pending\"");
            while (resultSet.next()) {
                Doubts d=new Doubts(resultSet.getString("username"), resultSet.getString("subject"), resultSet.getString("query"));
                Button btn=d.getButton();
                d.button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        data dat=new data();
                        dat.setuname(d.username);
                        Parent parent = FXMLLoader.load(getClass().getResource("Answer.fxml"));
                        Scene scene =new Scene(parent);
                        Stage stage= new Stage();
                        stage.setUserData(dat);
                        stage.setScene(scene);
                        stage.setTitle("Add Answer");
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        });
                doubtList.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }

        unameCol.setCellValueFactory(new PropertyValueFactory("username"));
        subCol.setCellValueFactory(new PropertyValueFactory("subject"));
        queryCol.setCellValueFactory(new PropertyValueFactory("doubt"));
        answerCol.setCellValueFactory(new PropertyValueFactory("button"));


        facultyTable.setItems(doubtList);
}    
}   
