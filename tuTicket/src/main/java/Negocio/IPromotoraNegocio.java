/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import entidades.Boleto;
import entidades.Evento;
import entidades.Promotora;
import java.util.List;

/**
 *
 * @author melis
 */
public interface IPromotoraNegocio {

    Promotora autenticar(String correo, String contrasena);

    boolean registrarPromotora(Promotora promotora);

    boolean crearEvento(Evento evento);

    List<Evento> misEventos(Long idPromotora);

    boolean registrarBoletosEvento(List<Boleto> boletos);

    List<Boleto> obtenerBoletosPorEvento (Long idEvento);
}
