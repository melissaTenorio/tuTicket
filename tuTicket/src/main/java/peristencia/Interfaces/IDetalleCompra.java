/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package peristencia.Interfaces;

import entidades.DetalleCompra;
/**
 *
 * @author melis
 */
public interface IDetalleCompra {
    DetalleCompra guardar(DetalleCompra detalleCompra) throws Exception;
    DetalleCompra buscarPorIdCompra(Long idCompra) throws Exception;
}
