package logica.excepciones;
import java.lang.Exception;

public class Excepciones extends Exception {
	
	private String mensaje;
	
	public Excepciones(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String darMensaje() {
		return mensaje;
	}
}