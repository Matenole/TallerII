package grafica.Boleto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaVentaBoleto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNumero;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtCelular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVentaBoleto frame = new VentanaVentaBoleto();
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
	public VentanaVentaBoleto() {
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
		txtCodigo.setBounds(100, 7, 96, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(100, 33, 96, 19);
		contentPane.add(txtNumero);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 36, 45, 13);
		contentPane.add(lblNumero);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(100, 62, 96, 19);
		contentPane.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 65, 45, 13);
		contentPane.add(lblNombre);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(100, 91, 96, 19);
		contentPane.add(txtEdad);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 94, 45, 13);
		contentPane.add(lblEdad);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(100, 120, 96, 19);
		contentPane.add(txtCelular);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 123, 45, 13);
		contentPane.add(lblCelular);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(111, 232, 85, 21);
		contentPane.add(btnAceptar);
	}

	public void MostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

}
