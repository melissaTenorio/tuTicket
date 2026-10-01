/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;

/**
 *
 * @author melis
 */
public class Boleto {
    private long id;
    private String numeroBoleto;
    private String lugar;
    private String nombreEvento;
    private double precioUnitario;
    private Date fechaHora;
    private String estado;
  private long idEvento;
    private long idCompra;
    
    public Boleto() {
    }

    public Boleto(long id, String numeroBoleto, String lugar, String nombreEvento, double precioUnitario, Date fechaHora, String estado, long idEvento, long idCompra) {
        this.id = id;
        this.numeroBoleto = numeroBoleto;
        this.lugar = lugar;
        this.nombreEvento = nombreEvento;
        this.precioUnitario = precioUnitario;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.idEvento = idEvento;
        this.idCompra = idCompra;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }

    public long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(long idCompra) {
        this.idCompra = idCompra;
    }
    
    
    
    
}
