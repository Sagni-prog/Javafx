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

import java.sql.*;

public class Student {

    private static String userName = "";
    private static String password = "";
    private TextField tfEmail = new TextField();
    private TextField tfPassword = new TextField();

    private TextField tfName = new TextField();

    private TextField tfGrade = new TextField();

    private Button btnReg = new Button("Register");

    private Button btnCancel = new Button("Cancel");
    public void studentUi(Stage stage){

            VBox vMain = new VBox();
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            GridPane gridPane = new GridPane();
            gridPane.setHgap(5);
            gridPane.setVgap(10);

            tfName.setStyle("-fx-padding-top:30;");
            tfName.setMinHeight(35);
            tfName.setMinWidth(220);

            tfEmail.setStyle("-fx-padding-top:30;");
            tfEmail.setMinHeight(35);
            tfEmail.setMinWidth(220);

            tfPassword.setMinHeight(35);
            tfPassword.setMinWidth(220);

            tfGrade.setMinHeight(35);
            tfGrade.setMinWidth(220);

            btnReg.setMinHeight(35);
            btnReg.setMinWidth(100);
            btnReg.setStyle("-fx-background-color: #34aeeb; -fx-text-fill:white; -fx-font-size:16");

            btnCancel.setMinHeight(35);
            btnCancel.setMinWidth(100);
            btnCancel.setStyle("-fx-background-color: #ed185f; -fx-text-fill:white; -fx-font-size:16");

            Label NameLabel  = new Label("Name: ");
            NameLabel.setStyle("-fx-font-size:16");

            Label userNameLabel  = new Label("Email: ");
            userNameLabel.setStyle("-fx-font-size:16");

            Label passwordLabel = new Label("Password: ");
            passwordLabel.setStyle("-fx-font-size:16");

            Label gradeLabel = new Label("Grade: ");
            gradeLabel.setStyle("-fx-font-size:16");

            gridPane.add(NameLabel, 1, 0);
            gridPane.add(tfName, 2, 0);
            gridPane.add(userNameLabel, 1, 1);
            gridPane.add(tfEmail, 2, 1);
            gridPane.add(passwordLabel, 1, 2);
            gridPane.add(tfPassword, 2, 2);

            gridPane.add(gradeLabel, 1, 3);
            gridPane.add(tfGrade, 2, 3);
            HBox buttonBox = new HBox(10);
            buttonBox.getChildren().addAll(btnReg,btnCancel);
            buttonBox.setAlignment(Pos.CENTER);


            gridPane.add(buttonBox, 1, 5);

            btnReg.setOnAction(e -> {
                String name = tfName.getText();
                String email = tfEmail.getText();
                String password = tfPassword.getText();
                double grade = Double.parseDouble(tfGrade.getText());
               saveToDb(name,email,password,grade);
            });
//        gridPane.setGridLinesVisible(true);
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setColumnSpan(buttonBox,2);
            vBox.getChildren().addAll(gridPane);


            Scene scene = new Scene(vBox, 600, 400);
            stage.setScene(scene);

    }

    public void saveToDb(String name,String email,String password,double grade){


                try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db","sagni","123");

            Statement stmt=con.createStatement();
                    System.out.println(name);
           String sql = "insert into student(name,email,password,grade) values(?,?,?,?)";
//           stmt.executeUpdate(sql);


            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,password);
            preparedStatement.setInt(4, (int) grade);

            preparedStatement.executeUpdate();

                    con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
