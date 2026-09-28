/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author melis
 */
public class Compra {
    private long id;
        private long idCliente;
        private long idBoleto;
                private long idCuentaCliente;
    private LocalDate fechaHora;
    private double precio;
    private String estado;
    //o detalle compra?

    public Compra() {
    }

    public Compra(long id, long idCliente, long idBoleto, long idCuentaCliente, LocalDate fechaHora, double precio, String estado) {
        this.id = id;
        this.idCliente = idCliente;
        this.idBoleto = idBoleto;
        this.idCuentaCliente = idCuentaCliente;
        this.fechaHora = fechaHora;
        this.precio = precio;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(long idBoleto) {
        this.idBoleto = idBoleto;
    }

    public long getIdCuentaCliente() {
        return idCuentaCliente;
    }

    public void setIdCuentaCliente(long idCuentaCliente) {
        this.idCuentaCliente = idCuentaCliente;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    
}
