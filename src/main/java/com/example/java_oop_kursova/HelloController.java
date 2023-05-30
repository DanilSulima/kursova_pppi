package com.example.java_oop_kursova;

import animations.Shake;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button sign_in_button;

    @FXML
    private Button sign_up_button;

    Stack<Scene> sceneStack = new Stack<>();
    @FXML
    void initialize() {
        sign_in_button.setOnAction(event ->{
            String loginText = login_field.getText().trim();
            String loginPass = password_field.getText().trim();
            if(!loginText.equals("")&&!loginPass.equals(""))
                loginUser(loginText,loginPass);
            else
                System.out.println("Login or password incorrect");


        });
        sign_up_button.setOnAction(event ->{
            OpenNewScene("app.fxml");
        });

    }

    private void loginUser(String loginText, String loginPass) {
        DBhenler dbh = new DBhenler();
        User user = new User();
        user.setUsername(loginText);
        user.setPassword(loginPass);
        dbh.getuser(user);
        ResultSet result =dbh.getuser(user);
        int counter =0;
        while (true){
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
        }
        if (counter>=1) {
        OpenNewScene("signUp.fxml");
        }
        else {
            Shake userlogAnim = new Shake(login_field);
            Shake userPassAnim = new Shake(password_field);
            userlogAnim.playAnim();
            userPassAnim.playAnim();
        }

    }
    public void OpenNewScene(String window){
        sign_up_button.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

}
