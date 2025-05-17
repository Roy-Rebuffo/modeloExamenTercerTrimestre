package modeloexamentercertrimestre;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Aparcamiento {

    //la lista que va a recoger todos los vehiculos
    public ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    //Atributos
    private int capacidad = 10;
    private LocalDateTime fecha;

    //Getters & Setters
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
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

    public Aparcamiento(int capacidad, LocalDateTime fecha) {
        this.capacidad = capacidad;
        this.fecha = fecha;
    }

    //toString
    @Override
    public String toString() {
        return "Aparcamiento{" + "vehiculos=" + vehiculos + ", capacidad=" +
                capacidad + ", fecha=" + fecha.getDayOfMonth()+"-" + 
                fecha.getMonthValue() + "-"+fecha.getYear() + 
                "\nHora:"+ fecha.getHour() + ": "+ fecha.getMinute() +
                ": "+fecha.getSecond();
    }
    

    //CalcularImporte
    public abstract double calcularImporte();

    //toDo logic de leer el archivo (separar todos por comas)
}
