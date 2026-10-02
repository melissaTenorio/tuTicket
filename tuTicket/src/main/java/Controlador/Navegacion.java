/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Controlador;

import Negocio.IPromotoraNegocio;
import Negocio.PromotoraNegocio;
import entidades.Promotora;

/**
 *
 * @author melis
 */
public class Navegacion {
private final IPromotoraNegocio promotoraNegocio;

    public controlPromotora() {
        this.promotoraNegocio = new PromotoraNegocio();
    }
    public Promotora login(String correo, String contrasena) {
        return promotoraNegocio.autenticar(correo, contrasena);
    }
    public void mostrarLog(){}
    
//    public void mostrarRegistroCliente(){}
}
