package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GoalsController extends SceneController implements Initializable
{

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

    }

//    private void iniLineChart() throws SQLException {
//
//
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?serverTimezone=UTC", "root", "password");
//
//        Statement stmt = connection.createStatement();
//
//        ResultSet rs = stmt.executeQuery("SELECT date_of_expense, bills FROM usertable");
//
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//
//
//        XYChart.Series series = new XYChart.Series();
//
//
//        while(rs.next()) {
//            series.getData().add(new XYChart.Data(rs.getString("date_of_expense"), rs.getDouble("bills")));
//        }
//
//        linechart.getData().add(series);





   // }
//}
}
