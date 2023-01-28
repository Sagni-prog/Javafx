package com.example.demo;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Stack;

class MysqlCon{


    static ArrayList<String> list = new ArrayList<String>();
//    public ArrayList Dir(File dir){
//     File elements[] = dir.listFiles();
//        int num = elements.length-1;
//
//
//        for(File element : elements){
//            if(element.isDirectory()){
//                list.add(element.getAbsolutePath());
//                Dir(new File(list.get(list.size()-1)));
//            }
//        }
//
//        return list;
//    }
//
//    public void openDir(String  path){
//        File file = new File(path);
//        File elements[] = file.listFiles();
//
//        for(File element : elements){
//            if(element.isFile()){
//                System.out.println(element.getAbsoluteFile().getName());
//            }
//            else{
//                System.out.println("no file found in this directory");
//            }
//        }
//    }


    public static void main(String args[]){
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
}