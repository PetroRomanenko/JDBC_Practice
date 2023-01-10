package com.ferros;

import com.ferros.model.Writer;
import com.ferros.repository.jdbc.JdbcWriterRepositoryImpl;
import com.ferros.utils.JdbcUtils;
import com.ferros.view.MainView;
import com.ferros.view.WriterView;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;

public class Main {


    public static void main(String[] args) throws SQLException {
//        System.out.println(new Date(1673203795337L));
//        JdbcWriterRepositoryImpl repository = new  JdbcWriterRepositoryImpl();
//        WriterView view = new WriterView();
//        Writer writer = new Writer("BOb", "MArley");
//
//        view.findWriterById();


        MainView mainView = new MainView();
        mainView.showMainMenu();
    }
}
