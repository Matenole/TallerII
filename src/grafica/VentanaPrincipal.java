package grafica;
import java.awt.EventQueue;
import javax.swing.*;
import grafica.Boleto.VentanaLisBoletosVendidosPorPaseo;
import grafica.Boleto.VentanaVentaBoleto;
import grafica.Minivan.VentanaIngresoMinivan;
import grafica.Minivan.VentanaLisMinivans;
import grafica.Paseo.VentanaLisPaseosAsigMinivan;
import grafica.Paseo.VentanaLisPaseosPorDestino;
import grafica.Paseo.VentanaLisPaseosPorDispBoletos;
import grafica.Paseo.VentanaMontoRecaudadoPaseo;
import grafica.Paseo.VentanaRegistroPaseo;
import logica.excepciones.PersistenciaException;
import logica.fachada.Fachada;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextPane txtenQuePodemos;
    private ControladorPrincipal controlador;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VentanaPrincipal frame = new VentanaPrincipal();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public VentanaPrincipal() {
    	controlador = new ControladorPrincipal(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 752, 482);
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icono = new ImageIcon("Paseos del sol.png");

        Image imagenEscalada = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        JLabel etiquetaImagen = new JLabel(iconoEscalado);
        etiquetaImagen.setBounds(597, 312, 150, 141);

        contentPane.add(etiquetaImagen);

        JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(318, 401, 100, 23);
		contentPane.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	controlador.Respaldar();
		    }
		});
		
		JButton btnLisBol = new JButton("Listar Boletos");
		btnLisBol.setBounds(576, 126, 150, 23);
		contentPane.add(btnLisBol);
		
		btnLisBol.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaLisBoletosVendidosPorPaseo ventana = new VentanaLisBoletosVendidosPorPaseo();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnVentBol = new JButton("Vender Boleto");
		btnVentBol.setBounds(576, 92, 150, 23);
		contentPane.add(btnVentBol);
		
		btnVentBol.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaVentaBoleto ventana = new VentanaVentaBoleto();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnIngMin = new JButton("Ingresar Minivan");
		btnIngMin.setBounds(10, 92, 150, 23);
		contentPane.add(btnIngMin);
		
		btnIngMin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        VentanaIngresoMinivan ventana = new VentanaIngresoMinivan();
		        ventana.setVisible(true);
		    }
		});
		
		
		JButton btnListMin = new JButton("Listar Minivans");
		btnListMin.setBounds(10, 126, 150, 23);
		contentPane.add(btnListMin);
		
		btnListMin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaLisMinivans ventana = new VentanaLisMinivans();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnIngPas = new JButton("Ingresar Paseo");
		btnIngPas.setBounds(293, 92, 150, 23);
		contentPane.add(btnIngPas);
		
		btnIngPas.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaRegistroPaseo ventana = new VentanaRegistroPaseo();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnMonRec = new JButton("Monto Recaudado");
		btnMonRec.setBounds(293, 126, 150, 23);
		contentPane.add(btnMonRec);
		
		btnMonRec.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaMontoRecaudadoPaseo ventana = new VentanaMontoRecaudadoPaseo();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnLisPasMin = new JButton("Listar Paseo por Minivan");
		btnLisPasMin.setBounds(251, 160, 233, 23);
		contentPane.add(btnLisPasMin);
		
		btnLisPasMin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaLisPaseosAsigMinivan ventana = new VentanaLisPaseosAsigMinivan();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnLisPasDes = new JButton("Listar Paseo por Destino");
		btnLisPasDes.setBounds(251, 194, 233, 23);
		contentPane.add(btnLisPasDes);
		
		btnLisPasDes.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	VentanaLisPaseosPorDestino ventana = new VentanaLisPaseosPorDestino();
		        ventana.setVisible(true);
		    }
		});
		
		JButton btnLisDisBol = new JButton("Listar Paseo por Disponibilidad");
	    btnLisDisBol.setBounds(251, 228, 233, 23);
	    contentPane.add(btnLisDisBol);
	    btnLisDisBol.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		VentanaLisPaseosPorDispBoletos ventana = new VentanaLisPaseosPorDispBoletos();
			        ventana.setVisible(true);
	        	}
	        });
	    
	      
			
		txtenQuePodemos = new JTextPane();
        txtenQuePodemos.setEditable(false);
        txtenQuePodemos.setText("¿En que podemos ayudarte?");
        txtenQuePodemos.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        txtenQuePodemos.setBackground(SystemColor.activeCaption);
        txtenQuePodemos.setBounds(201, 45, 334, 36);
        contentPane.add(txtenQuePodemos);
        
        JTextPane txtpnBienvenidoAPaseos = new JTextPane();
        txtpnBienvenidoAPaseos.setText("Bienvenido a Paseos Del Sol S.A");
        txtpnBienvenidoAPaseos.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
        txtpnBienvenidoAPaseos.setEditable(false);
        txtpnBienvenidoAPaseos.setBackground(SystemColor.activeCaption);
        txtpnBienvenidoAPaseos.setBounds(177, 11, 382, 36);
        contentPane.add(txtpnBienvenidoAPaseos);
        
        JTextPane txtpnNicolasCarreras = new JTextPane();
        txtpnNicolasCarreras.setText("Nicolas Carreras");
        txtpnNicolasCarreras.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        txtpnNicolasCarreras.setEditable(false);
        txtpnNicolasCarreras.setBackground(SystemColor.activeCaption);
        txtpnNicolasCarreras.setBounds(0, 371, 72, 25);
        contentPane.add(txtpnNicolasCarreras);
        
        JTextPane txtpnMateoMendiondo = new JTextPane();
        txtpnMateoMendiondo.setText("Mateo Mendiondo");
        txtpnMateoMendiondo.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        txtpnMateoMendiondo.setEditable(false);
        txtpnMateoMendiondo.setBackground(SystemColor.activeCaption);
        txtpnMateoMendiondo.setBounds(0, 418, 94, 25);
        contentPane.add(txtpnMateoMendiondo);
        
        JTextPane txtpnFabricioMedero = new JTextPane();
        txtpnFabricioMedero.setText("Fabricio Medero");
        txtpnFabricioMedero.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        txtpnFabricioMedero.setEditable(false);
        txtpnFabricioMedero.setBackground(SystemColor.activeCaption);
        txtpnFabricioMedero.setBounds(0, 395, 94, 25);
        contentPane.add(txtpnFabricioMedero);
        
      
    }
}