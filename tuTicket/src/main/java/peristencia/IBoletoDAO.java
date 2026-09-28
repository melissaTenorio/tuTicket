/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package peristencia;
import entidades.Boleto;
import java.util.List;
/**
 *
 * @author melis
 */
public interface IBoletoDAO {
    Boleto guardar(Boleto boleto);
    void guardarLote(List<Boleto> boletos);
    Boleto buscarID(long id);
    List<Boleto> obtenerPorEvento(long idEvento);
    List<Boleto> obtenerBoletoDisponible(long idEvento);
    
}
