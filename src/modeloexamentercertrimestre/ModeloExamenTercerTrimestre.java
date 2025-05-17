package modeloexamentercertrimestre;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloExamenTercerTrimestre {

    public static void main(String[] args) throws IOException {
        String fileName = "fichero.txt";
        escribirFichero(fileName);
        
        //Creo un arrayList para luego poder iterar sobre ello y leer todas las lineas
        ArrayList<String> fileStrings = leerFichero(fileName);
        
        for (String linea : fileStrings) {
            System.out.println(linea);
        }
    }
    
    public static ArrayList<String> leerFichero(String fileName) throws IOException{
        //Creamos el arrayList
        ArrayList<String> lista = new ArrayList<>();
        
        //Gestionamos la condicion de si existe o no el fichero para evitar errores
        File file  = new File(fileName);
        if (file.isFile()) {
            //Lector del fichero
        FileReader reader = new FileReader(fileName);
        BufferedReader bReader = new BufferedReader(reader);
        
        String line;
        //Leemos las lineas mientras que no sea null
        while ((line = bReader.readLine()) != null) {
            //Metodo que mete en la lista las lineas que va leyendo del fichero
            lista.add(line);
        }
        //Cerramos el reader para evitar error y reducir el consumo de recursos
        bReader.close();
        return lista;
        }
        //Si no lo encuentra tira la excepcion
        throw new FileNotFoundException();
    }
    
    
    //Metodo para leer los ficheros
    public static void escribirFichero(String pathName) throws IOException{
        //Puntero de referencia a la entrada del fichero
        File file = new File(pathName);
        
        //Escritor del fichero
        FileWriter writer = new FileWriter(file);
        //Envoltorio de writer para facilitar la escritura de lineas
        PrintWriter printer = new PrintWriter(writer);
        printer.println("LMAO ESTO FUNCIONA!");
        
        //Sino cerramos la escritura del fichero no va a escribir nada
        printer.close();
    }
}
