package grafica.Paseo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import javax.swing.JOptionPane;

import logica.excepciones.DestinoException;
import logica.excepciones.LogicaException;
import logica.excepciones.RegistroExceptionII;
import logica.fachada.IFachada;

public class ControladorRegistroPaseo {
	private IFachada f;
	private VentanaRegistroPaseo v;
	
	public ControladorRegistroPaseo(VentanaRegistroPaseo ven) {
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
	
	public void VentaBoleto(String cod, String des, String HP, String HL, String Prec, String MaxBol) throws RegistroExceptionII, DestinoException{
		try {
			
			int maxb = Integer.parseInt(MaxBol);
			float pre = Float.parseFloat(Prec);
			
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	        LocalTime partida = LocalTime.parse(HP, dateTimeFormatter);
	        LocalTime llegada = LocalTime.parse(HL, dateTimeFormatter);
			
			f.RegisPas(cod, des, partida, llegada, pre, maxb);
			v.MostrarMensaje("Paseo ingresado correctamente");
		} catch (LogicaException | RemoteException e) {
			v.MostrarMensaje(e.getMessage());
		}
	}
}
