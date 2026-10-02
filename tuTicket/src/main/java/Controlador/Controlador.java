/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import presentacion.FR
/**
 *
 * @author melis
 */
public class Controlador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Se ejecuta en el hilo de la interfaz de Swing
        SwingUtilities.invokeLater(() -> {
            FrmLoginPromotora login = new FrmLoginPromotora();
            Navegador.cambiarPantalla(null, login); // Abre la primera pantalla centrada
        });
    }
