package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        Button notbtn = new Button("Notepad");
        Button adbtn = new Button("Admin");
        Button stdbtn = new Button("Student");
        Button transbtn = new Button("Transverse");

        notbtn.setOnAction(e-> {
            LoginPage loginPage = new LoginPage();
            loginPage.loginUi(stage);
        });

        stdbtn.setOnAction(e->{
            Student student = new Student();
            student.studentRegistrationUi(stage);
        });

        transbtn.setOnAction(e -> {
             DirectoryTransverse directoryTransverse = new DirectoryTransverse();
             directoryTransverse.directoryTransverseUi(stage);
        });

        adbtn.setOnAction(e -> {
            Admin admin = new Admin();
            admin.adminLoginUi(stage);
        });
        
        hBox.getChildren().addAll(notbtn,stdbtn,adbtn,transbtn);
        vBox.getChildren().add(hBox);

        Scene scene = new Scene(vBox,600,400);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}
