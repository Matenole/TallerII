package grafica.Boleto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import grafica.Paseo.ControladorRegistroPaseo;
import logica.excepciones.LogicaException;
import logica.excepciones.RegistroExceptionII;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import java.awt.Font;

public class VentanaVentaBoleto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNumero;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtCelular;
	private ControladorVentaBoleto controlador;
	private JTextField txtDesc;

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
		setTitle("Vender Boleto");
		
		controlador = new ControladorVentaBoleto(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo :");
		lblCodigo.setBounds(10, 84, 62, 13);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(106, 80, 96, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(106, 106, 96, 19);
		contentPane.add(txtNumero);
		
		JLabel lblNumero = new JLabel("Numero :");
		lblNumero.setBounds(10, 110, 62, 13);
		contentPane.add(lblNumero);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(106, 135, 96, 19);
		contentPane.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(10, 139, 62, 13);
		contentPane.add(lblNombre);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(106, 164, 96, 19);
		contentPane.add(txtEdad);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setBounds(10, 168, 62, 13);
		contentPane.add(lblEdad);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(106, 193, 96, 19);
		contentPane.add(txtCelular);
		
		JLabel lblCelular = new JLabel("Celular :");
		lblCelular.setBounds(10, 197, 62, 13);
		contentPane.add(lblCelular);
		
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(106, 249, 96, 19);
		contentPane.add(txtDesc);
		
		JLabel lbldescuento = new JLabel("¿Descuento? :");
		lbldescuento.setBounds(10, 253, 85, 13);
		contentPane.add(lbldescuento);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.VentaBoleto(txtCodigo.getText(), txtNumero.getText(), txtNombre.getText(), txtEdad.getText(), txtCelular.getText());
					txtDesc.getText();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} catch (LogicaException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAceptar.setBounds(10, 329, 85, 21);
		contentPane.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(188, 328, 86, 23);
		contentPane.add(btnVolver);
		
		JCheckBox chcDescuento = new JCheckBox("Tiene descuento");
		chcDescuento.setBounds(10, 222, 192, 19);
		contentPane.add(chcDescuento);
		
		JLabel lblNewLabel = new JLabel("Venta Boleto");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(81, 29, 121, 19);
		contentPane.add(lblNewLabel);

	}

	public void MostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
