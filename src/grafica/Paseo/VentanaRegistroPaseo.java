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

public class VentanaRegistroPaseo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtDestino;
	private JTextField txtHoraPartida;
	private JLabel lblHoraLlegada;
	private JTextField txtHoraLlegada;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblMaxBoletos;
	private JTextField txtMaxBoletos;
	private ControladorRegistroPaseo controlador;

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
		
		controlador = new ControladorRegistroPaseo(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(10, 10, 45, 13);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(84, 7, 96, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDestino = new JTextField();
		txtDestino.setColumns(10);
		txtDestino.setBounds(84, 36, 96, 19);
		contentPane.add(txtDestino);
		
		JLabel lblDestino = new JLabel("Destino:");
		lblDestino.setBounds(10, 39, 45, 13);
		contentPane.add(lblDestino);
		
		txtHoraPartida = new JTextField();
		txtHoraPartida.setText("hh:mm");
		txtHoraPartida.setColumns(10);
		txtHoraPartida.setBounds(84, 65, 96, 19);
		contentPane.add(txtHoraPartida);
		
		JLabel lblHoraPartida = new JLabel("Hora Partida:");
		lblHoraPartida.setBounds(10, 68, 61, 13);
		contentPane.add(lblHoraPartida);
		
		lblHoraLlegada = new JLabel("Hora Llegada:");
		lblHoraLlegada.setBounds(10, 97, 64, 13);
		contentPane.add(lblHoraLlegada);
		
		txtHoraLlegada = new JTextField();
		txtHoraLlegada.setText("hh:mm");
		txtHoraLlegada.setColumns(10);
		txtHoraLlegada.setBounds(84, 94, 96, 19);
		contentPane.add(txtHoraLlegada);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 123, 45, 13);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(84, 120, 96, 19);
		contentPane.add(txtPrecio);
		
		lblMaxBoletos = new JLabel("MaxBoletos:");
		lblMaxBoletos.setBounds(10, 149, 61, 13);
		contentPane.add(lblMaxBoletos);
		
		txtMaxBoletos = new JTextField();
		txtMaxBoletos.setColumns(10);
		txtMaxBoletos.setBounds(84, 146, 96, 19);
		contentPane.add(txtMaxBoletos);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.VentaBoleto(txtCodigo.getText(), txtDestino.getText(), txtHoraPartida.getText(), txtHoraLlegada.getText(), txtPrecio.getText(), txtMaxBoletos.getText());
				} catch (RegistroExceptionII e1) {
					e1.printStackTrace();
				} catch (DestinoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAceptar.setBounds(95, 232, 85, 21);
		contentPane.add(btnAceptar);
	}
	
	public void MostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
