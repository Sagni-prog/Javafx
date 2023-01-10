package com.example.demo;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Admin {

    private TextField tfName = new TextField();
    private TextField tfEmail = new TextField();
    private TextField tfUsername = new TextField();

    private TextField tfPassword = new TextField();




    private Button btnReg = new Button("Register");

    private Button btnLogin = new Button("Login");
    private  Button toLogin = new Button("Login");

    private  Button toReg = new Button("Register");

    public void adminRegistrationUi(Stage stage){

        VBox vMain = new VBox();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(6);
        gridPane.setVgap(9);

        tfName.setStyle("-fx-padding-top:30;");
        tfName.setMinHeight(35);
        tfName.setMinWidth(220);

        tfUsername.setStyle("-fx-padding-top:30;");
        tfUsername.setMinHeight(35);
        tfUsername.setMinWidth(220);

        tfEmail.setStyle("-fx-padding-top:30;");
        tfEmail.setMinHeight(35);
        tfEmail.setMinWidth(220);

        tfName.setMinHeight(35);
        tfName.setMinWidth(220);

        tfPassword.setMinHeight(35);
        tfPassword.setMinWidth(220);

        btnReg.setMinHeight(35);
        btnReg.setMinWidth(100);
        btnReg.setStyle("-fx-background-color: #34aeeb; -fx-text-fill:white; -fx-font-size:16");

        toLogin.setMinHeight(35);
        toLogin.setMinWidth(100);
        toLogin.setStyle("-fx-background-color: #ed185f; -fx-text-fill:white; -fx-font-size:16");



        Label NameLabel = new Label("Name: ");
        NameLabel.setStyle("-fx-font-size:16");

        Label EmailLabel = new Label("Email: ");
        EmailLabel.setStyle("-fx-font-size:16");

        Label UsenameLabel = new Label("Username: ");
        UsenameLabel.setStyle("-fx-font-size:16");

        Label passwordLabel = new Label("Password: ");
        passwordLabel.setStyle("-fx-font-size:16");

        gridPane.add(NameLabel, 1, 0);
        gridPane.add(tfName, 2, 0);
        gridPane.add(EmailLabel, 1, 1);
        gridPane.add(tfEmail, 2, 1);
        gridPane.add(UsenameLabel, 1, 2);
        gridPane.add(tfUsername, 2, 2);

        gridPane.add(passwordLabel, 1, 3);
        gridPane.add(tfPassword, 2, 3);
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(btnReg, toLogin);
        buttonBox.setAlignment(Pos.CENTER);


        gridPane.add(buttonBox, 1, 5);

        btnReg.setOnAction(e -> {
            String name = tfName.getText();
            String email = tfEmail.getText();
            String username = tfUsername.getText();
            String password = tfPassword.getText();
            saveToDb(name,email,username,password);
        });

        toLogin.setOnAction(e -> {
            adminLoginUi(stage);
        });
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setColumnSpan(buttonBox,2);
        vBox.getChildren().addAll(gridPane);


        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);

    }

    public void adminLoginUi(Stage stage){

        VBox vMain = new VBox();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(6);
        gridPane.setVgap(9);

        tfUsername.setStyle("-fx-padding-top:30;");
        tfUsername.setMinHeight(35);
        tfUsername.setMinWidth(220);

        tfName.setMinHeight(35);
        tfName.setMinWidth(220);

        Button btnLogin = new Button("Login");
        btnLogin.setMinHeight(35);
        btnLogin.setMinWidth(100);
        btnLogin.setStyle("-fx-background-color: #34aeeb; -fx-text-fill:white; -fx-font-size:16");

        toReg.setMinHeight(35);
        toReg.setMinWidth(100);
        toReg.setStyle("-fx-background-color: #ed185f; -fx-text-fill:white; -fx-font-size:16");

        Label userNameLabel  = new Label("Email: ");
        userNameLabel.setStyle("-fx-font-size:16");

        Label passwordLabel = new Label("Password: ");
        passwordLabel.setStyle("-fx-font-size:16");

        gridPane.add(userNameLabel, 1, 0);
        gridPane.add(tfUsername, 2, 0);
        gridPane.add(passwordLabel, 1, 1);
        gridPane.add(tfName, 2, 1);
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(btnLogin, toReg);
        buttonBox.setAlignment(Pos.CENTER);


        gridPane.add(buttonBox, 1, 3);

        btnLogin.setOnAction(e -> {
//            if(tfUsername.getText().equals(userName) && tfName.getText().equals(password)){
//                NotePad notePad = new NotePad();
//                notePad.NotePadaUi(stage);
//            }else{
//                System.out.println("it is not you");
//            }
        });

        toReg.setOnAction(e -> {
            adminRegistrationUi(stage);
        });
//        gridPane.setGridLinesVisible(true);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setColumnSpan(buttonBox,2);
        vBox.getChildren().addAll(gridPane);


        Scene scene = new Scene(vBox, 600, 400);
        stage.setScene(scene);

    }

    public void login(String username,String password){

    }

    public void saveToDb(String name,String email,String username,String password){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db","sagni","123");

            Statement stmt=con.createStatement();
            String sql = "insert into admin(name,email,username,password) values(?,?,?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,username);
            preparedStatement.setString(4,password);

            preparedStatement.executeUpdate();

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
  }

