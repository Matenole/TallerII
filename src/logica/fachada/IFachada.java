package logica.fachada;
import java.rmi.Remote;
import java.time.LocalTime;
import logica.valueobject.VOboletoingreso;
import logica.valueobject.VOminivan;
import logica.valueobject.VOpaseoingreso;
public interface IFachada extends Remote {
	///Metodos
	public void VentaBol(int codigo,VOboletoingreso bo);
	public void RegisMin(VOminivan mini);
	public VOminivan LisMin();
	public void RegisPas(int cod,String des,LocalTime HP,LocalTime HL,float Prec,int MaxBol);
	public VOpaseoingreso LisPasAsMin();
	public VOpaseoingreso LisPasDes(String des);
	public VOpaseoingreso LisDisBol(int maxb);
	public VOpaseoingreso LisPasBolVen(String cod);
	public float MonRec(String cod);
	public void respaldardatos();	
	public void recuperardatos();
}
