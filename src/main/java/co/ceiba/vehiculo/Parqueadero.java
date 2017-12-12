package co.ceiba.vehiculo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Parqueadero {

    Date FecheEntrada;
    Date FechaSalida;
    Date FechaIniPark;
    Date FechaFinPark;
    int CapacidadCarros = 20;
    int CapacidadMotos=10;
    int ValorHoracarro = 1000;
    int ValothoraMoto = 500;
    int dia;
    boolean letraPlaca;



    Carro[] celdasCarros=new Carro[CapacidadCarros];
    Moto[] celdasMoto=new Moto[CapacidadMotos];



    public Parqueadero(){
        //Carro[] celdasCarros=new Carro[CapacidadCarros];
        celdasCarros = new Carro[CapacidadCarros];
        celdasMoto=new Moto[CapacidadMotos];

    }


   public void setFechainicioPark( Date FechaIni){
       FechaIniPark=FechaIni;
   }

    public void setFechaFinPark( Date FechaFin){
        FechaFinPark=FechaFin;
    }

    public Date getFechaInicioPark() {
        Date FechaIni = new Date();
        SimpleDateFormat Formatea = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return FechaIni; // Formatea.format(FechaEntrada);
    }

    public Date getFechaFinPark() {
        Date FechaFin = new Date();
        SimpleDateFormat Formatea = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return FechaFin; // Formatea.format(FechaEntrada);
    }


    public Date getFechaEntrada() {
        Date FechaEntrada = new Date();
        SimpleDateFormat Formatea = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return FechaEntrada; // Formatea.format(FechaEntrada);
    }



    public Date getFechaSalida() {
        Date FechaSalida = new Date();
        SimpleDateFormat Formatea = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return FechaSalida;
    }


    //Obtener primer Letra de la placa
    public boolean validaPlaca(String placa) {
        Calendar fecha = Calendar.getInstance();
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

        if (placa.substring(0, 1).equalsIgnoreCase("A")) {
            if (fecha.get(Calendar.DAY_OF_WEEK)-1 == 1 || fecha.get(Calendar.DAY_OF_WEEK)-1 == 7) {
                return true;
            }
        }
        return false;
    }

//CARRO -

    public void setCapacidadCarro(int CapacidadCarros) {

        if (CapacidadCarros >0) {
            this.CapacidadCarros=CapacidadCarros-1;
        }
    }

    public int getCapacidadCarro() {
        return CapacidadCarros-getCeldasCarroOcupadas();
    }


    public int getCeldasCarroOcupadas() {

        int CapacidadOcupados=0;
        for (int i=0; i<celdasCarros.length; i++){

            if (celdasCarros[i] !=null ) {
                CapacidadOcupados=CapacidadOcupados+1;
            }

        }
        return CapacidadOcupados;
    }

    public void setCeldasCarro( int indice, String placa) {

        /*for (int i = 0; i <= CapacidadCarros; i++) {
            if (i==indice){
            celdasCarros[i].setPlaca(placa);
            }
        }*/
        celdasCarros[indice]=new Carro(placa);
        // return celdasCarros[indice].getPlaca();
    }

    public String getCeldasCarro(int indice) {
         /*  if (celdasCarros[indice].getPlaca()==null){
                      return null;
           }
          */
        return celdasCarros[indice].getPlaca();


    }

    public String RegistrarCarro(String placa, int fechaEnt) {

        return  "Placa "+placa+" Fecha Entrada "+fechaEnt;
    }




    public String getCeldasLibres() {

       String Celdaslibres=" ";
        for (int i=0; i<celdasCarros.length; i++){

            if (celdasCarros[i] ==null ) {
                Celdaslibres=Celdaslibres+"\n"+i;
            }

        }
        return Celdaslibres;
    }

    public void setLiberarCarro( String placa) {

        for (int i = 0; i <=celdasCarros.length ; i++) {
            if (celdasCarros[i].getPlaca() == placa) {
                celdasCarros[i]=null;
                break;
               // setCeldasCarro( i, null);

            }

        }
    }

    public int getValorHoracarroCarro(  ) {
        return ValorHoracarro;
    }


    public int getValorHoracarroMoto(  ) {
        return ValothoraMoto;
    }

    public double CalcularTarifa(double numhoras, int ValorDia, int ValorHora, int ValorCilindro){

        double NumDIas;
        double  NumHfaltante;
        double ValorTotal;


        NumDIas=Math.floor(numhoras/9);
        NumHfaltante=numhoras -(9*NumDIas);

        if (numhoras >=9) {
            ValorTotal = (NumDIas * ValorDia) + (NumHfaltante * ValorHora) + ValorCilindro;
        }
          else{
                ValorTotal = (numhoras * ValorHora) + ValorCilindro;
            }


        return ValorTotal;
    }


    public double Calcularhora(Date FechaEntrada, Date FechaSalida){

        double NumHoras;
        double numdias;

        NumHoras =(Math.abs(FechaSalida.getTime()-FechaEntrada.getTime()))/(1000*3600);

        if (NumHoras >=9) {
            numdias= NumHoras/24;
            NumHoras=(9*Math.floor(numdias))+((numdias-Math.floor(numdias))*24);
        }
        return NumHoras;
    }






}


