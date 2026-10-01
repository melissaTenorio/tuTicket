/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package peristencia.Interfaces;
import entidades.Compra;
import java.util.List;
/**
 *
 * @author melis
 */
public interface ICompraDAO {
    Compra guardar(Compra compra)throws Exception;
    Compra buscarPorId(Long id)throws Exception;
    List<Compra> obtenerPorCliente(Long idCliente)throws Exception;
    List<Compra> obtenerTodas();
}
