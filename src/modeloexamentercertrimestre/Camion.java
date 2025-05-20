package modeloexamentercertrimestre;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Camion extends Vehiculo{
    private int numEjes;

    //Getter & Setter
    public int getNumEjes() {
        return numEjes;
    }

    public void setNumEjes(int numEjes) {
        this.numEjes = numEjes;
    }

    //Constructores
    public Camion(int numEjes) {
        this.numEjes = numEjes;
    }

    public Camion(int numEjes, String matricula, boolean abono, LocalDateTime fecha) {
        super(matricula, abono, fecha);
        this.numEjes = numEjes;
    }
    
    //toStrings
    @Override
    public String toString() {
        return super.toString()+ "\nnumEjes: " + numEjes ;
    }
    
    public String writeFileToString() {
        return super.writeFileToString() + numEjes;
    }
    
    @Override
    public double calcularImporte() {
        //Damos valor a la fecha de salida con la fecha que es cuando introduce de nuevo la matirucla
        LocalDateTime fechaSalida = LocalDateTime.now();
        //Convertimos a minutos y hacemos la diferencia entre la entrada (Fecha) y Salida
        //Para calcular el tiempo total en minutos
        LocalDateTime inicioMinutos = this.getFecha().withNano(0).withSecond(0);
        long totalMinutos = ChronoUnit.MINUTES.between(this.getFecha(), fechaSalida);
        
        System.out.println("Fecha de Inicio: " + inicioMinutos);
        System.out.println("Tiempo en minutos: "+totalMinutos);
        System.out.println("Numero de Ejes: " + this.numEjes);
        
        double tasa=0;
        double total=0;
        //Tasa equivale a lo que cuesta según las caracteristicas del vehiculo
        if (this.numEjes<=3){
            tasa = 4.5;
        }else{
            tasa = 6.5;
        }
        //Calculamos el precio a pagar por el usuario
        total = Math.round((totalMinutos * tasa / 60)* 100.0) / 100.0; 
        if(this.isAbono()){
            //Si tiene abono a ese total le aplicamos el 40% de descuento
            total -= (total*0.4);
        }
        total=Math.round(total*100.0)/100.0;
        return total;
    }
}
