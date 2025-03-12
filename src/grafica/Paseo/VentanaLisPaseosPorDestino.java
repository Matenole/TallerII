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

public class VentanaLisPaseosPorDestino extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JFrame frmListadoPaseos;
	private ControladorLisPaseosPorDestino controlador;
	public JTable tableListadoPaseos;
	private JTextField txtDestino;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLisPaseosPorDestino frame = new VentanaLisPaseosPorDestino();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaLisPaseosPorDestino() {
		initialize();
		  controlador = new ControladorLisPaseosPorDestino(this);
		 }

		private void initialize() {
			frmListadoPaseos = new JFrame();
			frmListadoPaseos.getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
			frmListadoPaseos.getContentPane().setBackground(SystemColor.activeCaption);
			frmListadoPaseos.setBackground(SystemColor.inactiveCaption);
			frmListadoPaseos.setTitle("Listar Paseo por Destino");
			frmListadoPaseos.setBounds(100, 100, 602, 391);
			frmListadoPaseos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frmListadoPaseos.setResizable(false);
			frmListadoPaseos.getContentPane().setLayout(null);

			JLabel lblLisPaseos = new JLabel("Listado de Paseos por Destino");
			lblLisPaseos.setHorizontalAlignment(SwingConstants.CENTER);
			lblLisPaseos.setForeground(SystemColor.text);
			lblLisPaseos.setFont(new Font("Arial", Font.BOLD, 20));
			lblLisPaseos.setBounds(43, 23, 499, 24);
			frmListadoPaseos.getContentPane().add(lblLisPaseos);

			JButton btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmListadoPaseos.dispose();
				}
			});
			btnVolver.setBounds(250, 301, 85, 32);
			frmListadoPaseos.getContentPane().add(btnVolver);

			JButton btnListar = new JButton("Listar");
			btnListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controlador.ListarPaseos();
				}
			});
			btnListar.setBounds(250, 58, 85, 32);
			frmListadoPaseos.getContentPane().add(btnListar);

			JScrollPane scrollPanePaseos = new JScrollPane();
			scrollPanePaseos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPanePaseos.setBounds(10, 101, 566, 189);
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
			
			JLabel lblDestino = new JLabel("Destino");
			lblDestino.setFont(new Font("Arial", Font.BOLD, 12));
			lblDestino.setForeground(UIManager.getColor("Button.highlight"));
			lblDestino.setBounds(10, 67, 68, 14);
			frmListadoPaseos.getContentPane().add(lblDestino);
			
			txtDestino = new JTextField();
			txtDestino.setBounds(64, 64, 86, 20);
			frmListadoPaseos.getContentPane().add(txtDestino);
			txtDestino.setColumns(10);
				}
		
		public String getDes() {
		    return txtDestino.getText();
		}
		public void setVisible(boolean visible) {
			frmListadoPaseos.setVisible(visible);
		}
		public void mostrarMensaje (String Mensaje) {
			JOptionPane.showMessageDialog(frmListadoPaseos, Mensaje);
		}

	}
