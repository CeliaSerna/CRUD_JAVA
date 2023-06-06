package com.cursoceat.modell;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
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

    public Alumno(int id, String nombre, String curso, float media, String fNacimiento) throws ParseException{
        this.id = id;
        setNombre(nombre);
        setCurso(curso);
        this.media = media;
        SimpleDateFormat f= new SimpleDateFormat("yyyy-MM-dd") ;
        this.fNacimiento = f.parse(fNacimiento);

    }
    //este constructor lo utilizamos para crear un nuevo alumno porque
    // la BBDD crea automaticamente el id
    public Alumno(String nombre, String curso, float media, String fNacimiento) throws  ParseException{
        setNombre(nombre);
        setCurso(curso);
        this.media = media;
        SimpleDateFormat f= new SimpleDateFormat("yyyy-MM-dd") ;
        this.fNacimiento = f.parse(fNacimiento);
    }

    public void setNombre(String nombre) {

        this.nombre =nombre.substring(0,Math.min(TAMNOMBRE,nombre.length()));
    }
    public  void setCurso(String curso){
        this.curso=curso.substring(0,Math.min(2,curso.length()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public Date getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Date fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCurso() {
        return curso;
    }
}
