package grafica.Boleto;

import logica.excepciones.LogicaException;
import logica.fachada.IFachada;
import logica.valueobject.VOboletoespeciallistado;
import logica.valueobject.VOboletolistado;
import java.util.ArrayList;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import javax.swing.table.DefaultTableModel;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;

public class ControladorLisBoletosVendidosPorPaseo {
	private IFachada f;
	private VentanaLisBoletosVendidosPorPaseo VLBV;
	
	public ControladorLisBoletosVendidosPorPaseo(VentanaLisBoletosVendidosPorPaseo ven) {
		VLBV = ven;
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
		
	public void ListarBoletos(String codigo) throws LogicaException, RemoteException {
		
		if (codigo.isEmpty()) {
		    VLBV.mostrarMensaje("Ingrese un codigo para listar paseos.");
		}
		DefaultTableModel dm = (DefaultTableModel) VLBV.tableListadoBoletos.getModel();
		while (VLBV.tableListadoBoletos.getRowCount() != 0)
			dm.removeRow(VLBV.tableListadoBoletos.getRowCount() - 1);
		
		if (VLBV.getTipoBoleto()) {
			ArrayList<VOboletoespeciallistado> Boleto = f.LisBolVenEsp(codigo);
			if (Boleto.isEmpty()) {
				VLBV.mostrarMensaje("No hay ningun Boleto registrado");
			} else {
				for (int i = 0; i < Boleto.size(); i++) {
					dm.addRow(new Object[] { Boleto.get(i).getNumero(), Boleto.get(i).getNombrepasajero(),
							Boleto.get(i).getEdad(), Boleto.get(i).getCelular(), Boleto.get(i).getDescuento()});
				}
			}			
		}else {
			ArrayList<VOboletolistado> Boleto = f.LisBolVen(codigo);
			if (Boleto.isEmpty()) {
				VLBV.mostrarMensaje("No hay ningun Boleto registrado");
			} else {
				for (int i = 0; i < Boleto.size(); i++) {
					dm.addRow(new Object[] { Boleto.get(i).getNumero(), Boleto.get(i).getNombrepasajero(),
							Boleto.get(i).getEdad(), Boleto.get(i).getCelular(), "0"});
				}
			}
		}
	}

}



