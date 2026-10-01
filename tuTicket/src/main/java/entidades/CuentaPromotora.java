/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author melis
 */
class CuentaPromotora {
    private long id;
    private long idPromotora;
    private String usuario;
    private String contraseña;

    public CuentaPromotora() {
    }

    public CuentaPromotora(long id, long idPromotora, String usuario, String contraseña) {
        this.id = id;
        this.idPromotora = idPromotora;
        this.usuario = usuario;
        this.contraseña = contraseña;
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
