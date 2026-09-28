/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melis
 */
public class Promotora {

    private long id;
    private String nombreEmpresa;
    private String calle;
    private String numero;
    private String colonia;
    private String ciudad;
    private String estado;
    private List<CuentaPrmotora> cuentas;

    public Promotora() {
    }

    public Promotora(List<CuentaPrmotora> cuentas) {
        this.cuentas = new ArrayList<>();
    }

    public Promotora(long id, String nombreEmpresa, String calle, String numero, String colonia, String ciudad, String estado, List<CuentaPrmotora> cuentas) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.cuentas = cuentas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<CuentaPrmotora> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<CuentaPrmotora> cuentas) {
        this.cuentas = cuentas;
    }

}
