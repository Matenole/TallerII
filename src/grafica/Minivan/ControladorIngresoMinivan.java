package grafica.Minivan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;
import javax.swing.JOptionPane;
import logica.excepciones.LogicaException;
import logica.excepciones.RegistroException;
import logica.fachada.IFachada;
import logica.valueobject.VOminivan;

public class ControladorIngresoMinivan implements Serializable{
	private IFachada f;
	private VentanaIngresoMinivan v;
	
	public ControladorIngresoMinivan(VentanaIngresoMinivan ven) {
		v = ven;
		conectarServidor();
	}
	
	private void conectarServidor() {
		try {
			Properties prop = new Properties();
			String nomArch = "config/txt.properties";
			prop.load (new FileInputStream (nomArch));
			String ip = prop.getProperty("ip");
			String puerto = prop.getProperty("puerto");
			f = (IFachada)
					Naming.lookup("//"+ip+":"+puerto+"/fachada");
		} catch (Exception e) {
			mostrarErrorConexion();
			f = null;
		}
	}
		
	private void mostrarErrorConexion() {
			JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con el servidor",
			"Error de Conexión", JOptionPane.ERROR_MESSAGE);
	}
	
	private boolean verificarConexion() {
		if (f == null) {
			conectarServidor();
		}
		return f != null;
	}
	
	public void IngresarMinivan(String matricula, String marca, String modelo, int asientos) throws RegistroException { 
		if (!verificarConexion()) {
		v.MostrarMensaje("Error: No hay conexión con el servidor.");
		return;
	}
		try {
			VOminivan mini = new VOminivan(matricula, marca, modelo, asientos);
			f.RegisMin(mini);
			v.MostrarMensaje("Minivan ingresada correctamente");
		} catch (RemoteException e) {
			v.MostrarMensaje(e.getMessage());
			f = null;
		}
	}

	public boolean estaConectado() {
		return false;
	}
	
}
