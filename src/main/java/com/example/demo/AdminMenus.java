package com.example.demo;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

class AdminMenus {

    public MenuBar myMenus(Stage stage){


        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu viewMenu =  new Menu("View");
        viewMenu.setStyle("-fx-font-size: 16");
        menuFile.setStyle("-fx-font-size: 16");

        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem trans = new MenuItem("Trans");
        MenuItem copy = new MenuItem("Copy");
        MenuItem exit = new MenuItem("Exit");

        MenuItem view = new MenuItem("View");
        MenuItem search = new MenuItem("Search");

        view.setOnAction(e -> {
           Student stident = new Student();
            stident.studentList();
        });

        search.setOnAction(e -> {
            Student student = new Student();
            try {
                student.searchStudentById("2");
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        save.setOnAction(e -> {

        });

        open.setOnAction(e -> {

        });

        trans.setOnAction(e-> {
            DirectoryTransverse directoryTransverse = new DirectoryTransverse();
//            directoryTransverse.directoryTransverseUi(stage,);
        });

        copy.setOnAction(e -> {

        });

        exit.setOnAction(e -> {
            App app = new App();
            try {
                app.start(stage);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });




        MenuItem saveas = new MenuItem("Save as");
        menuFile.getItems().addAll(open,save,saveas,trans,copy,exit);
        viewMenu.getItems().addAll(view,search);

        menuBar.getMenus().addAll(menuFile,viewMenu);
        return menuBar;
    }
}

