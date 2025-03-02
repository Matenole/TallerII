package grafica.Paseo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaMontoRecaudadoPaseo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMontoRecaudadoPaseo frame = new VentanaMontoRecaudadoPaseo();
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
	public VentanaMontoRecaudadoPaseo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 10, 45, 13);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(65, 7, 96, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(108, 232, 85, 21);
		contentPane.add(btnAceptar);
	}

	public void MostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}
