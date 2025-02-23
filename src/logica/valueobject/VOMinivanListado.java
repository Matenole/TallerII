package logica.valueobject;
public class VOMinivanListado extends VOminivan {
	
	private int cantpaseosasignados;

	public VOMinivanListado(String matricula, String marca, String modelo, int cantasientos,int cantpaseosasignados) {
		super(matricula, marca, modelo, cantasientos);
		this.cantpaseosasignados = cantpaseosasignados;
		// TODO Auto-generated constructor stub
	}
	
	public int getCantpaseosasignados() {
		return cantpaseosasignados;
	}

	public void setCantpaseosasignados(int cantpaseosasignados) {
		this.cantpaseosasignados = cantpaseosasignados;
	}
}
