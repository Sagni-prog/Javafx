package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
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

    public static void main(String[] args) {
        launch(args);
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
            directoryTransverse.transverse(stage);
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

class DirectoryTransverse {
    public void transverse(Stage stage) {
        Group group1 = new Group();
        Scene Texteditor = new Scene(group1);
        stage.setScene(Texteditor);
        stage.setTitle("Transverse");
        stage.setHeight(500);
        stage.setWidth(400);
        stage.show();
        VBox container = new VBox();
        container.setSpacing(4);
        group1.getChildren().add(container);
        HBox nav = new HBox();
        Menu menu = new Menu("File");
        MenuItem m1 = new MenuItem("open");
        MenuItem m2 = new MenuItem("save");
        MenuItem m3 = new MenuItem("saveAs");
        menu.getItems().add(m1);
        menu.getItems().add(m2);
        menu.getItems().add(m3);
        Menu menu1 = new Menu("Directory");
        MenuItem m11 = new MenuItem("Open Directory");
        MenuItem m22 = new MenuItem("Transverse Directory");
        MenuItem m33 = new MenuItem("Check IsFile || IsDirectory");
        menu1.getItems().add(m11);
        menu1.getItems().add(m22);
        menu1.getItems().add(m33);
        Menu menu2 = new Menu("Student Information");
        MenuItem m111 = new MenuItem("Register student");
        MenuItem m222 = new MenuItem("All Students");
        MenuItem m333 = new MenuItem("Single Student information");
        menu2.getItems().add(m111);
        menu2.getItems().add(m222);
        menu2.getItems().add(m333);
        MenuBar menuBar1 = new MenuBar();
        menuBar1.getMenus().add(menu);
        menuBar1.getMenus().add(menu1);
        menuBar1.getMenus().add(menu2);
        Menu log = new Menu("Logout");
        MenuItem logut = new MenuItem("logout");
        log.getItems().add(logut);
        MenuBar menuBar2 = new MenuBar();
        menuBar2.getMenus().add(log);
        nav.getChildren().add(menuBar1);
        nav.getChildren().add(menuBar2);
        nav.setSpacing(80);
        container.getChildren().add(nav);





        HBox header = new HBox();
        Button button = new Button("Transverse Directory");
        button.setPadding(new Insets(150, 100, 10, 100));

        button.setTextFill(Color.web("#0076a3"));
        button.setStyle("-fx-font-size:20px" +
                "-fx-background-color:red");
        header.setAlignment(Pos.CENTER);
        header.getChildren().add(button);
        container.getChildren().add(header);


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DirectoryChooser directoryChooser = new DirectoryChooser();
                File file = directoryChooser.showDialog(stage);
                if (file.isDirectory()) {

                    File[] files = file.listFiles();

                    for (File f : files) {
                        String data = f.getName();
                        System.out.println(f.getName());
                        HBox header = new HBox();
                        Label headertitle = new Label(data + "\n");
                        headertitle.setPadding(new Insets(10, 100, 10, 50));
                        headertitle.setTextFill(Color.web("#0076a3"));
                        headertitle.setStyle("-fx-font-size:20px");
                        header.setAlignment(Pos.CENTER);
                        header.getChildren().add(headertitle);
                        container.getChildren().add(header);

                        if (f.isDirectory()) {
                            File[] files1 = f.listFiles();
                            for (File f2 : files1) {

                                String data2 = f2.getName();
                                System.out.println(f.getName());
                                HBox header1 = new HBox();
                                Label headertitle1 = new Label("\n" + data2);
                                headertitle.setPadding(new Insets(10, 100, 10, 0));
                                headertitle.setTextFill(Color.web("#0076a3"));
                                headertitle.setStyle("-fx-font-size:20px");
                                header.setAlignment(Pos.CENTER);
                                header.getChildren().add(headertitle1);
                                container.getChildren().add(header1);
                                try {
                                    String path = f2.getPath();
                                    File file1 = new File(path);
                                    if (file1.isFile()) {
                                        FileInputStream inputStream = new FileInputStream(file1);
                                        BufferedInputStream bin = new BufferedInputStream(inputStream);
                                        byte[] contents = new byte[1024];
                                        int bytesRead = 0;
                                        String content;
                                        while ((bytesRead = bin.read(contents)) != -1) {
                                            content = new String(contents, 0, bytesRead);
                                            HBox header2 = new HBox();
                                            Label headertitle2 = new Label("\n" + content);
                                            headertitle.setPadding(new Insets(10, 100, 10, 0));
                                            headertitle.setTextFill(Color.web("#0076a3"));
                                            headertitle.setStyle("-fx-font-size:20px");
                                            header.setAlignment(Pos.CENTER);
                                            header.getChildren().add(headertitle2);
                                            container.getChildren().add(header2);
                                            System.out.print(content);
                                            bin.close();
                                            inputStream.close();
                                        }
                                    }

                                } catch (FileNotFoundException F) {
                                    System.out.println(F);
                                } catch (IOException E) {
                                    System.out.println(E);
                                }
                            }
                        } else {
                            System.out.println("no other directory");
                        }


                    }


                } else {
                    HBox header = new HBox();
                    Label headertitle = new Label("Isn't Directory!!!");
                    headertitle.setPadding(new Insets(10, 100, 10, 50));

                    headertitle.setTextFill(Color.web("#0076a3"));
                    headertitle.setStyle("-fx-font-size:20px");
                    header.setAlignment(Pos.CENTER);
                    header.getChildren().add(headertitle);
                    container.getChildren().add(header);
                }


            }
        });


    }
}


