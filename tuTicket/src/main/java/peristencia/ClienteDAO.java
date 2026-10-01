/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peristencia; 
import dtos.ClienteDTO;
import java.sql.SQLException;



import java.sql.*; 

/**
 * esta clase sera estatica para comprobar un funcionamiento antes de la conexion
 * @author melis
 */
public class ClienteDAO implements IClienteDAO {
    
    private ConexionDB conexion; 
    
    
    @Override
    public Long insertar(ClienteDTO cliente) throws SQLException {
        String sql = "INSERT INTO Cliente(nombre, apellidoPaterno, apellidoMaterno, fecha_nacimiento, nombre_usuario, contraseña)" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        
        try(Connection con = conexion.crearConexion();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido_paterno());
            ps.setString(3, cliente.getApellido_materno()); 
            ps.setDate(4, cliente.getFeha_nac());
            ps.setString(5, cliente.getNombre_usuario());
            ps.setString(6, cliente.getContraseña());
            
            int filasAfectadas = ps.executeUpdate();
            
            if(filasAfectadas > 0){
                try(ResultSet rs = ps.getGeneratedKeys()){
                    if(rs.next()){
                        return rs.getLong(1); 
                    }
                }
            }
        }
        
        return null; 
}


    @Override
    public ClienteDTO buscarPorUsuario(String usuario) throws SQLException {
       String sql = "SELECT id_cliente, nombre, apellidoPaterno, apellidoMaterno, fecha_nacimiento, nombre_usuario, contraseña" +
               "FROM cliente HWERE nombre_usuario = ?"; 
       
       try(Connection con = conexion.crearConexion();
               PreparedStatement ps = con.prepareStatement(sql)){
           
           ps.setString(0, usuario);
           try(ResultSet rs = ps.executeQuery()){
               if (rs.next()){
                   return mapearCliente(rs);
               }
           }    
       }
       return null;
    }

    
    private ClienteDTO mapearCliente(ResultSet rs) throws SQLException{
        return new ClienteDTO(
            rs.getInt("id_usuario"),
            rs.getString("nombre"),
            rs.getString("apellidoPaterno"),
            rs.getString("apellido_materno"),
            rs.getDate("fecha_nacimiento"),
            rs.getString("nombre_usuario"),
            rs.getString("contraseña")
        );
    }
   
    
}
