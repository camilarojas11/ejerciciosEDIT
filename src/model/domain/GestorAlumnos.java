package model.domain;

import java.util.ArrayList;
import java.util.List;

public class GestorAlumnos {

    public Alumno[] alumnos;

    public GestorAlumnos() {

    }

    //Indica al array la cantidad de alumnos a ingresar
    public GestorAlumnos(int cantAlumnos) {
        this.alumnos = new Alumno[cantAlumnos];
    }

    //Registra alumnos
    public void registrarAlumno(Alumno alumno) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = alumno;
                break;
            }
        }
    }

    //Muestra la opciones del menu
    public void menuInicio() {
        System.out.println("1- Calificacion mas alta.");
        System.out.println("2- Calificacion mas baja.");
        System.out.println("3- Alumnos que promocionaron.");
        System.out.println("4- Alumnos que recursan.");
        System.out.println("5- Salir\n");
    }

    //Gestiona el menu de acuerdo a la opcion seleccionada
    public void gestionarMenu(int opcion) {

        switch (opcion) {
            case 1:
                System.out.println(obtenerAlumnoConMayorNota());
                break;

            case 2:
                System.out.println(obtenerAlumnoConMenorNota());
                break;

            case 3:
                System.out.println(obtenerAlumnosPromocionados());
                break;

            case 4:
                System.out.println(obtenerAlumnosARecursar());
                break;

            case 5:
                System.out.println("Saliendo del programa. ¡Gracias!");
                break;

            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
    }

    //Metodo que obtiene la nota mas alta
    public String obtenerAlumnoConMayorNota() {
        Alumno notaAlta = null;
        int notaMax = 0;

        for (Alumno alumno : alumnos) {
            if (alumno.nota > notaMax) {
                notaMax = alumno.nota;
                notaAlta = alumno;
            }
        }
        return "El alumno/a con la nota mas alta es: " + notaAlta.nombre.toUpperCase() + " " + notaAlta.apellido.toUpperCase() + ".  Nota: " + notaAlta.nota;
    }

    //Metodo que obtiene la nota mas baja
    public String obtenerAlumnoConMenorNota() {
        Alumno notaBaja = null;
        int notaMin = 0;

        for (Alumno alumno : alumnos) {
            if (alumno.nota < notaMin) {
                notaMin = alumno.nota;
                notaBaja = alumno;
            }
        }
        return "El alumno/a con la nota mas baja es: " + notaBaja.nombre.toUpperCase() + " " + notaBaja.apellido.toUpperCase() + ".  Nota: " + notaBaja.nota;
    }

    //Devuelve los alumnos que promocionaron
    public String obtenerAlumnosPromocionados() {
        List<String> listaPromocionados = new ArrayList<>();

        for (Alumno alumno : alumnos) {
            if (alumno.nota >= 7) {
                String infoAlumno = alumno.nombre.toUpperCase() + " " + alumno.apellido.toUpperCase() + " - Nota: " + alumno.nota;
                listaPromocionados.add(infoAlumno);
            }
        }

        if (listaPromocionados.isEmpty()) {
            return "Ningun alumno ha promocionado segun las notas ingresadas.";
        } else {
            return "Los alumnos que promocionaron son: " + listaPromocionados;
        }
    }

    //Devuelve los alumnos que recursaron
    public String obtenerAlumnosARecursar() {
        List<String> listaRecursantes = new ArrayList<>();

        for (Alumno alumno : alumnos) {
            if (alumno.nota < 7) {
                String infoAlumno = alumno.nombre.toUpperCase() + " " + alumno.apellido.toUpperCase() + " - Nota: " + alumno.nota;
                listaRecursantes.add(infoAlumno);
            }
        }

        if (listaRecursantes.isEmpty()) {
            return "Ningun alumno ha recursado segun las notas ingresadas.";
        } else {
            return "Los alumnos que recursaron son: " + listaRecursantes;
        }
    }
}
