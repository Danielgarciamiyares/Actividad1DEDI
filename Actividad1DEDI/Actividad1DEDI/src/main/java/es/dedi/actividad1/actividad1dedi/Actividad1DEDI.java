/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.dedi.actividad1.actividad1dedi;

import Entidades.Aeropuerto;
import Entidades.Vuelo;
import Ficheros.Creacion;
import static Ficheros.Creacion.ficheroAeropuerto;
import LogicaNegocio.LogicaNegocio;
import static LogicaNegocio.LogicaNegocio.cargarVuelos;
import static LogicaNegocio.LogicaNegocio.getVueloDiarioByDia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import static LogicaNegocio.LogicaNegocio.verAeropuertos;
import static LogicaNegocio.LogicaNegocio.verCompanias;
import static LogicaNegocio.LogicaNegocio.verVuelos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Actividad1DEDI 
{
    public static void main(String[] args) 
    {
/*-----------------------------Aeropuertos------------------------------------*/
//    Creacion.crearFicheroAeropuertos();
//    Creacion.valoresInicialesAeropuertos();
//    verAeropuertos();
        
//    System.out.println(LogicaNegocio.getAeropuertoByIata("OVD"));
//    System.out.println(LogicaNegocio.getAeropuertoByNombre("Aeropuerto de León"));
//    System.out.println(LogicaNegocio.getAeropuertoByMunicipio("1524"));
        
//    System.out.println("Añadimos un nuevo aeropuerto");
//    LogicaNegocio.anadirAeropuerto("ABC", "Aeropuerto de Albacete", "02003");
        
//    Aeropuerto a=new Aeropuerto("3","Aeropuerto3","1524");
//    LogicaNegocio.modificarAeropuerto("3", a);
        
//    LogicaNegocio.eliminarAeropuerto("2");
//    System.out.println(LogicaNegocio.listaAeropuertos);
//    verAeropuertos();  
        
/*-----------------------------Companias--------------------------------------*/
//      Creacion.crearFicheroCompanias();
//        verCompanias();
        
        
/*--------------------------------Vuelos--------------------------------------*/        
//        Creacion.crearFicheroVuelos();
//        cargarVuelos();
//        verVuelos();
        
//      String s=  Creacion.crearCodigoVuelo("AA");
//        System.out.println(s);
        
        
//     List<Vuelo>  listavuelos=LogicaNegocio.getVueloByDiaOpera("LX");
//        System.out.println(listavuelos);
        
        
//        try {
//            
//         List<Vuelo>  vuelosHoy= LogicaNegocio.getVueloByDia("2023-12-05");
//         System.out.println(vuelosHoy);
//            
//        } catch (ParseException ex) {
//            Logger.getLogger(Actividad1DEDI.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
//        System.out.println(LogicaNegocio.todasLasCompanias()); 
        
//        LogicaNegocio.calculoRecaudacion("2024-01-01", 1f);
        
        
    }
}
