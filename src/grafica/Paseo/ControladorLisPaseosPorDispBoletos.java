package grafica.Paseo;

import logica.excepciones.DisponibilidadException;
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

public class ControladorLisPaseosPorDispBoletos {
	private IFachada f;
	private VentanaLisPaseosPorDispBoletos VLPDB;
	
	public ControladorLisPaseosPorDispBoletos(VentanaLisPaseosPorDispBoletos ven) {
		VLPDB = ven;
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
	
	public void ListarPaseos() throws DisponibilidadException {
		try {
			String BolDisp = VLPDB.getBolDisp();
	        if (BolDisp.isEmpty()) {
	            VLPDB.mostrarMensaje("Ingrese una cantidad de Boletos Disponibles para listar paseos.");
	            return;
	        }
	        DefaultTableModel dm = (DefaultTableModel) VLPDB.tableListadoPaseos.getModel();
			while (VLPDB.tableListadoPaseos.getRowCount() != 0)
				dm.removeRow(VLPDB.tableListadoPaseos.getRowCount() - 1);
			ArrayList<VOpaseolistado> Paseo = f.LisDisBol(Integer.parseInt(BolDisp));
			if (Paseo.isEmpty()) {
				VLPDB.mostrarMensaje("No hay ningun Paseo registrado");
			} else {
				for (int i = 0; i < Paseo.size(); i++) {
					dm.addRow(new Object[] { Paseo.get(i).getCodigo(), Paseo.get(i).getDestino(), Paseo.get(i).getHorasalida(), 
							Paseo.get(i).getHorallegada(), Paseo.get(i).getPrecio(), Paseo.get(i).getMaxboletos(), Paseo.get(i).cantBoletosDisponibles()});
				}
			}
		} catch (RemoteException e) {
			VLPDB.mostrarMensaje("Error");
		}

	}

}
