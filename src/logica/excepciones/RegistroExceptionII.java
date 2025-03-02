package logica.excepciones;

public class RegistroExceptionII extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public RegistroExceptionII(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
