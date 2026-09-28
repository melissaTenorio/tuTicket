/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author melis
 */
public class Boleto {
    private long id;
    private long idEvento;
    private String folioBoleto;
    private double precio;
    private String estado;

    public Boleto() {
    }

    public Boleto(long id, long idEvento, String folioBoleto, double precio, String estado) {
        this.id = id;
        this.idEvento = idEvento;
        this.folioBoleto = folioBoleto;
        this.precio = precio;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(long idEvento) {
        this.idEvento = idEvento;
    }

    public String getFolioBoleto() {
        return folioBoleto;
    }

    public void setFolioBoleto(String folioBoleto) {
        this.folioBoleto = folioBoleto;
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
