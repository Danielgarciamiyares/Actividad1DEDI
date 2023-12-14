/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author danielgarcia
 */
public class Municipio 
{
    private String codigo;
    private String nombre;
    
    
    /*Constructores*/
    public Municipio(String codigo, String nombre) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    /*Getters y Setters*/
    public String getCodigo() 
    {
        return codigo;
    }
    public String getNombre() 
    {
        return nombre;
    }
    
    
}
