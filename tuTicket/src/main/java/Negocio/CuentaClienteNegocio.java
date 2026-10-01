/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import persistencia.CuentaClienteDAO;
import persistencia.ICuentaClienteDAO;
import dtos.CuentaClienteDTO;

import java.util.List; 
import java.util.Random; 
/**
 * Implementacion de la clase CuentaCliente en la capa Negocio
 * @author jdani
 */
public class CuentaClienteNegocio implements ICuentaClienteNegocio {
    
    private final ICuentaClienteDAO cuentaClienteDAO; 
    
    public CuentaClienteServicio(){
        this.cuentaClienteDAO = new CuentaClienteDAO();
    }

    @Override
    public boolean crearCuentasIniciales(Long idCliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CuentaClienteDTO> obtenerCuentasPorCliente(Long idCliente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CuentaClienteDTO obtenerCuentaPorId(Long idCuenta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
