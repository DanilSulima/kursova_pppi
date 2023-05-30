package com.example.java_oop_kursova;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class profile extends DBhenler{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button2;

    @FXML
    private Label label;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Text text;

    @FXML
    void initialize() {
        assert back_button2 != null : "fx:id=\"back_button2\" was not injected: check your FXML file 'profile .fxml'.";
    }

    @FXML
    void btnHandler2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        Scene scene = new Scene(root, 700, 400);
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    public class DatabaseAccess {
        public void main(String[] args) {
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                connection = DriverManager.getConnection("jdbc:mysql://"+dbHost+":"
                        +dbPort+"/"+dbName);
                String query = "SELECT * FROM" + Const.USER_TABLE + " WHERE " + Const.USER_NAME + " = ? AND " + Const.USER_PASSWORD + " = ?";
                statement = connection.prepareStatement(query);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("idusers");
                    String name = resultSet.getString("first_name");
                    String password = resultSet.getString("password");

                    label.setText(String.valueOf(id));
                    label1.setText(name);
                    label2.setText(password);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Закрытие ресурсов
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}






