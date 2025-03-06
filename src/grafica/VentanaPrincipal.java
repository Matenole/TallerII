package grafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 380);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(192, 307, 100, 23);
		contentPane.add(btnGuardar);
		
		JButton btnLisBol = new JButton("Listar Boletos");
		btnLisBol.setBounds(10, 71, 125, 23);
		contentPane.add(btnLisBol);
		
		JButton btnVentBol = new JButton("Vender Boleto");
		btnVentBol.setBounds(10, 23, 125, 23);
		contentPane.add(btnVentBol);
		
		JButton btnIngMin = new JButton("Ingresar Minivan");
		btnIngMin.setBounds(349, 23, 125, 23);
		contentPane.add(btnIngMin);
		
		JButton btnListMin = new JButton("Listar Minivans");
		btnListMin.setBounds(349, 71, 125, 23);
		contentPane.add(btnListMin);
		
		JButton btnIngPas = new JButton("Ingresar Paseo");
		btnIngPas.setBounds(179, 23, 125, 23);
		contentPane.add(btnIngPas);
		
		JButton btnMonRec = new JButton("Monto Recaudado");
		btnMonRec.setBounds(179, 71, 125, 23);
		contentPane.add(btnMonRec);
		
		JButton btnMonRec_1 = new JButton("Monto Recaudado");
		btnMonRec_1.setBounds(179, 118, 125, 23);
		contentPane.add(btnMonRec_1);
		
		JButton btnMonRec_1_1 = new JButton("Monto Recaudado");
		btnMonRec_1_1.setBounds(179, 167, 125, 23);
		contentPane.add(btnMonRec_1_1);
		
		JButton btnMonRec_1_1_1 = new JButton("Monto Recaudado");
		btnMonRec_1_1_1.setBounds(179, 216, 125, 23);
		contentPane.add(btnMonRec_1_1_1);
	}
}
