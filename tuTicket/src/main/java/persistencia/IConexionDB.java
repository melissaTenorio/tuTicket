package persistencia; 
import java.sql.Connection; 
import java.sql.SQLException; 

/**
 *  Interfaz para la clase ConexionDB
 * @author jdani
 */
public interface IConexionDB {
    
    Connection crearConexion() throws SQLException; 
    Connection obtenerConexion() throws SQLException;
}
