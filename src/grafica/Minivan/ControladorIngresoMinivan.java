package grafica.Minivan;

import java.rmi.RemoteException;

import logica.excepciones.LogicaException;
import logica.fachada.IFachada;
import logica.valueobject.VOminivan;

public class ControladorIngresoMinivan {
	private IFachada f;
	private VentanaIngresoMinivan v;
	
	public ControladorIngresoMinivan(VentanaIngresoMinivan ven) {
		v = ven;
		//f = naming.lookup() Buscar fachada por RMI
	}
	
	public void IngresarMinivan(String matricula, String marca, String modelo, int asientos){
		try {
			VOminivan mini = new VOminivan(matricula, marca, modelo, asientos);
			f.RegisMin(mini);
			v.MostrarMensaje("Minivan ingresada correctamente");
		} catch (LogicaException | RemoteException e) {
			v.MostrarMensaje(e.getMessage());
		}
	}
	
}
