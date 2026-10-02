/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import Negocio.IPromotoraNegocio;
import Negocio.PromotoraNegocio;
import entidades.Boleto;
import entidades.Evento;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author melis
 */
public class frmGestionarBoletos extends JDialog {

  private final Evento eventoSeleccionado;
    private final IPromotoraNegocio promotoraNegocio;

    private JTextField txtPrecioUnitario;
    private JTextField txtCantidadGenerar;
    private JLabel lblCapacidadInfo;
    private JButton btnGenerarBoletos;
    private JButton btnCancelar;

    public frmGestionarBoletos(Window parent, boolean modal, Evento evento) {
        super(parent, "Generar Boletos - " + evento.getNombreEvento(), modal ? DEFAULT_MODALITY_TYPE : ModalityType.MODELESS);
        this.eventoSeleccionado = evento;
        this.promotoraNegocio = new PromotoraNegocio();

        initComponents();
    }

    private void initComponents() {
        setSize(420, 260);
        setLocationRelativeTo(getOwner());
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        // Panel Norte: Información del evento
        JPanel panelNorte = new JPanel(new GridLayout(2, 1, 5, 5));
        panelNorte.setBorder(BorderFactory.createEmptyBorder(15, 15, 5, 15));

        JLabel lblEvento = new JLabel("Evento: " + eventoSeleccionado.getNombreEvento());
        lblEvento.setFont(new Font("Arial", Font.BOLD, 14));
        lblCapacidadInfo = new JLabel("Capacidad máxima permitida: " + eventoSeleccionado.getCapacidad());

        panelNorte.add(lblEvento);
        panelNorte.add(lblCapacidadInfo);
        add(panelNorte, BorderLayout.NORTH);

        // Panel Centro: Formulario de Precio y Cantidad
        JPanel panelCentro = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        panelCentro.add(new JLabel("Precio Unitario ($):"));
        txtPrecioUnitario = new JTextField();
        panelCentro.add(txtPrecioUnitario);

        panelCentro.add(new JLabel("Cantidad de Boletos:"));
        txtCantidadGenerar = new JTextField(String.valueOf(eventoSeleccionado.getCapacidad()));
        panelCentro.add(txtCantidadGenerar);

        add(panelCentro, BorderLayout.CENTER);

        // Panel Sur: Botones de Acción
        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        btnGenerarBoletos = new JButton("Generar y Guardar");
        btnCancelar = new JButton("Cancelar");

        panelSur.add(btnGenerarBoletos);
        panelSur.add(btnCancelar);
        add(panelSur, BorderLayout.SOUTH);

        // Eventos
        btnGenerarBoletos.addActionListener(e -> procesarGeneracionBoletos());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void procesarGeneracionBoletos() {
        String precioTexto = txtPrecioUnitario.getText().trim();
        String cantidadTexto = txtCantidadGenerar.getText().trim();

        if (precioTexto.isEmpty() || cantidadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el precio unitario y la cantidad de boletos.", "Atención", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double precio = Double.parseDouble(precioTexto);
            int cantidad = Integer.parseInt(cantidadTexto);

            if (precio <= 0 || cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "El precio y la cantidad deben ser valores positivos.", "Atención", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (cantidad > eventoSeleccionado.getCapacidad()) {
                JOptionPane.showMessageDialog(this, "La cantidad de boletos no puede superar la capacidad del evento (" + eventoSeleccionado.getCapacidad() + ").", "Exceso de Capacidad", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Generar la lista de objetos Boleto de acuerdo a la clase del dominio
            List<Boleto> listaBoletos = new ArrayList<>();
            for (int i = 1; i <= cantidad; i++) {
                Boleto b = new Boleto();
                // Generación de un folio/número único de boleto
                b.setNumeroBoleto("BOL-" + eventoSeleccionado.getId() + "-" + String.format("%04d", i));
                b.setLugar(eventoSeleccionado.getLugar());
                b.setNombreEvento(eventoSeleccionado.getNombreEvento());
                b.setPrecioUnitario(precio);
                b.setFechaHora(eventoSeleccionado.getFecha());
                b.setEstado("DISPONIBLE");
                b.setIdEvento(eventoSeleccionado.getId());
                b.setIdCompra(0); // Aún no ha sido comprado

                listaBoletos.add(b);
            }

            boolean exito = promotoraNegocio.registrarBoletosEvento(listaBoletos);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Se generaron " + cantidad + " boletos exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudieron registrar los boletos.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese números válidos para precio y cantidad.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }
}