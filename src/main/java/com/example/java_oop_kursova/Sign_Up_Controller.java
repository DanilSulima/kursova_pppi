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
        import javafx.scene.control.CheckBox;
        import javafx.scene.control.TextField;
        import javafx.stage.Stage;

public class Sign_Up_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox Female;

    @FXML
    private TextField Login;

    @FXML
    private CheckBox Male;

    @FXML
    private TextField NameOfUser;

    @FXML
    private TextField PasswordOfUser;

    @FXML
    private TextField SurnameOfUser;

    @FXML
    private Button sign_in_button;
    @FXML
    void gotokatalog(ActionEvent event) throws IOException {

    }

    @FXML
    void initialize() {
        signUpNewUser();

    }

    private void signUpNewUser() {
        DBhenler dBhendler = new DBhenler();
        sign_in_button.setOnAction(event -> {
            String first_name = NameOfUser.getText();
            String last_name = SurnameOfUser.getText();
            String username_name =Login.getText();
            String password = PasswordOfUser.getText();
            String gender ="";
            if (Male.isSelected())
                gender = "male";
            else
                gender = "female";
            User user = new User(first_name,last_name,username_name,password,gender);
            dBhendler.SignUpuser(user);
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root, 700, 400);
            Stage window = new Stage();
            window.setScene(scene);
            window.show();
            ((Node) event.getSource()).getScene().getWindow().hide();
        });

    }

}


