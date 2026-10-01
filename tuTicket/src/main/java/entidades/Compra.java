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
    private LocalDate fechaHora;// detalle compra
    private double montoTotal; // lo que va a pagar
    private String estado;// detalle compra
    //o detalle compra?

    public Compra() {
    }

    public Compra(long id, long idCliente, LocalDate fechaHora, double montoTotal, String estado) {
        this.id = id;
        this.idCliente = idCliente;
        this.fechaHora = fechaHora;
        this.montoTotal = montoTotal;
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

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    
    
}
