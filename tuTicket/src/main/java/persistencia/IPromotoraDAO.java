/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import entidades.Promotora;
import java.util.List;

/**
 *
 * @author melis
 */
public interface IPromotoraDAO {

    Promotora gusradr(Promotora promotora);

    Promotora buscarid(long id);

    List<Promotora> obten();

    Promotora iniciarSesion(String correo, String contrasena);

    boolean registrar(Promotora promotora);

}
