/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import entidades.Boleto;
import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Evento;
import java.time.LocalDate;
import java.util.Date;
import peristencia.Interfaces.IBoletoDAO;
import peristencia.Interfaces.ICompraDAO;
import peristencia.Interfaces.IDetalleCompra;
import persistencia.BoletoDAO;
import persistencia.CompraDAO;
import persistencia.DetalleCompraDAO;

/**
 *
 * @author melis
 */
public class CompraNegocio implements ICompraNegocio{
    private final ICompraDAO compraDAO;
    private final IDetalleCompra detalleCompraDAO;
    private final IBoletoDAO boletoDAO;

    public CompraNegocio() {
        this.compraDAO = new CompraDAO();
        this.detalleCompraDAO = new DetalleCompraDAO();
        this.boletoDAO = new BoletoDAO();
    }

    @Override
    public Compra registrarCompraConTransferencia(Long idCliente, Evento evento, int cantidad, DetalleCompra detalle) throws Exception {
        // 1. Validaciones
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad de boletos debe ser mayor a cero.");
        }
        if (detalle.getFolioCompra()== null || detalle.getFolioCompra().isBlank()) {
            throw new IllegalArgumentException("La clave de rastreo de la transferencia es obligatoria.");
        }

        double total = evento.getPrecio() * cantidad;

        // 2. Crear y guardar registro de Compra
        Compra compra = new Compra();
        compra.setFechaHora(LocalDate.EPOCH);
        compra.setMontoTotal(total);
        compra.setEstado("Completada");
        compra.setIdCliente(idCliente);
        
        compra = compraDAO.guardar(compra);

        // 3. Vincular y guardar el DetalleCompra (datos bancarios)
        detalle.setMonto(total);
        detalle.setFecha(new Date());
        detalle.setIdCompra(compra.getId());
        
        detalleCompraDAO.guardar(detalle);

        // 4. Generar y guardar los boletos correspondientes
        for (int i = 1; i <= cantidad; i++) {
            Boleto boleto = new Boleto();
            boleto.setNumeroBoleto("TKT-" + System.currentTimeMillis() + "-" + i);
            boleto.setNombreEvento(evento.getNombreEvento());
            boleto.setLugar(evento.getLugar());
            boleto.setFechaHora(evento.getFecha());
            boleto.setPrecio(evento.getPrecio());
            boleto.setIdEvento(evento.getId());
            boleto.setIdCompra(compra.getId());

            boletoDAO.guardar(boleto);
        }

        return compra;
    }
}