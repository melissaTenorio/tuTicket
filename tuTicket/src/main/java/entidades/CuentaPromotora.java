/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author melis
 */
class CuentaPromotora {
    private long id;
    private long idPromotora;
    private String banco;
    private String numeroCuenta;
     private double saldo;

    public CuentaPromotora() {
    }

    public CuentaPromotora(long id, long idPromotora, String banco, String numeroCuenta, double saldo) {
        this.id = id;
        this.idPromotora = idPromotora;
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPromotora() {
        return idPromotora;
    }

    public void setIdPromotora(long idPromotora) {
        this.idPromotora = idPromotora;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
     
     
     
    
    
}
