/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package peristencia;
import dtos.ClienteDTO; 
import java.sql.SQLException; 

/**
 *  Interfaz para la clase Cliente
 * @author jdani
 */
public interface IClienteDAO {
    Long insertar(ClienteDTO cliente) throws SQLException;
    ClienteDTO buscarPorUsuario(String usuario) throws SQLException;
    
}
