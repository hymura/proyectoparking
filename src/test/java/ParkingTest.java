
import co.ceiba.vehiculo.Carro;
import co.ceiba.vehiculo.Parqueadero;
import co.ceiba.vehiculo.Parqueo;
import com.sun.org.apache.xml.internal.security.utils.JavaUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ParkingTest {


    @Test
    public void parkingTest() {
        //Arrange


        Parqueadero parking = new Parqueadero();

        //Act

    //    System.out.println(parking.getFechaEntrada());
      //  parking.getFechaSalida();
        //Assert
        Assert.assertNotNull("1234", parking.getFechaEntrada());
    }

    @Test
    public void validaPlacaTest() {
        //Arrange

        Parqueadero parking = new Parqueadero();
        Carro coche = new Carro("MJQ757");
        //boolean letraPlaca;

        //ACT
        parking.validaPlaca(coche.getPlaca());
        //Assert
        Assert.assertFalse(parking.validaPlaca(coche.getPlaca()));

    }

    @Test
    public void validaDisponibilidadCarroTest() {
        //Arrange
        Parqueadero parking = new Parqueadero();
        //ACT

        int capacidadCarro=parking.getCapacidadCarro();
        System.out.println("capacidadCarro "+capacidadCarro );

        //Assert
        Assert.assertTrue(capacidadCarro>0);

    }


    @Test
    public void validaCeldaLibreCarroTest() {
        //Arrange
        Parqueadero parking = new Parqueadero();
        //ACT

        int capacidadCarro=parking.getCapacidadCarro();
        System.out.println("getCeldasLibres "+parking.getCeldasLibres() );

        //Assert
        Assert.assertTrue(capacidadCarro>0);

    }


    @Test
    public void IngresarCarro() {
        //Arrange
        Parqueadero parking = new Parqueadero();

        //ACT
        parking.setCeldasCarro( 0, "MJQ757");
        parking.setCeldasCarro( 1, "MJQ758");
        parking.setCeldasCarro( 2, "MJQ759");
        parking.setCeldasCarro( 3, "MJQ753");
        parking.setCeldasCarro( 4, "MJQ750");


        System.out.println("getCeldasLibres "+parking.getCeldasLibres() );

       //Assert
       Assert.assertEquals("MJQ757", parking.getCeldasCarro(0));

    }


    @Test
    public void SalirCarro() {
        //Arrange
        Parqueadero parking = new Parqueadero();

        //ACT
        parking.setCeldasCarro( 2, "MJQ757");
        parking.setCeldasCarro( 1, "MJQ758");
        parking.setCeldasCarro( 0, "MJQ759");
        parking.setCeldasCarro( 3, "MJQ753");
        parking.setCeldasCarro( 4, "MJQ750");


        parking.setLiberarCarro( "MJQ757");

        System.out.println("getCeldasLibres "+parking.getCeldasLibres() );


        //Assert
        Assert.assertNull( parking.getCeldasCarro(2));

    }


    @Test
    public void ParqueoTest() {

        Parqueadero parking = new Parqueadero();

        Carro coche = new Carro("MJQ757");

        parking.setCeldasCarro( 0, "MJQ757");
        Date fechaEntrada=  parking.getFechaEntrada();
        Date fechaSalida=  parking.getFechaSalida();
        //boolean letraPlaca;
        Parqueo parqueo = new Parqueo(coche ,0 ,fechaEntrada, fechaSalida);

        System.out.println("Fecha de registro: "+ parqueo.getfechaEntrada() +" placa "+parqueo.getPlaca()+" indice"+parqueo.getIndice());
        Assert.assertEquals("MJQ757", parqueo.getPlaca());
    }


    @Test
    public void SalidaParqueoTest() {

        Parqueadero parking = new Parqueadero();
        Carro coche = new Carro("MJQ757");
        parking.setCeldasCarro( 0, "MJQ757");
       Date fechaEntrada= parking.getFechaEntrada();
       //Date fechaSalida= parking.getFechaSalida();


        //boolean letraPlaca;
        Parqueo parqueo = new Parqueo(coche ,0 ,fechaEntrada,fechaEntrada);

        System.out.println("Fecha de registro: "+ parqueo.getfechaEntrada() +" placa "+parqueo.getPlaca()+" indice"+parqueo.getIndice()+" Fecha Salida"+parqueo.getfechaSalida() );
        Assert.assertEquals("MJQ757", parqueo.getPlaca());
    }

@Test
public void CalcularTarifaCarroHoraTest() {
    Parqueadero parking = new Parqueadero();


    Date DiferFecha= new Date();
    int valorHcarro=0;
    double CalculaHora=0;
    double NumHora=0;

    Date fechaEntrada = new Date(117, 11, 5,8,00,00);

    //ACT

    System.out.println("fecha entrada "+ fechaEntrada);
    System.out.println("fecha Salida "+ parking.getFechaEntrada());

    valorHcarro=parking.getValorHoracarroCarro();
    NumHora=parking.Calcularhora(fechaEntrada,parking.getFechaSalida());

   System.out.println("NumHora "+ NumHora);

   CalculaHora=parking.CalcularTarifa(NumHora,8000, 1000,0);

    System.out.println("CalculaHora "+ CalculaHora);




    //ASSERT
    Assert.assertEquals("2000", CalculaHora);
}


    @Test
    public void CalcularTarifaMotoHoraTest() {
        Parqueadero parking = new Parqueadero();


        Date DiferFecha= new Date();
        int valorHcarro=0;
        double CalculaHora=0;
        double NumHora=0;

        Date fechaEntrada = new Date(117, 11, 6,8,00,00);

        //ACT

        System.out.println("fecha entrada "+ fechaEntrada);
        System.out.println("fecha Salida "+ parking.getFechaEntrada());

        valorHcarro=parking.getValorHoracarroCarro();
        NumHora=parking.Calcularhora(fechaEntrada,parking.getFechaSalida());

        System.out.println("NumHora "+ NumHora);

        CalculaHora=parking.CalcularTarifa(NumHora,8000, 1000,500);

        System.out.println("CalculaHora "+ CalculaHora);




        //ASSERT
        Assert.assertEquals("3500", CalculaHora);
    }

    @Test
    public void CalcularHoraTest() {
        Parqueadero parking = new Parqueadero();


        Date DiferFecha= new Date();
        int valorHcarro=0;
        double CalculaHora=0;
        double NumHora=0;

        Date fechaEntrada = new Date(117, 11, 5,8,00,00);


        //ACT

        System.out.println("fecha entrada "+ fechaEntrada);

        System.out.println("fecha SALIDA "+ parking.getFechaSalida());
        NumHora=parking.Calcularhora(fechaEntrada,parking.getFechaSalida());

        System.out.println("NumHora "+ NumHora);


        //ASSERT
        Assert.assertEquals("12", CalculaHora);
    }


    // @Test
    /*public void RegistroCarro() {

        //valida Placa
        if (parking.validaPlaca(coche.getPlaca(),parking.getDIaEntrada(coche.getPlaca()))){
            System.out.println("Fecha de registro: "+parking.getFechaEntrada());

        }else
        {
            System.out.println("Placa no se puede registrar");
        }

        //verifica Disponibilidad

        if (parking.getCapacidadCarro() >0 ){

            parking.RegistrarCarro(coche.getPlaca(),parking.getDIaEntrada(coche.getPlaca()));
            parking.setCapacidadCarro( parking.getCapacidadCarro());
            System.out.println( parking.getCapacidadCarro());
        }


        //Assert
        Assert.assertNotNull("2017", 2017);

    }
*/
}


