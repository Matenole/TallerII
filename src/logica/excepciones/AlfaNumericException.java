package logica.excepciones;

public class AlfaNumericException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public AlfaNumericException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
