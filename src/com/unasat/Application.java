package com.unasat;


import com.unasat.config.dbconnector.DatabaseManager;
import com.unasat.service.operations.Menus;

import java.sql.SQLException;

public class Application {


    public static void main(String[] args) throws SQLException {
        DatabaseManager databaseManager = new DatabaseManager("jdbc:mysql://localhost:3306/memoryg", "root", "dKwRaUyYnDeEN0025");
        Menus menus = new Menus(databaseManager);
        menus.fullGame();
    }



}
