package com.example.kulb_lab1;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
public class HelloController implements Initializable {
    @FXML
    private TableView<coachAppointment> tableView;
    @FXML
    private TableColumn<coachAppointment, Integer> playerId;
    @FXML
    private TableColumn<coachAppointment, String> playerName;
    @FXML
    private TableColumn<coachAppointment, String> coachName;
    @FXML
    private TableColumn<coachAppointment, Integer> coachRoom;
    ObservableList<coachAppointment> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerId.setCellValueFactory(new
                PropertyValueFactory<coachAppointment, Integer>("playerId"));
        playerName.setCellValueFactory(new
                PropertyValueFactory<coachAppointment, String>("playerName"));
        coachName.setCellValueFactory(new
                PropertyValueFactory<coachAppointment, String>("coachName"));
        coachRoom.setCellValueFactory(new
                PropertyValueFactory<coachAppointment, Integer>("coachRoom"));
        tableView.setItems(list);
    }

    @FXML
    protected void onHelloButtonClick() {
        populateTable();
    }

    public void populateTable() {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/pc_lab1";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM footballCoach";
            Statement statement = ((java.sql.Connection) connection).createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int playerId = resultSet.getInt("playerId");
                String playerName = resultSet.getString("playerName");
                String coachName = resultSet.getString("coachName");
                int coachRoom = resultSet.getInt("coachRoom");
                tableView.getItems().add(new coachAppointment(playerId, playerName, coachName,
                        coachRoom));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}



