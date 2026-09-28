/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package peristencia;
import entidades.Compra;
import java.util.List;
/**
 *
 * @author melis
 */
public interface IcCompraDAO {
    Compra guardar(Compra compra);
    Compra buscarPorId(Long id);
    List<Compra> obtenerPorCliente(Long idCliente);
    List<Compra> obtenerTodas();
}
