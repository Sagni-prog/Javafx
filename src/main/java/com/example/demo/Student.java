package com.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
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
    private TextField tfid = new TextField();

    private TextField tfName = new TextField();

    private TextField tfGrade = new TextField();

    private Button btnReg = new Button("Register");

    private Button btnLogin = new Button("Login");
    private  Button toLogin = new Button("Cancel");

    private  Button toReg = new Button("Register");

//    private Button toLogin = new Button("Login");
    public void studentRegistrationUi(Stage stage){

            VBox vMain = new VBox();
            VBox vBox = new VBox();

            AdminMenus menus = new AdminMenus();
            MenuBar menuBar =  menus.myMenus(stage);

            vBox.setAlignment(Pos.CENTER);
            vBox.setPadding(new Insets(50,0,0,0));
            GridPane gridPane = new GridPane();
            gridPane.setHgap(5);
            gridPane.setVgap(10);
            vMain.getChildren().addAll(menuBar,vBox);

        tfName.setStyle("-fx-padding-top:30;");
            tfName.setMinHeight(35);
            tfName.setMinWidth(220);

            tfEmail.setStyle("-fx-padding-top:30;");
            tfEmail.setMinHeight(35);
            tfEmail.setMinWidth(220);

            tfid.setMinHeight(35);
            tfid.setMinWidth(220);

            tfGrade.setMinHeight(35);
            tfGrade.setMinWidth(220);

            btnReg.setMinHeight(35);
            btnReg.setMinWidth(100);
            btnReg.setStyle("-fx-background-color: #34aeeb; -fx-text-fill:white; -fx-font-size:16");

            toLogin.setMinHeight(35);
            toLogin.setMinWidth(100);
            toLogin.setStyle("-fx-background-color: #ed185f; -fx-text-fill:white; -fx-font-size:16");

            Label IdLabel = new Label("Id: ");
            IdLabel.setStyle("-fx-font-size:16");

            Label NameLabel = new Label("Name: ");
            NameLabel.setStyle("-fx-font-size:16");

            Label EmailLabel = new Label("Email: ");
            EmailLabel.setStyle("-fx-font-size:16");

            Label gradeLabel = new Label("Grade: ");
            gradeLabel.setStyle("-fx-font-size:16");

            gridPane.add(IdLabel, 1, 0);
            gridPane.add(tfName, 2, 0);
            gridPane.add(NameLabel, 1, 1);
            gridPane.add(tfEmail, 2, 1);
            gridPane.add(EmailLabel, 1, 2);
            gridPane.add(tfid, 2, 2);

            gridPane.add(gradeLabel, 1, 3);
            gridPane.add(tfGrade, 2, 3);
            HBox buttonBox = new HBox(10);
            buttonBox.getChildren().addAll(btnReg, toLogin);
            buttonBox.setAlignment(Pos.CENTER);


            gridPane.add(buttonBox, 1, 5);

            btnReg.setOnAction(e -> {
                String id = tfName.getText();
                String name = tfEmail.getText();
                String email = tfid.getText();
                double grade = Double.parseDouble(tfGrade.getText());
               saveToDb(id,name,email,grade);
            });

        toLogin.setOnAction(e -> {
            tfid.setText(null);
            tfName.setText(null);
            tfEmail.setText(null);
            tfGrade.setText(null);
        });
//        gridPane.setGridLinesVisible(true);
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setColumnSpan(buttonBox,2);
            vBox.getChildren().addAll(gridPane);


            Scene scene = new Scene(vMain, 600, 400);
            stage.setScene(scene);

    }

    public void studentLoginUi(Stage stage){

            VBox vMain = new VBox();
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            GridPane gridPane = new GridPane();
            gridPane.setHgap(5);
            gridPane.setVgap(10);

            tfEmail.setStyle("-fx-padding-top:30;");
            tfEmail.setMinHeight(35);
            tfEmail.setMinWidth(220);

            tfid.setMinHeight(35);
            tfid.setMinWidth(220);

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
            gridPane.add(tfEmail, 2, 0);
            gridPane.add(passwordLabel, 1, 1);
            gridPane.add(tfid, 2, 1);
            HBox buttonBox = new HBox(10);
            buttonBox.getChildren().addAll(btnLogin, toReg);
            buttonBox.setAlignment(Pos.CENTER);


            gridPane.add(buttonBox, 1, 3);

            btnLogin.setOnAction(e -> {
                if(tfEmail.getText().equals(userName) && tfid.getText().equals(password)){
                    NotePad notePad = new NotePad();
                    notePad.NotePadaUi(stage);
                }else{
                    System.out.println("it is not you");
                }
            });

            toLogin.setOnAction(e -> {
                studentLoginUi(stage);
            });
//        gridPane.setGridLinesVisible(true);
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setColumnSpan(buttonBox,2);
            vBox.getChildren().addAll(gridPane);


            Scene scene = new Scene(vBox, 600, 400);
            stage.setScene(scene);

    }

    public void saveToDb(String id,String name,String email,double grade){

                try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db","sagni","123");

            Statement stmt=con.createStatement();
                    System.out.println(name);
           String sql = "insert into students(id,name,email,grade) values(?,?,?,?)";
//           stmt.executeUpdate(sql);

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,email);
            preparedStatement.setDouble(4,grade);

            preparedStatement.executeUpdate();

                    con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    public void studentList(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","sagni","123");

            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=stmt.executeQuery("select * from students");
            while(rs.next())

                System.out.println(
                        rs.getString("id") + ":" +
                                rs.getString("name") + ":" +
                                rs.getString("email") + ":" +
                                rs.getString("grade")
                );
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    public void searchStudentById(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.
                            getConnection(
                                   "jdbc:mysql://localhost:3306/db",
                                   "sagni","123");
        String sql = "select * from students where id = '" + id + "';";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()){
                System.out.println(
                        rs.getString("id") + ":" +
                        rs.getString("name") + ":" +
                        rs.getString("email") + ":" +
                        rs.getString("grade")
                );
          }
    }
}
