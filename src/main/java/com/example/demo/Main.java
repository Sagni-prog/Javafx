package com.example.demo;

import java.sql.*;
class MysqlCon{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","sagni","123");


            Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=stmt.executeQuery("select * from user");
            while(rs.next())
//               / System.out.println(rs.getInt(1));
                System.out.println("name: " + rs.getString("name"));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}