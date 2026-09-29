/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package peristencia.Interfaces;
import entidades.Administrador;
/**
 *
 * @author melis
 */
public interface IAdminDAO {
    Administrador guardar (Administrador administrador);
    Administrador buscarUsuarioAdmin(String usuario);
}
