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
import logica.excepciones.MinivanException;
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
	
	public void RegistroPaseo(String cod, String des, String HP, String HL, String Prec){
		try {
			if(HP.equals(HL)) {
				throw new HorarioException("El horario de salida no puede ser igual al horario de llegada");
			}else {
				float pre = Float.parseFloat(Prec);
				
					DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
			        LocalTime partida = LocalTime.parse(HP, dateTimeFormatter);
			        LocalTime llegada = LocalTime.parse(HL, dateTimeFormatter);
					
					f.RegisPas(cod, des, partida, llegada, pre);
					v.MostrarMensaje("Paseo ingresado correctamente");
			}
		} catch (LogicaException | RemoteException e) {
			v.MostrarMensaje("Warning: No se pudo establecer conexion\nRevise su conexion al servidor\n" + "\nDetalle: \n" + e.getMessage());
		}
		catch (RegistroExceptionII e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "El codigo ingresado no existe", "Error en codigo", JOptionPane.ERROR_MESSAGE);
		} catch (DestinoException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "El Destino ingresado es incorrecto", "Error en el campo destino", JOptionPane.ERROR_MESSAGE);
		} catch (AlfaNumericException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "El codigo ingresado posee digitos que no son alfanumericos", "Error en codigo", JOptionPane.ERROR_MESSAGE);
		} catch (PrecioException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "El precio no puede ser menor o igual a 0", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (HorarioException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "El horario ingresado es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch (MinivanException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Actualmente no hay ninguna minivan que pueda realizar el paseo en ese horario", "Error", JOptionPane.ERROR_MESSAGE);
		}
		catch(DateTimeParseException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "El formato horario no es el correcto", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}