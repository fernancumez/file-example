
package fileexample;

public class Alumno {
    private String nombre;
    private String rut;
    private int nota1;
    private int nota2;
    private int nota3;

    public Alumno(String nombre, String rut, int nota1, int nota2, int nota3) {
        this.nombre = nombre;
        this.rut = rut;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }
    
    public int getPromedio(){
        int suma  = this.nota1 + this.nota2 + this.nota3;
        int prom = suma / 3;
        return prom;
    }
    
    public String getFormatoArchivo(){
        String n = this.nombre;
        String r = this.rut;
        int n1 = this.nota1;
        int n2 = this.nota2;
        int n3 = this.nota3;
        
        String gato = "#";
        return n + gato + r + gato + n1 + gato + n2 + gato + n3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getNota1() {
        return nota1;
    }

    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public int getNota2() {
        return nota2;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }

    public int getNota3() {
        return nota3;
    }

    public void setNota3(int nota3) {
        this.nota3 = nota3;
    }
    
    
}
