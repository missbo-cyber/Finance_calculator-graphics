package sample;

import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.LineChart;
import javafx.fxml.FXML;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private LineChart<?, ?> linechart;
    @FXML
    private ImageView Img1;

    public void Dashboard(ActionEvent e){
        System.out.println("Dashboard");

    }
    public void Tables(ActionEvent e){
        System.out.println("Tables");

    }
    public void Goals(ActionEvent e){
        System.out.println("Goals");

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
