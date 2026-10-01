/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

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

    public BoletoDAO(IConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }

    public List<Boleto> consultarBoletosPorEvento(int idEvento) {
        List<Boleto> boletos = new ArrayList<>();
        String sql = "SELECT id, codigoBoleto, estado precio id_evento FROM boletos where id_evento=?";

        try (Connection con = conexionDB.crearConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idEvento);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Boleto boleto = new Boleto();
                    boleto.setId(rs.getInt("id"));
                    boleto.setFolioBoleto(rs.getString("numero_asiento"));
                    boleto.setEstado(rs.getString("estado"));
                    boleto.setPrecio(rs.getDouble("precio"));
                    
                    boletos.add(boleto);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boletos;
    }

}
