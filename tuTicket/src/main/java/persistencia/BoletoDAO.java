/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import dtos.BoletoDTO;
import entidades.Boleto;
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

    public BoletoDAO() {
        this.conexionDB = new ConexionDB();
    }

    public boolean guardarLote(List<Boleto> boletos) {
        String sql = "INSERT INTO boletos (numero_boleto, lugar, evento, precio_unitario, fecha_hora, estado, id_evento, id_compra) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = conexionDB.crearConexion()) {
            con.setAutoCommit(false); // Transacción manual para optimizar inserción masiva

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                for (Boleto b : boletos) {
                    ps.setString(1, b.getNumeroBoleto());
                    ps.setString(2, b.getLugar());
                    ps.setString(3, b.getNombreEvento());
                    ps.setDouble(4, b.getPrecioUnitario());
                    ps.setTimestamp(5, new Timestamp(b.getFechaHora().getTime()));
                    ps.setString(6, b.getEstado());
                    ps.setLong(7, b.getIdEvento());
                    ps.setLong(8, b.getIdCompra());

                    ps.addBatch();
                }

                ps.executeBatch();
                con.commit(); // Confirmar transacción
                return true;

            } catch (SQLException e) {
                con.rollback(); // Revertir en caso de falla
                e.printStackTrace();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Boleto> obtenerPorEvento(long idEvento) {
        List<Boleto> lista = new ArrayList<>();
        String sql = "SELECT * FROM boletos WHERE id_evento = ?";

        try (Connection con = conexionDB.crearConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, idEvento);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(extraerBoleto(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Boleto> obtenerDisponiblesPorEvento(long idEvento) {
        List<Boleto> lista = new ArrayList<>();
        String sql = "SELECT * FROM boletos WHERE id_evento = ? AND estado = 'DISPONIBLE'";

        try (Connection con = conexionDB.crearConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, idEvento);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(extraerBoleto(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean actualizarEstado(long idBoleto, String estado, long idCompra) {
        String sql = "UPDATE boletos SET estado = ?, id_compra = ? WHERE id = ?";

        try (Connection con = conexionDB.crearConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, estado);
            ps.setLong(2, idCompra);
            ps.setLong(3, idBoleto);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método auxiliar para mapear el ResultSet a un objeto Boleto
    private Boleto extraerBoleto(ResultSet rs) throws SQLException {
        Boleto b = new Boleto();
        b.setId(rs.getLong("id"));
        b.setNumeroBoleto(rs.getString("numero_boleto"));
        b.setLugar(rs.getString("lugar"));
        b.setNombreEvento(rs.getString("evento"));
        b.setPrecioUnitario(rs.getDouble("precio_unitario"));
        b.setFechaHora(rs.getTimestamp("fecha_hora"));
        b.setEstado(rs.getString("estado"));
        b.setIdEvento(rs.getLong("id_evento"));
        b.setIdCompra(rs.getLong("id_compra"));
        return b;
    }

    
    public BoletoDTO guardar(BoletoDTO boleto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardar(Boleto boleto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

}