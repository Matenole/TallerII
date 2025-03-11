package logica.excepciones;

public class PrecioException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public PrecioException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
