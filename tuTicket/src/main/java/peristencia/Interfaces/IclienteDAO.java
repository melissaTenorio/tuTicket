/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package peristencia.Interfaces;

import entidades.Cliente;
import java.util.List;

/**
 *
 * @author melis
 */
public interface IClienteDAO {
    
    Cliente guardar (Cliente cliente);
    Cliente buscarID (long id);
    Cliente buscarUsuario(String usuario); // pa calarle
    List <Cliente> obtener();
    
}
