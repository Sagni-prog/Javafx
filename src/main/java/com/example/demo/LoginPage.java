package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

public class LoginPage extends Application {

    private static String userName = "";
    private static String password = "";
    private TextField tfUsername = new TextField();
    private TextField tfPassword = new TextField();

    private Button btnLogin = new Button("Login");

    private Button btnCancel = new Button("Cancel");
    @Override
    public void start(Stage primaryStage) {}

    public void loginUi(Stage stage){
        VBox vMain = new VBox();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(10);

        tfUsername.setStyle("-fx-padding-top:30;");
        tfUsername.setMinHeight(35);
        tfUsername.setMinWidth(220);

        tfPassword.setMinHeight(35);
        tfPassword.setMinWidth(220);

        btnLogin.setMinHeight(35);
        btnLogin.setMinWidth(100);
        btnLogin.setStyle("-fx-background-color: #34aeeb; -fx-text-fill:white; -fx-font-size:16");

        btnCancel.setMinHeight(35);
        btnCancel.setMinWidth(100);
        btnCancel.setStyle("-fx-background-color: #ed185f; -fx-text-fill:white; -fx-font-size:16");

        Label userNameLabel  = new Label("Email: ");
        userNameLabel.setStyle("-fx-font-size:16");

        Label passwordLabel = new Label("Password: ");
        passwordLabel.setStyle("-fx-font-size:16");

        gridPane.add(userNameLabel, 1, 0);
        gridPane.add(tfUsername, 2, 0);
        gridPane.add(passwordLabel, 1, 1);
        gridPane.add(tfPassword, 2, 1);
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(btnLogin,btnCancel);
        buttonBox.setAlignment(Pos.CENTER);


        gridPane.add(buttonBox, 1, 3);

        btnLogin.setOnAction(e -> {
            if(tfUsername.getText().equals(userName) && tfPassword.getText().equals(password)){
                NotePad notePad = new NotePad();
                notePad.NotePadaUi(stage);
            }else{
                System.out.println("it is not you");
            }
        });
//        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setColumnSpan(buttonBox,2);
        vBox.getChildren().addAll(gridPane);


        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);
    }

}




