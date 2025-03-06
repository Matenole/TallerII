package logica.excepciones;

public class DestinoException extends Exception{
	private String mensaje;
	public DestinoException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
