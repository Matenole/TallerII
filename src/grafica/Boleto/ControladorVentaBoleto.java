package grafica.Boleto;

import java.rmi.RemoteException;
import logica.excepciones.LogicaException;
import logica.fachada.IFachada;
import logica.negocio.boleto;

public class ControladorVentaBoleto {
	private IFachada f;
	private VentanaVentaBoleto v;
	
	public ControladorVentaBoleto(VentanaVentaBoleto ven) {
		v = ven;
		//f = naming.lookup() Buscar fachada por RMI
	}
	
	public void VentaBoleto(String codigo, int numero, String nombrepasajero, int edad, String celular){
		try {
			boleto boleto = new boleto(numero, nombrepasajero, edad, celular);
			f.VentaBol(codigo, boleto);
			v.MostrarMensaje("Boleto ingresado correctamente");
		} catch (LogicaException | RemoteException e) {
			v.MostrarMensaje(e.getMessage());
		}
	}
	
}
