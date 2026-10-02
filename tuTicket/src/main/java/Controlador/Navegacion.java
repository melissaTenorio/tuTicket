/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Controlador;

import Negocio.IPromotoraNegocio;
import Negocio.PromotoraNegocio;
import entidades.Evento;
import entidades.Promotora;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import presentacion.FrmCrearEvento;
import presentacion.frmGestionarBoletos;

/**
 *
 * @author melis
 */
public class Navegacion {
public static void abrirDialogo(JDialog dialog) {
        dialog.setLocationRelativeTo(dialog.getOwner());
        dialog.setVisible(true);
    }

    // Método para cambiar de pantalla principal (JFrames)
    public static void cambiarPantalla(JFrame actual, JFrame nueva) {
        if (actual != null) {
            actual.dispose(); // Cierra la pantalla anterior
        }
        nueva.setLocationRelativeTo(null);
        nueva.setVisible(true);
    }
}
    
    
    



