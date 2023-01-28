package com.example.demo;

import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

class NotePad{
    TextArea tPad;
    public void NotePadaUi(Stage stage){

        TextArea tPad = new TextArea();
        tPad.setMinHeight(800);
        tPad.setMinWidth(800);
        tPad.setStyle("-fx-border: none");

        NotePadMenus menu = new NotePadMenus();
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

        fileChooser.setInitialDirectory(new File("/home/sagni/Documents"));

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

        String noteContent = " ";
        String cont;
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while(true){
            if(!((cont= bufferedReader.readLine())!=null)) break;
            noteContent = noteContent  + cont + "\n";
        }
        System.out.println(noteContent);
//        noteContent = bufferedReader.readLine();
//        while ((noteContent = bufferedReader.readLine()) != null) {
//          cont = noteContent;
//
//         }
        return noteContent;
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
