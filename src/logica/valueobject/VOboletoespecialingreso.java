package logica.valueobject;

public class VOboletoespecialingreso {

	private String nombrepasajero;
	
	private int edad;
	
	private String celular;

	public VOboletoespecialingreso(String nombrepasajero, int edad, String celular) {
		super();
		this.nombrepasajero = nombrepasajero;
		this.edad = edad;
		this.celular = celular;
	}

	public String getNombrepasajero() {
		return nombrepasajero;
	}

	public void setNombrepasajero(String nombrepasajero) {
		this.nombrepasajero = nombrepasajero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
