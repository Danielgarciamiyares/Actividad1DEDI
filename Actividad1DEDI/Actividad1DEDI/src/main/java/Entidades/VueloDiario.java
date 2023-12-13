/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author danielgarcia
 */
public class VueloDiario 
{
    /*Variables*/
    private String codigoVuelo;/*Relacionado con el codigo_vuelo de la clase vuelo*/
    private LocalDate fechaVuelo;/*Comprobar coherencia con los dias que vuela dicho avión*/
    private Date horaSalida;
    private Date horaLlegada;
    private int plazas;
    private float precio;/*precio medio*/
    /*Gettesr y Setters*/
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
     * @return the fechaVuelo
     */
    public LocalDate getFechaVuelo() 
    {
        return fechaVuelo;
    }
    /**
     * @param fechaVuelo the fechaVuelo to set
     */
    public void setFechaVuelo(LocalDate fechaVuelo) 
    {
        this.fechaVuelo = fechaVuelo;
    }
    /**
     * @return the horaSalida
     */
    public Date getHoraSalida() 
    {
        return horaSalida;
    }
    /**
     * @param horaSalida the horaSalida to set
     */
    public void setHoraSalida(Date horaSalida) 
    {
        this.horaSalida = horaSalida;
    }
    /**
     * @return the horaLlegada
     */
    public Date getHoraLlegada() 
    {
        return horaLlegada;
    }
    /**
     * @param horaLlegada the horaLlegada to set
     */
    public void setHoraLlegada(Date horaLlegada) 
    {
        this.horaLlegada = horaLlegada;
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
     * @return the precio
     */
    public float getPrecio() 
    {
        return precio;
    }
    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) 
    {
        this.precio = precio;
    }
    /*Constructores*/
    public VueloDiario() 
    {
        
    }
    public VueloDiario(String codigoVuelo, LocalDate fechaVuelo, Date horaSalida, Date horaLlegada, int plazas, float precio) 
    {
        this.codigoVuelo = codigoVuelo;
        this.fechaVuelo = fechaVuelo;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.plazas = plazas;
        this.precio = precio;
    }
    /*Metodos*/
    
    
}
