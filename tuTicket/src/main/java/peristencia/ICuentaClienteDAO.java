/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package peristencia;
import dtos.CuentaClienteDTO; 
import java.sql.SQLException; 
import java.util.List; 


/**
 * Interfaz para la entidad CuentaClienteDAO
 * @author jdani
 */
public interface ICuentaClienteDAO {
    
    boolean insertar(CuentaClienteDTO cuenta) throws SQLException; 
    
    List<CuentaClienteDTO> listarPorCliente(Long idCliente) throws SQLException;
    
    CuentaClienteDTO buscarPorId(Long idCuenta) throws SQLException; 
    
    boolean actualizarSaldo(Long idCuenta, Double nuevoSaldo) throws SQLException; 
    
}
