package modeloexamentercertrimestre;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Automovil extends Vehiculo{
     private String tipo;

    //Getter & Setter de automovil
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
     
    //Constructor que va a recoger tambien los atributos de la clase Vehiculo

    public Automovil(String tipo) {
        this.tipo = tipo;
    }

    public Automovil(String tipo, String matricula, boolean abono, LocalDateTime fecha) {
        super(matricula, abono, fecha);
        this.tipo = tipo;
    }

    //toString final para ver por consola los vehiculos de tipo Automovil
    @Override
    public String toString() {
        return super.toString()+ "\nTipo: " + tipo;
    }
    
    public String writeFileToString(){
            return  super.writeFileToString() + tipo;
    }
    
    //Aplicamos el metoodo de calcularImporte
    @Override
    public double calcularImporte() {
        //Damos valor a la fecha de salida con la fecha que es cuando introduce de nuevo la matirucla
        LocalDateTime fechaSalida = LocalDateTime.now();
        //Convertimos a minutos y hacemso la diferencia entre la entrada (Fecha) y Salida
        //Para calcular el tiempo total en minutos
        
        LocalDateTime inicioMinutos = this.getFecha().withNano(0).withSecond(0);
        long totalMinutos = ChronoUnit.MINUTES.between(this.getFecha(), fechaSalida);
        
        System.out.println("Fecha de Inicio: " + inicioMinutos);
        System.out.println("Tiempo en minutos: " + totalMinutos);
        System.out.println("Tipo: " + tipo);
        double tasa=0;
        double total=0;
        
        //Tasa equivale a lo que cuesta según las caracteristicas del vehiculo
        switch(this.tipo){
            case "Turismo":
                tasa=1.5;
                break;
            case "TodoTerreno":
                tasa=2.5;
                break;
            case "Furgoneta":
                tasa=3.5;
                break;    
        }
        //Calculamos el precio a pagar por el usuario
        total=( totalMinutos * tasa) / 60; 
        if(this.isAbono()){
            //Si tiene abono a ese total le aplicamos el 40% de descuento
            total -= (total*0.4);
        }
        
        return Math.round((total)*100.0) / 100.0 ;
    }
}
