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
    
    Cliente guardar (Cliente cliente) throws Exception;
    Cliente buscarID (long id) throws Exception;
    Cliente buscarUsuario(String usuario); // pa calarle
    List <Cliente> obtenerTodos()throws Exception;
    
}
