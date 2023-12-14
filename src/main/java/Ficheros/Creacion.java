/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ficheros;

import Entidades.Aeropuerto;
import Entidades.Compania;
import Entidades.Vuelo;
import LogicaNegocio.LogicaNegocio;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielgarcia
 */
public class Creacion 
{
    public static File ficheroAeropuerto=new File("src/main/java/Ficheros","Aeropuertos.csv");
    public static File ficheroCompania=new File("src/main/java/Ficheros","Compañias.csv");
    public static File ficheroVuelo=new File("src/main/java/Ficheros","Vuelo.csv");
    public static void main(String[] args) 
    {
        
    }
    
    /*---------------------------------------------------------------Creación de ficheros-----------------------------------------------------------------------*/
    /**
     * Metodo para crear el fichero Aeropuertos
     */
    public static void crearFicheroAeropuertos()
    {
        try
       {
            ficheroAeropuerto.createNewFile();
            valoresInicialesAeropuertos();
            LogicaNegocio.cargarAeropuertos();
       }
       catch(IOException e)
       {
           e.getMessage();
       }
    }
    /**
     * Metodo para crear el fichero Companias
     */
    public static void crearFicheroCompanias()
    {
        try
       {
            ficheroCompania.createNewFile();
            valoresInicialesCompanias();
            LogicaNegocio.cargarCompanias();
       }
       catch(IOException e)
       {
           e.getMessage();
       }
    }
    /**
     * Metodo para crear el fichero Vuelos
     */
    public static void crearFicheroVuelos()
    {
        try
       {
            ficheroVuelo.createNewFile();
            valoresInicialesVuelos();
            LogicaNegocio.cargarVuelos();
       }
       catch(IOException e)
       {
           e.getMessage();
       }
    }
    /**
     * Metodo para crear todos los ficheros
     */
    public static void crearFicheros()
    {
        try
       {
            crearFicheroAeropuertos();
            crearFicheroCompanias();
            crearFicheroVuelos();
       }
       catch(Exception e)
       {
           e.getMessage();
       }
    }
    /*---------------------------------------------------------------Creación de ficheros-----------------------------------------------------------------------*/

    /*---------------------------------------------------------------Valores iniciales de ficheros--------------------------------------------------------------*/
    /**
     * Metodo para la insercion de los valores iniciales del fichero Aeropuertos
     */
    public static void valoresInicialesAeropuertos()
    {
    try
        {
            FileWriter writerAer = new FileWriter(Ficheros.Creacion.ficheroAeropuerto,true);
            BufferedWriter bwAer = new BufferedWriter (writerAer);
            
            Aeropuerto a1=new Aeropuerto("OVD","Aeropuerto de Astirias","33016");
            Aeropuerto a2=new Aeropuerto("2","Aeropuerto2","1522");
            Aeropuerto a3=new Aeropuerto("3","Aeropuerto3","1523");
            Aeropuerto a4=new Aeropuerto("4","Aeropuerto4","1524");
            Aeropuerto a5=new Aeropuerto("ABC", "Aeropuerto de Albacete", "02003");

            LogicaNegocio.listaAeropuertos.add(a1);
            LogicaNegocio.listaAeropuertos.add(a2);
            LogicaNegocio.listaAeropuertos.add(a3);
            LogicaNegocio.listaAeropuertos.add(a4);
            LogicaNegocio.listaAeropuertos.add(a5);
            
            for(int i=0;i<LogicaNegocio.listaAeropuertos.size();i++)
            {
               bwAer.write(LogicaNegocio.listaAeropuertos.get(i).toString());
            }
            
            bwAer.close();
            writerAer.close();
        }
        catch(IOException e)
        {
            e.getMessage();
        }
    }
    /**
     * Metodo para la insercion de los valores iniciales del fichero Aeropuertos
     */
    public static void valoresInicialesCompanias()
    {
    try
        {
            FileWriter writerAer = new FileWriter(Ficheros.Creacion.ficheroCompania,true);
            BufferedWriter bwAer = new BufferedWriter (writerAer);
            
            Compania c1=new Compania("001","AA","American Airlines","1","Madrid",crearTelfonoCompania("001"),crearTelfonoCompania("001"));
            Compania c2=new Compania("005","CO","Continental Airlines Inc.","2","Barcelona",crearTelfonoCompania("005"),crearTelfonoCompania("005"));
            Compania c3=new Compania("006","DL","Delta Airlines Inc.","3","Sevilla",crearTelfonoCompania("006"),crearTelfonoCompania("006"));
            Compania c4=new Compania("012","NW","Northwest Airlines Inc.","4","Zaragoza",crearTelfonoCompania("012"),crearTelfonoCompania("012"));

            LogicaNegocio.listaCompanias.add(c1);
            LogicaNegocio.listaCompanias.add(c2);
            LogicaNegocio.listaCompanias.add(c3);
            LogicaNegocio.listaCompanias.add(c4);
            
            for(int i=0;i<LogicaNegocio.listaCompanias.size();i++)
            {
               bwAer.write(LogicaNegocio.listaCompanias.get(i).toString());
            }
            
            bwAer.close();
            writerAer.close();
        }
        catch(IOException e)
        {
            e.getMessage();
        }
    }
     
