package logica.excepciones;

public class MinivanException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensaje;
	public MinivanException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
