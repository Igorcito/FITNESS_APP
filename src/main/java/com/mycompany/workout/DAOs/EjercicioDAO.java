/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.workout.DAOs;

import Entidades.Ejercicio_Flexibilidad;
import Entidades.Ejercicio_Fuerza;
import Entidades.Ejercicio_Resistencia;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IGOR
 */
public class EjercicioDAO {
    
    private Connection conexion;
    
    public void conectar() throws ClassNotFoundException, SQLException, IOException {
        String host = "localhost";
        String port = "3306";
        String dbname = "Workout";
        String username = "root";
        String password = "1234";
        
        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":" +
        port + "/" + dbname + "?serverTimezone=UTC", username, password);
        
    }
   
    
    // DIVIDIMOS EN 3 LISTVIEWS PARA MOSTRAR LOS EJERCICIOS:
    
    public List<Ejercicio_Fuerza> listEF() throws SQLException {
        List<Ejercicio_Fuerza> EJF = new ArrayList<>();
        String sql = "SELECT * FROM workout.ejercicios WHERE Tipo = 'fuerza'";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
                
            Ejercicio_Fuerza EF = new Ejercicio_Fuerza();
            EF.setId_Ejercicio(resultado.getInt(1));
            EF.setNombre(resultado.getString(2));
            EF.setTipo(resultado.getString(3));
            EF.setZona(resultado.getString(4));
            EF.setPeso(resultado.getInt(5));
            
            EJF.add(EF);
        }
        
        return EJF;
    }
    
    public List<Ejercicio_Resistencia> listER() throws SQLException {
        List<Ejercicio_Resistencia> EJR = new ArrayList<>();
        String sql = "SELECT * FROM workout.ejercicios WHERE Tipo = 'resistencia'";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
                
            Ejercicio_Resistencia ER = new Ejercicio_Resistencia();
            ER.setId_Ejercicio(resultado.getInt(1));
            ER.setNombre(resultado.getString(2));
            ER.setTipo(resultado.getString(3));
            ER.setZona(resultado.getString(4));
            ER.setTiempo(resultado.getInt(7));
            
            EJR.add(ER);
        }
        
        return EJR;
    }
    
    public List<Ejercicio_Flexibilidad> listEFL() throws SQLException {
        List<Ejercicio_Flexibilidad> EJFL = new ArrayList<>();
        String sql = "SELECT * FROM workout.ejercicios WHERE Tipo = 'flexibilidad'";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
                
            Ejercicio_Flexibilidad EFL = new Ejercicio_Flexibilidad();
            EFL.setId_Ejercicio(resultado.getInt(1));
            EFL.setNombre(resultado.getString(2));
            EFL.setTipo(resultado.getString(3));
            EFL.setZona(resultado.getString(4));
            EFL.setIntensidad(resultado.getString(6));
            
            EJFL.add(EFL);
        }
        
        return EJFL;
    }
    
   public void desconectar() throws SQLException
   {
            conexion.close();
   }
   
}
