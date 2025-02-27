package logica.fachada;
import java.time.LocalTime;
import logica.colecciones.*;
import logica.valueobject.*;
import logica.excepciones.*;
import logica.negocio.*;
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
	public void VentaBol(String codigo,Boletos bo) throws LogicaException {
		if(Viaje.member(codigo))//maxboletos esta en paseo
			throw new LogicaException("El codigo no existe en la realidad");
		//if(bo.size() == Viaje.get(getMaxboletos()))
		//	throw new LogicaException("La cantidad de boletos disponibles con la cantidad maxima de boletos no coincide");
		//if(bo.get(getEdad()) || bo.get(getEdad()))
		//	throw new LogicaException("El celular o la edad es menor que 0");
	}
	public void RegisMin(VOminivan mini) {
		if(true) {
			
		}
	}
	public VOminivan LisMin() {
		VOminivan vo = Locomocion.listarMinivan();
		return vo;
	}
	public void RegisPas(String cod,String des,LocalTime HP,LocalTime HL,float Prec,int MaxBol) throws LogicaException {
		if(Viaje.member(cod) || cod.matches("[a-zA-Z0-9]+") )
			throw new LogicaException("El paseo no se puede registrar pq el mismo ya se encuentra en el sistema o el codigo ingresado no es alfanumerico");
		else {
				
		}
	}
	public VOpaseoingreso LisPasAsMin() {
		VOpaseoingreso h20 = null;
		return h20;
	}
	public VOpaseoingreso LisPasDes(String des) {
		if(Viaje == null) {
			 VOpaseoingreso vo = new VOpaseoingreso(null,null, null, null, 0, 0);
			 return vo;
		}
		else
			return Viaje.listadoPaseosPorDestino(des);
	}
	/*public VOpaseoingreso LisDisBol(int maxb,Boletos bo) {
		VOpaseoingreso AU = null;
		//if(Viaje.get(getMaxboletos()) - bo.size() >= maxb)
		//	return AU;
		//else 
		//	throw new LogicaException("el maximo de boletos es menor a la resta de los boletos maximos y los boletos disponibles");
		
	}*/
	public VOpaseoingreso LisPasBolVen(String cod) {
		VOpaseoingreso CO2 = null;
		return CO2;
	}
	public float MonRec(String cod) {
		float x = 0;
		return x;
	}
	public void respaldardatos() {
		
	}
	public void recuperardatos() {
	}
	
}	
