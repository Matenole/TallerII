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

import logica.excepciones.CelularException;
import logica.excepciones.DescuentoException;
import logica.excepciones.EdadException;
import logica.excepciones.LogicaException;
import logica.fachada.IFachada;
import logica.valueobject.VOboletoespecialingreso;
import logica.valueobject.VOboletoingreso;

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
	
	public void VentaBoleto(String codigo,String Nombre, String Edad, String Celular,boolean tienedesc, float desc){
			int edad = Integer.parseInt(Edad);
			try {
				if (tienedesc) {
					VOboletoespecialingreso vo = new VOboletoespecialingreso(Nombre, edad, Celular, desc);
					f.VentaBol(codigo, vo, desc);
				}else {
					VOboletoingreso vo = new VOboletoingreso(Nombre, edad, Celular);
					f.VentaBol(codigo, vo, desc);
				}
				v.MostrarMensaje("Boleto ingresado correctamente");
			} catch (RemoteException e) {
				JOptionPane.showMessageDialog(null, "Warning: No se pudo establecer conexion\nRevise su conexion al servidor\n" + "\nDetalle: \n" + e.getMessage());
				e.printStackTrace();
			} catch (LogicaException e) {
				JOptionPane.showMessageDialog(null, "No hay mas boletos diponibles a la venta en este paseo","Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (DescuentoException e) {
				JOptionPane.showMessageDialog(null, "Por favor, coloque un Descuento valido", "Error al ingresar un Descuento", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (CelularException e) {
				JOptionPane.showMessageDialog(null, "El celular no es valido","Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (EdadException e) {
				JOptionPane.showMessageDialog(null, "La edad no puede ser menor o igual a 0; Ni mayor a 120.","Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
	}
}
