package logica.fachada;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;
import java.util.ArrayList;
import logica.colecciones.Boletos;
import logica.excepciones.LogicaException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.RegistroException;
import logica.excepciones.RegistroExceptionII;
import logica.valueobject.VOboletoingreso;
import logica.valueobject.VOminivan;
import logica.valueobject.VOpaseoingreso;
import logica.valueobject.VOpaseolistado;
import logica.negocio.boleto;
public interface IFachada extends Remote {
	///Metodos
	
	public void RegisMin(VOminivan mini) throws RemoteException,LogicaException, RegistroException;
	public void VentaBol(String codigo,boleto bo) throws RemoteException,LogicaException;
	public void recuperardatos1() throws RemoteException, PersistenciaException;
	public void RegisPas(String cod,String des,LocalTime HP,LocalTime HL,float Prec,int MaxBol) throws RemoteException,LogicaException, RegistroExceptionII;
	public ArrayList<VOpaseolistado>  LisPasAsMin(String mat);
	public ArrayList<VOpaseolistado> LisPasDes(String des) throws RemoteException;
	public ArrayList<VOpaseolistado> LisDisBol(int maxb,Boletos bo) throws RemoteException,LogicaException;
	public  Boletos LisPasBolVen(String cod) throws RemoteException,LogicaException;
	public float MonRec(String cod) throws RemoteException;
	public void respaldardatos() throws RemoteException, PersistenciaException;
	public void recuperardatos() throws RemoteException, PersistenciaException;
}
