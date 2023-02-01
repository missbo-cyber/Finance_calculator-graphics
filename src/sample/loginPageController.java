package sample;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;


public class loginPageController extends SceneController implements Initializable
{
    public TextField usernameField;
    public TextField passwordField;
    public Button loginButton;
    public CheckBox newUserCheck;

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
        new Expense(LocalDate.of(2023, Month.JANUARY,28), 100,200,300);
    }

    public void tryLogin(ActionEvent event)
    {

        errorVisual();
        if(newUserCheck.isSelected())
        {
            checkLogin();
        }
        else
        {
            registerNew();
        }
    }

    private void registerNew()
    {

    }

    private boolean checkLogin()
    {
        return true;
    }

    private void errorVisual()
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.3), loginButton);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();

        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.3), loginButton);
        fadeTransition2.setFromValue(0.0);
        fadeTransition2.setToValue(1.0);
        fadeTransition2.setCycleCount(1);
        fadeTransition2.play();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
