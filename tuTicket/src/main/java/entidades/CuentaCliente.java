/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author melis
 */
public class CuentaCliente {
    private long id;
        private long idCliente;
    private String usuario;
    private String contraseña;

    public CuentaCliente() {
    }

    public CuentaCliente(long id, long idCliente, String usuario, String contraseña) {
        this.id = id;
        this.idCliente = idCliente;
        this.usuario = usuario;
        this.contraseña = contraseña;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

        
    
}
