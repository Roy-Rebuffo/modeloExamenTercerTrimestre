package modeloexamentercertrimestre;

import java.util.ArrayList;

public abstract class Aparcamiento {

    //la lista que va a recoger todos los vehiculos
    public ArrayList<Vehiculo> vehiculos = new ArrayList<>();

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

    //CalcularImporte
    public abstract double calcularImporte();

    //toDo logic de leer el archivo (separar todos por comas)
}
