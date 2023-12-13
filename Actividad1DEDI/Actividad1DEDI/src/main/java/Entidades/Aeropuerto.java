/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author danielgarcia
 */
public class Aeropuerto 
{
    /*Variavles*/
    private String codigoIATA;
    private String nombreAeropuerto;
    private String codMunicipio;/*5 caracteres numéricos,internacional=00000*/
    /*Getters y Setters*/
    /**
     * @return the codigoIATA
     */
    public String getCodigoIATA() 
    {
        return codigoIATA;
    }
    /**
     * @param codigoIATA the codigoIATA to set
     */
    public void setCodigoIATA(String codigoIATA) 
    {
        this.codigoIATA = codigoIATA;
    }
    /**
     * @return the nombreAeropuerto
     */
    public String getNombreAeropuerto() 
    {
        return nombreAeropuerto;
    }
    /**
     * @param nombreAeropuerto the nombreAeropuerto to set
     */
    public void setNombreAeropuerto(String nombreAeropuerto) 
    {
        this.nombreAeropuerto = nombreAeropuerto;
    }
    /**
     * @return the codMunicipio
     */
    public String getCodMunicipio() 
    {
        return codMunicipio;
    }
    /**
     * @param codMunicipio the codMunicipio to set
     */
    public void setCodMunicipio(String codMunicipio) 
    {
        this.codMunicipio = codMunicipio;
    }
    /*Constructores*/
    public Aeropuerto() 
    {
        
    }
    public Aeropuerto(String codigoIATA, String nombreAeropuerto, String codMunicipio) 
    {
        this.codigoIATA = codigoIATA;
        this.nombreAeropuerto = nombreAeropuerto;
        this.codMunicipio = codMunicipio;
    }
    /*Metodos*/

    @Override
    public String toString() {
        return codigoIATA + "," + nombreAeropuerto + "," + codMunicipio+"\n";
    }
    
    
    
}