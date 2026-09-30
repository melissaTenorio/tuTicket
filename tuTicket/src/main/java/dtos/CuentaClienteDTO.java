/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 * DTO para la entidad CuentaCliente
 * @author jdani
 */
public class CuentaClienteDTO {
    private Long idCuenta; 
    private String banco; 
    private String numCuenta; 
    private Double saldo; 
    private Long idCliente; 
    
    public CuentaClienteDTO(){
        
    }

    public CuentaClienteDTO(Long idCuenta, String banco, String numCuenta, Double saldo, Long idCliente) {
        this.idCuenta = idCuenta;
        this.banco = banco;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
    
}
