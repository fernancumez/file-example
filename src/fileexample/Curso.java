
package fileexample;
import java.io.*;

public class Curso {
    private String nombre;
    private ListadoAlumnos listaAlumnos;
    
    //Lectura de archivo
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    
    //Escritura de archivo
    FileWriter fichero = null;
    PrintWriter pw = null;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.listaAlumnos = new ListadoAlumnos();
    }
    
    public String buscarDatosAlumno(String rut){ 
        Alumno a =  this.listaAlumnos.buscar(rut);
        if(a != null){
            int prom = a.getPromedio();
            String nombre = a.getNombre();
            return "Promedio de " + nombre + ": " + prom;
        }
        return "Alumno no encontrado";
    }
    
    public String modificarNota(String rut, int numeroPrueba, int nota){
        Alumno a = this.listaAlumnos.buscar(rut);
        if(a != null){
            if(numeroPrueba == 1) a.setNota1(nota);
            if(numeroPrueba == 2) a.setNota2(nota);
            if(numeroPrueba == 3) a.setNota3(nota);
            
            return "Notas modificadas";
        }
        return "Alumno no encontrado";
    }
    
    public String generarReporteAprobado(){
        try {
            fichero = new FileWriter("aprobados.txt");
            pw = new PrintWriter(fichero);
            
            String aprobados = this.listaAlumnos.getAprobados();
            fichero.write(aprobados);
            
            return "Archivo creado";
            
        } catch (Exception e) {
            return "Error en la carga de datos";
        }finally{
            try {
                if(null != fichero){
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public String guardarDatos(){
        try {
            fichero = new FileWriter("miCurso.txt");
            pw = new PrintWriter(archivo);
            
            String alumnos = this.listaAlumnos.getListadoArchivo();
            fichero.write(alumnos);
            
            return "Archivo modificado";
            
        } catch (Exception e) {
            return "Error en la carga de datos";
        }finally{
            try {
                if(null != fichero){
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public String cargarArchivo(){
        try {
            archivo = new File("miCurso.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            String linea;
            while((linea = br.readLine()) != null){
                
                //Separatr los campos desde el archivo
                String[] campos = linea.split("#");
                String nombre = campos[0];
                String rut = campos[1];
                String sNota1 = campos[2];
                String sNota2 = campos[3];
                String sNota3 = campos[4];
                
                //Convertir las notas a entero
                int nota1 = Integer.parseInt(sNota1);
                int nota2 = Integer.parseInt(sNota2);
                int nota3 = Integer.parseInt(sNota3);
                
                //Crear objeto alumno
                Alumno alumno = new Alumno(nombre,rut, nota1, nota2, nota3);
                this.listaAlumnos.agregar(alumno);
                //System.out.println(nota3);
            }
            return "Datos cargado en memoria";
        } catch (Exception e) {
            return "Error en la carga de datos";
        }finally{
            try {
                if(null != fr){
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
