package com.cursoceat.services;
import  java.sql.*;
public class Conexion {
    private Connection con;
    private String url;
    private String user;
    private String password;

    public Connection conectar(){
        url="jdbc:mariadb://localhost:3306/instituto";
        user="root";
        password="";
        try{
            con=DriverManager.getConnection(url,user,password);
            System.out.println("Éxito");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
        }
        return con;
    }

}
