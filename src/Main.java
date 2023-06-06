import com.cursoceat.modell.Alumno;
import com.cursoceat.services.AlumnoDAO;
import com.cursoceat.services.Conexion;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {

        //System.out.printf("Hello and welcome!");
        Alumno a = new Alumno("Maria","2b", 5.3f,"2015-05-01");

        AlumnoDAO alumnoDAO = new AlumnoDAO();
       // alumnoDAO.create(a);
        a=alumnoDAO.read(10);

    System.out.println( "Nombre: "+ a.getNombre() + ", ID:"+ a.getId()+ ", Curso: "+a.getCurso());
    a=new Alumno(10,"Josefa","3b",4.5f,"1989-05-05");
    alumnoDAO.update(a);
    System.out.println("Alumno actualizado");
        System.out.println( "Nombre: "+ a.getNombre() + ", ID:"+ a.getId()+ ", Curso: "+a.getCurso());
    }
    }