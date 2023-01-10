package com.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class DirectoryTransverse {

    static ArrayList<String> dirPath = new ArrayList<String>();
    static ArrayList<String> fileName = new ArrayList<String>();
   static File file = new File("/home/sagni/Documents");

    public void directoryTransverseUi(Stage stage) {

        VBox vBox = new VBox();
        VBox container = new VBox();
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(50,10,10,10));

        MenuBar menuBar = new MenuBar();
        Menu diretory = new Menu("Directory");
        MenuItem tran = new MenuItem("Transverse");
        MenuItem open = new MenuItem("Open");

        diretory.getItems().addAll(tran,open);
        menuBar.getMenus().add(diretory);
        GridPane gridPane = new GridPane();

        Button dirbtn = new Button("+");
        dirbtn.setMinWidth(250);
        dirbtn.setMinHeight(40);
        dirbtn.setStyle("-fx-background-color: #34aeeb; -fx-text-fill:white; -fx-font-size:16");
        gridPane.setAlignment(Pos.CENTER);


        VBox box = new VBox(10);
        box.setPadding(new Insets(15,0,0,0));
        Label[] label;
        label = new Label[3];
        Label dirlable = new Label();
        dirlable.setStyle("-fx-font-size: 18;");
        dirlable.setText("Dir:  "+(String)Dir(file).get(Dir(file).size()-1));
        dirlable.setUnderline(true);
        dirlable.setPadding(new Insets(0,0,6,0));
        box.getChildren().add(dirlable);

        ArrayList<String> list = new ArrayList<>();
        list = openDir((String)Dir(file).get(Dir(file).size()-1));
        System.out.println(list);

        for(int i = 0; i<=list.size()-1; i ++){

            label[i] = new Label(list.get(i));
            label[i].setStyle("-fx-font-size: 16;");
            box.getChildren().add(label[i]);

        }

        gridPane.setColumnSpan(dirbtn,3);
        gridPane.setColumnSpan(box,3);

        gridPane.add(dirbtn,0,0);
        gridPane.add(box,0,2);

        container.getChildren().add(gridPane);

        vBox.getChildren().addAll(menuBar,container);
        Scene scene = new Scene(vBox,600,400);
        stage.setScene(scene);
    }

    public ArrayList Dir(File dir){
        File elements[] = dir.listFiles();
        int num = elements.length-1;


        for(File element : elements){
            if(element.isDirectory()){
                dirPath.add(element.getAbsolutePath());
                Dir(new File(dirPath.get(dirPath.size()-1)));
            }
        }

        return dirPath;
    }

    public ArrayList openDir(String  path){

        File file = new File(path);
        File elements[] = file.listFiles();

        for(File element : elements){
            if(element.isFile()){

                fileName.add(element.getAbsoluteFile().getName());
//                System.out.println(element.getAbsoluteFile().getName());
            }
            else{
                System.out.println("no file found in this directory");
            }
        }
        return fileName;
    }

}
