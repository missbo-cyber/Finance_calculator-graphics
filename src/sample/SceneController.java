package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneController
{
    enum Scenes
    {
        DASHBOARD,
        TABLES,
        GOALS,
        LOGIN
    }

    private static int activeUserSessionID;
    private static String currentUsername;

    public static void setCurrentUsername(String currentUsername)
    {
        SceneController.currentUsername = currentUsername;
    }

    public static String getCurrentUsername()
    {
        return currentUsername;
    }

    public static void setActiveUserSessionID(int activeUserSessionID)
    {
        SceneController.activeUserSessionID = activeUserSessionID;
    }

    public static int getActiveUserSessionID()
    {
        return activeUserSessionID;
    }

    @FXML
    private void switchScene(ActionEvent event, Scenes sceneName) throws IOException
    {
        Parent parent;
        Scene newScene;

       switch (sceneName)
       {
           case DASHBOARD -> {
               parent   = FXMLLoader.load(getClass().getResource("dashboardPage.fxml"));
               newScene = new Scene(parent);

               break;
           }

           case TABLES -> {
               parent   = FXMLLoader.load(getClass().getResource("tablesPage.fxml"));
               newScene = new Scene(parent);

               break;
           }

           case GOALS -> {
               parent   = FXMLLoader.load(getClass().getResource("goalsPage.fxml"));
               newScene = new Scene(parent);
               break;
           }

           case LOGIN -> {
               parent   = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
               newScene = new Scene(parent);
               break;
           }

           default -> throw new IllegalStateException("Unexpected value: " + sceneName);
       }

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }

    @FXML
    public void changeSceneToDashboard(ActionEvent event) throws IOException
    {
        switchScene(event,Scenes.DASHBOARD);
    }

    @FXML
    public void changeSceneToTables(ActionEvent event) throws IOException
    {
        switchScene(event,Scenes.TABLES);
    }

    @FXML
    public void changeSceneToGoals(ActionEvent event) throws IOException
    {
        switchScene(event,Scenes.GOALS);
    }

    @FXML
    public  void changeSceneToLogin(ActionEvent event) throws IOException
    {
        switchScene(event,Scenes.LOGIN);
    }

}
