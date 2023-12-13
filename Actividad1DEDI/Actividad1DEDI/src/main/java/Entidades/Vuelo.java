/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import LogicaNegocio.LogicaNegocio;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author danielgarcia
 */
public class Vuelo 
{
    /*Variables*/
    private String codigoVuelo;/*Codigo de la compañia +numero 0-9999,
    Ejemplo: V73585,IB480*/
    private String IATAAeropuertoOrigen;
    private String IATAAeropuertoDestino;
    private int plazas;/*Total*/
    private LocalDate horaSalida;
    private Date fechaSalida;
    private LocalDate horaLlegada;
    private Date fechaLlegada;
    private String diasOpera;/*7 caracteres con cada dia de la semana que opera, 
    Ejemplo: LMXJVSD (todos los dias)*/
    /*Getters y Setters*/
    /**
     * @return the codigoVuelo
     */
    public String getCodigoVuelo() 
    {
        return codigoVuelo;
    }
    /**
     * @param codigoVuelo the codigoVuelo to set
     */
    public void setCodigoVuelo(String codigoVuelo) 
    {
        this.codigoVuelo = codigoVuelo;
    }
    /**
     * @return the AeropuertoOrigen
     */
    public String getAeropuertoOrigen() 
    {
        return IATAAeropuertoOrigen;
    }
    /**
     * @param AeropuertoOrigen the AeropuertoOrigen to set
     */
    public void setAeropuertoOrigen(String AeropuertoOrigen) 
    {
        this.IATAAeropuertoOrigen = AeropuertoOrigen;
    }
    /**
     * @return the AeropuertoDestino
     */
    public String getAeropuertoDestino() 
    {
        return IATAAeropuertoDestino;
    }
    /**
     * @param AeropuertoDestino the AeropuertoDestino to set
     */
    public void setAeropuertoDestino(String AeropuertoDestino) 
    {
        this.IATAAeropuertoDestino = AeropuertoDestino;
    }
    /**
     * @return the plazas
     */
    public int getPlazas() 
    {
        return plazas;
    }
    /**
     * @param plazas the plazas to set
     */
    public void setPlazas(int plazas) 
    {
        this.plazas = plazas;
    }
    /**
     * @return the horaSalida
     */
    public LocalDate getHoraSalida() 
    {
        return horaSalida;
    }
    /**
     * @param horaSalida the horaSalida to set
     */
    public void setHoraSalida(LocalDate horaSalida) 
    {
        this.horaSalida = horaSalida;
    }
    /**
     * @return the horaLlegada
     */
    public LocalDate getHoraLlegada() 
    {
        return horaLlegada;
    }
    /**
     * @param horaLlegada the horaLlegada to set
     */
    public void setHoraLlegada(LocalDate horaLlegada) 
    {
        this.horaLlegada = horaLlegada;
    }
    /**
     * @return the diasOpera
     */
    public String getDiasOpera() 
    {
        return diasOpera;
    }
    /**
     * @param diasOpera the diasOpera to set
     */
    public void setDiasOpera(String diasOpera) 
    {
        this.diasOpera = diasOpera;
    }
    /*Constructores*/
    public Vuelo() 
    {
        
    }
    public Vuelo(String codigoVuelo, String IATAAeropuertoOrigen, String IATAAeropuertoDestino, int plazas, LocalDate horaSalida, LocalDate horaLlegada, String diasOpera) 
    {
        this.codigoVuelo = codigoVuelo;
        this.IATAAeropuertoOrigen = IATAAeropuertoOrigen;
        this.IATAAeropuertoDestino =IATAAeropuertoDestino;
        this.plazas = plazas;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.diasOpera = diasOpera;
    }
    /*Metodos*/

    @Override
    public String toString() {
        return codigoVuelo + ","+ IATAAeropuertoOrigen + "," + IATAAeropuertoDestino + "," + plazas + "," + horaSalida + "," + horaLlegada + "," + diasOpera + '\n';
    }
    
    
    
   
    
}
