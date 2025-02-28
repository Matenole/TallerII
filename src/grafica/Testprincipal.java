package grafica;
import java.time.LocalTime;
import java.util.List;
import logica.valueobject.*;
import logica.colecciones.*;
import logica.excepciones.LogicaException;
import logica.negocio.*;
public class Testprincipal {

	public static void main(String[] args) throws LogicaException {
		// TODO Auto-generated method stub
		Minivans  m = new Minivans();
		minivan m1 = new minivan("dwdwd","toyota","prius",14);
		m.insert(m1);
		Paseos p = new Paseos();
		paseo p1 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		Boletos b = p1.getBoletosVendidos();
		p.insert(p1);
		m1.insertarPaseo(p1);
		boleto b1 = new boleto(1122, "Pedro Picapiedra", 19 , "098588832");
		p1.ventaBoleto(b1);
		especial b2 = new especial(2211, "Jefferson Gutierritos", 21, "0999590447",50.5f);
		p1.ventaBoleto(b2);
		float resu = p1.montoRecaudado();
		System.out.println("El Monto es:" + " " + resu);
		List<VOboletolistado> vobl = p1.listarBoletos();
		vobl.forEach((vo)-> System.out.println("El boleto es: " + vo.getNumero()+ ", " + vo.getCelular() + ", " + vo.getEdad() + ", " + vo.getNombrepasajero() + ", " + vo.getMonto()));
		List<VOminivanlistado> vom = m.listarMinivan();
		vom.forEach((vo)-> System.out.println("La minivan es: " + vo.getMatricula()+ ", " + vo.getMarca() + ", " + vo.getModelo() + ", " + vo.getCantasientos() + ", " + vo.getCantpaseosasignados()));
		List<VOpaseolistado> vopl = p.listadoPaseos();
		vopl.forEach((vo)-> System.out.println("El paseo es: " + vo.getCodigo() + ", " + vo.getDestino() + ", " + vo.getMaxboletos() + ", " + vo.getMonto() + ", " + vo.getPrecio()));
		if(m.esta_asignado(p1.getCodigo()))
			System.out.println("Esta asignado");
		else
			System.out.println("No esta asignado");
		List<VOpaseolistado> minivanasignada =m.listadoporasignacionpaseos(m1.getMatricula());
		minivanasignada.forEach((vo)-> System.out.println("La minivan es: " + vo.getCodigo()+ ", " + vo.getDestino() + ", " + vo.getHorasalida() + ", " + vo.getHorallegada() + ", " + vo.getMonto()));
		;
	}

}
