/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModels;

import Entidades.Compania;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class CompaniaTableModel extends AbstractTableModel
{
    List<Compania> lstRegistro;
    ArrayList<String> columnNames;
    ArrayList<Class> columnClasses;
    
    
    public CompaniaTableModel(List<Compania> lstRegistro)
    {
        this.lstRegistro=lstRegistro;
        columnNames=new ArrayList<>();
        columnClasses= new ArrayList<>();
        columnNames.add("Prefijo");
        columnNames.add("Codigo");
        columnNames.add("Nombre");
        columnNames.add("Direccion");
        columnNames.add("Municipio");
        columnNames.add("Telefono atencion pasajero");
        columnNames.add("Telefono atencion aeropuerto");
        
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        
        
        
        
    }
    
    @Override
    public int getRowCount() 
    {
        return lstRegistro.size();
    }

    @Override
    public int getColumnCount() 
    {
        return columnClasses.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        Compania actual=lstRegistro.get(rowIndex);
        if(actual!=null && columnIndex >=0 && columnIndex <getColumnCount())
        {
            switch (columnIndex) 
            {
                case 0:
                {
                    return actual.getPrefijo();
                }
                case 1:
                {
                    return actual.getCodigo();
                }
                case 2:
                {
                    return actual.getNombre();
                }
                case 3:
                {
                    return actual.getDireccion();
                }
                case 4:
                {
                    return actual.getMunicipio();
                }
                case 5:
                {
                    return actual.getTlfInfoPasajero();
                }
                case 6:
                {
                    return actual.getTlfInfoAeropuerto();
                }
            }
        }
        return "";
    }
    public String getColumnName(int column)
    {
        return columnNames.get(column);
    }
}
