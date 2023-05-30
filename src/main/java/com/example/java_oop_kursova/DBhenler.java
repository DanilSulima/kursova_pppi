package com.example.java_oop_kursova;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DBhenler extends Configs{
    Connection dbConnection;
public Connection getDbConnection()
        throws ClassNotFoundException,SQLException{
        String connectionString = "jdbc:mysql://"+dbHost+":"
                +dbPort+"/"+dbName;
    Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser,dbPass);
        return dbConnection;
    }
    public void SignUpuser(User user){
    String incert = "INSERT INTO "+Const.USER_TABLE+"("+Const.USER_FIRSTNAME+","+Const.USER_LASTNAME+","+Const.USER_NAME+","+Const.USER_PASSWORD+","+
            Const.USER_GENDER+")"+"VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(incert);
            prSt.setString(1, user.getFirst_name());
            prSt.setString(2, user.getLast_name());
            prSt.setString(3, user.getUsername());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getGender());

            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getuser(User user) {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USER_NAME + " = ? AND " + Const.USER_PASSWORD + " = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, user.getUsername());
            prSt.setString(2, user.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }
}
