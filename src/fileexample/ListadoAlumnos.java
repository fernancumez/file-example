
package fileexample;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListadoAlumnos {
    List lista;

    public ListadoAlumnos() {
        this.lista = new LinkedList();
    }
    
    public String agregar(Alumno a){
        this.lista.add(a);
        return "Alumno Ingresado.";
    }
    
    public String getAprobados(){
        String s = "";
        Iterator items = this.lista.iterator();
        while(items.hasNext()){
            Alumno a = (Alumno)items.next();
            if(a.getPromedio() >= 40){
                s += "\n" + a.getNombre() + " PROM: " + a.getPromedio();   
            }
        }
        return s;
    }
    
    public String getListadoArchivo(){
        String s = "";
        Iterator items = this.lista.iterator();
        while(items.hasNext()){
            Alumno a = (Alumno)items.next();
            if(!s.equals("")) s += "\n";
            s += a.getFormatoArchivo();
        }
        return s;
    }
    
    public Alumno buscar(String rut){
        Iterator items = this.lista.iterator();
        while(items.hasNext()){
            Alumno a = (Alumno)items.next();
            if(a.getRut().equalsIgnoreCase(rut)){
                return a;
            }
        }
        return null;
    }
    
}
