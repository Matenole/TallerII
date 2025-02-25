package logica.fachada;
import java.time.LocalTime;

import logica.colecciones.*;
import logica.valueobject.*;
public class Fachada {
	///Atributos
	private  Minivans Locomocion;
	private Paseos Viaje;
	///Constructor
	public Fachada(Minivans locomocion, Paseos viaje) {
		super();
		Locomocion = locomocion;
		Viaje = viaje;
	}
	///Getters y Setters
	public Minivans getLocomocion() {
		return Locomocion;
	}
	public void setLocomocion(Minivans locomocion) {
		Locomocion = locomocion;
	}
	public Paseos getViaje() {
		return Viaje;
	}
	public void setViaje(Paseos viaje) {
		Viaje = viaje;
	}
	///Metodos
	public void VentaBol(int codigo,VOboletoingreso bo) {
		
	}
	public void RegisMin(VOminivan mini) {
		
	}
	public VOminivan LisMin() {
		VOminivan vo = null;
		return vo;
	}
	public void RegisPas(int cod,String des,LocalTime HP,LocalTime HL,float Prec,int MaxBol) {
		
	}
	public VOpaseoingreso LisPasAsMin() {
		VOpaseoingreso h20 = null;
		return h20;
	}
	public VOpaseoingreso LisPasDes(String des) {
		VOpaseoingreso Fe = null;
		return Fe;
	}
	public VOpaseoingreso LisDisBol(int maxb) {
		VOpaseoingreso AU = null;
		return AU;
	}
	public VOpaseoingreso LisPasBolVen(String cod) {
		VOpaseoingreso CO2 = null;
		return CO2;
	}
	public float MonRec(String cod) {
		float mon = 0;
		return mon;
	}
	public void respaldardatos() {
		
	}
	public void recuperardatos() {
		
	}
	
}	
