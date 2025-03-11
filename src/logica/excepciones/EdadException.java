package logica.excepciones;

public class EdadException extends Exception {

	private static final long serialVersionUID = 1L;
	private String mensaje;
	public EdadException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
