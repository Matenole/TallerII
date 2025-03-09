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

import logica.excepciones.DescuentoException;
import logica.excepciones.LogicaException;
import logica.fachada.IFachada;
import logica.negocio.boleto;

public class ControladorVentaBoleto<VOboletoingreso> {
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
	
	public void VentaBoleto(String codigo,VOboletoingreso vo) throws RemoteException, LogicaException, DescuentoException{
			int num = Integer.parseInt(vo.g);
			int age = Integer.parseInt(edad);
			VOboletoingreso vobl = new VOboletoingreso(num, nombrepasajero, age, celular);
			f.VentaBol(codigo,(logica.valueobject.VOboletoingreso) vobl);
			v.MostrarMensaje("Boleto ingresado correctamente");
	}
	
}
