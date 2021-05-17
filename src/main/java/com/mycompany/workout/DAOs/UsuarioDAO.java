/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.workout.DAOs;
//import java.sql.Connection;

import Entidades.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author IGOR
 */
public class UsuarioDAO {

    private Connection conexion;

    //PARA CONECTAR CON LA BASE DE DATOS: "WORKOUT"------------------------------
    public void conectar() throws ClassNotFoundException, SQLException, IOException {
        String host = "localhost";
        String port = "3306";
        String dbname = "workout";
        String username = "root";
        String password = "1234";

        conexion = DriverManager.getConnection("jdbc:mariadb://" + host + ":"
                + port + "/" + dbname + "?serverTimezone=UTC", username, password);
    }

    //PARA REGISTRAR AL USUARIO (INSERT).---------------------------------------
    public void InsertarUsuario(Usuario u) throws SQLException {
        String sql = "INSERT INTO Workout.usuario (nombre,pass,dni) VALUES(?,?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, u.getNombre());
        sentencia.setString(2, u.getPass());
        sentencia.setString(3, u.getDni());
        sentencia.executeUpdate();
    }

    //PARA LOGEAR AL USUARIO.---------------------------------------------------
    public Usuario cogerUsuarioPorNombre(String nombre) throws SQLException {

        String sql = "SELECT ID_USUARIO, NOMBRE, PASS FROM USUARIO WHERE NOMBRE=?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, nombre);
        ResultSet resultado = sentencia.executeQuery();

        Usuario user = new Usuario();

        while (resultado.next()) {
            user.setId_usuario(resultado.getInt(1));
            user.setNombre(resultado.getString(2));
            user.setPass(resultado.getString(3));
        }

        return user;
    }

    //PARA CAMBIAR LA CONTRASEÑA:-----------------------------------------------
    public boolean usuarioExistente(String nombrecambiopass) throws SQLException {

        String sql = "SELECT NOMBRE FROM USUARIO WHERE NOMBRE=?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, nombrecambiopass);
        ResultSet resultado = sentencia.executeQuery();

        boolean nombreexistente = false;

        while (resultado.next()) {
            nombreexistente = true;
        }
        return nombreexistente;
    }

    public void UpdatePass(int id, String newpass) throws SQLException {
        
        String sql = "CALL spUpdatePass(?,?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, newpass);
        sentencia.setInt(2, id);
        sentencia.executeUpdate();
    }
    
    public void borrarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM WORKOUT.USUARIO WHERE ID_USUARIO = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, id);
        sentencia.executeUpdate();
    }
    
    public void desconectar() throws SQLException {
        conexion.close();
    }

}
