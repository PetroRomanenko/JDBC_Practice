package com.ferros;

import com.ferros.utils.JdbcUtils;
import com.ferros.view.MainView;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;

public class Main {


    public static void main(String[] args) throws SQLException {
//        System.out.println(new Date(1673203795337L));
        MainView mainView = new MainView();
        mainView.showMainMenu();
    }
}
