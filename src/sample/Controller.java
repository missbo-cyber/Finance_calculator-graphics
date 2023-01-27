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
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private LineChart<?, ?> linechart;
    @FXML
    private ImageView Img1;
    @FXML
    private Button DashboardButton;

    private void handleDashboardButton(ActionEvent e){
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


        try {
            iniLineChart();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }



    private void iniLineChart() throws SQLException {


        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?serverTimezone=UTC", "root", "password");

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT date_of_expense, bills FROM usertable");

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());


        XYChart.Series series = new XYChart.Series();


        while(rs.next()) {
            series.getData().add(new XYChart.Data(rs.getString("date_of_expense"), rs.getDouble("bills")));
        }

        linechart.getData().add(series);





    }
}
