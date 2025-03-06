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
import java.awt.Color;

public class VentanaLisPaseosPorDispBoletos extends JFrame {
	
	private JFrame frmListadoPaseos;
	private ControladorLisPaseosPorDispBoletos controlador;
	public JTable tableListadoPaseos;
	private JTextField txtCantBoletosDisponibles;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public VentanaLisPaseosPorDispBoletos() {
		initialize();
		  controlador = new ControladorLisPaseosPorDispBoletos(this);
		 }

		private void initialize() {
			frmListadoPaseos = new JFrame();
			frmListadoPaseos.getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
			frmListadoPaseos.getContentPane().setBackground(SystemColor.activeCaption);
			frmListadoPaseos.setBackground(SystemColor.inactiveCaption);
			frmListadoPaseos.setTitle("Listado de Paseos");
			frmListadoPaseos.setBounds(100, 100, 602, 391);
			frmListadoPaseos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frmListadoPaseos.getContentPane().setLayout(null);

			JLabel lblLisPaseos = new JLabel("Listado de Paseos");
			lblLisPaseos.setHorizontalAlignment(SwingConstants.CENTER);
			lblLisPaseos.setForeground(SystemColor.text);
			lblLisPaseos.setFont(new Font("Arial", Font.BOLD, 20));
			lblLisPaseos.setBounds(24, 23, 499, 24);
			frmListadoPaseos.getContentPane().add(lblLisPaseos);

			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmListadoPaseos.dispose();
				}
			});
			btnVolver.setBounds(242, 301, 85, 32);
			frmListadoPaseos.getContentPane().add(btnVolver);

			JButton btnListar = new JButton("Listar");
			btnListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlador.ListarPaseos();
				}
			});
			btnListar.setBounds(242, 58, 85, 32);
			frmListadoPaseos.getContentPane().add(btnListar);

			JScrollPane scrollPanePaseos = new JScrollPane();
			scrollPanePaseos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPanePaseos.setBounds(24, 101, 525, 189);
			frmListadoPaseos.getContentPane().add(scrollPanePaseos);

			tableListadoPaseos = new JTable();
			scrollPanePaseos.setViewportView(tableListadoPaseos);
			tableListadoPaseos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Codigo", "Destino", "Hora Salida", "Hora Llegada", "Precio", "Cant. Maxima de Boletos", "Cant. Boletos Disponibles"
				}
			));
			tableListadoPaseos.getColumnModel().getColumn(0).setPreferredWidth(100);
			tableListadoPaseos.getColumnModel().getColumn(1).setPreferredWidth(100);
			tableListadoPaseos.getColumnModel().getColumn(2).setPreferredWidth(100);
			tableListadoPaseos.getColumnModel().getColumn(3).setPreferredWidth(80);
			tableListadoPaseos.getColumnModel().getColumn(4).setPreferredWidth(80);
			tableListadoPaseos.getColumnModel().getColumn(5).setPreferredWidth(80);
			tableListadoPaseos.getColumnModel().getColumn(6).setPreferredWidth(80);
			scrollPanePaseos.setViewportView(tableListadoPaseos.getTableHeader());
			
			JLabel lblBoletosDisponibles = new JLabel("Boletos Disponibles");
			lblBoletosDisponibles.setFont(new Font("Arial", Font.BOLD, 12));
			lblBoletosDisponibles.setForeground(UIManager.getColor("Button.highlight"));
			lblBoletosDisponibles.setBounds(24, 67, 117, 14);
			frmListadoPaseos.getContentPane().add(lblBoletosDisponibles);
			
			txtCantBoletosDisponibles = new JTextField();
			txtCantBoletosDisponibles.setBounds(151, 64, 66, 20);
			frmListadoPaseos.getContentPane().add(txtCantBoletosDisponibles);
			txtCantBoletosDisponibles.setColumns(10);
				}
	
		public void setVisible(boolean visible) {
			frmListadoPaseos.setVisible(visible);
		}

		public void mostrarMensaje (String Mensaje) {
			JOptionPane.showMessageDialog(frmListadoPaseos, Mensaje);
		}

	}
