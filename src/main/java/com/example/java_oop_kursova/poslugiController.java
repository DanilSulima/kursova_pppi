package com.example.java_oop_kursova;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class poslugiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bk_bnt2;

    @FXML
    void PROFILE1(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("profile .fxml"));
        Scene scene = new Scene(root, 700, 400);
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
    @FXML
    void bk_bnt2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
        Scene scene = new Scene(root, 700, 400);
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
        ((Node) event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
        assert bk_bnt2 != null : "fx:id=\"bk_bnt2\" was not injected: check your FXML file 'poslugi.fxml'.";

    }

}
