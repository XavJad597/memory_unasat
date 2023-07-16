package com.unasat;


import com.unasat.config.dbconnector.DatabaseManager;
import com.unasat.service.operations.Menus;

import java.sql.SQLException;

public class Application {

    /*Groepsleden:
    Xavier Kiba SE/1122/046
    Dwayne Kruydenhof  SE/1122/051
    Shivani Mahabier 1122/058
    Michelle Karioredjo SE/1122/041
    */

    public static void main(String[] args) throws SQLException {
        DatabaseManager databaseManager = new DatabaseManager();
        Menus menus = new Menus(databaseManager);
        menus.fullGame();
    }



}
