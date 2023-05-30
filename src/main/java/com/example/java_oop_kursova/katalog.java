package com.example.java_oop_kursova;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class katalog {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_button1;
    @FXML
    private Button next;
    @FXML
    private Button PROFILE;

    @FXML
    void PROFILE1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("profile .fxml"));
        Scene scene = new Scene(root, 700, 400);
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void btnHandler(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root, 700, 400);
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
    @FXML
    void gonext(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("poslugi.fxml"));
        Scene scene = new Scene(root, 700, 400);
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
        assert back_button1 != null : "fx:id=\"back_button1\" was not injected: check your FXML file 'signUp.fxml'.";

    }
}
