/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package peristencia.Interfaces;
import dtos.BoletoDTO;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author melis
 */
public interface IBoletoDAO {
    BoletoDTO guardar(BoletoDTO boleto) throws SQLException;
    boolean guardarLote(List<BoletoDTO> boletos) throws SQLException;
    BoletoDTO buscarID(long id) throws SQLException;
    List<BoletoDTO> obtenerPorEvento(long idEvento) throws SQLException;
    boolean actualizarEstado(long idBoleto, String nuevoEstado) throws SQLException; 
}
