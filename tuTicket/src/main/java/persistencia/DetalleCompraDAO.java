/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.Date;
import peristencia.Interfaces.IDetalleCompra;

/**
 *
 * @author melis
 */
public class DetalleCompraDAO implements IDetalleCompra{
    private Long id;
    private String bancoOrigen;
    private String cuentaOrigen;
    private String claveRastreo;
    private double monto;
    private Date fechaTransferencia;
    private Long idCompra;

    public DetalleCompraDAO() {
    }

    public DetalleCompraDAO(Long id, String bancoOrigen, String cuentaOrigen, String claveRastreo, double monto, Date fechaTransferencia, Long idCompra) {
        this.id = id;
        this.bancoOrigen = bancoOrigen;
        this.cuentaOrigen = cuentaOrigen;
        this.claveRastreo = claveRastreo;
        this.monto = monto;
        this.fechaTransferencia = fechaTransferencia;
        this.idCompra = idCompra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBancoOrigen() {
        return bancoOrigen;
    }

    public void setBancoOrigen(String bancoOrigen) {
        this.bancoOrigen = bancoOrigen;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getClaveRastreo() {
        return claveRastreo;
    }

    public void setClaveRastreo(String claveRastreo) {
        this.claveRastreo = claveRastreo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaTransferencia() {
        return fechaTransferencia;
    }

    public void setFechaTransferencia(Date fechaTransferencia) {
        this.fechaTransferencia = fechaTransferencia;
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }
    
    
    
    
}
