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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Ishani
 */
public class PrevDoubtsController implements Initializable {

    
    @FXML
    private TableView<doubtsAnswer> AnswerTable;

    @FXML
    private TableColumn<doubtsAnswer, String> answerCol;

    @FXML
    private TableColumn<doubtsAnswer, String> queryCol;

    @FXML
    private TableColumn<doubtsAnswer, String> statusCol;

    @FXML
    private TableColumn<doubtsAnswer, String> subCol;

    @FXML
    private TableColumn<doubtsAnswer, String> unameCol;
    
    String query = null;
    Connection connection = dbConnect.getConnect() ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Student student = null ;
    
    
    ObservableList<doubtsAnswer>  AnswerList = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ResultSet resultSet =connection.createStatement().executeQuery("select * from doubts");
            while(resultSet.next()){
                AnswerList.add(new doubtsAnswer(resultSet.getString("username"), resultSet.getString("subject"), resultSet.getString("query"), resultSet.getString("answer"), resultSet.getString("status")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FacultyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        unameCol.setCellValueFactory(new PropertyValueFactory("username"));
        subCol.setCellValueFactory(new PropertyValueFactory("subject"));
        queryCol.setCellValueFactory(new PropertyValueFactory("doubt"));
        answerCol.setCellValueFactory(new PropertyValueFactory("answer"));
        statusCol.setCellValueFactory(new PropertyValueFactory("status"));
        
        AnswerTable.setItems(AnswerList);
    }    
}    
    

