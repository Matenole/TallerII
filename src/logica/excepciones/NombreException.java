package logica.excepciones;

public class NombreException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;

	public NombreException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}
}
