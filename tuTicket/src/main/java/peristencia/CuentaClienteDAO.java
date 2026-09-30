/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package peristencia;
import dtos.CuentaClienteDTO;
import java.sql.SQLException;
import java.util.List;
import java.sql.*; 
import java.util.ArrayList;

/**
 *
 * @author jdani
 */
public class CuentaClienteDAO implements ICuentaClienteDAO{

    private ConexionDB conexion; 
    
    
    
    @Override
    public boolean insertar(CuentaClienteDTO cuenta) throws SQLException {
        
        String sql = "INSERT INTO cuenta_cliente (banco, num_cuenta, saldo, id_cliente) VALUES (?, ?, ?, ?)";
        
        try(Connection con = conexion.crearConexion();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, cuenta.getBanco());
            ps.setString(2, cuenta.getNumCuenta());
            ps.setDouble(3, cuenta.getSaldo());
            ps.setLong(4, cuenta.getIdCliente());
            
            return ps.executeUpdate() > 0;
        }
        
    }

    @Override
    public List<CuentaClienteDTO> listarPorCliente(Long idCuenta) throws SQLException {
        List<CuentaClienteDTO> lista = new ArrayList<>();
        String sql = "SELECT id_cuenta, banco, num_cuenta, saldo, id_cliente FROM cuenta_cliente WHERE id_cliente = ?"; 
        
        try(Connection con = conexion.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setLong(1, idCuenta);
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    lista.add(mapearCuenta(rs)); 
                }
            }
            
        }
        return lista;
    }

    @Override
    public CuentaClienteDTO buscarPorId(Long idCuenta) throws SQLException {
        String sq = "SELECT id_cuenta, banco, num_cuenta, saldo, id_cliente FROM cuenta_cliente WHERE id_cuenta = ?";
        
        try(Connection con = conexion.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(sq)){
            
            ps.setLong(1, idCuenta);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return mapearCuenta(rs); 
                }
            }
        }
        return null; 
    }

    @Override
    public boolean actualizarSaldo(Long idCuenta, Double nuevoSaldo) throws SQLException {
        String sql = "UPDATE cuenta_cliente SET saldo = ? WHERE id_cuenta = ?"; 
        
        try(Connection con = conexion.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setDouble(1, nuevoSaldo);
            ps.setLong(2, idCuenta);
            
            
            return ps.executeUpdate() > 0;
            
        }
    }
    
    
    private CuentaClienteDTO mapearCuenta(ResultSet rs) throws SQLException{
        return new CuentaClienteDTO(
        rs.getLong("id_cuenta"),
        rs.getString("banco"),
        rs.getString("num_cuenta"),
        rs.getDouble("saldo"),
        rs.getLong("id_cliente")
        );
    }
    
    
    
}
