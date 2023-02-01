package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class DashboardController extends SceneController implements Initializable
{
    @FXML
    private LineChart<?, ?> linechart;


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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        try
        {
            iniLineChart();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }


    }



    private void iniLineChart() throws SQLException
    {


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/financial_calculator?serverTimezone=UTC", "root", "password");

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT date_of_expense, bills FROM expensestable");

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());


        XYChart.Series series = new XYChart.Series();




        while(rs.next()) {
            series.getData().add(new XYChart.Data(rs.getString("date_of_expense"), rs.getDouble("bills")));
        }

        linechart.getData().add(series);

    }
}
