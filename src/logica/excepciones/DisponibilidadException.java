package logica.excepciones;

public class DisponibilidadException extends Exception {
	private String mensaje;
	public DisponibilidadException(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	public String getMensaje() {
		return mensaje;
	}
}
