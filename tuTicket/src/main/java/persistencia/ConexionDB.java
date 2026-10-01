/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 


/**
 *
 * Clase que maneja la conexión a la base de datos
 * @author jdani
 */
public class ConexionDB implements IConexionDB {
    // Atributos de la clase
    private static final String SERVER = "127.0.0.1"; 
    private static final String BASE_DATOS = "tuTicket"; 
    private static final String CADENA_CONEXION = "jdbx:mysql://" + SERVER + "/" + BASE_DATOS; 
    private static final String USUARIO = "root"; 
    private static final String CONTRASEÑA = "root"; 
    
    
    /**
     * Obtiene una nueva conexion a la base de datos 
     * @return Connection objeto de conexcion a la BD 
     * @throws SQLException si la conexion no se pudo crear
     */
    @Override
    public Connection crearConexion() throws SQLException {
        return DriverManager.getConnection(SERVER, USUARIO, CONTRASEÑA); 
    }

    @Override
    public Connection obtenerConexion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
    
    
   
    }
    
    
