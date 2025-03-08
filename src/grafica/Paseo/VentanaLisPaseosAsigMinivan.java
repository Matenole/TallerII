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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class VentanaLisPaseosAsigMinivan extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmListadoPaseos;
	private ControladorLisPaseosAsigMinivan controlador;
	public JTable tableListadoPaseos;
	private JTextField txtMatricula;
	private JTextField txtCod;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLisPaseosAsigMinivan frame = new VentanaLisPaseosAsigMinivan();
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
	public VentanaLisPaseosAsigMinivan() {
		initialize();
		  controlador = new ControladorLisPaseosAsigMinivan(this);
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
			lblLisPaseos.setBounds(34, 23, 499, 24);
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
			scrollPanePaseos.setBounds(34, 101, 464, 189);
			frmListadoPaseos.getContentPane().add(scrollPanePaseos);
			
			tableListadoPaseos = new JTable();
			tableListadoPaseos.setEnabled(false);
			tableListadoPaseos.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
				},
				new String[] {
					"Codigo", "Destino", "Hora Salida", "Hora Llegada", "Precio", "Cant. Asientos", "Boletos Dis."
				}
			));
			scrollPanePaseos.setViewportView(tableListadoPaseos);
			
			JLabel lblMatricula = new JLabel("Matricula");
			lblMatricula.setFont(new Font("Arial", Font.BOLD, 12));
			lblMatricula.setForeground(UIManager.getColor("Button.highlight"));
			lblMatricula.setBounds(24, 42, 68, 14);
			frmListadoPaseos.getContentPane().add(lblMatricula);
			
			txtMatricula = new JTextField();
			txtMatricula.setBounds(93, 39, 86, 20);
			frmListadoPaseos.getContentPane().add(txtMatricula);
			txtMatricula.setColumns(10);
				}
		
		public String getMatricula() {
		    return txtMatricula.getText();
		}
		public void setVisible(boolean visible) {
			frmListadoPaseos.setVisible(visible);
		}

		public void mostrarMensaje (String Mensaje) {
			JOptionPane.showMessageDialog(frmListadoPaseos, Mensaje);
		}

		public JTextField getTxtCod() {
			return txtCod;
		}

		public void setTxtCod(JTextField txtCod) {
			this.txtCod = txtCod;
		}
	}
