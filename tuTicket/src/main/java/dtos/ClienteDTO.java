/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;
import java.sql.Date;


/**
 * DTO para la clase Usuario
 * @author jdani
 */
public class ClienteDTO {
    // Atributos
    private int id; 
    private String nombre, apellido_materno, apellido_paterno; 
    private Date feha_nac; 
    private String nombre_usuario; 
    private String contraseña; 

    // Constsructor por omición
    public ClienteDTO() {
    
    }

    // Constructor de la clase 
    public ClienteDTO(int id, String nombre, String apellido_materno, String apellido_paterno, Date feha_nac, String nombre_usuario, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_materno = apellido_materno;
        this.apellido_paterno = apellido_paterno;
        this.feha_nac = feha_nac;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
    }
    
    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public Date getFeha_nac() {
        return feha_nac;
    }

    public void setFeha_nac(Date feha_nac) {
        this.feha_nac = feha_nac;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    // Método toString

    @Override
    public String toString() {
        return "ClienteDTO{" + "id=" + id + ", nombre=" + nombre + ", apellido_materno=" + apellido_materno + ", apellido_paterno=" + apellido_paterno + ", feha_nac=" + feha_nac + ", nombre_usuario=" + nombre_usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    
    
}
