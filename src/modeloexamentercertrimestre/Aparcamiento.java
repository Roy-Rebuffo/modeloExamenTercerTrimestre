package modeloexamentercertrimestre;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import static modeloexamentercertrimestre.ModeloExamenTercerTrimestre.aparcamiento;

public class Aparcamiento {

    static String fileName = "aparcamiento.txt";
    static Scanner dato = new Scanner(System.in);
    //la lista que va a recoger todos los vehiculos
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    //Atributos
    private int capacidad = 10;

    //Getters & Setters
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    //Constructores
    public Aparcamiento() {
    }

    public Aparcamiento(int capacidad) {
        this.capacidad = capacidad;
    }

    //toString
    @Override
    public String toString() {
        return "vehiculos: " + vehiculos + "\tcapacidad: "
                + capacidad;
    }
    
    //metodo para introducir un vehiculo en el parking + escribirFichero
    public void entrarParking() {
        if (capacidad == 0) {
            System.out.println("No hay mas espacio en el parking");
            return;
        }

        boolean encontrado = false;

        System.out.print("Introduzca la matricula del vehiculo: ");
        String matr = dato.next();

        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().equalsIgnoreCase(matr)) {
                System.out.println("El vehiculo se encuentra dentro del parking");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            boolean abono = false;
            System.out.println("Que tipo de vehiculo quiere introducir");
            System.out.println(" 0 para Automovil \n 1 para Camion");
            int respuesta = dato.nextInt();
            System.out.println("Tiene abono? S/N");
            String respuesta2 = dato.next();
            if (respuesta2.equalsIgnoreCase("S")) {
                abono = true;
            }
            if (respuesta == 0) {
                String tipo = "Automovil";
                System.out.println("Tipo:");
                System.out.println("1) TodoTerreno");
                System.out.println("2) Turismo");
                System.out.println("3) Furgoneta");

                int tipoOpcion = dato.nextInt();
                if (tipoOpcion == 1) {
                    tipo = "TodoTerreno";
                } else if (tipoOpcion == 2) {
                    tipo = "Turismo";
                } else if (tipoOpcion == 3) {
                    tipo = "Furgoneta";
                } else {
                    System.out.println("Has introducido un valor no valido");
                }
                Automovil newAuto = new Automovil(tipo, matr, abono, LocalDateTime.now());
                vehiculos.add(newAuto);
            }
            if (respuesta == 1) {
                System.out.println("Numero de ejes: ");
                int ejes = dato.nextInt();
                Camion newCamion = new Camion(ejes, matr, abono, LocalDateTime.now());
                vehiculos.add(newCamion);
            }
            escribirFichero(fileName);
            capacidad = capacidad - 1;
            System.out.println("Vehiculo añadido correctamente.");
        }
    }

    //Guardamos los vehiculos en un fichero
    public void escribirFichero(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Vehiculo v : vehiculos) {
                writer.write(v.writeFileToString());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error al guardar los vehiculos " + e.getMessage());
        }
    }

    //Leemos el fichero
    public void leerFichero(String fileName) {
        vehiculos.clear();
        //Verificar si existe el archivo 
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            Vehiculo v = null;
            while ((linea = br.readLine()) != null) {
                // Suponiendo que los atributos están separados por coma ","
                String[] datos = linea.split(","); // Dividimos en 2 partes
                String matr = datos[0];
                boolean abono = Boolean.parseBoolean(datos[1]);
                LocalDateTime fecha = LocalDateTime.parse(datos[2]);
                //Vemos si es Automovil o Camion

                if (datos[3].equals("TodoTerreno") || datos[3].equals("Furgoneta") || datos[3].equals("Turismo")) {
                    //  System.out.println("Es un auto");
                    String tipo = datos[3];
                    v = new Automovil(tipo, matr, abono, fecha);
                } else {
                    //  System.out.println("Es un camion");
                    int nEjes = Integer.parseInt(datos[3]);
                    v = new Camion(nEjes, matr, abono, fecha);
                }
                // Crear objeto a partir de los datos leídos
                vehiculos.add(v);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Listado de vehiculos: ");
        for (Vehiculo v : vehiculos) {
            System.out.println("----------------");
            System.out.println(v);
            System.out.println("Importe" + v.calcularImporte() + "€");
        }
        System.out.println("\nDatos procesados correctamente.");
        
    }

    //toDo logic de leer el archivo (separar todos por comas)
}
