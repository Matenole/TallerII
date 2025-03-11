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
import java.time.format.DateTimeParseException;
import java.util.Properties;
import javax.swing.JOptionPane;

import logica.excepciones.AlfaNumericException;
import logica.excepciones.DestinoException;
import logica.excepciones.HorarioException;
import logica.excepciones.LogicaException;
import logica.excepciones.PrecioException;
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
	
	public void RegistroPaseo(String cod, String des, String HP, String HL, String Prec) throws RegistroExceptionII, DestinoException, AlfaNumericException, PrecioException, HorarioException{
		try {
			if(HP.equals(HL)) {
				v.MostrarMensaje("El horario de salida no puede ser igual al horario de llegada");
				throw new HorarioException("El horario de salida no puede ser igual al horario de llegada");
			}else {
				float pre = Float.parseFloat(Prec);
				
				try {
					DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
			        LocalTime partida = LocalTime.parse(HP, dateTimeFormatter);
			        LocalTime llegada = LocalTime.parse(HL, dateTimeFormatter);
					
					f.RegisPas(cod, des, partida, llegada, pre);
					v.MostrarMensaje("Paseo ingresado correctamente");
				}catch(DateTimeParseException e) {
					v.MostrarMensaje("El formato horario no es el correcto");
					throw new HorarioException("El formato horario no es el correcto");
				}
				
			}
		} catch (LogicaException | RemoteException e) {
			v.MostrarMensaje("Warning: No se pudo establecer conexion\nRevise su conexion al servidor\n" + "\nDetalle: \n" + e.getMessage());
		}
	}
}