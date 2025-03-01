package logica.valueobject;

public class VOminivan {
	///Atributos
	private String Matricula;
	private String Marca;
	private String Modelo;
	private int Cantasientos;
	
	///Constructor
	public VOminivan(String matricula, String marca, String modelo, int cantasientos) {
		super();
		Matricula = matricula;
		Marca = marca;
		Modelo = modelo;
		Cantasientos = cantasientos;
	}
	///Getters y Setters
	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public int getCantasientos() {
		return Cantasientos;
	}

	public void setCantasientos(int cantasientos) {
		Cantasientos = cantasientos;
	}


}
