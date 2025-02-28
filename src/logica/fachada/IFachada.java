package logica.fachada;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;
import java.util.ArrayList;

import logica.colecciones.Boletos;
import logica.excepciones.LogicaException;
import logica.excepciones.PersistenciaException;
import logica.valueobject.VOboletoingreso;
import logica.valueobject.VOminivan;
import logica.valueobject.VOpaseoingreso;
import logica.valueobject.VOpaseolistado;
public interface IFachada extends Remote {
	///Metodos
	
	public void RegisMin(VOminivan mini) throws RemoteException,LogicaException;
	public void VentaBol(String codigo,Boletos bo) throws RemoteException,LogicaException;
	public void recuperardatos1() throws RemoteException, PersistenciaException;
	public void RegisPas(String cod,String des,LocalTime HP,LocalTime HL,float Prec,int MaxBol) throws RemoteException,LogicaException;
	public ArrayList<VOpaseolistado>  LisPasAsMin(String mat);
	public ArrayList<VOpaseolistado> LisPasDes(String des);
	public VOpaseoingreso LisDisBol(int maxb,Boletos bo) throws RemoteException,LogicaException;
	public  ArrayList<VOpaseolistado> LisPasBolVen(String cod) throws RemoteException,LogicaException;
	public float MonRec(String cod);
	public void respaldardatos() throws RemoteException, PersistenciaException;
	public void recuperardatos() throws RemoteException, PersistenciaException;
}
