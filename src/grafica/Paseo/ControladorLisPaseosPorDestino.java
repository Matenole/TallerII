package grafica.Paseo;

import logica.excepciones.LogicaException;
import logica.excepciones.PersistenciaException;
import logica.fachada.IFachada;
import logica.valueobject.VOpaseolistado;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorLisPaseosPorDestino {
	private IFachada f;
	private VentanaLisPaseosPorDestino VLPD;
	
	public ControladorLisPaseosPorDestino(VentanaLisPaseosPorDestino ven) {
		VLPD = ven;
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
	
	public void ListarPaseos() {
		try {
			DefaultTableModel dm = (DefaultTableModel) VLPD.tableListadoPaseos.getModel();
			while (VLPD.tableListadoPaseos.getRowCount() != 0)
				dm.removeRow(VLPD.tableListadoPaseos.getRowCount() - 1);
			ArrayList<VOpaseolistado> Paseo = f.LisPasDes(null);
			if (Paseo.isEmpty()) {
				VLPD.mostrarMensaje("No hay ningun Paseo registrado");
			} else {
				for (int i = 0; i < Paseo.size(); i++) {
					dm.addRow(new Object[] { Paseo.get(i).getCodigo(), Paseo.get(i).getDestino(), Paseo.get(i).getHorasalida(), 
							Paseo.get(i).getHorallegada(), Paseo.get(i).getPrecio(), Paseo.get(i).getMaxboletos(), Paseo.get(i).cantBoletosDisponibles(i)});
				}
			}
		} catch (RemoteException e) {
			VLPD.mostrarMensaje("Error");
		} catch (PersistenciaException e) {
			VLPD.mostrarMensaje(e.getMensaje());
		}

	}

}
