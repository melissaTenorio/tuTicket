/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author melis
 */
public class Evento {
    private long id;
    private long idPromotora;
    private String nombreEvento;
    private String tipoEvento;
    private int edadMin;
    private String imagenPromocional;
    private long cantidadBoletos;

    public Evento() {
    }
    
    public Evento(long id, long idPromotora, String nombreEvento, String tipoEvento, int edadMin, String imagenPromocional, long cantidadBoletos) {
        this.id = id;
        this.idPromotora = idPromotora;
        this.nombreEvento = nombreEvento;
        this.tipoEvento = tipoEvento;
        this.edadMin = edadMin;
        this.imagenPromocional = imagenPromocional;
        this.cantidadBoletos = cantidadBoletos;
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

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }

    public String getImagenPromocional() {
        return imagenPromocional;
    }

    public void setImagenPromocional(String imagenPromocional) {
        this.imagenPromocional = imagenPromocional;
    }

    public long getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(long cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }
            
    
    
}
