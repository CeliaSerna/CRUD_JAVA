package com.cursoceat.modell;
import java.util.Date;
public class Alumno {

    private int id;
    private String nombre;
    private String curso;
    private float media;
    private Date fNacimiento;
    //los atributos final van en mayusculas
    private final int TAMNOMBRE = 50;

    public Alumno(int id) {
        this.id = id;

    }

    public Alumno(int id, String nombre, String curso, float media, Date fNacimiento) {
        this.id = id;
       setNombre(nombre);
        setCurso(curso);
        this.media = media;
        this.fNacimiento = fNacimiento;
    }

    public void setNombre(String nombre) {

        this.nombre =nombre.substring(0,Math.min(TAMNOMBRE,nombre.length()));
    }
    public  void setCurso(String curso){
        this.curso=curso.substring(0,Math.min(2,curso.length()));
    }
}
