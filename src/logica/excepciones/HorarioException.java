package logica.excepciones;

public class HorarioException  extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public HorarioException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
