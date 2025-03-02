package grafica.Paseo;

import java.rmi.RemoteException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import logica.excepciones.LogicaException;
import logica.fachada.IFachada;

public class ControladorRegistroPaseo {
	private IFachada f;
	private VentanaRegistroPaseo v;
	
	public ControladorRegistroPaseo(VentanaRegistroPaseo ven) {
		v = ven;
		//f = naming.lookup() Buscar fachada por RMI
	}
	
	public void VentaBoleto(String cod, String des, String HP, String HL, float Prec, int MaxBol){
		try {
			
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");

	        LocalTime partida = LocalTime.parse(HP, dateTimeFormatter);
	        LocalTime llegada = LocalTime.parse(HL, dateTimeFormatter);
			
			f.RegisPas(cod, des, partida, llegada, Prec, MaxBol);
			v.MostrarMensaje("Paseo ingresado correctamente");
		} catch (LogicaException | RemoteException e) {
			v.MostrarMensaje(e.getMessage());
		}
	}
}
