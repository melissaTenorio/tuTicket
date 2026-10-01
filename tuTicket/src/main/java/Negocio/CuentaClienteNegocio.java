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
    
    private final ICuentaClienteDAO cuentaClienteDAOI; 

    public CuentaClienteNegocio(){
        this.cuentaClienteDAOI = new CuentaClienteDAO(); 
    }
    
    @Override
    public boolean crearCuentasIniciales(Long idCliente) throws Exception {
        if(idCliente == null){
            throw new IllegalArgumentException("El ID del cliente no puede ser nulo"); 
        }
    
        String[] bancosDisponibles = {"BBVA", "Banamex", "Santander", "Banorte", "HSBC", "Maze Bank"}; 
        Random random = new Random();
        
        for(int i = 1; i <= 3; i++){
            String banco = 
                    bancosDisponibles[random.nextInt(bancosDisponibles.length)];
            String numCuenta = "CT-" + (100000 + random.nextInt(900000)); 
            Double saldoInicial = 1000.00;
            
            CuentaClienteDTO nuevaCuenta = new CuentaClienteDTO(null, banco, numCuenta, saldoInicial, idCliente); 
            cuentaClienteDAOI.insertar(nuevaCuenta); 
            
        }
        return true; 
    }

    @Override
    public List<CuentaClienteDTO> obtenerCuentasPorCliente(Long idCliente) throws Exception {
        if(idCliente == null){
            throw new IllegalArgumentException("El ID de cliente no es válido.");
        }

        return cuentaClienteDAOI.listarPorCliente(idCliente); 
    }

    @Override
    public CuentaClienteDTO obtenerCuentaPorId(Long idCuenta) throws Exception {
        if(idCuenta == null){
            throw new IllegalArgumentException("El ID del cliente no es válido"); 
        }

        return cuentaClienteDAOI.buscarPorId(idCuenta);
    }
    
    
   
}
