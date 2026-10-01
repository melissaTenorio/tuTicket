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
public class Evento {

    private long id;
    private long idPromotora;
    private String nombreEvento;
    private String descripcion;
    private String lugar;
    private Date fecha;
    private double precio;
    private int capacidad;
    private long boletosDisponibles;

    private String tipoEvento;
    private int edadMin;
    private String imagenPromocional;

    public Evento() {
    }

    public Evento(long id, long idPromotora, String nombreEvento, String descripcion, String lugar, Date fecha, double precio, int capacidad, long boletosDisponibles, String tipoEvento, int edadMin, String imagenPromocional) {
        this.id = id;
        this.idPromotora = idPromotora;
        this.nombreEvento = nombreEvento;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
        this.precio = precio;
        this.capacidad = capacidad;
        this.boletosDisponibles = boletosDisponibles;
        this.tipoEvento = tipoEvento;
        this.edadMin = edadMin;
        this.imagenPromocional = imagenPromocional;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public long getBoletosDisponibles() {
        return boletosDisponibles;
    }

    public void setBoletosDisponibles(long boletosDisponibles) {
        this.boletosDisponibles = boletosDisponibles;
    }

  

}
