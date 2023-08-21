import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String errorMsg = "El dato ingresado es invalido. Ingrese nuevamente.";
        String errorDateMsg = "La fecha ingresada es incorrecta.";
        String okDateMsg = "La fecha ingresada es correcta";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Validaremos si las fechas que ingrese son correctas. El formato debe se dd/mm/yyyy.\n");

        System.out.println("Ingrese el dia: ");
        int day = scanner.nextInt();
        while(day < 1 || day > 31){
            System.out.println(errorMsg);
            day = scanner.nextInt();
        }

        System.out.println("Ingrese el mes: ");
        int month = scanner.nextInt();
        while(month < 1 || month > 12){
            System.out.println(errorMsg);
            month = scanner.nextInt();
        }

        System.out.println("Ingrese el año: ");
        int year = scanner.nextInt();
        while(year < 1900 || year > 2099){
            System.out.println(errorMsg);
            year = scanner.nextInt();
        }

        if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
            if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31){
                System.out.println(errorDateMsg);

            }else if (month == 2 && day > 29){
                System.out.println(errorDateMsg);

            }else{
                System.out.println(okDateMsg);
            }

        }else {
            if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31){
                System.out.println(errorDateMsg);

            }else if (month == 2 && day > 28){
                System.out.println(errorDateMsg);

            }else{
                System.out.println(okDateMsg);
            }
        }
        scanner.close();
    }
}