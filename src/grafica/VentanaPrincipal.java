package grafica;

import java.awt.EventQueue;
import grafica.Paseo.*;
import grafica.Minivan.*;
import grafica.Boleto.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.excepciones.PersistenciaException;
import logica.fachada.*;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

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
		btnGuardar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	Fachada fachada = null;
				try {
					fachada = new Fachada();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				try {
					fachada.respaldardatos();
				} catch (RemoteException | PersistenciaException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnLisBol = new JButton("Listar Boletos");
		btnLisBol.setBounds(10, 71, 125, 23);
		contentPane.add(btnLisBol);
		
		btnLisBol.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaLisBoletosVendidosPorPaseo ventana = new VentanaLisBoletosVendidosPorPaseo();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnVentBol = new JButton("Vender Boleto");
		btnVentBol.setBounds(10, 23, 125, 23);
		contentPane.add(btnVentBol);
		
		btnVentBol.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaVentaBoleto ventana = new VentanaVentaBoleto();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnIngMin = new JButton("Ingresar Minivan");
		btnIngMin.setBounds(349, 23, 125, 23);
		contentPane.add(btnIngMin);
		
		btnIngMin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        VentanaIngresoMinivan ventana = new VentanaIngresoMinivan();
		        ventana.setVisible(true);
		    }
		});
		
		
		JButton btnListMin = new JButton("Listar Minivans");
		btnListMin.setBounds(349, 71, 125, 23);
		contentPane.add(btnListMin);
		
		btnListMin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaLisMinivans ventana = new VentanaLisMinivans();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnIngPas = new JButton("Ingresar Paseo");
		btnIngPas.setBounds(179, 23, 125, 23);
		contentPane.add(btnIngPas);
		
		btnIngPas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaRegistroPaseo ventana = new VentanaRegistroPaseo();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnMonRec = new JButton("Monto Recaudado");
		btnMonRec.setBounds(179, 71, 125, 23);
		contentPane.add(btnMonRec);
		
		btnMonRec.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaMontoRecaudadoPaseo ventana = new VentanaMontoRecaudadoPaseo();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnLisPasMin = new JButton("Listar Paseo por Minivan");
		btnLisPasMin.setBounds(164, 118, 155, 23);
		contentPane.add(btnLisPasMin);
		
		btnLisPasMin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaLisPaseosAsigMinivan ventana = new VentanaLisPaseosAsigMinivan();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnLisPasDes = new JButton("Listar Paseo por Destino");
		btnLisPasDes.setBounds(164, 164, 155, 23);
		contentPane.add(btnLisPasDes);
		
		btnLisPasDes.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaLisPaseosPorDestino ventana = new VentanaLisPaseosPorDestino();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnLisPasBol = new JButton("Listar Paseo por Boletos");
		btnLisPasBol.setBounds(164, 212, 155, 23);
		contentPane.add(btnLisPasBol);
		
		btnLisPasBol.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaLisPaseosPorDispBoletos ventana = new VentanaLisPaseosPorDispBoletos();
		        ventana.setVisible(true);
		    }
		});
	}
}
