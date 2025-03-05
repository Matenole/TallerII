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
import java.rmi.server.UnicastRemoteObject;
public class Fachada extends UnicastRemoteObject implements IFachada{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	///Atributos
	private  Minivans Locomocion;
	private Paseos Viaje;
	private Monitor m;
	
	
	///Constructor
	public Fachada() throws RemoteException {
		super();
		Locomocion =new Minivans();
		Viaje = new Paseos();
		m = new Monitor();
	}
	
	///Metodos
	public void VentaBol(String codigo,boleto b) throws RemoteException,LogicaException {
		m.comienzoEscritura();
        paseo controladorsubcutaneodecantidadmaximadeboletos = Viaje.find(codigo);
        Boletos bo = controladorsubcutaneodecantidadmaximadeboletos.getBoletosVendidos();
		if(bo.size() == controladorsubcutaneodecantidadmaximadeboletos.getMaxboletos())
			throw new LogicaException("Ya se vendieron todos los boletos rey, haber estado mas atento");
		if(b.getEdad() <= 0)
			throw new LogicaException("La edad es menor o igual que 0");
		if(b.getCelular() == "0")
			throw new LogicaException("El celular es 0");
		if(b.getCelular().contains("-"))
			throw new LogicaException("El celular es negativo");
		controladorsubcutaneodecantidadmaximadeboletos.ventaBoleto(b);
		m.terminoEscritura();
	}
	
	public void RegisMin(VOminivan mini) throws RemoteException, RegistroException{
		if(Locomocion.member(mini.getMatricula()))
			throw new RegistroException("La matricula ya existe en el sistema");
		else {
		m.comienzoEscritura();
		minivan mi = new minivan(mini.getMatricula(), mini.getMarca(), mini.getModelo(), mini.getCantasientos());
		Locomocion.insert(mi);
		m.terminoEscritura();
		}
	}
	
	public List<VOminivanlistado> LisMin()  throws RemoteException{
		m.comienzoLectura();
		List<VOminivanlistado> list = Locomocion.listarMinivan();
		m.terminoLectura();
		return list;
	}
	
	public void RegisPas(String cod,String des,LocalTime HP,LocalTime HL,float Prec,int MaxBol) throws RemoteException,RegistroExceptionII {
		if(Viaje.member(cod))
			throw new RegistroExceptionII("El paseo no se puede registrar porque el mismo ya se encuentra en el sistema");
		else
			if(!cod.matches("[a-zA-Z0-9]+"))
					throw new RegistroExceptionII("El paseo posee digitos que no son alfanumericos en su codigo");
		else {
			m.comienzoEscritura();
				paseo p = new paseo(cod, des, HP, HL, Prec, MaxBol);
				Viaje.insert(p);
			m.terminoEscritura();
		}
	}
	
	public ArrayList<VOpaseolistado>  LisPasAsMin(String mat,String cod) throws RemoteException{
		m.comienzoLectura();
		ArrayList<VOpaseolistado> array = Locomocion.listadoporasignacionpaseos(mat,cod);
		m.terminoLectura();
		return array;
	}
	
	public ArrayList<VOpaseolistado> LisPasDes(String des) throws RemoteException{
		m.comienzoLectura();
		ArrayList<VOpaseolistado> array = Viaje.listadoPaseosPorDestino(des);
		m.terminoLectura();
		return array;
	}
	
	public ArrayList<VOpaseolistado> LisDisBol(int maxb,Boletos bo) throws RemoteException,LogicaException {
		m.comienzoLectura();
		String asesoramientoPaseos = Viaje.keyfinder();
        paseo a_asesorar = Viaje.find(asesoramientoPaseos);
        if(a_asesorar.getMaxboletos() - bo.size() < maxb)
			throw new LogicaException("el maximo de boletos es menor a la resta de los boletos maximos y los boletos disponibles");
        else
        {
        	ArrayList<VOpaseolistado> arr = Viaje.listadoPorDisponibilidad(maxb);
		m.terminoLectura();
		return arr;
        }
	}
	
	public Boletos LisPasBolVen(String cod) throws RemoteException,LogicaException {
		m.comienzoLectura();
		paseo p = Viaje.find(cod);
		Boletos bo = p.getBoletosVendidos();
		int sisi = bo.size();
		int nono = p.getMaxboletos();
		if(sisi != nono)
			throw new LogicaException("La cantidad de boletos vendida no es la suficiente");
		else
			m.terminoLectura();
			return bo;
		
	}
	
	public float MonRec(String cod) throws RemoteException{
		m.comienzoLectura();
		paseo p = Viaje.find(cod);
		float monto = p.montoRecaudado();
		m.terminoLectura();
		return monto;
	}
	public void asignar(String mat,String cod) {
		minivan m = Locomocion.find(mat);
		paseo p = Viaje.find(cod);
		m.insertarPaseo(p);
	}
	public void respaldardatos() throws RemoteException, PersistenciaException{
		m.comienzoLectura();
		VOPersistencia vo = new VOPersistencia(Locomocion,Viaje);
		Persistencia p = new Persistencia();
		try{
			Properties prop = new Properties();
			String nomArch = "C:\\Users\\mateo\\Documents\\Taller II\\Taller2-20250217T021949Z-001\\TallerII\\test";
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
			String nomArch = "config/txt.properties";
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

	@Override
	public void recuperardatos1() throws RemoteException, PersistenciaException {
		
	}

	@Override
	public ArrayList<VOpaseolistado> LisPasAsMin(String mat) {
		return null;
	}
}