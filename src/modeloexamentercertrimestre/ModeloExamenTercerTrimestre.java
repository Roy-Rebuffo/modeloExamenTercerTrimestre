package modeloexamentercertrimestre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloExamenTercerTrimestre {

    static Aparcamiento aparcamiento = new Aparcamiento();
    
    static String fileName = "aparcamiento.txt";
    
    public static void main(String[] args) throws IOException {
        aparcamiento.leerFichero(fileName);
        mainMenu();
    }
    
    public static void mainMenu() {
        int opcion = 1;
        Scanner dato = new Scanner(System.in);
        while (opcion != 0) {
            System.out.println("-//-/-/-/-/-//-/-/Bienvenido Al Parking/-/-/-//-/-/-/-//-/-/");
            System.out.println("Que desea hacer?");
            System.out.println("(1) Entrar al Parking");
            System.out.println("(2) Salir del Parking");
            System.out.println("(3) Ver cuantos vehiculos hay en el Parking");
            System.out.println("(0) Salir");
            System.out.print("SELECCIONE OPCION QUE DESEA:");
            opcion = dato.nextInt();
            switch (opcion) {
                case 1:
                    aparcamiento.entrarParking();
                    break;
                case 2:
                    //salirDelParking();
                    break;
                case 3:
                    aparcamiento.leerFichero(fileName);
                    break;
                case 4:
                    //extra();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Selecciona un Numero valido");
            }
        }
    }
}
