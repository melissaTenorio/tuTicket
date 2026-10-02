/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import entidades.Boleto;
import entidades.Evento;
import entidades.Promotora;
import java.util.List;
import peristencia.Interfaces.IEventoDAO;
import persistencia.ConexionDB;
import persistencia.EventoDAO;
import persistencia.IPromotoraDAO;
import persistencia.PromotoraDAO;

/**
 *
 * @author melis
 */
public class PromotoraNegocio implements IPromotoraNegocio {
    private final IPromotoraDAO promotoraDAO;
    private final IEventoDAO eventoDAO;

    public PromotoraNegocio() {
        this.promotoraDAO = new PromotoraDAO(new ConexionDB());
        this.eventoDAO = new EventoDAO(new ConexionDB());
    }

    @Override
    public Promotora autenticar(String correo, String contrasena) {
        if (correo == null || correo.isBlank() || contrasena == null || contrasena.isBlank()) {
            return null;
        }
        return promotoraDAO.iniciarSesion(correo, contrasena);
    }
    
    @Override
    public boolean registrarPromotora(Promotora promotora) {
        if (promotora.getNombreEmpresa().isBlank() || promotora.getCorreo().isBlank()) {
            return false;
        }
        return promotoraDAO.registrar(promotora);
    }

    @Override
    public boolean crearEvento(Evento evento) {
        if (evento.getNombreEvento().isBlank() || evento.getCapacidad() <= 0) {
            return false;
        }
        return eventoDAO.guardar(evento);
    }

    @Override
    public List<Evento> misEventos(Long idPromotora) {
        return eventoDAO.obtenerPorPromotora(idPromotora);
    }

    @Override
    public boolean registrarBoletosEvento(List<Boleto> boletos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Boleto> obtenerBoletosPorEvento(Long idEvento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

