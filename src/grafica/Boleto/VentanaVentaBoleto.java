package grafica.Boleto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logica.excepciones.DescuentoException;
import logica.excepciones.LogicaException;

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

@SuppressWarnings("serial")
public class VentanaVentaBoleto extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtCelular;
	private ControladorVentaBoleto controlador;
	private JTextField txtDesc;
	private JCheckBox chcDescuento;

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
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(106, 108, 96, 19);
		contentPane.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setBounds(10, 112, 62, 13);
		contentPane.add(lblNombre);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(106, 137, 96, 19);
		contentPane.add(txtEdad);
		
		JLabel lblEdad = new JLabel("Edad :");
		lblEdad.setBounds(10, 141, 62, 13);
		contentPane.add(lblEdad);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(106, 166, 96, 19);
		contentPane.add(txtCelular);
		
		JLabel lblCelular = new JLabel("Celular :");
		lblCelular.setBounds(10, 170, 62, 13);
		contentPane.add(lblCelular);
		
		
		txtDesc = new JTextField();
		txtDesc.setEditable(false);
		txtDesc.setEnabled(false);
		txtDesc.setColumns(10);
		txtDesc.setBounds(106, 222, 96, 19);
		contentPane.add(txtDesc);
		txtDesc.setVisible(false);
		
		JLabel lbldescuento = new JLabel("¿Descuento? :");
		lbldescuento.setEnabled(false);
		lbldescuento.setBounds(10, 226, 85, 13);
		contentPane.add(lbldescuento);
		lbldescuento.setVisible(false);
			
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (chcDescuento.isSelected()) {
						float desc = Float.parseFloat(txtDesc.getText());
						controlador.VentaBoleto(txtCodigo.getText(), txtNombre.getText(), txtEdad.getText(), txtCelular.getText(), chcDescuento.isSelected() , desc);
					}
					else
					{
						controlador.VentaBoleto(txtCodigo.getText(), txtNombre.getText(), txtEdad.getText(), txtCelular.getText(), chcDescuento.isSelected(),0);
					}
				} catch (DescuentoException e1) {
					e1.printStackTrace();
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
		
		chcDescuento = new JCheckBox("Tiene descuento");
		chcDescuento.setBackground(SystemColor.activeCaption);
		chcDescuento.setBounds(10, 195, 192, 19);
		contentPane.add(chcDescuento);
		chcDescuento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(chcDescuento.isSelected()) {
        		lbldescuento.setVisible(true);
        		txtDesc.setVisible(true);
        		lbldescuento.setEnabled(true);
        		txtDesc.setEnabled(true);
        		txtDesc.setEditable(true);
               }else {
            	    lbldescuento.setVisible(false);
           			txtDesc.setVisible(false);
           			lbldescuento.setEnabled(false);
           			txtDesc.setEnabled(false);
           			txtDesc.setEditable(false);
               }
            	   
            }
        });

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
