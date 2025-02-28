package logica.fachada;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.rmi.RemoteException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import logica.colecciones.*;
import logica.valueobject.*;
import logica.excepciones.*;
import logica.negocio.*;
import persistencia.*;
import java.util.Properties;

public class Fachada {
	
	///Atributos
	private  Minivans Locomocion;
	private Paseos Viaje;
	private Monitor m;
	
	///Constructor
	public Fachada() {
		super();
		Locomocion =new Minivans();
		Viaje = new Paseos();
		m = new Monitor();
	}
	
	///Metodos
	public void VentaBol(String codigo,Boletos bo) throws RemoteException,LogicaException {
		m.comienzoEscritura();
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
		controladorsubcutaneodecantidadmaximadeboletos.ventaBoleto(b);
		m.terminoEscritura();
	}
	
	public void RegisMin(VOminivan mini) throws RemoteException, LogicaException {
		m.comienzoEscritura();
		minivan mi = new minivan(mini.getMatricula(), mini.getMarca(), mini.getModelo(), mini.getCantasientos());
		Locomocion.insert(mi);
		m.terminoEscritura();
	}
	
	public List<VOminivanlistado> LisMin()  throws RemoteException{
		m.comienzoLectura();
		List<VOminivanlistado> list = Locomocion.listarMinivan();
		m.terminoLectura();
		return list;
	}
	
	public void RegisPas(String cod,String des,LocalTime HP,LocalTime HL,float Prec,int MaxBol) throws RemoteException,LogicaException {
		m.comienzoEscritura();
		if(Viaje.member(cod) || !cod.matches("[a-zA-Z0-9]+") )
			throw new LogicaException("El paseo no se puede registrar porque el mismo ya se encuentra en el sistema o el codigo ingresado no es alfanumerico");
		else {
				paseo p = new paseo(cod, des, HP, HL, Prec, MaxBol);
				Viaje.insert(p);
		}
		m.terminoEscritura();
	}
	
	public ArrayList<VOpaseolistado>  LisPasAsMin(String mat) throws RemoteException{
		m.comienzoLectura();
		ArrayList<VOpaseolistado> array = Locomocion.listadoporasignacionpaseos(mat);
		m.terminoLectura();
		return array;
	}
	
	public ArrayList<VOpaseolistado> LisPasDes(String des) throws RemoteException{
		m.comienzoLectura();
		ArrayList<VOpaseolistado> array = Viaje.listadoPaseosPorDestino(des);
		m.terminoLectura();
		return array;
	}
	
	public VOpaseoingreso LisDisBol(int maxb,Boletos bo) throws RemoteException,LogicaException {
		m.comienzoLectura();
		String asesoramientoPaseos = Viaje.keyfinder();
        paseo a_asesorar = Viaje.find(asesoramientoPaseos);
        if(a_asesorar.getMaxboletos() - bo.size() < maxb)
			throw new LogicaException("el maximo de boletos es menor a la resta de los boletos maximos y los boletos disponibles");
        VOpaseoingreso AU = new VOpaseoingreso(asesoramientoPaseos,a_asesorar.getDestino(),a_asesorar.getHorasalida(),a_asesorar.getHorallegada(),a_asesorar.getPrecio(),maxb);
		m.terminoLectura();
		return AU;
	}
	
	public  ArrayList<VOpaseolistado> LisPasBolVen(String cod) throws RemoteException,LogicaException {
		m.comienzoLectura();
		paseo p = Viaje.find(cod);
		Boletos bo = p.getBoletosVendidos();
		int sisi = bo.size();
		if(sisi < p.getMaxboletos() )
			throw new LogicaException("La cantidad de boletos vendida no es la suficiente");
		ArrayList<VOpaseolistado> list = Viaje.listadoPorDisponibilidad(sisi);
		m.terminoLectura();
		return list;
	}
	
	public float MonRec(String cod) throws RemoteException{
		m.comienzoLectura();
		paseo p = Viaje.find(cod);
		float monto = p.montoRecaudado();
		m.terminoLectura();
		return monto;
	}
	
	public void respaldardatos() throws RemoteException, PersistenciaException{
		m.comienzoLectura();
		VOPersistencia vo = new VOPersistencia(Locomocion,Viaje);
		Persistencia p = new Persistencia();
		try{
			Properties prop = new Properties();
			String nomArch = "config/properties";
			prop.load (new FileInputStream (nomArch));
			String nombrearchivo = prop.getProperty(nomArch);
			p.respaldar(nombrearchivo, vo);
			m.terminoLectura();
		}catch(PersistenciaException e) {
			m.terminoLectura();
			throw e;
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			m.terminoLectura();
			throw new PersistenciaException(e.getMessage());
		}catch(IOException e) {
			e.printStackTrace();
			m.terminoLectura();
			throw new PersistenciaException(e.getMessage());
		}	
	}

	public void recuperardatos() throws RemoteException, PersistenciaException{
		m.comienzoEscritura();
		Persistencia p = new Persistencia();
		try{
			Properties prop = new Properties();
			String nomArch = "config/properties";
			prop.load (new FileInputStream (nomArch));
			String nombrearchivo = prop.getProperty(nomArch);
			VOPersistencia vo = p.recuperar(nombrearchivo);
			Locomocion = vo.getMini();
			Viaje = vo.getPas();
			m.terminoEscritura();
		}catch(PersistenciaException e) {
			m.terminoEscritura();
			throw e;
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			m.terminoEscritura();
			throw new PersistenciaException(e.getMessage());
		}catch(IOException e) {
			e.printStackTrace();
			m.terminoEscritura();
			throw new PersistenciaException(e.getMessage());
		}
	}
}