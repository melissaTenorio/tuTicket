/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author jdani
 */
public class BoletoDTO {
    private Long idBoleto; 
    private String codigo_boleto; 
    private double precio; 
    private String estado; 
    private Long idEvento; 
    
    public BoletoDTO(){
        
    }

    public BoletoDTO(Long idBoleto, String codigo_boleto, double precio, String estado, Long idEvento) {
        this.idBoleto = idBoleto;
        this.codigo_boleto = codigo_boleto;
        this.precio = precio;
        this.estado = estado;
        this.idEvento = idEvento;
    }

    public Long getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(Long idBoleto) {
        this.idBoleto = idBoleto;
    }

    public String getCodigo_boleto() {
        return codigo_boleto;
    }

    public void setCodigo_boleto(String codigo_boleto) {
        this.codigo_boleto = codigo_boleto;
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

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }
    
    
}