    public static String crearTelfonoCompania(String prefijo)
    {
      String ret;
      String tlf="";
      for(int i=0;i<9;i++)
      {
          int n=(int)(Math.random()*(0+9));
          tlf+=Integer.toString(n);
      }
        ret=prefijo+tlf;
       return ret;
    }
    
    /*Metodo para crear el codigo de vuelo en base a una compañia(su codigo)*/
    public static String crearCodigoVuelo(String codigoCompania)
    {
        String ret;
       String numero="";
       int random=(int)(Math.random()*(2+4));
      for(int i=0;i<random;i++)
      {
          int n=(int)(Math.random()*(0+9));
          numero+=Integer.toString(n);
      }
     ret=codigoCompania+numero;
       return ret;
    } 
    
    /**
     * Metodo para la insercion de los valores iniciales del fichero Vuelo
     */
    public static void valoresInicialesVuelos()
    {
        try
        {
            LogicaNegocio.cargarAeropuertos();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy" /*HH:mm:ss"*/); 
            
            Aeropuerto a1= LogicaNegocio.listaAeropuertos.get(1);
            Aeropuerto a2=LogicaNegocio.listaAeropuertos.get(2);
            Aeropuerto a3=LogicaNegocio.listaAeropuertos.get(3);
            
            FileWriter writerAer = new FileWriter(Ficheros.Creacion.ficheroVuelo,true);
            BufferedWriter bwAer = new BufferedWriter (writerAer);
            
            Vuelo v1=new Vuelo(crearCodigoVuelo("012"),a1.getCodigoIATA(),("OVD"),10,/*formato.parse*/LocalDate.parse("2023-12-05" /*17:30:00"*/),/*formato.parse*/LocalDate.parse("2023-12-05" /*18:00:00"*/),"LXSD");
            Vuelo v2=new Vuelo(crearCodigoVuelo("001"),a2.getCodigoIATA(),("OVD"),10,/*formato.parse*/LocalDate.parse("2024-01-01" /*20:00:00"*/),/*formato.parse*/LocalDate.parse("2024-01-01" /*20:15:00"*/),"XVD");
            Vuelo v3=new Vuelo(crearCodigoVuelo("006"),a3.getCodigoIATA(),("OVD"),10,/*formato.parse*/LocalDate.parse("2023-12-05"/*17:40:00"*/),/*formato.parse*/LocalDate.parse("2023-12-05"/*17:50:00"*/),"LVD");
            Vuelo v4=new Vuelo(crearCodigoVuelo("012"),("OVD"),a1.getCodigoIATA(),10,/*formato.parse*/LocalDate.parse("2024-01-01"/*20:00:00"*/),/*formato.parse*/LocalDate.parse("2024-01-01"/*20:05:00"*/),"XD");
            Vuelo v5=new Vuelo(crearCodigoVuelo("005"),("OVD"),a2.getCodigoIATA(),10,/*formato.parse*/LocalDate.parse("2023-11-29"/*10:00:00"*/),/*formato.parse*/LocalDate.parse("2023-11-29"/*10:10:00"*/),"LD");
            Vuelo v6=new Vuelo(crearCodigoVuelo("001"),("OVD"),a3.getCodigoIATA(),10,/*2formato.parse*/LocalDate.parse("2023-11-29" /*10:00:00"*/),/*formato.parse*/LocalDate.parse("2023-11-29"/*10:10:00"*/),"LXVS");
            
            LogicaNegocio.listaVuelos.add(v1);
            LogicaNegocio.listaVuelos.add(v2);
            LogicaNegocio.listaVuelos.add(v3);
            LogicaNegocio.listaVuelos.add(v4);
            LogicaNegocio.listaVuelos.add(v5);
            LogicaNegocio.listaVuelos.add(v6);
            
            for(int i=0;i<LogicaNegocio.listaVuelos.size();i++)
            {
               bwAer.write(LogicaNegocio.listaVuelos.get(i).toString());
            }
            bwAer.close();
            writerAer.close();
        }
        catch(IOException e)
        {
            e.getMessage();
        } 
//        catch (ParseException ex) 
//        {
//            ex.getMessage();
//        }
    }
    

    
    
    
    
    /*---------------------------------------------------------------Valores iniciales de ficheros--------------------------------------------------------------*/
    
    
    
}
