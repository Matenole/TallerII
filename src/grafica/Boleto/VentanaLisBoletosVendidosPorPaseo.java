package grafica.Boleto;

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
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import logica.excepciones.LogicaException;
import javax.swing.JCheckBox;

public class VentanaLisBoletosVendidosPorPaseo extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmListadoBoletos;
	private ControladorLisBoletosVendidosPorPaseo controlador;
	public JTable tableListadoBoletos;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLisBoletosVendidosPorPaseo frame = new VentanaLisBoletosVendidosPorPaseo();
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
	public VentanaLisBoletosVendidosPorPaseo() {
		initialize();
		  controlador = new ControladorLisBoletosVendidosPorPaseo(this);
		 }

		private void initialize() {
			frmListadoBoletos = new JFrame();
			frmListadoBoletos.getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
			frmListadoBoletos.getContentPane().setBackground(SystemColor.activeCaption);
			frmListadoBoletos.setBackground(SystemColor.inactiveCaption);
			frmListadoBoletos.setTitle("Listar Boletos");
			frmListadoBoletos.setBounds(100, 100, 507, 391);
			frmListadoBoletos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frmListadoBoletos.getContentPane().setLayout(null);

			JLabel lblLisBoletos = new JLabel("Listado de Boletos");
			lblLisBoletos.setHorizontalAlignment(SwingConstants.CENTER);
			lblLisBoletos.setForeground(SystemColor.text);
			lblLisBoletos.setFont(new Font("Arial", Font.BOLD, 20));
			lblLisBoletos.setBounds(-4, 11, 499, 24);
			frmListadoBoletos.getContentPane().add(lblLisBoletos);

			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmListadoBoletos.dispose();
				}
			});
			btnVolver.setBounds(203, 301, 85, 32);
			frmListadoBoletos.getContentPane().add(btnVolver);

			JButton btnListar = new JButton("Listar");
			btnListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						controlador.ListarBoletos(txtCodigo.getText());
					} catch (LogicaException | RemoteException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnListar.setBounds(203, 58, 85, 32);
			frmListadoBoletos.getContentPane().add(btnListar);

			JScrollPane scrollPaneBoletos = new JScrollPane();
			scrollPaneBoletos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneBoletos.setBounds(95, 101, 301, 189);
			frmListadoBoletos.getContentPane().add(scrollPaneBoletos);

			tableListadoBoletos = new JTable();
			tableListadoBoletos.setEnabled(false);
			tableListadoBoletos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Numero", "Nombre Pasajero", "Edad", "Celular"
				}
			));
			scrollPaneBoletos.setViewportView(tableListadoBoletos);
			
			JLabel lblCodigo = new JLabel("Codigo");
			lblCodigo.setFont(new Font("Arial", Font.BOLD, 12));
			lblCodigo.setForeground(UIManager.getColor("Button.highlight"));
			lblCodigo.setBounds(20, 49, 117, 14);
			frmListadoBoletos.getContentPane().add(lblCodigo);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(95, 46, 66, 20);
			frmListadoBoletos.getContentPane().add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("Boleto Especial");
			chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
			chckbxNewCheckBox.setBounds(20, 71, 141, 23);
			frmListadoBoletos.getContentPane().add(chckbxNewCheckBox);
		}
		public String getCod() {
		    return txtCodigo.getText();
		}
		/*public String getTipoBoleto() {
		    return txtTipoBoleto.getText();
		}*/
		public void setVisible(boolean visible) {
			frmListadoBoletos.setVisible(visible);
		}

		public void mostrarMensaje (String Mensaje) {
			JOptionPane.showMessageDialog(frmListadoBoletos, Mensaje);
		}
	}
