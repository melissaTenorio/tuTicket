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
        return null;
    }

    @Override
    public void guardarLote(List<BoletoDTO> boletos) {
        String sql = "INSERT INTO boleto(id_boleto, codigo_boleto, precio, estado, id_evento) VALUES (?, ?, ?, ?, ?)";

        //try(Connection con = conexionDB.crearConexion(); 
          //      PreparedStatement ps = con.prepareStatement(sql)){
        //
        

    }

    @Override
    public BoletoDTO buscarID(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BoletoDTO> obtenerPorEvento(long idEvento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BoletoDTO> obtenerBoletoDisponible(long idEvento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
