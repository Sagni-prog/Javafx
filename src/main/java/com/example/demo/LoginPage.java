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
    public void start(Stage primaryStage) {

//        VBox vMain = new VBox();
//        VBox vBox = new VBox();
//        vBox.setAlignment(Pos.CENTER);
//        GridPane gridPane = new GridPane();
//        gridPane.setHgap(5);
//        gridPane.setVgap(10);
//
//        tfUsername.setStyle("-fx-padding-top:30;");
//        tfUsername.setMinHeight(35);
//        tfUsername.setMinWidth(220);
//
//        tfPassword.setMinHeight(35);
//        tfPassword.setMinWidth(220);
//
//        btnLogin.setMinHeight(35);
//        btnLogin.setMinWidth(100);
//        btnLogin.setStyle("-fx-background-color: #34aeeb; -fx-text-fill:white; -fx-font-size:16");
//
//        btnCancel.setMinHeight(35);
//        btnCancel.setMinWidth(100);
//        btnCancel.setStyle("-fx-background-color: #ed185f; -fx-text-fill:white; -fx-font-size:16");
//
//        Label userNameLabel  = new Label("Email: ");
//        userNameLabel.setStyle("-fx-font-size:16");
//
//        Label passwordLabel = new Label("Password: ");
//        passwordLabel.setStyle("-fx-font-size:16");
//
//        gridPane.add(userNameLabel, 1, 0);
//        gridPane.add(tfUsername, 2, 0);
//        gridPane.add(passwordLabel, 1, 1);
//        gridPane.add(tfPassword, 2, 1);
//        HBox buttonBox = new HBox(10);
//        buttonBox.getChildren().addAll(btnLogin,btnCancel);
//        buttonBox.setAlignment(Pos.CENTER);
//
//
//                gridPane.add(buttonBox, 1, 3);
//
//                btnLogin.setOnAction(e -> {
//                    if(tfUsername.getText().equals(userName) && tfPassword.getText().equals(password)){
//                       NotePad notePad = new NotePad();
//                       notePad.NotePadaUi(primaryStage);
//                    }else{
//                        System.out.println("it is not you");
//                    }
//                });
////        gridPane.setGridLinesVisible(true);
//        gridPane.setAlignment(Pos.CENTER);
//        gridPane.setColumnSpan(buttonBox,2);
//        vBox.getChildren().addAll(gridPane);
//
//
//        Scene scene = new Scene(vBox, 600, 400);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
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
class NotePad{
    TextArea tPad;
    public void NotePadaUi(Stage stage){
        
        TextArea tPad = new TextArea();
        tPad.setMinHeight(800);
        tPad.setMinWidth(800);
        tPad.setStyle("-fx-border: none");

        Menus menu = new Menus();
        MenuBar menuBar = menu.myMenu(tPad,stage);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(menuBar,tPad);
        Scene sc = new Scene(vBox,600,400);
      stage.setScene(sc);
    }
    public void Save(TextArea tPad,Stage stage){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter txt = new FileChooser.ExtensionFilter("TXT files (*.txt)","*.txt");
        fileChooser.getExtensionFilters().add(txt);

        File path = fileChooser.showSaveDialog(stage);
        if(path != null){
            try {
                saveNoteToFile(path,tPad.getText());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void saveNoteToFile(File path, String note) throws FileNotFoundException {

        PrintWriter printWriter = new PrintWriter(path);
        printWriter.println(note);
        printWriter.close();
    }

    public String openNotePad(File path) throws IOException {

        String noteContent;
        String cont = null;
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        noteContent = bufferedReader.readLine();
        while ((noteContent = bufferedReader.readLine()) != null) {
          cont = noteContent;
            
         }
        return cont;
    }

    public void copyNotTo(File destinationPath,String content) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(destinationPath);
        printWriter.println(content);
        printWriter.close();
    }

    public void Open(TextArea tPad,Stage stage) throws IOException {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter txt = new FileChooser.ExtensionFilter("TXT files (*.txt)","*.txt");
        fileChooser.getExtensionFilters().add(txt);

        fileChooser.setInitialDirectory(new File("/home/sagni/Documents"));

        File path = fileChooser.showOpenDialog(stage);
        if(path != null){
            tPad.setText(openNotePad(path));
        }
    }

    public void Copy(TextArea tPad, Stage stage) {

        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter txt = new FileChooser.ExtensionFilter("TXT files (*.txt)","*.txt");
        fileChooser.getExtensionFilters().add(txt);


        File path = fileChooser.showSaveDialog(stage);
        if(path != null){
            try {
                copyNotTo(path,tPad.getText());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Menus{

    public MenuBar myMenu(TextArea tPad,Stage stage){

      
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        menuFile.setStyle("-fx-font-size: 16");

        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem trans = new MenuItem("Trans");
        MenuItem copy = new MenuItem("Copy");
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
            directoryTransverse.directoryTransverseUi(stage);
        });

        copy.setOnAction(e -> {
            NotePad notePad = new NotePad();
            notePad.Copy(tPad,stage);
        });




        MenuItem saveas = new MenuItem("Save as");
        menuFile.getItems().addAll(open,save,saveas,trans,copy);

        menuBar.getMenus().addAll(menuFile);
        return menuBar;
    }
}




