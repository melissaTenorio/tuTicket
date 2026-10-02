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
    Evento agregar(Evento evento) throws Exception;
    Evento actualizar(Evento evento) throws Exception;
    boolean eliminar (long id) throws Exception;
    boolean guardar(Evento evento);
    Evento buscarPorID(Long id);
    List<Evento> obtenPromotora(); //deberia buscar por promotora los eventos
    List<Evento>ObtenerTodos(); //Lista de todos los eventos registrados

    public List<Evento> obtenerPorPromotora(Long idPromotora);
}
