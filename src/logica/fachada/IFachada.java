package logica.fachada;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import logica.colecciones.Boletos;
import logica.excepciones.DestinoException;
import logica.excepciones.DisponibilidadException;
import logica.excepciones.LogicaException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.RegistroException;
import logica.excepciones.RegistroExceptionII;
import logica.valueobject.VOboletolistado;
import logica.valueobject.VOminivan;
import logica.valueobject.VOminivanlistado;
import logica.valueobject.VOpaseolistado;
import logica.negocio.boleto;
public interface IFachada extends Remote {
	///Metodos
	
	public void RegisMin(VOminivan mini) throws RemoteException, RegistroException;
	public void VentaBol(String codigo,boleto b) throws RemoteException,LogicaException;
	public List<VOminivanlistado> LisMin()  throws RemoteException;
	public ArrayList<VOpaseolistado>  LisPasAsMin(String mat) throws RemoteException;
	public void RegisPas(String cod,String des,LocalTime HP,LocalTime HL,float Prec,int MaxBol) throws RemoteException,LogicaException, RegistroExceptionII, DestinoException;
	public ArrayList<VOpaseolistado> LisPasDes(String des) throws RemoteException;
	public ArrayList<VOpaseolistado> LisDisBol(int maxb) throws RemoteException, DisponibilidadException;
	public ArrayList<VOboletolistado> LisBolVen(String cod) throws RemoteException,LogicaException;
	public float MonRec(String cod) throws RemoteException;
	public void respaldardatos() throws RemoteException, PersistenciaException;
	public void recuperardatos() throws RemoteException, PersistenciaException;
	public ArrayList<VOboletolistado> LisBolVen(String cod, Object tb);
}
