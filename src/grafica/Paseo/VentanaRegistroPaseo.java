package grafica.Paseo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.excepciones.DestinoException;
import logica.excepciones.RegistroExceptionII;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class VentanaRegistroPaseo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtDestino;
	private JTextField txtHoraPartida;
	private JLabel lblHoraLlegada;
	private JTextField txtHoraLlegada;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private ControladorRegistroPaseo controlador;
	private JLabel lblIngresarPaseo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistroPaseo frame = new VentanaRegistroPaseo();
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
	public VentanaRegistroPaseo() {
		setTitle("Ingresar Paseo");
		
		controlador = new ControladorRegistroPaseo(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 58, 56, 13);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(118, 52, 96, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDestino = new JTextField();
		txtDestino.setColumns(10);
		txtDestino.setBounds(118, 81, 96, 19);
		contentPane.add(txtDestino);
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setBounds(10, 87, 56, 13);
		contentPane.add(lblDestino);
		
		txtHoraPartida = new JTextField();
		txtHoraPartida.setText("hh:mm");
		txtHoraPartida.setColumns(10);
		txtHoraPartida.setBounds(118, 110, 96, 19);
		contentPane.add(txtHoraPartida);
		
		JLabel lblHoraPartida = new JLabel("Hora Partida:");
		lblHoraPartida.setBounds(10, 116, 85, 13);
		contentPane.add(lblHoraPartida);
		
		lblHoraLlegada = new JLabel("Hora Llegada:");
		lblHoraLlegada.setBounds(10, 145, 85, 13);
		contentPane.add(lblHoraLlegada);
		
		txtHoraLlegada = new JTextField();
		txtHoraLlegada.setText("hh:mm");
		txtHoraLlegada.setColumns(10);
		txtHoraLlegada.setBounds(118, 139, 96, 19);
		contentPane.add(txtHoraLlegada);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 171, 56, 13);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(118, 165, 96, 19);
		contentPane.add(txtPrecio);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.RegistroPaseo(txtCodigo.getText(), txtDestino.getText(), txtHoraPartida.getText(), txtHoraLlegada.getText(), txtPrecio.getText());
				} catch (RegistroExceptionII e1) {
					e1.printStackTrace();
				} catch (DestinoException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAceptar.setBounds(10, 228, 85, 21);
		contentPane.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(188, 227, 86, 23);
		contentPane.add(btnVolver);
		
		lblIngresarPaseo = new JLabel("Ingresar Paseo");
		lblIngresarPaseo.setForeground(new Color(255, 255, 255));
		lblIngresarPaseo.setFont(new Font("Arial", Font.BOLD, 20));
		lblIngresarPaseo.setBounds(70, 20, 144, 24);
		contentPane.add(lblIngresarPaseo);
	}
	
	public void MostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
