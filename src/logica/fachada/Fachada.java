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

	private static final long serialVersionUID = 1L;
	///Atributos
	private  Minivans Locomocion;
	private Paseos Viaje;
	private Monitor m;
	
	
	///Constructor
	public Fachada() throws RemoteException {
		super();
		Locomocion = new Minivans();
		Viaje = new Paseos();
		m = new Monitor();
	}
	
	///Metodos
	public void VentaBol(String codigo, VOboletoingreso vo, float desc) throws RemoteException,LogicaException, DescuentoException, CelularException, EdadException, NombreException{
		m.comienzoEscritura();
        paseo p = Viaje.find(codigo);
        Boletos bo = p.getBoletosVendidos();
		if(bo.size() == p.getMaxboletos()) {
			m.terminoEscritura();
			throw new LogicaException("Ya se vendieron todos los boletos rey, haber estado mas atento");
		}
		if(vo.getNombrepasajero() == null || !vo.getNombrepasajero().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) {
			m.terminoEscritura();
			throw new NombreException("El Nombre ha sido ingresado incorrectamente (solo se permiten letras y espacios)");
		}
		if(vo.getEdad() <= 0 || vo.getEdad() > 120) {
			m.terminoEscritura();
			throw new EdadException("La Edad ha sido ingresada incorrectamente");
		}
		if(vo.getCelular().equals("0") || vo.getCelular().contains("-") || !vo.getCelular().matches("^\\+?[0-9]{1,13}$")) {
			m.terminoEscritura();
			throw new CelularException("El Celular ha sido ingresado incorrectamente");
		}
		if(vo instanceof VOboletoespecialingreso) {
			if(desc <= 0) {
				m.terminoEscritura();
				throw new DescuentoException("el descuento ingresado no puede ser menor o igual a 0");
			}
			if(desc > (p.getPrecio()*0.75) && vo.getEdad() < 18) {
				m.terminoEscritura();
				throw new DescuentoException("El descuento no puede ser mayor que el precio del Paseo (En este caso el 75% del precio)");
			}else {
				if(desc > p.getPrecio() && vo.getEdad() >= 18) {
					m.terminoEscritura();
					throw new DescuentoException("El descuento no puede ser mayor que el precio del Paseo");
				}else {
					especial e = new especial(bo.size()+1 , vo.getNombrepasajero(),vo.getEdad(),vo.getCelular(),desc );
					p.ventaBoleto(e);
			}
			}
		}else {
			boleto b =  new boleto(bo.size()+1,vo.getNombrepasajero(),vo.getEdad(),vo.getCelular());
			p.ventaBoleto(b);
		}
		m.terminoEscritura();
	}
	
	public void RegisMin(@SuppressWarnings("exports") VOminivan mini) throws RemoteException, RegistroException{
		if(Locomocion.member(mini.getMatricula())) {
			m.terminoEscritura();
			throw new RegistroException("La matricula ya existe en el sistema");
		}
			int cantasientos = mini.getCantasientos();
			String cantasientosStr = String.valueOf(cantasientos);
			if(cantasientosStr.equals("0") || cantasientosStr.contains("-") || cantasientosStr.length() > 3) {
		    m.terminoEscritura();
		    throw new RegistroException("La Capacidad ha sido ingresada incorrectamente");
			}
			else {
				m.comienzoEscritura();
				minivan mi = new minivan(mini.getMatricula(), mini.getMarca(), mini.getModelo(), mini.getCantasientos());
				Locomocion.insert(mi);
				m.terminoEscritura();
		}
	}
	
	@SuppressWarnings("exports")
	public List<VOminivanlistado> LisMin()  throws RemoteException{
		m.comienzoLectura();
		List<VOminivanlistado> list = Locomocion.listarMinivan();
		m.terminoLectura();
		return list;
	}
	public void asignar(String mat,String cod) {
		minivan m = Locomocion.find(mat);
		paseo p = Viaje.find(cod);
		m.insertarPaseo(p);
	}
	public void RegisPas(String cod,String des,LocalTime HP,LocalTime HL,float Prec) throws RemoteException,RegistroExceptionII, DestinoException, AlfaNumericException, PrecioException, HorarioException, MinivanException {
		if(Viaje.member(cod)) {
			m.terminoEscritura();
			throw new RegistroExceptionII("El paseo no se puede registrar porque el mismo ya se encuentra en el sistema");
		}
		else
			if(Prec <= 0){
				m.terminoEscritura();
				throw new PrecioException("El paseo posee un precio invalido");
			}else {
				if(!cod.matches("[a-zA-Z0-9]+")) {
					m.terminoEscritura();
					throw new AlfaNumericException("El paseo posee digitos que no son alfanumericos en su codigo");
				}
				else {
					if (!(DestinosUruguay.esDestinoValido(des.toLowerCase()))) {
							m.terminoEscritura();
							throw new DestinoException("El destino ingresado no es correcto");
			        }
					else {
						minivan mini = Locomocion.MiniDis(HP, HL);
						if (mini == null) {
							m.terminoEscritura();
							throw new MinivanException("No hay ninguna minivan disponible para ese horario");
						}else {
							m.comienzoEscritura();
							int maxBoletos = mini.getCantasientos();
							paseo p = new paseo(cod, des.toLowerCase(), HP, HL, Prec, maxBoletos);
							Viaje.insert(p);
							mini.insertarPaseo(p);
							m.terminoEscritura();
							}
					}
				}
			}
	}
	
	@SuppressWarnings("exports")
	public ArrayList<VOpaseolistado>  LisPasAsMin(String mat) throws RemoteException{
		m.comienzoLectura();
		ArrayList<VOpaseolistado> array = Locomocion.listadoporasignacionpaseos(mat);
		m.terminoLectura();
		return array;
	}
	
	@SuppressWarnings("exports")
	public ArrayList<VOpaseolistado> LisPasDes(String des) throws RemoteException{
		m.comienzoLectura();
		ArrayList<VOpaseolistado> array = Viaje.listadoPaseosPorDestino(des.toLowerCase());
		m.terminoLectura();
		return array;
	}
			
	@SuppressWarnings("exports")
	public ArrayList<VOpaseolistado> LisDisBol(int maxb) throws RemoteException,DisponibilidadException {
		m.comienzoLectura();
		String asesoramientoPaseos = Viaje.keyfinder();
        paseo a_asesorar = Viaje.find(asesoramientoPaseos);
        Boletos bo = a_asesorar.getBoletosVendidos();
        if(a_asesorar.getMaxboletos() - bo.size() < maxb) {
        	m.terminoEscritura();
			throw new DisponibilidadException("el maximo de boletos es menor a la resta de los boletos maximos y los boletos disponibles");
        }
        else
        {
        	ArrayList<VOpaseolistado> arr = Viaje.listadoPorDisponibilidad(maxb);
		    m.terminoLectura();
		return arr;
        }
	}
	
	@SuppressWarnings("exports")
	public ArrayList<VOboletolistado> LisBolVen(String cod) throws RemoteException,LogicaException {
		m.comienzoLectura();
		if (!Viaje.member(cod)) {
			m.terminoLectura();
			throw new LogicaException("No existe un paseo con ese codigo");
		}
		paseo p = Viaje.find(cod);
		ArrayList<VOboletolistado> bo = p.listarBoletos();
		m.terminoLectura();
		return bo;
	}

	@SuppressWarnings("exports")
	public ArrayList<VOboletoespeciallistado> LisBolVenEsp(String cod) throws RemoteException,LogicaException {
		m.comienzoLectura();
		if (!Viaje.member(cod)) {
			m.terminoLectura();
			throw new LogicaException("No existe un paseo con ese codigo");
		}
		paseo p = Viaje.find(cod);
		ArrayList<VOboletoespeciallistado> bo = p.listarBoletosEspecial();
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
	public void respaldardatos() throws RemoteException, PersistenciaException{
		m.comienzoLectura();
		VOPersistencia vo = new VOPersistencia(Locomocion,Viaje);
		Persistencia p = new Persistencia();
		try{
			Properties prop = new Properties();
			String nomArch = "config/txt.properties";
			prop.load (new FileInputStream (nomArch));
			String nombrearchivo = prop.getProperty("nombrearchivo");
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
			String nombrearchivo = prop.getProperty("nombrearchivo");
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