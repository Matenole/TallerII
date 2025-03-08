package grafica.Paseo;

import logica.fachada.IFachada;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;
import javax.swing.JOptionPane;;

public class ControladorMontoRecaudadoPaseo {
	private IFachada f;
	private VentanaMontoRecaudadoPaseo v;
	
	public ControladorMontoRecaudadoPaseo(VentanaMontoRecaudadoPaseo ven) {
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
	
	public void Monto(String codigo){
		try {
			String monto = Float.toString(f.MonRec(codigo));
			v.MostrarMensaje("Monto recaudado: " + monto);
		} catch (RemoteException e) {
			v.MostrarMensaje("Warning: No se pudo establecer conexion\nRevise su conexion al servidor\n" + "\nDetalle: \n" + e.getMessage());
		}
	}
}
