package grafica.Paseo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaMontoRecaudadoPaseo extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JLabel lblResultado;
	private ControladorMontoRecaudadoPaseo controlador;

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
		setTitle("Monto Recaudado");
		
		controlador = new ControladorMontoRecaudadoPaseo(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 250);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(56, 82, 45, 17);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(132, 80, 96, 19);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.Monto(txtCodigo.getText());
			}
		});
		btnAceptar.setBounds(10, 179, 85, 21);
		contentPane.add(btnAceptar);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(188, 178, 86, 23);
		contentPane.add(btnVolver);
		
		JLabel lblMontoRecaudado = new JLabel("Monto Recaudado");
		lblMontoRecaudado.setForeground(new Color(255, 255, 255));
		lblMontoRecaudado.setFont(new Font("Arial", Font.BOLD, 20));
		lblMontoRecaudado.setBounds(56, 27, 172, 19);
		contentPane.add(lblMontoRecaudado);
		
		lblResultado = new JLabel("");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblResultado.setForeground(new Color(255, 255, 255));
		lblResultado.setBounds(0, 121, 284, 28);
		contentPane.add(lblResultado);
	}

	public void MostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void MostrarResu (String m) {
		lblResultado.setText(m);
	}
}
