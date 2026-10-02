/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Promotora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author melis
 */
public class PromotoraDAO implements IPromotoraDAO{

   private final IConexionDB conexionDB;

    public PromotoraDAO(IConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    public PromotoraDAO(ConexionDB conexionDB) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Promotora iniciarSesion(String correo, String contrasena) {
        String sql = "SELECT * FROM promotoras WHERE correo = ? AND contrasena = ?";
        try (Connection con = conexionDB.crearConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.setString(2, contrasena);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Promotora promotora = new Promotora();
                    promotora.setId(rs.getLong("id"));
                    promotora.setNombreEmpresa(rs.getString("nombre_empresa"));
                    promotora.setRfc(rs.getString("rfc"));
                    promotora.setCorreo(rs.getString("correo"));
                    promotora.setContraseña(rs.getString("contrasena"));
                    return promotora;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean registrar(Promotora promotora) {
        String sql = "INSERT INTO promotoras (nombre_empresa, rfc, correo, contrasena) VALUES (?, ?, ?, ?)";
        try (Connection con = conexionDB.crearConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, promotora.getNombreEmpresa());
            ps.setString(2, promotora.getRfc());
            ps.setString(3, promotora.getCorreo());
            ps.setString(4, promotora.getContraseña());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Promotora gusradr(Promotora promotora) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Promotora buscarid(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Promotora> obten() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    

