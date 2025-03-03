package logica.excepciones;

public class DescuentoException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public DescuentoException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
