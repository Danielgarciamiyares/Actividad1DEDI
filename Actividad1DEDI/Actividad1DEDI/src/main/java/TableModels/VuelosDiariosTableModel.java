/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TableModels;

import Entidades.Vuelo;
import Entidades.VueloDiario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class VuelosDiariosTableModel extends AbstractTableModel
{
    List<VueloDiario> lstRegistro;
    ArrayList<String> columnNames;
    ArrayList<Class> columnClasses;
    
    
    public VuelosDiariosTableModel(List<VueloDiario> lstRegistro)
    {
        this.lstRegistro=lstRegistro;
        columnNames=new ArrayList<>();
        columnClasses= new ArrayList<>();
        columnNames.add("Codigo");
        columnNames.add("Fecha salida");
        columnNames.add("Hora salida");
        columnNames.add("Hora llegada");
        columnNames.add("Plazas");
        columnNames.add("Precio");

        
        columnClasses.add(String.class);
        columnClasses.add(LocalDate.class);
        columnClasses.add(Date.class);
        columnClasses.add(Date.class);
        columnClasses.add(int.class);
        columnClasses.add(Float.class);

        
        
        
        
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
        VueloDiario actual=lstRegistro.get(rowIndex);
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
                    return actual.getFechaVuelo();
                }
                case 2:
                {
                    return actual.getHoraSalida();
                }
                case 3:
                {
                    return actual.getHoraLlegada();
                }
                case 4:
                {
                    return actual.getPlazas();
                }
                case 5:
                {
                    return actual.getPrecio();
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
