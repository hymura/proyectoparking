package co.ceiba.vehiculo;

public class Moto extends Vehiculo {

    int cilindraje;
    public Moto(String placa,int cilindraje) {
        super(placa);
        this.cilindraje=cilindraje;
    }

    public int getCilindraje(){
        return cilindraje;
    }
    public void setCilindraje(int cilindraje){
        this.cilindraje=cilindraje;
    }

}
