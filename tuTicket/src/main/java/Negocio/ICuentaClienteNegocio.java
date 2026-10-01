/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;
import dtos.CuentaClienteDTO;
import java.util.List; 


/**
 * Interfaz de CuentaClienteNegocio
 * @author jdani
 */
public interface ICuentaClienteNegocio {
    
    boolean crearCuentasIniciales(Long idCliente) throws Exception; 
    
    List<CuentaClienteDTO> obtenerCuentasPorCliente(Long idCliente) throws Exception; 
    
    CuentaClienteDTO obtenerCuentaPorId(Long idCuenta) throws Exception; 
    
}
