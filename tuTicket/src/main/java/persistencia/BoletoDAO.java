/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dtos.BoletoDTO;
import peristencia.Interfaces.IBoletoDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author melis
 */
public class BoletoDAO implements IBoletoDAO {

    private final IConexionDB conexionDB;

    public BoletoDAO(IConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    public List<BoletoDTO> consultarBoletosPorEvento(int idEvento) {
        List<BoletoDTO> boletos = new ArrayList<>();
        String sql = "SELECT id, codigoBoleto, estado precio id_evento FROM boletos where id_evento=?";

        try (Connection con = conexionDB.crearConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idEvento);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BoletoDTO boletoDTO = new BoletoDTO();
                    boletoDTO.setIdBoleto(rs.getLong("id"));
                    boletoDTO.setCodigo_boleto(rs.getString("numero_asiento"));
                    boletoDTO.setEstado(rs.getString("estado"));
                    boletoDTO.setPrecio(rs.getDouble("precio"));
                    
                    boletos.add(boletoDTO);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boletos;
    }

    @Override
    public BoletoDTO guardar(BoletoDTO boletoDTO) throws SQLException {
        String sql = "INSERT INTO boleto(id_boleto, codigo_boleto, precio, estado, id_evento) VALUES (?, ?, ?, ?, ?)";
        
        try(Connection con = conexionDB.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
                ps.setString(1, boletoDTO.getCodigo_boleto());
                ps.setDouble(2, boletoDTO.getPrecio());
                ps.setString(3, boletoDTO.getEstado());
                ps.setLong(4, boletoDTO.getIdEvento());
                
                int filasAfectadas = ps.executeUpdate(); 
                
                
                if (filasAfectadas > 0){
                    try(ResultSet rs = ps.getGeneratedKeys()){
                        if(rs.next()){
                            boletoDTO.setIdBoleto(rs.getLong(1));
                        }
                    }
                }
        }
        return boletoDTO;
    }

    @Override
    public boolean guardarLote(List<BoletoDTO> boletos) throws SQLException {
        String sql = "INSERT INTO boleto(id_boleto, codigo_boleto, precio, estado, id_evento) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = conexionDB.crearConexion();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            for(BoletoDTO b : boletos){
                ps.setString(1, b.getCodigo_boleto());
                ps.setDouble(2, b.getPrecio());
                ps.setString(3, b.getEstado());
                ps.setLong(4, b.getIdEvento());
                ps.addBatch();
            }
            
            int[] resultados = ps.executeBatch();
            return resultados.length > 0;
        }   

    }

    @Override
    public BoletoDTO buscarID(long id) throws SQLException{
        String sql = "SELECT id_boleto, codigo_boleto, precio, estado_boleto, id_evento" +
                "FROM boleto WHERE id_boleto"; 
        
        try(Connection con = conexionDB.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setLong(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return mapearBoleto(rs); 
                }
            }
        }
        return null; 
    }

    @Override
    public List<BoletoDTO> obtenerPorEvento(long idEvento) throws SQLException{
        List<BoletoDTO> lista = new ArrayList();
        String sql = "SELECT id_boleto, codigo_boleto, precio, estado_boleto, id_evento" + "FROM bole WHERE id_evento = ? AND estado_boleto = 'disponible'";
        
        try(Connection con = conexionDB.crearConexion();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setLong(1, idEvento);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    lista.add(mapearBoleto(rs)); 
                }
            }
        }
        return lista;
    }

    @Override
    public boolean actualizarEstado(long idBoleto, String nuevoEstado) throws SQLException {
        String sql = "UPDATE boleto SET estado_bolet = ? WHERE id_boleto = ?"; 
        
        try(Connection con = conexionDB.crearConexion(); 
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, nuevoEstado);
            ps.setLong(2, idBoleto);
            
            
            return ps.executeUpdate() > 0; 
        }
    } 

    
    private BoletoDTO mapearBoleto(ResultSet rs) throws SQLException {
        return new BoletoDTO(
        rs.getLong("id_boleto"),
        rs.getString("codigo_boleto"),
        rs.getDouble("precio"),
        rs.getString("estado_boleto"),
        rs.getLong("id_boleto")
        );
    }

   
}
