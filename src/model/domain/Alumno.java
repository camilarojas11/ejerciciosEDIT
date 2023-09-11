package model.domain;

public class Alumno {
    public String nombre;
    public String apellido;
    public String numeroDeExamen;
    public int nota;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, String numeroDeExamen, int nota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroDeExamen = numeroDeExamen;
        this.nota = nota;

    }

    @Override
    public String toString() {
        return "Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", N° Examen='" + numeroDeExamen + '\'' +
                ", Nota=" + nota;
    }
}
