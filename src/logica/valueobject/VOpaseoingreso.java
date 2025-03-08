package logica.valueobject;
import java.io.Serializable;
import java.time.*;

public class VOpaseoingreso implements Serializable{
	///Atributos
	private String Codigo;
	
	private String Destino;
	
	private LocalTime Horasalida;
	
	private LocalTime Horallegada;
	
	private float precio;
	
	///Constructor
	public VOpaseoingreso(String codigo, String destino, LocalTime horasalida, LocalTime horallegada, float precio) {
		super();
		Codigo = codigo;
		Destino = destino;
		Horasalida = horasalida;
		Horallegada = horallegada;
		this.precio = precio;
	}
	///Getter y Setters
	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	public LocalTime getHorasalida() {
		return Horasalida;
	}

	public void setHorasalida(LocalTime horasalida) {
		Horasalida = horasalida;
	}

	public LocalTime getHorallegada() {
		return Horallegada;
	}

	public void setHorallegada(LocalTime horallegada) {
		Horallegada = horallegada;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
