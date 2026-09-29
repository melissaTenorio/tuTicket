/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package peristencia.Interfaces;
import entidades.Evento;
import java.util.List;
/**
 *
 * @author melis
 */
public interface IEventoDAO {
    Evento guardar(Evento evento);
    Evento buscarPorID(Long id);
    List<Evento> obtenPromotora(); //deberia buscar por promotora los eventos
    List<Evento>Obten(); //Lista de todos los eventos registrados
}
