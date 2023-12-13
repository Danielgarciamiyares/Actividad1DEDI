/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocio;

import Entidades.Aeropuerto;
import Entidades.Compania;
import Entidades.Vuelo;
import Entidades.VueloDiario;
import Ficheros.Creacion;
import static Ficheros.Creacion.ficheroAeropuerto;
import static Ficheros.Creacion.ficheroVuelo;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielgarcia
 */
public class LogicaNegocio 
{
    /**
     * Metodos de Aeropuerto
     */
    /*-------------------------Logica de aeropuerto---------------------------*/
    /**
     * Metodo que crea un aeropuerto con los parametros
     *
     * @param codigoIata del aeropuerto
     * @param nombre del aeropuerto
     * @param codMunicipio
     */
    public static void anadirAeropuerto(String codigoIata, String nombre, String codMunicipio) 
    {
        boolean valido=false;
        do{
            if(!AeropuertoIATAExists(codigoIata)&&!AeropuertoNombreExists(nombre))
            {
//                valido=true;
                try 
                {
                    FileWriter writerAer = new FileWriter(Ficheros.Creacion.ficheroAeropuerto, true);
                    BufferedWriter bwAer = new BufferedWriter(writerAer);

                    Aeropuerto a = new Aeropuerto(codigoIata, nombre, codMunicipio);

                    bwAer.write(a.toString());
                    bwAer.close();
                    writerAer.close();
                } 
                catch (IOException e) 
                {
                    e.getMessage();
                }
            }
            else
            {
                System.out.println("Ya hay un aeropuerto con ese nombre o ese codigo IATA");
                break;
            }

        }while(!valido);
    }

    public static List<Aeropuerto> listaAeropuertos = new ArrayList<>();

    /*Metodo que llena la lista aeropuertos con los valores del fichero aeropuertos*/
    public static void cargarAeropuertos() 
    {
        List<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();
        Aeropuerto aeropuerto;
        try 
        {
            //Obtiene array de lineas contenidas en archivo.
            String[] lines = Files.readAllLines(Ficheros.Creacion.ficheroAeropuerto.toPath()).toArray(new String[0]);
            //Analiza cada linea y la compara.

            for (String line : lines) 
            {
                String[] values = line.split(",");

                aeropuerto = new Aeropuerto(values[0], values[1], values[2]);
                aeropuertos.add(aeropuerto);
            }
        } 
        catch (EOFException e) 
        {
            e.getMessage();
        } 
        catch (FileNotFoundException e) 
        {
            e.getMessage();
        } 
        catch (IOException e) 
        {
            e.getMessage();
        }
        listaAeropuertos = aeropuertos;
    }

    public static List<Aeropuerto> todosLosAeropuertos()
    {
        List<Aeropuerto> aeropuertos = new ArrayList<Aeropuerto>();
        Aeropuerto aeropuerto;
        try 
        {
            //Obtiene array de lineas contenidas en archivo.
            String[] lines = Files.readAllLines(Ficheros.Creacion.ficheroAeropuerto.toPath()).toArray(new String[0]);
            //Analiza cada linea y la compara.

            for (String line : lines) 
            {
                String[] values = line.split(",");

                aeropuerto = new Aeropuerto(values[0], values[1], values[2]);
                aeropuertos.add(aeropuerto);
            }
        } 
        catch (EOFException e) 
        {
            e.getMessage();
        } 
        catch (FileNotFoundException e) 
        {
            e.getMessage();
        } 
        catch (IOException e) 
        {
            e.getMessage();
        }
        return aeropuertos;
    }
    
    
    /**
     * Metodo que muestra la lista de todos los aeropuertos
     */
    public static void verAeropuertos() 
    {
        cargarAeropuertos();
        System.out.println(listaAeropuertos);
    }

