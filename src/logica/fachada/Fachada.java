package logica.fachada;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;
import logica.colecciones.*;
import logica.valueobject.*;
import logica.excepciones.*;
import logica.negocio.*;
public class Fachada {
	///Atributos
	private  Minivans Locomocion;
	private Paseos Viaje;
	///Constructor
	public Fachada() {
		super();
		Locomocion =new Minivans();
		Viaje = new Paseos();
	}
	
	///Metodos
	public void VentaBol(String codigo,Boletos bo) throws RemoteException,LogicaException {
		String checkeadordemlimusinas = Viaje.keyfinder();
        paseo controladorsubcutaneodecantidadmaximadeboletos = Viaje.find(checkeadordemlimusinas);
        boleto b = bo.kesimo(1);
        especial e = (especial) bo.kesimo(1);
		if(Viaje.member(codigo))//maxboletos esta en paseo
			throw new LogicaException("El codigo ya existe en la realidad");
		if(bo.size() == controladorsubcutaneodecantidadmaximadeboletos.getMaxboletos())
			throw new LogicaException("La cantidad de boletos disponibles con la cantidad maxima de boletos no coincide");
		if(b.getEdad() <= 0)
			throw new LogicaException("La edad es menor o igual que 0");
		if(b.getCelular() != "0")
			throw new LogicaException("El celular es menor o igual que 0");
		if(e.getDescuento() <= 0)
			throw new LogicaException("El Descuento es menor o igual que 0");
		controladorsubcutaneodecantidadmaximadeboletos.ventaBoleto(null);
	}
	
	public void RegisMin(VOminivan mini) throws LogicaException {
		minivan m = new minivan(mini.getMatricula(), mini.getMarca(), mini.getModelo(), mini.getCantasientos());
		Locomocion.insert(m);
	}
	
	public List<VOminivanlistado> LisMin() {
		return Locomocion.listarMinivan();
	}
	
	public void RegisPas(String cod,String des,LocalTime HP,LocalTime HL,float Prec,int MaxBol) throws LogicaException {
		if(Viaje.member(cod) || !cod.matches("[a-zA-Z0-9]+") )
			throw new LogicaException("El paseo no se puede registrar porque el mismo ya se encuentra en el sistema o el codigo ingresado no es alfanumerico");
		else {
				paseo p = new paseo(cod, des, HP, HL, Prec, MaxBol);
				Viaje.insert(p);
		}
	}
	
	public VOpaseoingreso LisPasAsMin() {
		VOpaseoingreso h20 = null;
		return h20;
	}
	
	public ArrayList<VOpaseolistado> LisPasDes(String des) {
		return Viaje.listadoPaseosPorDestino(des);
	}
	
	public VOpaseoingreso LisDisBol(int maxb,Boletos bo) throws LogicaException {
		String asesoramientoPaseos = Viaje.keyfinder();
        paseo a_asesorar = Viaje.find(asesoramientoPaseos);
        VOpaseoingreso AU = new VOpaseoingreso(asesoramientoPaseos,a_asesorar.getDestino(),a_asesorar.getHorasalida(),a_asesorar.getHorallegada(),maxb,maxb);
		if(a_asesorar.getMaxboletos() - bo.size() >= maxb)
		return AU;
		else 
		throw new LogicaException("el maximo de boletos es menor a la resta de los boletos maximos y los boletos disponibles");
	}
	
	public VOpaseoingreso LisPasBolVen(String cod) {
		VOpaseoingreso CO2 = null;
		return CO2;
	}
	
	public float MonRec(String cod) {
		paseo p = Viaje.find(cod);
		return p.montoRecaudado();
	}
	
	public void respaldardatos() {
		
	}
	public void recuperardatos() {
	}
	
}	
