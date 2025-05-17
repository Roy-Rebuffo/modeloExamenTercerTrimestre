package modeloexamentercertrimestre;

import java.time.LocalDateTime;
import java.util.Objects;

public class Vehiculo implements Comparable<Vehiculo> {

    //Atributos
    protected String matricula;
    protected boolean abono;

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

    //Constructor
    public Vehiculo() {
    }

    public Vehiculo(String matricula, boolean abono) {
        this.matricula = matricula;
        this.abono = abono;
    }

    @Override
    //toString
    public String toString() {
        return "matricula: " + matricula + "\nabono: " + abono;
    }

    //toString para escribir en el archivo
    public String writeFileToString(LocalDateTime fechaEntrada) {
        return matricula + "," + abono + "," + fechaEntrada;
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

}
