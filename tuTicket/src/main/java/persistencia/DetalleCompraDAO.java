/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.DetalleCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import peristencia.Interfaces.IDetalleCompra;

/**
 *
 * @author melis
 */
public class DetalleCompraDAO implements IDetalleCompra {

    private final IConexionDB conexionDB;

    public DetalleCompraDAO() {
        this.conexionDB = new ConexionDB();

    }

    @Override
    public DetalleCompra guardar(DetalleCompra detalleCompra) throws Exception {
        String sql = "INSERT INTO detalle_compra (banco_origen, cuenta_origen, clave_rastreo, monto, fecha_transferencia, id_compra) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = conexionDB.crearConexion(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, detalleCompra.getBancoOrigen());
            ps.setString(2, detalleCompra.getCuentaOrigen());
            ps.setString(3, detalleCompra.getFolioCompra());
            ps.setDouble(4, detalleCompra.getMonto());
            ps.setTimestamp(5, new Timestamp(detalleCompra.getFecha().getTime()));
            ps.setLong(6, detalleCompra.getIdCompra());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    detalleCompra.setId(rs.getLong(1));
                }
            }
        }
        return detalleCompra;

    }

    @Override
    public DetalleCompra buscarPorIdCompra(Long idCompra) throws Exception {
        String sql = "SELECT id, banco_origen, cuenta_origen, clave_rastreo, monto, fecha_transferencia, id_compra FROM detalle_compra WHERE id_compra = ?";
        DetalleCompra detalle = null;

        try (Connection con = conexionDB.crearConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, idCompra);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    detalle = new DetalleCompra(
                            rs.getLong("id"),
                            rs.getString("banco_origen"),
                            rs.getString("cuenta_origen"),
                            rs.getString("clave_rastreo"),
                            rs.getTimestamp("fecha_transferencia"),
                            rs.getDouble("monto"),
                            rs.getLong("id_compra")
                    );
                }
            }
        }
        return detalle;
    }
}
