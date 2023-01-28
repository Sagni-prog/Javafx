package com.example.demo;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

class NotePadMenus {

    public MenuBar myMenu(TextArea tPad, Stage stage){


        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuFile.setStyle("-fx-font-size: 16");

        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem trans = new MenuItem("Trans");
        MenuItem copy = new MenuItem("Copy");
        MenuItem exit = new MenuItem("Exit");
        save.setOnAction(e -> {
            NotePad notePad = new NotePad();
            notePad.Save(tPad,stage);
        });

        open.setOnAction(e -> {
            NotePad notePad = new NotePad();
            try {
                notePad.Open(tPad,stage);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        trans.setOnAction(e-> {
            DirectoryTransverse directoryTransverse = new DirectoryTransverse();
//            directoryTransverse.directoryTransverseUi(stage,);
        });

        copy.setOnAction(e -> {
            NotePad notePad = new NotePad();
            notePad.Copy(tPad,stage);
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

        menuBar.getMenus().addAll(menuFile);
        return menuBar;
    }
}
