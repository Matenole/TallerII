package grafica.Minivan;

import logica.excepciones.LogicaException;
import logica.excepciones.PersistenciaException;
import logica.fachada.IFachada;
import logica.valueobject.VOminivanlistado;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorLisMinivans {
	private IFachada f;
	private VentanaLisMinivans VLM;
	
	public ControladorLisMinivans(VentanaLisMinivans ven) {
		VLM = ven;
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
	
	public void ListarMinivans() {
		try {
			DefaultTableModel dm = (DefaultTableModel) VLM.tableListadoMinivans.getModel();
			while (VLM.tableListadoMinivans.getRowCount() != 0)
				dm.removeRow(VLM.tableListadoMinivans.getRowCount() - 1);
			List<VOminivanlistado> Minivan = f.LisMin();
			if (Minivan.isEmpty()) {
				VLM.mostrarMensaje("No hay ninguna Minivan registrada");
			} else {
				for (int i = 0; i < Minivan.size(); i++) {
					dm.addRow(new Object[] { Minivan.get(i).getMatricula(), Minivan.get(i).getMarca(),
							Minivan.get(i).getModelo(), Minivan.get(i).getCantasientos(), Minivan.get(i).getCantpaseosasignados() });
				}
			}
		} catch (RemoteException e) {
			VLM.mostrarMensaje("Error");
		} catch (PersistenciaException e) {
			VLM.mostrarMensaje(e.getMensaje());
		}

	}

}



