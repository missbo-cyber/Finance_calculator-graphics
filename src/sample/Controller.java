package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private LineChart<?, ?> linechart;


    @FXML
    private Button dshbButton;

    @FXML
    private Button golButton;

    @FXML
    private Button tblButton;



    @FXML
    void Dashboard(ActionEvent event)
    {
        System.out.println("AASASda");
    }

    @FXML
    void Goals(ActionEvent event)
    {

    }

    @FXML
    void Tables(ActionEvent event)
    {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
