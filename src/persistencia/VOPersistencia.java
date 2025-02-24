package persistencia;
import java.io.Serializable;
import logica.colecciones.*;

public class VOPersistencia implements Serializable{
	///Atributos
	private Minivans mini;
	private Paseos pas;
	///Constructor
	public VOPersistencia(Minivans mini, Paseos pas) {
		super();
		this.mini = mini;
		this.pas = pas;
	}
	///Getters y Setters
	public Minivans getMini() {
		return mini;
	}
	public void setMini(Minivans mini) {
		this.mini = mini;
	}
	public Paseos getPas() {
		return pas;
	}
	public void setPas(Paseos pas) {
		this.pas = pas;
	}

	
}
