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
import java.awt.GridLayout;
import java.awt.Window;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author melis
 */
class FrmCrearEvento extends JDialog {
    private final IPromotoraNegocio promotoraNegocio;
    
    private JTextField txtNombre;
    private JTextField txtFecha; // Formato esperado: yyyy-MM-dd
    private JTextField txtLugar;
    private JTextField txtCapacidad;
    private JButton btnGuardar;
    private JButton btnCancelar;
    private final Promotora promotoraLog;
    
    public FrmCrearEvento(Window parent, boolean modal, Promotora promotora) {
        super(parent, "Registrar Nuevo Evento", modal ? DEFAULT_MODALITY_TYPE : ModalityType.MODELESS);
        this.promotoraLog = promotora;
        this.promotoraNegocio = new PromotoraNegocio();

        initComponents();
    }

    private void initComponents() {
setSize(400, 300);
        setLocationRelativeTo(getOwner());
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        // Panel Principal del Formulario (Grid)
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 10));
        panelForm.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panelForm.add(new JLabel("Nombre del Evento:"));
        txtNombre = new JTextField();
        panelForm.add(txtNombre);

        panelForm.add(new JLabel("Fecha (YYYY-MM-DD):"));
        txtFecha = new JTextField();
        panelForm.add(txtFecha);

        panelForm.add(new JLabel("Lugar / Sede:"));
        txtLugar = new JTextField();
        panelForm.add(txtLugar);
panelForm.add(new JLabel("Capacidad Total:"));
        txtCapacidad = new JTextField();
        panelForm.add(txtCapacidad);

        add(panelForm, BorderLayout.CENTER);

        // Panel de Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        btnGuardar = new JButton("Guardar Evento");
        btnCancelar = new JButton("Cancelar");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnGuardar.addActionListener(e -> guardarEvento());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void guardarEvento() {
String nombre = txtNombre.getText().trim();
        String fechaTexto = txtFecha.getText().trim();
        String lugar = txtLugar.getText().trim();
        String capacidadTexto = txtCapacidad.getText().trim();

        // Validaciones básicas de entrada
        if (nombre.isEmpty() || fechaTexto.isEmpty() || lugar.isEmpty() || capacidadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }
int capacidad;
        try {
            capacidad = Integer.parseInt(capacidadTexto);
            if (capacidad <= 0) {
                JOptionPane.showMessageDialog(this, "La capacidad debe ser un número mayor a cero.", "Atención", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido para la capacidad.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Date fecha;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            fecha = sdf.parse(fechaTexto);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Utilice el formato YYYY-MM-DD.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
            return;
        }
   Evento nuevoEvento = new Evento();
        nuevoEvento.setNombreEvento(nombre);
        nuevoEvento.setFecha(fecha);
        nuevoEvento.setLugar(lugar);
        nuevoEvento.setCapacidad(capacidad);
        nuevoEvento.setIdPromotora(promotoraLog.getId()); // Asignar id de la promotora creadora

        // Guardar a través de la capa de Negocio
        boolean exito = promotoraNegocio.crearEvento(nuevoEvento);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Evento registrado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo registrar el evento. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}