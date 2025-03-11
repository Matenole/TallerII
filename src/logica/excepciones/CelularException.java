package logica.excepciones;

public class CelularException extends Exception {

	private static final long serialVersionUID = 1L;
	private String mensaje;
	public CelularException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
