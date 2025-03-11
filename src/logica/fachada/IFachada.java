package logica.fachada;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import logica.excepciones.AlfaNumericException;
import logica.excepciones.CelularException;
import logica.excepciones.DescuentoException;
import logica.excepciones.DestinoException;
import logica.excepciones.DisponibilidadException;
import logica.excepciones.EdadException;
import logica.excepciones.HorarioException;
import logica.excepciones.LogicaException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.PrecioException;
import logica.excepciones.RegistroException;
import logica.excepciones.RegistroExceptionII;
import logica.valueobject.VOboletoespeciallistado;
import logica.valueobject.VOboletoingreso;
import logica.valueobject.VOboletolistado;
import logica.valueobject.VOminivan;
import logica.valueobject.VOminivanlistado;
import logica.valueobject.VOpaseolistado;
public interface IFachada extends Remote {
	///Metodos
	
	public void RegisMin(@SuppressWarnings("exports") VOminivan mini) throws RemoteException, RegistroException;
	public void VentaBol(String codigo, @SuppressWarnings("exports") VOboletoingreso vo, float desc) throws RemoteException,LogicaException, DescuentoException, CelularException, EdadException;
	@SuppressWarnings("exports")
	public List<VOminivanlistado> LisMin()  throws RemoteException;
	@SuppressWarnings("exports")
	public ArrayList<VOpaseolistado>  LisPasAsMin(String mat) throws RemoteException;
	public void RegisPas(String cod,String des,LocalTime HP,LocalTime HL,float Prec) throws RemoteException,LogicaException, RegistroExceptionII, DestinoException, AlfaNumericException, PrecioException, HorarioException;
	@SuppressWarnings("exports")
	public ArrayList<VOpaseolistado> LisPasDes(String des) throws RemoteException;
	@SuppressWarnings("exports")
	public ArrayList<VOpaseolistado> LisDisBol(int maxb) throws RemoteException, DisponibilidadException;
	@SuppressWarnings("exports")
	public ArrayList<VOboletoespeciallistado> LisBolVenEsp(String cod) throws RemoteException,LogicaException;
	@SuppressWarnings("exports")
	public ArrayList<VOboletolistado> LisBolVen(String cod) throws RemoteException,LogicaException;
	public float MonRec(String cod) throws RemoteException;
	public void respaldardatos() throws RemoteException, PersistenciaException;
	public void recuperardatos() throws RemoteException, PersistenciaException;
}