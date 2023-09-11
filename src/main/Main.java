package main;

import model.domain.Alumno;
import model.domain.GestorAlumnos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de alumnos a procesar:\n");
        int cantAlumnosAIngresar = scanner.nextInt();

        GestorAlumnos gestionarAlumnos = new GestorAlumnos(cantAlumnosAIngresar);

        //Ingresamos alumnos
        for (int i = 0; i < cantAlumnosAIngresar; i++) {

            System.out.println("Nombre: ");
            String nombre = scanner.next();
            System.out.println("Apellido: ");
            String apellido = scanner.next();
            System.out.println("Nro. de Examen: ");
            String numeroExamen = scanner.next();
            System.out.println("Nota: ");
            int nota = scanner.nextInt();

            //Verifica que la nota
            while (nota < 0 || nota > 10) {
                System.out.println("Las notas van del 0 al 10. Intente nuevamente:\n");
                nota = scanner.nextInt();
            }

            Alumno alumno = new Alumno(nombre, apellido, numeroExamen, nota);
            gestionarAlumnos.registrarAlumno(alumno);

            System.out.println("Alumno ingresado correctamente: " + alumno);
        }

        //Muestra el menu
        gestionarAlumnos.menuInicio();
        opcion = scanner.nextInt();

        //Valida que las opciones sean de 1 al 5
        while (opcion < 1 || opcion > 5) {
            System.out.println("Debe elegir una opcion del 1 al 5.\nIntente nuevamente:");
            opcion = scanner.nextInt();
        }

        //Gestiona el menu segun la opcion indicada
        gestionarAlumnos.gestionarMenu(opcion);
        scanner.close();
    }

}
