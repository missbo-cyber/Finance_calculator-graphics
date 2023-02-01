package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class GoalsListController extends SceneController implements Initializable
{

    public ListView listgoals;
    ObservableList<String> goalsList = FXCollections.observableArrayList();
    public Label nickname;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        nickname.setText(getCurrentUsername());
        try {
            loadList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void loadList() throws SQLException {



        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financial_calculator?serverTimezone=UTC", "root", "password");

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM listofgoals WHERE user_id="+getActiveUserSessionID());

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        while(rs.next())
        {

            goalsList.add(rs.getString("name_of_goal") + ": " + String.valueOf(rs.getDouble("amount")));
        }
        listgoals.setItems(goalsList);




    }

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

}