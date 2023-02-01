package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class GoalsController extends SceneController implements Initializable

{
    public javafx.scene.control.TextField definetextfield;
    public javafx.scene.control.TextField amounttextfield;
    public Label nickname;




    @Override
    public void changeSceneToTables(ActionEvent event) throws IOException
    {
        super.changeSceneToTables(event);
    }

    @Override
    public void changeSceneToDashboard(ActionEvent event) throws IOException
    {
        super.changeSceneToDashboard(event);
    }

    @Override
    public void changeSceneToGoals(ActionEvent event) throws IOException
    {
        super.changeSceneToGoals(event);
    }

    @FXML
    public  void changeSceneToLogin(ActionEvent event) throws IOException
    {
        super.changeSceneToLogin(event);
    }


    public void addgoal(ActionEvent event) throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financial_calculator?serverTimezone=UTC", "root", "password");

        Statement stmt = connection.createStatement();


        String query = "INSERT INTO listofgoals (name_of_goal, amount, user_id) VALUES ('" + definetextfield.getText()+"',"+ amounttextfield.getText() + "," + getActiveUserSessionID() +")";

        stmt.executeUpdate(query);


        definetextfield.setText("");
        amounttextfield.setText("");


    }

    public void seeyourgoals(ActionEvent event) throws IOException, SQLException {




        Parent parent   = FXMLLoader.load(getClass().getResource("yourgoals.fxml"));
        Scene newScene = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();



    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        nickname.setText(getCurrentUsername());

    }





}