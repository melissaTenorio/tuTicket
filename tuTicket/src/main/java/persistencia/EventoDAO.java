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
    
    
    public List<Evento> consultarTodos(){
   
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT id, nombre, fecha, lugar, precio_base FROM eventos";

        try (Connection conn = conexionDB.crearConexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
               // faltan atributos aqui 
                eventos.add(evento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventos;
    
    }
    public Evento obteEvento (int idEvento){
    String sql = "SELECT id,nombre,fecha where id=?";
        try (Connection con = conexionDB.crearConexion();
                PreparedStatement ps = con.prepareStatement(sql)){
                ps.setInt(1, idEvento);
                try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
                    evento.setNombreEvento(rs.getString("nombre"));
                                   // faltan atributos aqui 
                    return evento;
                }
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Evento guardar(Evento evento) {
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
    public List<Evento> Obten() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
