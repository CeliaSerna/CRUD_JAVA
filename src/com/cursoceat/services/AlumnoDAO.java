package com.cursoceat.services;

import com.cursoceat.modell.Alumno;

import java.sql.*;
import java.text.ParseException;

//la clase AlumnosDAO es una conversion donde se realizan una serie de metodos que van a
//ser utilizados para acceder a la BBDD (listar, buscar, borrar, insertar...etc)
//Como necesita acceder a la BBDD hereda de Conexion
public class AlumnoDAO extends Conexion {
    String sql;

    public void create(Alumno a) {
        Connection con = conectar();
        sql = "INSERT INTO alumnos (nombre, curso,media,fnaci) VALUES (?,?,?,?);";
        try {
            escribir(a, con,sql,"create");
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Alumno read(int id) {
        Alumno a = null;
        sql = "SELECT * FROM alumnos WHERE cod=?;";
        try {
            Connection con = conectar();
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1,id);
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String curso = rs.getString("curso");
                Float media = rs.getFloat("media");
                String fNaci = rs.getString("fnaci");
                a = new Alumno(id,nombre, curso, media, fNaci);
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        return a;
    }

    public void update(Alumno a) {
        if (a != null) {
            sql = "UPDATE alumnos SET nombre=?, curso=?, media=?, fnaci=? WHERE cod=?;";
            try {
                Connection con = conectar();
                PreparedStatement pt = con.prepareStatement(sql);

                pt.setString(1, a.getNombre());
                pt.setString(2, a.getCurso());
                pt.setFloat(3, a.getMedia());
                //la fecha la recibimos como tipo java.util.date , la debemos castear
                java.sql.Date sqlDate = new java.sql.Date(a.getfNacimiento().getTime());
                pt.setDate(4, sqlDate);
                pt.setInt(5,a.getId());

                pt.executeUpdate();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void escribir(Alumno a, Connection con, String sql, String opcion) throws SQLException{
        PreparedStatement pt= con.prepareStatement(sql);

        pt.setString(1, a.getNombre());
        pt.setString(2, a.getCurso());
        pt.setFloat(3, a.getMedia());
        //la fecha la recibimos como tipo java.util.date , la debemos castear
        java.sql.Date sqlDate = new java.sql.Date(a.getfNacimiento().getTime());
        pt.setDate(4, sqlDate);
        if ( opcion.equals("update")){
            pt.setInt(5,a.getId());
        }
        pt.executeUpdate();
    }
}