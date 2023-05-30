package com.example.java_oop_kursova;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Configs {
    protected String dbHost = "LocalHost";
    protected String dbPort = "3305";
    protected String dbUser = "root";
    protected String dbPass = "12345";
    protected String dbName = "registr";

    public abstract Connection getDbConnection()
            throws ClassNotFoundException, SQLException;
}
