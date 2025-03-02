package logica.excepciones;

public class RegistroException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public RegistroException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
