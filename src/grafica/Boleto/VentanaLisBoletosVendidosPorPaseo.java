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
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import grafica.Boleto.ControladorLisBoletosVendidosPorPaseo;
import logica.excepciones.LogicaException;

import java.awt.Color;

public class VentanaLisBoletosVendidosPorPaseo extends JFrame {
	
	private JFrame frmListadoBoletos;
	private ControladorLisBoletosVendidosPorPaseo controlador;
	public JTable tableListadoBoletos;
	private JTextField txtCodigo;
	private JTextField txtTipoBoleto;

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
			frmListadoBoletos.setTitle("Listado de Boletos");
			frmListadoBoletos.setBounds(100, 100, 507, 391);
			frmListadoBoletos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frmListadoBoletos.getContentPane().setLayout(null);

			JLabel lblLisBoletos = new JLabel("Listado de Boletos");
			lblLisBoletos.setHorizontalAlignment(SwingConstants.CENTER);
			lblLisBoletos.setForeground(SystemColor.text);
			lblLisBoletos.setFont(new Font("Arial", Font.BOLD, 20));
			lblLisBoletos.setBounds(0, 11, 499, 24);
			frmListadoBoletos.getContentPane().add(lblLisBoletos);

			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmListadoBoletos.dispose();
				}
			});
			btnVolver.setBounds(210, 301, 85, 32);
			frmListadoBoletos.getContentPane().add(btnVolver);

			JButton btnListar = new JButton("Listar");
			btnListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						controlador.ListarBoletos(txtCodigo.getText());
					} catch (LogicaException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnListar.setBounds(210, 58, 85, 32);
			frmListadoBoletos.getContentPane().add(btnListar);

			JScrollPane scrollPaneBoletos = new JScrollPane();
			scrollPaneBoletos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneBoletos.setBounds(99, 101, 301, 189);
			frmListadoBoletos.getContentPane().add(scrollPaneBoletos);

			tableListadoBoletos = new JTable();
			scrollPaneBoletos.setViewportView(tableListadoBoletos);
			tableListadoBoletos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Numero", "Nombre pasajero", "Edad", "Celular"
				}
			));
			tableListadoBoletos.getColumnModel().getColumn(0).setPreferredWidth(100);
			tableListadoBoletos.getColumnModel().getColumn(1).setPreferredWidth(100);
			tableListadoBoletos.getColumnModel().getColumn(2).setPreferredWidth(100);
			tableListadoBoletos.getColumnModel().getColumn(3).setPreferredWidth(80);
			scrollPaneBoletos.setViewportView(tableListadoBoletos.getTableHeader());
			
			JLabel lblCodigo = new JLabel("Codigo");
			lblCodigo.setFont(new Font("Arial", Font.BOLD, 12));
			lblCodigo.setForeground(UIManager.getColor("Button.highlight"));
			lblCodigo.setBounds(10, 40, 117, 14);
			frmListadoBoletos.getContentPane().add(lblCodigo);
			
			txtCodigo = new JTextField();
			txtCodigo.setBounds(82, 37, 66, 20);
			frmListadoBoletos.getContentPane().add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblTipoBoleto = new JLabel("Tipo Boleto");
			lblTipoBoleto.setFont(new Font("Arial", Font.BOLD, 12));
			lblTipoBoleto.setForeground(UIManager.getColor("Button.highlight"));
			lblTipoBoleto.setBounds(10, 76, 117, 14);
			frmListadoBoletos.getContentPane().add(lblTipoBoleto);
			
			txtTipoBoleto = new JTextField();
			txtTipoBoleto.setBounds(82, 70, 66, 20);
			frmListadoBoletos.getContentPane().add(txtTipoBoleto);
			txtTipoBoleto.setColumns(10);
		}
		public void setVisible(boolean visible) {
			frmListadoBoletos.setVisible(visible);
		}

		public void mostrarMensaje (String Mensaje) {
			JOptionPane.showMessageDialog(frmListadoBoletos, Mensaje);
		}

	}
