/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import Negocio.IPromotoraNegocio;
import Negocio.PromotoraNegocio;
import entidades.Evento;
import entidades.Promotora;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author melis
 */
public class MenuPromotora extends JFrame {
    private final Promotora promotoraLog;
    private final IPromotoraNegocio promotoraNegocio;
    
    private JTable tablaEventos;
    private DefaultTableModel modeloTabla;
    private JButton btnCrearEvento;
    private JButton btnCerrarSesion;
    private JLabel lblBienvenida;

    public MenuPromotora(Promotora promotora) {
        this.promotoraLog = promotora;
        this.promotoraNegocio = new PromotoraNegocio();

        initComponents();
        cargarEventos();
    }

    private void initComponents() {
setTitle("Panel de Promotora - " + promotoraLog.getNombreEmpresa());
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));    
   
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 10));
        lblBienvenida = new JLabel("Bienvenido(a), " + promotoraLog.getNombreEmpresa());
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 16));
        panelNorte.add(lblBienvenida);
        add(panelNorte, BorderLayout.NORTH);
    
        // Panel Central: Tabla de Eventos
        String[] columnas = {"ID", "Nombre del Evento", "Fecha", "Lugar", "Capacidad"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer la tabla de solo lectura
            }
        };
        
        tablaEventos = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaEventos);
        add(scrollTabla, BorderLayout.CENTER);

        // Panel Inferior: Botones de Acción
        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        
        btnCrearEvento = new JButton(" + Crear Nuevo Evento");
        btnCerrarSesion = new JButton("Cerrar Sesión");

        panelSur.add(btnCrearEvento);
        panelSur.add(btnCerrarSesion);
        add(panelSur, BorderLayout.SOUTH);

        // Listeners de Eventos
        btnCrearEvento.addActionListener(e -> abrirFormularioCrearEvento());
        btnCerrarSesion.addActionListener(e -> cerrarSesion());
    }
    
    private void cargarEventos() {
        modeloTabla.setRowCount(0); // Limpiar filas anteriores
        List<Evento> eventos = promotoraNegocio.misEventos(promotoraLog.getId());

        if (eventos != null) {
            for (Evento ev : eventos) {
                Object[] fila = {
                    ev.getId(),
                    ev.getNombreEvento(),
                    ev.getFecha(),
                    ev.getLugar(),
                    ev.getCapacidad()
                };
                modeloTabla.addRow(fila);
            }
        }
    }
    private void abrirFormularioCrearEvento() {
        // Abre una ventana modal para registrar datos del evento
        FrmCrearEvento frm = new FrmCrearEvento(this, true, promotoraLog);
        frm.setVisible(true);
        cargarEventos(); 
    }

    private void cerrarSesion() {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "¿Deseas cerrar sesión?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION
        );
    }
}
    
    
    

