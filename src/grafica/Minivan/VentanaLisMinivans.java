package grafica.Minivan;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import grafica.Minivan.ControladorLisMinivans;
import java.awt.Color;

public class VentanaLisMinivans extends JFrame {
	
	public JTable table;
	private JFrame frmListadoMinivans;
	private ControladorLisMinivans controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLisMinivans frame = new VentanaLisMinivans();
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
	public VentanaLisMinivans() {
		initialize();
		  controlador = new ControladorLisMinivans(this);
		 }

		private void initialize() {
			frmListadoMinivans = new JFrame();
			frmListadoMinivans.getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
			frmListadoMinivans.getContentPane().setBackground(SystemColor.activeCaption);
			frmListadoMinivans.setBackground(SystemColor.inactiveCaption);
			frmListadoMinivans.setTitle("Listado de Minivans");
			frmListadoMinivans.setBounds(100, 100, 507, 391);
			frmListadoMinivans.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frmListadoMinivans.getContentPane().setLayout(null);

			JLabel lblLisMinivans = new JLabel("Listado de Minivans");
			lblLisMinivans.setHorizontalAlignment(SwingConstants.CENTER);
			lblLisMinivans.setForeground(SystemColor.text);
			lblLisMinivans.setFont(new Font("Arial", Font.BOLD, 20));
			lblLisMinivans.setBounds(0, 22, 499, 24);
			frmListadoMinivans.getContentPane().add(lblLisMinivans);

			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmListadoMinivans.dispose();
				}
			});
			btnVolver.setBounds(210, 301, 85, 32);
			frmListadoMinivans.getContentPane().add(btnVolver);

			JButton btnListar = new JButton("Listar");
			btnListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlador.ListarMinivans();
				}
			});
			btnListar.setBounds(210, 58, 85, 32);
			frmListadoMinivans.getContentPane().add(btnListar);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(60, 101, 371, 189);
			frmListadoMinivans.getContentPane().add(scrollPane);
			
			table = new JTable();
			table.setEnabled(false);
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Matricula", "Marca", "Modelo", "Cant. Asientos", "Paseos Asig."
				}
			));
			scrollPane.setViewportView(table);
			
		}
		public void setVisible(boolean visible) {
			frmListadoMinivans.setVisible(visible);
		}

		public void mostrarMensaje (String Mensaje) {
			JOptionPane.showMessageDialog(frmListadoMinivans, Mensaje);
		}
	}