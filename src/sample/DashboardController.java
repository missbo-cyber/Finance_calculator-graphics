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

        iniLineChart();


    }



    private void iniLineChart(){
        XYChart.Series series = new XYChart.Series();

        series.getData().add(new XYChart.Data("Monday",8));
        series.getData().add(new XYChart.Data("Tuesday",13));
        series.getData().add(new XYChart.Data("Wednesday",15));
        series.getData().add(new XYChart.Data("Thursday",17));
        series.getData().add(new XYChart.Data("Friday",20));
        series.getData().add(new XYChart.Data("Saturday",22));
        series.getData().add(new XYChart.Data("Sunday",25));

        linechart.getData().addAll(series);

    }
}