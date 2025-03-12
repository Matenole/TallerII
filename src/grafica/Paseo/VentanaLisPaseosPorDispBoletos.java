package grafica.Paseo;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import grafica.Paseo.ControladorLisPaseosPorDispBoletos;
import logica.excepciones.DisponibilidadException;

import java.awt.Color;

public class VentanaLisPaseosPorDispBoletos extends JFrame {
	
	private JFrame frmListadoPaseos;
	private ControladorLisPaseosPorDispBoletos controlador;
	public JTable tableListadoPaseos;
	private JTextField txtCantBoletosDisponibles;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLisPaseosPorDispBoletos frame = new VentanaLisPaseosPorDispBoletos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaLisPaseosPorDispBoletos() {
		initialize();
		  controlador = new ControladorLisPaseosPorDispBoletos(this);
		 }

		private void initialize() {
			frmListadoPaseos = new JFrame();
			frmListadoPaseos.getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
			frmListadoPaseos.getContentPane().setBackground(SystemColor.activeCaption);
			frmListadoPaseos.setBackground(SystemColor.inactiveCaption);
			frmListadoPaseos.setTitle("Listar Paseo por Disponibilidad");
			frmListadoPaseos.setBounds(100, 100, 731, 391);
			frmListadoPaseos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frmListadoPaseos.setResizable(false);
			frmListadoPaseos.getContentPane().setLayout(null);

			JLabel lblLisPaseos = new JLabel("Listado de Paseos por Disponibilidad");
			lblLisPaseos.setHorizontalAlignment(SwingConstants.CENTER);
			lblLisPaseos.setForeground(SystemColor.text);
			lblLisPaseos.setFont(new Font("Arial", Font.BOLD, 20));
			lblLisPaseos.setBounds(108, 23, 499, 24);
			frmListadoPaseos.getContentPane().add(lblLisPaseos);

			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmListadoPaseos.dispose();
				}
			});
			btnVolver.setBounds(315, 301, 85, 32);
			frmListadoPaseos.getContentPane().add(btnVolver);

			JButton btnListar = new JButton("Listar");
			btnListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						controlador.ListarPaseos();
					} catch (DisponibilidadException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnListar.setBounds(315, 58, 85, 32);
			frmListadoPaseos.getContentPane().add(btnListar);

			JScrollPane scrollPanePaseos = new JScrollPane();
			scrollPanePaseos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPanePaseos.setBounds(10, 101, 695, 189);
			frmListadoPaseos.getContentPane().add(scrollPanePaseos);

			tableListadoPaseos = new JTable();
			tableListadoPaseos.setEnabled(false);
			tableListadoPaseos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Destino", "Hora Salida", "Hora Llegada", "Precio", "Cant. Asientos", "Boletos Dis."
				}
			));
			tableListadoPaseos.getTableHeader().setReorderingAllowed(false);
			scrollPanePaseos.setViewportView(tableListadoPaseos);
			
			JLabel lblBoletosDisponibles = new JLabel("Boletos Disponibles");
			lblBoletosDisponibles.setFont(new Font("Arial", Font.BOLD, 12));
			lblBoletosDisponibles.setForeground(UIManager.getColor("Button.highlight"));
			lblBoletosDisponibles.setBounds(10, 67, 117, 14);
			frmListadoPaseos.getContentPane().add(lblBoletosDisponibles);
			
			txtCantBoletosDisponibles = new JTextField();
			txtCantBoletosDisponibles.setBounds(137, 64, 66, 20);
			frmListadoPaseos.getContentPane().add(txtCantBoletosDisponibles);
			txtCantBoletosDisponibles.setColumns(10);
				}
		
		public String getBolDisp() {
		    return txtCantBoletosDisponibles.getText();
		}
		public void setVisible(boolean visible) {
			frmListadoPaseos.setVisible(visible);
		}
		public void mostrarMensaje (String Mensaje) {
			JOptionPane.showMessageDialog(frmListadoPaseos, Mensaje);
		}

	}
