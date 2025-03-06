package logica.valueobject;

import java.io.Serializable;

public class VOminivanlistado extends VOminivan implements Serializable{
	///Atributo
	private int cantpaseosasignados;
	///Constructor
	public VOminivanlistado(String matricula, String marca, String modelo, int cantasientos,int cantpaseosasignados) {
		super(matricula, marca, modelo, cantasientos);
		this.cantpaseosasignados = cantpaseosasignados;
		// TODO Auto-generated constructor stub
	}
	///Getter y Setter
	public int getCantpaseosasignados() {
		return cantpaseosasignados;
	}

	public void setCantpaseosasignados(int cantpaseosasignados) {
		this.cantpaseosasignados = cantpaseosasignados;
	}
}
