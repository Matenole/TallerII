package grafica;
import java.time.LocalTime;

import logica.colecciones.*;
import logica.negocio.*;
public class Testprincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Minivans  m = new Minivans();
		minivan m1 = new minivan("dwdwd","toyota","prius",14);
		m.insert(m1);
		Paseos p = new Paseos();
		paseo p1 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		p.insert(p1);
		m1.insertarPaseo(p1);
		boleto b1 = new boleto(1122, "Pedro Picapiedra", 12 , "098588832");
		p1.ventaBoleto(b1);
		especial b2 = new especial(2211, "Jefferson Gutierritos", 17, "0999590447",50.5f);
		p1.ventaBoleto(b2);
		float resu = p1.montoRecaudado();
		System.out.println("monto es:" + resu);
	}

}
