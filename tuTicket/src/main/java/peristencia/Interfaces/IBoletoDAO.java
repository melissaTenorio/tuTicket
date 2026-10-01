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
    void guardarLote(List<BoletoDTO> boletos);
    BoletoDTO buscarID(long id);
    List<BoletoDTO> obtenerPorEvento(long idEvento);
    List<BoletoDTO> obtenerBoletoDisponible(long idEvento);
    
}
