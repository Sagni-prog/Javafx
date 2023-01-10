package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.*;

public class DirectoryTransverse {

    public void transverse(Stage stage) {

        VBox vBox = new VBox();

        MenuBar menuBar = new MenuBar();
        Menu diretory = new Menu("Directory");
        MenuItem tran = new MenuItem("Transverse");
        MenuItem open = new MenuItem("Open");

        diretory.getItems().addAll(tran,open);
        menuBar.getMenus().add(diretory);
        GridPane gridPane = new GridPane();


        vBox.getChildren().addAll(menuBar,gridPane);
        Scene scene = new Scene(vBox,600,400);
        stage.setScene(scene);
    }
}
