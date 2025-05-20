package modeloexamentercertrimestre;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Vehiculo implements Comparable<Vehiculo> {

    //Atributos
    protected String matricula;
    protected boolean abono;
    protected LocalDateTime fecha;

    //Getters & Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isAbono() {
        return abono;
    }

    public void setAbono(boolean abono) {
        this.abono = abono;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    //Constructor
    public Vehiculo() {
    }

    public Vehiculo(String matricula, boolean abono, LocalDateTime fecha) {
        this.matricula = matricula;
        this.abono = abono;
        this.fecha = fecha;
    }

    //toString para leer en consola + toString de la clase hija (lo sobreescribirá) y añadirá el tipo de vehículo
    @Override
    public String toString() {
        return "Matricula: " + matricula
                + "\nAbono: " + abono
                + "\nfecha de entrada: " + fecha.getDayOfMonth() + "-"
                + fecha.getMonthValue() + "-"
                + fecha.getYear() + " "
                + fecha.getHour() + ":"
                + fecha.getMinute();
    }

    //writeFileToString para escribir en el archivo + writeFileToString de la clase hija (lo sobreescribirá) y añadirá el tipo de vehículo
    public String writeFileToString() {
        return matricula + "," + abono + "," + fecha.toString() + ",";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.matricula);
        hash = 37 * hash + (this.abono ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (this.abono != other.abono) {
            return false;
        }
        return Objects.equals(this.matricula, other.matricula);
    }

    //compareTo
    @Override
    public int compareTo(Vehiculo obj) {
        return this.matricula.compareTo(obj.matricula);
    }

    //CalcularImporte
    public abstract double calcularImporte();
}