    /**
     * Metodo que actualiza un aeropuerto(seleccionado por el codigo IATA) con los valores de un aeropuerto pasado como parametro
     * @param CodigoIATA el codigo IATA del aeropuerto que se quiere modificar
     * @param aeroActualizado El aeropuerto ya modificado
     */
    public static void modificarAeropuerto(String CodigoIATA,Aeropuerto aeroActualizado) 
    {
        try
        {
            Aeropuerto a=getAeropuertoByIata(CodigoIATA);
            a.setCodigoIATA(aeroActualizado.getCodigoIATA());
            a.setNombreAeropuerto(aeroActualizado.getNombreAeropuerto());
            a.setCodMunicipio(aeroActualizado.getCodMunicipio());

            BufferedWriter BW;
            BW=new BufferedWriter(new FileWriter(Ficheros.Creacion.ficheroAeropuerto));
                /*Borra el fichero anterior*/
                Creacion.ficheroAeropuerto.delete();
                /*crea el fichero aeropuertos y lo llena con los datos anteriores y el modificado*/
                ficheroAeropuerto.createNewFile();
            /*escribe las filas de la lista en el fichero */
            for(int i=0;i<LogicaNegocio.listaAeropuertos.size();i++)
            {
               BW.write(LogicaNegocio.listaAeropuertos.get(i).toString());
            }

            BW.close();
        }
        catch(IOException e)
        {
            e.getMessage();
        }
    }
    
