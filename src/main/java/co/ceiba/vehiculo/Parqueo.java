package co.ceiba.vehiculo;

import java.util.Date;

public class Parqueo {

int indice;
Date fechaEntrada;
Date fechaSalida;
Vehiculo vehiculo;
    public Parqueo(Vehiculo vehiculo, int indice, Date fechaEntrada, Date fechaSalida) {

        this.vehiculo=vehiculo;
        this.indice=indice;
        this.fechaEntrada=fechaEntrada;
        this.fechaSalida=fechaSalida;

    }


    public Date getfechaEntrada() {
        return fechaEntrada;
    }

    public String getPlaca() {
        return vehiculo.getPlaca();
    }

    public int getIndice() {
        return indice;
    }

    public Date getfechaSalida() {
        return fechaSalida;
    }
}

