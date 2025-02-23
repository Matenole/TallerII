package logica.valueobject;
public class VOMinivanListado extends VOminivan {
	///Atributo
	private int cantpaseosasignados;
	///Constructor
	public VOMinivanListado(String matricula, String marca, String modelo, int cantasientos,int cantpaseosasignados) {
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