    /**
     * Metodo para eliminar un aeropuerto cuyo codigo IATA sea igual al pasado como parámetro
     * @param CodigoIATA El coddigoIATA pasado como parámettro
     */
    public static void eliminarAeropuerto(String CodigoIATA)
    {
        cargarAeropuertos();
        try
        {
            listaAeropuertos.removeIf((pred) -> pred.getCodigoIATA().equals(CodigoIATA));
            
            BufferedWriter BW;
            BW=new BufferedWriter(new FileWriter(Ficheros.Creacion.ficheroAeropuerto));
                /*Borra el fichero anterior*/
                Creacion.ficheroAeropuerto.delete();
                /*crea el fichero aeropuertos y lo llena con los datos anteriores y el modificado*/
                ficheroAeropuerto.createNewFile();
            /*escribe las filas de la lista en el fichero */
            for(int i=0;i<LogicaNegocio.listaAeropuertos.size();i++)
            {
               BW.write(LogicaNegocio.listaAeropuertos.get(i).toString());
            }

            BW.close();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    /**
     * Metodo que devuelve un aeropuerto cuyo codigo Iata sea el pasado como
     * parametro
     *
     * @param CodigoIata del aeropuerto
     * @return el aeropuerto con ese codigo Iata
     */
    public static Aeropuerto getAeropuertoByIata(String CodigoIata) 
    {
        cargarAeropuertos();
        try 
        {
            Optional<Aeropuerto> ret = listaAeropuertos.stream()/*convierte una coleccion en un flujo*/
                    .filter(value -> value.getCodigoIATA().equals(CodigoIata))
                    .findFirst();
            if (ret.isPresent()) 
            {
                return ret.get();/*Devulve el valor de Optional(en este caso un aeropuerto)*/
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }

        return new Aeropuerto();/*Devuelve todos los valores como null al ser nuevo*/
    }
    /**
     * Metodo que devuelve un aeropuerto cuyo nombre coincida con el valor
     * pasado
     *
     * @param Nombre del aeropuerto
     * @return el aeropuerto con ese nombre
     */
    public static Aeropuerto getAeropuertoByNombre(String Nombre) 
    {
        cargarAeropuertos();
        try 
        {
            Optional<Aeropuerto> ret = listaAeropuertos.stream()
                    .filter(value -> value.getNombreAeropuerto().equals(Nombre))
                    .findFirst();
            if (ret.isPresent()) 
            {
                return ret.get();
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
        return new Aeropuerto();
    }
    /**
     * Metodo que devuelve una lista de aeropuetos cuyo codigo de municipio sea
     * el pasado
     *
     * @param Codigo es el codigo de municipio
     * @return una lista de los aeropuertos con ese codigo de municipio
     */
    public static List<Aeropuerto> getAeropuertoByMunicipio(String Codigo) {
        cargarAeropuertos();
        List<Aeropuerto> ret = listaAeropuertos.stream()
            .filter(value -> value.getCodMunicipio().equals(Codigo))
            .toList();
        return ret;
    }
    /**
     * Metodo para seleccionar el aeropuerto principal
     */
    public static Aeropuerto aeropuertoPrincipal = getAeropuertoByIata("OVD");

    /**
     * Metodo para saber si hay algun aeropuerto con ese nombre
     * @param Nombre
     * @return devuelve true si existe
     */
    public static boolean AeropuertoNombreExists(String Nombre)
    {
        boolean ret=false;
        
        cargarAeropuertos();
        try 
        {
            Optional<Aeropuerto> opt = listaAeropuertos.stream()
                    .filter(value -> value.getNombreAeropuerto().equals(Nombre))
                    .findFirst();
            if (opt.isPresent()) 
            {
                ret=true;
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
        
        return ret;
    }
            
            
    /**
     * Metodo para saber si hay algun aeropuerto con ese codigo IATA
     * @param codigoIATA 
     * @return devuelve true si existe
     */
    public static boolean AeropuertoIATAExists(String codigoIATA)
    {
        boolean ret=false;
        
        cargarAeropuertos();
        try 
        {
            Optional<Aeropuerto> opt = listaAeropuertos.stream()
                    .filter(value -> value.getCodigoIATA().equals(codigoIATA))
                    .findFirst();
            if (opt.isPresent()) 
            {
                ret=true;
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
        
        return ret;
    }   
            
            
            
    
    /*-----------------------Fin Logica Aeropuerto----------------------------*/

    /*-----------------------Logica de compañias------------------------------*/
    public static List<Compania> listaCompanias = new ArrayList<>();

    /*Metodo que llena la lista companias con los valores del fichero companias*/
    public static void cargarCompanias() 
    {
        List<Compania> companias = new ArrayList<Compania>();
        Compania compania;
        try 
        {
            //Obtiene array de lineas contenidas en archivo.
            String[] lines = Files.readAllLines(Ficheros.Creacion.ficheroCompania.toPath()).toArray(new String[0]);
            //Analiza cada linea y la compara.

            for (String line : lines) 
            {
                String[] values = line.split(",");

                compania = new Compania(values[0], values[1], values[2],values[3], values[4], values[5],values[6]);
                companias.add(compania);
            }
        } 
        catch (EOFException e) 
        {
            e.getMessage();
        } 
        catch (FileNotFoundException e) 
        {
            e.getMessage();
        } 
        catch (IOException e) 
        {
            e.getMessage();
        }
        listaCompanias = companias;
    }
    
    public static List<Compania> todasLasCompanias() 
    {
        List<Compania> companias = new ArrayList<Compania>();
        Compania compania;
        try 
        {
            //Obtiene array de lineas contenidas en archivo.
            String[] lines = Files.readAllLines(Ficheros.Creacion.ficheroCompania.toPath()).toArray(new String[0]);
            //Analiza cada linea y la compara.

            for (String line : lines) 
            {
                String[] values = line.split(",");

                compania = new Compania(values[0], values[1], values[2],values[3], values[4], values[5],values[6]);
                companias.add(compania);
            }
        } 
        catch (EOFException e) 
        {
            e.getMessage();
        } 
        catch (FileNotFoundException e) 
        {
            e.getMessage();
        } 
        catch (IOException e) 
        {
            e.getMessage();
        }
        return companias;
    }
    
    public static void verCompanias() 
    {
        cargarCompanias();
        System.out.println(listaCompanias);
    }
    /**
     * Metodo que devuelve una compania cuyo prefijo coincida con el valor
     * pasado
     *
     * @param prefijo
     * @return la compania con ese prefijo
     */
    public static Compania getCompaniaByPrefijo(String prefijo) {
        cargarCompanias();
        try 
        {
            Optional<Compania> ret = listaCompanias.stream()
                    .filter(value -> value.getPrefijo().equals(prefijo))
                    .findFirst();
            if (ret.isPresent()) 
            {
                return ret.get();
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
        return new Compania();
    }
    /**
     * Metodo que devuelve una compania cuyo codigo coincida con el valor pasado
     *
     * @param codigo de la compania
     * @return la compania con ese codigo
     */
    public static Compania getCompaniaByCodigo(String codigo) {
        cargarCompanias();
        try 
        {
            Optional<Compania> ret = listaCompanias.stream()
                    .filter(value -> value.getCodigo().equals(codigo))
                    .findFirst();
            if (ret.isPresent()) 
            {
                return ret.get();
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
        return new Compania();
    }
    /**
     * Metodo que devuelve una compania cuyo nombre coincida con el valor pasado
     *
     * @param nombre de la compania
     * @return la compania con ese nombre
     */
    public static Compania getCompaniaByNombre(String nombre) 
    {
        cargarCompanias();
        try 
        {
            Optional<Compania> ret = listaCompanias.stream()
                .filter(value -> value.getNombre().toUpperCase().equals(nombre.toUpperCase()))
                .findFirst();
            if (ret.isPresent()) 
            {
                return ret.get();
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
        return new Compania();
    }
    
    public static List<Compania> getCompaniaByMunicipio(String municipio) 
    {
    cargarCompanias();
        List<Compania> ret = listaCompanias.stream()
            .filter(value -> value.getMunicipio().toUpperCase().equals(municipio.toUpperCase()))
            .toList();

        return ret;
    }
    
    
    /**
     * Metodo que revisa si ya existe una compañia con ese prefijo
     * @param prefijo 
     * @return devuelve true si existe
     */
    public static boolean CompaniaPrefijoExists(String prefijo)
    {
        boolean ret=false;
        
        cargarCompanias();
        try 
        {
            Optional<Compania> opt = listaCompanias.stream()
                    .filter(value -> value.getPrefijo().equals(prefijo))
                    .findFirst();
            if (opt.isPresent()) 
            {
                ret=true;
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
        
        return ret;
    }   
    
    
    /**
     * Metodo que revisa si ya existe una compañia con ese nombre
     * @param Nombre 
     * @return devuelve true si existe
     */
    public static boolean CompaniaNombreExists(String Nombre)
    {
        boolean ret=false;
        
        cargarCompanias();
        try 
        {
            Optional<Compania> opt = listaCompanias.stream()
                    .filter(value -> value.getNombre().toUpperCase().equals(Nombre.toUpperCase()))
                    .findFirst();
            if (opt.isPresent()) 
            {
                ret=true;
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
        
        return ret;
    }   
    
    
    /**
     * Metodo que revisa si ya existe una compañia con ese prefijo
     * @param prefijo 
     * @return devuelve true si existe
     */
    public static boolean CompaniaCodigoExists(String Codigo)
    {
        boolean ret=false;
        
        cargarCompanias();
        try 
        {
            Optional<Compania> opt = listaCompanias.stream()
                    .filter(value -> value.getCodigo().toUpperCase().equals(Codigo.toUpperCase()))
                    .findFirst();
            if (opt.isPresent()) 
            {
                ret=true;
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
        
        return ret;
    }   
    
    /**
     * Metodo que revisa si ya existe una compañia con ese prefijo
     * @param Direccion 
     * @return devuelve true si existe
     */
    public static boolean CompaniaDireccionExists(String Direccion)
    {
        boolean ret=false;
        
        cargarCompanias();
        try 
        {
            Optional<Compania> opt = listaCompanias.stream()
                    .filter(value -> (value.getDireccion().toUpperCase()).equals(Direccion.toUpperCase()))
                    .findFirst();
            if (opt.isPresent()) 
            {
                ret=true;
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
        
        return ret;
    }
    

    /**
     * Metodo que añade una compañia al fichero compañias con los parametros
     *
     * @param prefijo de la compañia
     * @param codigo de la compañia
     * @param nombre de la compañia
     * @param direccion de la compañia
     * @param municipio de la compañia
     * @param tlfP teléfono de atención al pasajero
     * @param tlfA teléfono de atención a aeropouertos
     */
    public static void anadirCompania(String prefijo, String codigo, String nombre, String direccion, String municipio, String tlfP, String tlfA) {
     boolean valido=false;
        do
        {
            if(!CompaniaPrefijoExists(prefijo)&&!CompaniaCodigoExists(codigo)&&!CompaniaNombreExists(nombre)&&!CompaniaDireccionExists(direccion))
            {
                try 
                {
                    FileWriter writerCom = new FileWriter(Ficheros.Creacion.ficheroAeropuerto, true);
                    BufferedWriter bwCom = new BufferedWriter(writerCom);

                    Compania c = new Compania(prefijo, codigo, nombre, direccion, municipio, tlfP, tlfA);

                    bwCom.write(c.toString());
                    bwCom.close();
                    writerCom.close();
                } 
                catch (IOException e) 
                {
                    e.getMessage();
                }
            }
            else
            {
                System.out.println("Ya existe alguna compania con alguno de los valores introducidos");
                break;
            }
        }while(!valido);
    }
    /**
     * Metodo que permite modificar la compañia cuyo codigo sea igual que el pasado como parametro
     * @param codigo codigo introducido como parametro
     * @param compActualizada Compañia de la que se cogen los datos 
     */
    public static void modificarCompañia(String codigo,Compania compActualizada) 
    {
        try
        {
            Compania comp=getCompaniaByCodigo(codigo);
            comp.setPrefijo(compActualizada.getPrefijo());
            comp.setCodigo(compActualizada.getCodigo());
            comp.setNombre(compActualizada.getNombre());
            comp.setDireccion(compActualizada.getDireccion());
            comp.setMunicipio(compActualizada.getMunicipio());
            comp.setTlfInfoPasajero(compActualizada.getTlfInfoPasajero());
            comp.setTlfInfoAeropuerto(compActualizada.getTlfInfoAeropuerto());
            
            BufferedWriter BW;
            BW=new BufferedWriter(new FileWriter(Ficheros.Creacion.ficheroCompania));
                /*Borra el fichero anterior*/
                Creacion.ficheroCompania.delete();
                /*crea el fichero aeropuertos y lo llena con los datos anteriores y el modificado*/
                Creacion.ficheroCompania.createNewFile();
            /*escribe las filas de la lista en el fichero */
            for(int i=0;i<LogicaNegocio.listaCompanias.size();i++)
            {
               BW.write(LogicaNegocio.listaCompanias.get(i).toString());
            }

            BW.close();
        }
        catch(IOException e)
        {
            e.getMessage();
        }
    }
    /**
     * Metodo que permite eliminar la compañia cuyo codigo es igual que el pasado como parametro
     * @param codigo codigo introducido como parametro
     */
    public static void eliminarCompania(String codigo) 
    {
        cargarCompanias();
        try
        {
            listaCompanias.removeIf((pred) -> pred.getCodigo().equals(codigo));
            
            BufferedWriter BW;
            BW=new BufferedWriter(new FileWriter(Ficheros.Creacion.ficheroCompania));
                /*Borra el fichero anterior*/
                Creacion.ficheroCompania.delete();
                /*crea el fichero aeropuertos y lo llena con los datos anteriores y el modificado*/
                Creacion.ficheroCompania.createNewFile();
            /*escribe las filas de la lista en el fichero */
            for(int i=0;i<LogicaNegocio.listaCompanias.size();i++)
            {
               BW.write(LogicaNegocio.listaCompanias.get(i).toString());
            }

            BW.close();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    /*-----------------------Fin Logica Compañias-----------------------------*/

    /*---------------------------Logica Vuelos--------------------------------*/
    
    public static List<Vuelo> listaVuelos=new ArrayList<>();
    
    
    /*Metodo que llena la lista companias con los valores del fichero companias*/
    public static void cargarVuelos() 
    {
        List<Vuelo> vuelos = new ArrayList<Vuelo>();
        Vuelo vuelo;
        try 
        {
//            SimpleDateFormat formato = new Local("dd/MM/yyyy" /*HH:mm:ss"*/); 
            
            //Obtiene array de lineas contenidas en archivo.
            String[] lines = Files.readAllLines(Ficheros.Creacion.ficheroVuelo.toPath()).toArray(new String[0]);
            //Analiza cada linea y la compara.

            for (String line : lines) 
            {
                String[] values = line.split(",");

                vuelo = new Vuelo(values[0],values[1],values[2],Integer.parseInt(values[3]), /*formato.parse*/LocalDate.parse(values[4]),/*formato.parse*/LocalDate.parse(values[5]),values[6]);
                vuelos.add(vuelo);
            }
        } 
        catch (EOFException e) 
        {
            e.getMessage();
        } 
        catch (FileNotFoundException e) 
        {
            e.getMessage();
        } 
        catch (IOException e) 
        {
            e.getMessage();
        } 
//        catch (ParseException ex) 
//        {
//            ex.getMessage();
//        }
        listaVuelos = vuelos;
    }
    
    
    public static List<Vuelo> todosLosVuelos() 
    {
        List<Vuelo> vuelos = new ArrayList<Vuelo>();
        Vuelo vuelo;
        try 
        {
            //Obtiene array de lineas contenidas en archivo.
            String[] lines = Files.readAllLines(Ficheros.Creacion.ficheroVuelo.toPath()).toArray(new String[0]);
            //Analiza cada linea y la compara.

            for (String line : lines) 
            {
                String[] values = line.split(",");

                vuelo = new Vuelo(values[0], values[1], values[2],Integer.parseInt(values[3]),LocalDate.parse(values[4]), LocalDate.parse(values[5]),values[6]);
                vuelos.add(vuelo);
            }
        } 
        catch (EOFException e) 
        {
            e.getMessage();
        } 
        catch (FileNotFoundException e) 
        {
            e.getMessage();
        } 
        catch (IOException e) 
        {
            e.getMessage();
        }
        return vuelos;
    }
    
    
    
    
    
    
    
    
    
    /**
     * Metodo que muestra la lista de todos los vuelos
     */
    public static void verVuelos() 
    {
        cargarVuelos();
        System.out.println(listaVuelos);
    }
    
    /**
     * Metodo que añade una compañia al fichero compañias con los parametros
     *
     * @param prefijo de la compañia
     * @param codigo de la compañia
     * @param nombre de la compañia
     * @param direccion de la compañia
     * @param municipio de la compañia
     * @param tlfP teléfono de atención al pasajero
     * @param tlfA teléfono de atención a aeropouertos
     */
    public static void anadirVuelo(String codigo, String AeropuertoOrigen, String AeropuertoDestino, int Plazas, LocalDate FechaSalida, LocalDate FechaLlegada, String DiasOpera) {
     boolean valido=false;
        do
        {
            if(!VueloCodigoExists(codigo))
            {
                try 
                {
                    FileWriter writerCom = new FileWriter(Ficheros.Creacion.ficheroVuelo, true);
                    BufferedWriter bwCom = new BufferedWriter(writerCom);

                    Vuelo v = new Vuelo(codigo, AeropuertoOrigen, AeropuertoDestino, Plazas, FechaSalida,FechaLlegada, DiasOpera);

                    bwCom.write(v.toString());
                    bwCom.close();
                    writerCom.close();
                } 
                catch (IOException e) 
                {
                    e.getMessage();
                }
            }
            else
            {
                System.out.println("Ya existe algun vuelo con alguno de los valores introducidos");
                break;
            }
        }while(!valido);
    }
    
    
    public static void modificarVuelos(String Codigo,Vuelo vueloActualizado) 
    {
        try
        {
            Vuelo v=getVueloByCodigo(Codigo);
            v.setCodigoVuelo(vueloActualizado.getCodigoVuelo());
            v.setAeropuertoOrigen(vueloActualizado.getAeropuertoOrigen());
            v.setAeropuertoDestino(vueloActualizado.getAeropuertoDestino());
            v.setPlazas(vueloActualizado.getPlazas());
            v.setHoraSalida(vueloActualizado.getHoraSalida());
            v.setHoraLlegada(vueloActualizado.getHoraLlegada());
            v.setDiasOpera(vueloActualizado.getDiasOpera());
            
            BufferedWriter BW;
            BW=new BufferedWriter(new FileWriter(ficheroVuelo));
                /*Borra el fichero anterior*/
                ficheroVuelo.delete();
                /*crea el fichero aeropuertos y lo llena con los datos anteriores y el modificado*/
                ficheroVuelo.createNewFile();
            /*escribe las filas de la lista en el fichero */
            for(int i=0;i<LogicaNegocio.listaVuelos.size();i++)
            {
               BW.write(LogicaNegocio.listaVuelos.get(i).toString());
            }

            BW.close();
        }
        catch(IOException e)
        {
            e.getMessage();
        }
    }
    
    
    public static void eliminarVuelo(String Codigo)
    {
        cargarVuelos();
        try
        {
            listaVuelos.removeIf((pred) -> pred.getCodigoVuelo().equals(Codigo));
            
            BufferedWriter BW;
            BW=new BufferedWriter(new FileWriter(Ficheros.Creacion.ficheroVuelo));
                /*Borra el fichero anterior*/
                ficheroVuelo.delete();
                /*crea el fichero aeropuertos y lo llena con los datos anteriores y el modificado*/
                ficheroVuelo.createNewFile();
            /*escribe las filas de la lista en el fichero */
            for(int i=0;i<LogicaNegocio.listaVuelos.size();i++)
            {
               BW.write(LogicaNegocio.listaVuelos.get(i).toString());
            }

            BW.close();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
    
    public static Vuelo getVueloByCodigo(String Codigo) 
    {
        cargarVuelos();
        try 
        {
            Optional<Vuelo> ret = listaVuelos.stream()/*convierte una coleccion en un*/
                    .filter(value -> value.getCodigoVuelo().equals(Codigo))
                    .findFirst();
            if (ret.isPresent()) 
            {
                return ret.get();/*Devulve el valor de Optional(en este caso un aeropuerto)*/
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }

        return new Vuelo();/*Devuelve todos los valores como null al ser nuevo*/
    }
    
    /**
     * Metodo que devuelve los vuelos que salen desde un aeropuerto pasado como parametro
     * @param a aeropuerto origen
     * @return una lista de vuelos que salen de ese aeropuerto
     */
    public static List<Vuelo> getVueloByOrigen(String codigo) 
    {
    cargarVuelos();
        List<Vuelo> ret = listaVuelos.stream()/*convierte una coleccion en un*/
                .filter(value -> value.getAeropuertoOrigen().equals(codigo))
                .toList();
        return ret;
    }
    /**
     * Metodo que devuelve los vuelos que van hacia un aeropuerto pasado como parametro
     * @param a aeropuerto destino
     * @return una lista de vuelos que salgan hacia ese aeropuerto
     */
    public static List<Vuelo> getVueloByDestino(String codigo) 
    {
    cargarVuelos();
        List<Vuelo> ret = listaVuelos.stream()/*convierte una coleccion en un*/
                .filter(value -> value.getAeropuertoDestino().equals((codigo)))
                .toList();
        return ret;
    }
    /**
     * Metodo que devuelve los vuelos que salgan un dia determinado(numerico 2023-10-22)
     * @param dia dia pasado como parametro
     * @return una lista de vuelos que salgan ese dia
     * @throws ParseException 
     */
    public static List<Vuelo> getVueloByDia(String dia) throws ParseException
    {
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy" /*HH:mm:ss"*/); 
    cargarVuelos();
    LocalDate Datedia=LocalDate.parse(dia);
    
        List<Vuelo> ret = listaVuelos.stream()/*convierte una coleccion en un*/
                .filter(value -> value.getHoraSalida().equals(Datedia))
                .filter(value -> value.getHoraLlegada().equals(Datedia))
                .toList();

        return ret;
    }
    /**
     * Metodo que saca una lista con los vuelos que operen en el dia pasado como parametro (LMXJVSD)
     * @param diasOP dia pasado como parametro
     * @return devueve una lista con los vuelos que operen en esos dias
     */
    public static List<Vuelo> getVueloByDiaOpera(String diasOP)
    {
    cargarVuelos();
        List<Vuelo> ret = listaVuelos.stream()/*convierte una coleccion en un*/
                .filter(value -> value.getDiasOpera().contains(diasOP))
                .toList();

        return ret;
    }
    
    public static boolean VueloCodigoExists(String codigo)
    {
        boolean ret=false;
        
        cargarVuelos();
        try 
        {
            Optional<Vuelo> opt = listaVuelos.stream()
                    .filter(value -> value.getCodigoVuelo().equals(codigo))
                    .findFirst();
            if (opt.isPresent()) 
            {
                ret=true;
            } 
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
        
        return ret;
    }
    
    /*-------------------------Fin Logica Vuelos------------------------------*/
    
    
    
    
    
    public static String calculoRecaudacion(String dia,Float PrecioMedio)
    {
        String msj="";
        try 
        {
           List<Vuelo> vuelos =getVueloByDia(dia);
           float recaudacion=0;
            for (Vuelo vuelo : vuelos) 
            {
                if(vuelo.getAeropuertoOrigen().equals(aeropuertoPrincipal.getCodigoIATA()))
                {
                    int plazas=vuelo.getPlazas();
                   recaudacion=plazas*PrecioMedio+recaudacion;
                }
               
            }
            
            msj=("Se han recudado "+recaudacion+" € el dia "+LocalDate.parse(dia));
        } 
        catch (ParseException ex) 
        {
            Logger.getLogger(LogicaNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msj;
    }
    
    
    public static List<VueloDiario> listaVuelosDiarios=new ArrayList<>();
    
    public static List<VueloDiario> getVueloDiarioByDia() throws ParseException
    {
        
Date now = new Date(System.currentTimeMillis());
SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

String fecha=date.format(now);
        
        
        
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy" /*HH:mm:ss"*/); 
    cargarVuelos();
    
        List ret = listaVuelos.stream()/*convierte una coleccion en un*/
                .filter(value -> value.getHoraSalida().equals(fecha))
                .toList();

        listaVuelosDiarios=ret;
        return listaVuelosDiarios;
    }
    
}
