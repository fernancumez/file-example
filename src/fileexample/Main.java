
package fileexample;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner _op = new Scanner(System.in);
        
        int opcion;
        Curso curso = new Curso("Octavo A");
        
        do{
            System.out.println("\n[1]. Cargar datos desde archivo");
            System.out.println("[2]. Promedio de alumno");
            System.out.println("[3]. Modificar notas");
            System.out.println("[4]. Reporte de Aprobados");
            System.out.println("[5]. Guardar datos al archivo");
            System.out.println("[6]. Salir");
            System.out.print("\nIngrese la opcion: ");
            opcion = _op.nextInt();
            
            switch(opcion){
                case 1:   //Cargar archivo
                    System.out.println(curso.cargarArchivo());  break;
                case 2:    //Buscar alumno en archivo
                    System.out.print("Ingrese el rut del alumno: "); 
                    String rut = _op.next();
                    System.out.println(curso.buscarDatosAlumno(rut));
                    break;
                case 3:    //Modificar archivo
                    System.out.print("\nIngrese el rut del alumno: "); 
                    String rut1 = _op.next();
                    System.out.print("Ingrese el numero de prueba: ");
                    int numeroPrueba = _op.nextInt();
                    System.out.print("Ingrese nueva nota: ");
                    int nota = _op.nextInt();
                    
                    System.out.println(curso.modificarNota(rut1, numeroPrueba, nota));
                    break;
                case 4:   //Reporte de aprobados
                    System.out.println(curso.generarReporteAprobado());
                    break;
                case 5:  //Guardar datos al archivo
                    System.out.println(curso.guardarDatos());
                    break;
                case 6: 
                    System.out.println("Gracias por su visita"); 
                    break;
                default: 
                    System.out.println("Ingrese un numero valido");    
                    break;
            }

        }while(opcion !=6 );   
    }
}
