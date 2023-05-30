module com.example.java_oop_kursova {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.java_oop_kursova to javafx.fxml;
    exports com.example.java_oop_kursova;
}