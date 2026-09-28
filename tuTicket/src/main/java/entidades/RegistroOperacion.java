/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDateTime;

/**
 *
 * @author melis
 */
public class RegistroOperacion {
    private long id;
    private long idCuentaCliente;
    private String tipoOperacion;
    private double monto;
    private LocalDateTime fechaHora;

    public RegistroOperacion() {
    }

    
    
    public RegistroOperacion(long id, long idCuentaCliente, String tipoOperacion, double monto, LocalDateTime fechaHora) {
        this.id  = id;
        this.idCuentaCliente = idCuentaCliente;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        this.fechaHora = fechaHora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCuentaCliente() {
        return idCuentaCliente;
    }

    public void setIdCuentaCliente(long idCuentaCliente) {
        this.idCuentaCliente = idCuentaCliente;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    
    
    
}
