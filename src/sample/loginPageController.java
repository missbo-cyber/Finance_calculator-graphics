package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
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

    public void tryLogin(ActionEvent event) throws SQLException, IOException
    {


        if(!newUserCheck.isSelected())
        {
            if(!checkLogin())
            {
                errorVisual();
            }
            else
            {

                changeSceneToDashboard(event);
            }
        }
        else
        {
            if(!registerNew())
            {
                errorVisual();
            }
            else
            {
                usernameField.setText("");
                passwordField.setText("");
            }
        }
    }

    private boolean registerNew() throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financial_calculator?serverTimezone=UTC", "root", "password");

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT username, password FROM users");

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());


        while(rs.next())
        {
            if(rs.getString("username").equals(usernameField.getText()))
            {
               return false;
            }
        }
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) return false;

        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, usernameField.getText());
        preparedStatement.setString(2, passwordField.getText());
        preparedStatement.executeUpdate();


        return true;
    }

    private boolean checkLogin() throws SQLException
    {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financial_calculator?serverTimezone=UTC", "root", "password");

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());


        while(rs.next())
        {
            if(rs.getString("username").equals(usernameField.getText()))
            {
                if(rs.getString("password").equals(passwordField.getText()))
                {
                    setActiveUserSessionID(rs.getInt("usernameID"));
                    setCurrentUsername(rs.getString("username"));
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }





        return false;
    }

    private void errorVisual()
    {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.3), loginButton);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();

        Timeline colorChange = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new KeyValue(loginButton.styleProperty(), "-fx-background-color: #F3ABB5;")),
                new KeyFrame(Duration.seconds(0.3),
                        new KeyValue(loginButton.styleProperty(), "-fx-background-color: #ff8198;")));
        colorChange.play();

        Timeline colorChange2 = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new KeyValue(loginButton.styleProperty(), "-fx-background-color: #ff8198;")),
                new KeyFrame(Duration.seconds(0.3),
                        new KeyValue(loginButton.styleProperty(), "-fx-background-color: #F3ABB5;")));
        colorChange2.play();

        FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(0.4), loginButton);
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
