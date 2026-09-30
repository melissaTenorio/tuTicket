/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;
import dtos.ClienteDTO; 
import java.sql.SQLException; 
/**
 * Interfaz para la clase ClienteServicio
 * @author jdani
 */
public interface IClienteNegocio {
    
    boolean registrarCliente(ClienteDTO cliente) throws Exception; 
    
    ClienteDTO iniciarSesion(String usuario, String contraseña) throws Exception; 
    
    
}
