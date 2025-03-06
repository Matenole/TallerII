package grafica.Boleto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;
import javax.swing.JOptionPane;
import logica.excepciones.LogicaException;
import logica.fachada.IFachada;
import logica.negocio.boleto;

public class ControladorVentaBoleto {
	private IFachada f;
	private VentanaVentaBoleto v;
	
	public ControladorVentaBoleto(VentanaVentaBoleto ven) {
		v = ven;
		try {

			Properties prop = new Properties();
			String nomArch = "config/txt.properties";
			prop.load (new FileInputStream (nomArch));
			String ip = prop.getProperty("ip");
			String puerto = prop.getProperty("puerto");
			f = (IFachada)
			Naming.lookup("//"+ip+":"+puerto+"/fachada");

		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo establecer conexion");
			e.printStackTrace();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, "No se pudo establecer conexion");
			e.printStackTrace();
		} catch (NotBoundException e) {
			JOptionPane.showMessageDialog(null, "No se pudo establecer conexion");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void VentaBoleto(String codigo, String numero, String nombrepasajero, String edad, String celular) throws RemoteException, LogicaException{
			int num = Integer.parseInt(numero);
			int age = Integer.parseInt(edad);
			boleto boleto = new boleto(num, nombrepasajero, age, celular);
			f.VentaBol(codigo, boleto);
			v.MostrarMensaje("Boleto ingresado correctamente");
	}
	
}
