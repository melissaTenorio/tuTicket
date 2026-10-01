/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import entidades.Compra;
import entidades.DetalleCompra;
import entidades.Evento;

/**
 *
 * @author melis
 */
public interface ICompraNegocio {
    Compra registrarCompraConTransferencia(Long idCliente, Evento evento, int cantidad, DetalleCompra detalle) throws Exception;
}
