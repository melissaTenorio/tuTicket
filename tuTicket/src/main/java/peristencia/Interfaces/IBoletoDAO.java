/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package peristencia.Interfaces;
import dtos.BoletoDTO;
import entidades.Boleto;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author melis
 */
public interface IBoletoDAO {
    boolean guardarLote(List<BoletoDTO> boletos) throws SQLException;
    List<BoletoDTO> obtenerPorEvento(long idEvento) throws SQLException;
List<Boleto> obtenerDisponiblesPorEvento(long idEvento);
boolean actualizarEstado(long idBoleto, String estado, long idCompra);
}
