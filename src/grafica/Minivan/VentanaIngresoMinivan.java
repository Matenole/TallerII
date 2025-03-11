package grafica.Minivan;
//public void recuperardatos() throws RemoteException, PersistenciaException;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import logica.excepciones.RegistroException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
public class VentanaIngresoMinivan extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtCapacidad;
	private ControladorIngresoMinivan controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngresoMinivan frame = new VentanaIngresoMinivan();
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
	public VentanaIngresoMinivan() {
		setTitle("Ingresar Minivan");
		controlador = new ControladorIngresoMinivan(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 277, 248);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 45, 64, 20);
		contentPane.add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(104, 45, 86, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(10, 73, 64, 20);
		contentPane.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(104, 73, 86, 20);
		contentPane.add(txtMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(10, 104, 54, 14);
		contentPane.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(104, 101, 86, 20);
		contentPane.add(txtModelo);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setBounds(10, 132, 84, 17);
		contentPane.add(lblCapacidad);
		
		txtCapacidad = new JTextField();
		txtCapacidad.setColumns(10);
		txtCapacidad.setBounds(104, 129, 86, 20);
		contentPane.add(txtCapacidad);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String matricula = txtMatricula.getText();
				String marca = txtMarca.getText();
				String modelo = txtModelo.getText();
				int asientos = Integer.valueOf(txtCapacidad.getText());
				try {
					controlador.IngresarMinivan(matricula, marca, modelo, asientos);
				} catch (RegistroException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAceptar.setBounds(10, 175, 86, 23);
		contentPane.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(165, 175, 86, 23);
		contentPane.add(btnVolver);
		
		JLabel lblIngresarMinivan = new JLabel("Ingresar Minivan");
		lblIngresarMinivan.setForeground(new Color(255, 255, 255));
		lblIngresarMinivan.setFont(new Font("Arial", Font.BOLD, 20));
		lblIngresarMinivan.setBounds(52, 11, 157, 23);
		contentPane.add(lblIngresarMinivan);
	
	}

	public void MostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
}