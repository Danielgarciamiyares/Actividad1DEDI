/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModels;

import Entidades.Vuelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class VueloTableModel extends AbstractTableModel
{
    List<Vuelo> lstRegistro;
    ArrayList<String> columnNames;
    ArrayList<Class> columnClasses;
    
    
    public VueloTableModel(List<Vuelo> lstRegistro)
    {
        this.lstRegistro=lstRegistro;
        columnNames=new ArrayList<>();
        columnClasses= new ArrayList<>();
        columnNames.add("Codigo");
        columnNames.add("Aeropuerto Origen");
        columnNames.add("Aeropuerto Destino");
        columnNames.add("Plazas");
        columnNames.add("Dia salida");
        columnNames.add("Dia Llegada");
        columnNames.add("Dias que opera");
        
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(String.class);
        columnClasses.add(int.class);
        columnClasses.add(LocalDate.class);
        columnClasses.add(LocalDate.class);
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
        Vuelo actual=lstRegistro.get(rowIndex);
        if(actual!=null && columnIndex >=0 && columnIndex <getColumnCount())
        {
            switch (columnIndex) 
            {
                case 0:
                {
                    return actual.getCodigoVuelo();
                }
                case 1:
                {
                    return actual.getAeropuertoOrigen();
                }
                case 2:
                {
                    return actual.getAeropuertoDestino();
                }
                case 3:
                {
                    return actual.getPlazas();
                }
                case 4:
                {
                    return actual.getHoraSalida();
                }
                case 5:
                {
                    return actual.getHoraLlegada();
                }
                case 6:
                {
                    return actual.getDiasOpera();
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
