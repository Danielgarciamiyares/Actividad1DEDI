/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author danielgarcia
 */
public class Compania 
{
    /*Variables*/
       private String prefijo;/*código 0-999*/
       private String codigo;/*2 caracteres de tamaño fijo,
       2 letras mayúsculas o 1mayúscula y 1 numero
       Ejemplo: IB,V7*/
       private String nombre;/*Nombre de la compañia*/
       private String direccion;/*Dirrección de la sede central*/
       private String municipio;/*Municipio de la sede central*/
       private String tlfInfoPasajero;/*3 dígitos(cod pais)+12 dígitos*/
       private String tlfInfoAeropuerto;/*3 dígitos(cod pais)+12 dígitos*/
    /*Getters y Setters*/   
    /**
     * @return the prefijo
     */
    public String getPrefijo() {
        return prefijo;
    }
    /**
     * @param prefijo the prefijo to set
     */
    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }
    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    /**
     * @return the tlfInfoPasajero
     */
    public String getTlfInfoPasajero() {
        return tlfInfoPasajero;
    }
    /**
     * @param tlfInfoPasajero the tlfInfoPasajero to set
     */
    public void setTlfInfoPasajero(String tlfInfoPasajero) {
        this.tlfInfoPasajero = tlfInfoPasajero;
    }
    /**
     * @return the tlfInfoAeropuerto
     */
    public String getTlfInfoAeropuerto() {
        return tlfInfoAeropuerto;
    }
    /**
     * @param tlfInfoAeropuerto the tlfInfoAeropuerto to set
     */
    public void setTlfInfoAeropuerto(String tlfInfoAeropuerto) {
        this.tlfInfoAeropuerto = tlfInfoAeropuerto;
    }
    /*Constructores*/
    public Compania() 
    {
        
    }
    public Compania(String prefijo, String codigo, String nombre, String direccion, String municipio, String tlfInfoPasajero, String tlfInfoAeropuerto) {
        this.prefijo = prefijo;
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.tlfInfoPasajero = tlfInfoPasajero;
        this.tlfInfoAeropuerto = tlfInfoAeropuerto;
    }
    /*Metodos*/



    @Override
    public String toString() {
        return prefijo + "," + codigo + "," + nombre + "," + direccion + "," + municipio + "," + tlfInfoPasajero + "," + tlfInfoAeropuerto+"\n" ;
    }
    
    
    
    
    
       
}
