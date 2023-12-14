/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModels;

import Entidades.Aeropuerto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class AeropuertoTableModel extends AbstractTableModel
{
    List<Aeropuerto> lstRegistro;
    ArrayList<String> columnNames;
    ArrayList<Class> columnClasses;
    
    
    public AeropuertoTableModel(List<Aeropuerto> lstRegistro)
    {
        this.lstRegistro=lstRegistro;
        columnNames=new ArrayList<>();
        columnClasses= new ArrayList<>();
        columnNames.add("Codigo IATA");
        columnNames.add("Nombre");
        columnNames.add("Municipio");
        
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
        Aeropuerto actual=lstRegistro.get(rowIndex);
        if(actual!=null && columnIndex >=0 && columnIndex <getColumnCount())
        {
            switch (columnIndex) 
            {
                case 0:
                {
                    return actual.getCodigoIATA();
                }
                case 1:
                {
                    return actual.getNombreAeropuerto();
                }
                case 2:
                {
                    return actual.getCodMunicipio();
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
