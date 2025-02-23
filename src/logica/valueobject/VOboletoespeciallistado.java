package logica.valueobject;

public class VOboletoespeciallistado extends VOboletoespecialingreso{
	///Atributos
	private int numero;
	
	private float monto;
	///Constructor
	public VOboletoespeciallistado(String nombrepasajero, int edad, String celular, int numero, float monto) {
		super(nombrepasajero, edad, celular);
		this.numero = numero;
		this.monto = monto;
	}
	///Getters y Setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}
				
}
