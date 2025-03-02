package grafica.Paseo;

import logica.fachada.IFachada;
import java.rmi.RemoteException;;

public class ControladorMontoRecaudadoPaseo {
	private IFachada f;
private VentanaMontoRecaudadoPaseo v;
	
	public ControladorMontoRecaudadoPaseo(VentanaMontoRecaudadoPaseo ven) {
		v = ven;
		//f = naming.lookup() Buscar fachada por RMI
	}
	
	public void VentaBoleto(String codigo){
		try {
			String monto = Float.toString(f.MonRec(codigo));
			v.MostrarMensaje("Monto recaudado: " + monto);
		} catch (RemoteException e) {
			v.MostrarMensaje(e.getMessage());
		}
	}
}
