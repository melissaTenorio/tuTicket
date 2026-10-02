/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import peristencia.Interfaces.IEventoDAO;

/**
 *
 * @author melis
 */
public class EventoDAO implements IEventoDAO {
    private final IConexionDB conexionDB;

    public EventoDAO(IConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public boolean guardar(Evento evento) {
        String sql = "INSERT INTO eventos (nombre, fecha, lugar, capacidad, id_promotora) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conexionDB.crearConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, evento.getNombreEvento());
            ps.setDate(2, new java.sql.Date(evento.getFecha().getTime()));
            ps.setString(3, evento.getLugar());
            ps.setInt(4, evento.getCapacidad());
            ps.setLong(5, evento.getIdPromotora());
          return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Evento> obtenerTodos() {
        List<Evento> lista = new ArrayList<>();
        String sql = "SELECT * FROM eventos";
        try (Connection con = conexionDB.crearConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(extraerEvento(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<Evento> obtenerPorPromotora(Long idPromotora) {
        List<Evento> lista = new ArrayList<>();
        String sql = "SELECT * FROM eventos WHERE id_promotora = ?";
        try (Connection con = conexionDB.crearConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, idPromotora);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(extraerEvento(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public Evento obtenerPorId(Long id) {
        String sql = "SELECT * FROM eventos WHERE id = ?";
        try (Connection con = conexionDB.crearConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extraerEvento(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

  private Evento extraerEvento(ResultSet rs) throws SQLException {
        Evento e = new Evento();
        e.setId(rs.getLong("id"));
        e.setNombreEvento(rs.getString("nombre"));
        e.setFecha(rs.getDate("fecha"));
        e.setLugar(rs.getString("lugar"));
        e.setCapacidad(rs.getInt("capacidad"));
        e.setIdPromotora(rs.getLong("id_promotora"));
        return e;
    }

    @Override
    public Evento agregar(Evento evento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Evento actualizar(Evento evento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Evento buscarPorID(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Evento> obtenPromotora() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Evento> ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

  
    

