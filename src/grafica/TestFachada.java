package grafica;
import java.rmi.RemoteException;
import java.time.LocalTime;
import logica.colecciones.*;
import logica.excepciones.LogicaException;
import logica.excepciones.RegistroException;
import logica.excepciones.RegistroExceptionII;
import logica.fachada.Fachada;
import logica.negocio.*;
import logica.valueobject.*;
public class TestFachada {

	public static void main(String[] args) throws LogicaException, RegistroException, RemoteException, RegistroExceptionII {
		// TODO Auto-generated method stub
		///Inicio Prueba fachada
		Fachada f = new Fachada();
		///Prueba 1: venta boleto(testing positivo)
		
	
		/*
		paseo p3 = new paseo("guillermobenitez345","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		boleto b1 = new boleto(1122,"Josh Peck",14,"urrutia098588832");
		f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
		f.VentaBol(p3.getCodigo(),b1);
		*/
		
		
		///Error: en ventaboleto siempre salta en que el codigo ya existe sin ningun tipo de sentido, se probo agregar un mismo paseo con los mismos datos y 
		///Distinto codigo y siempre salta ese error.cuando no deberia. Se sugiere crear excepciones para cada error particular en la fachada para evitar apropiamientos
		///de valores en las excepciones e impedir que las excepciones no funcionen como deberia. mi temor personal es que las excepciones esten mal usadas y sobrecargadas en este programa. 
		///Prueba 2:Registrar un paseo en el sistema(testing positivo)
		///
		/*
		paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		*/
		//Acierto: registrar un paseo en el sistema funciona correctamente.
		//Prueba 2.1: ingresar dos paseos con el mismo codigo(testing negativo)
		
		/*
		paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		paseo p3 = new paseo("Salus1","PuntaDelEste",LocalTime.of(15,06),LocalTime.of(02,45),10.5f,8);
		f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
		*/
		//Acierto:registrar dos paseos con el mismo codigo en el sistema da efectivamente error,como debe ser. buen trabajo para el que lo hizo. mi mas querido enhorabuena.
		//Prueba 2.2: agregar un paseo con datos no alfanumericos en su codigo
		/*
		paseo p2 = new paseo("++xxxAnonimoxx---","Arroyo Solis chico",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		 */	
		//Acierto:ingresar codigo NO alfanumerico en el sistema efectivamente dara error. muy bien hecho.
		
		//Prueba 3: Registrar una minivan en el sistema(Testing positivo):
		/*
		minivan m1= new minivan("LAA1921","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		f.RegisMin(vom);
		*/
		///Acierto: el ingreso normal de una minivan funciona correctamente.
		///Prueba 3.1:Registrar dos minivanes con el mismo codigo.
		/*
		minivan m1= new minivan("LAA1921","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		f.RegisMin(vom);
		minivan m2= new minivan("LAA1921","Toyota","Prius",30);
		VOminivan vl = new VOminivan(m2.getMatricula(),m2.getMarca(),m2.getModelo(),m2.getCantasientos());
		f.RegisMin(vl);
		*/
		///Acierto: efectivamente salta un error en el sistema al ingresar dos minivanes con el mismo codigo.
		///Prueba 3.2: Registrar una minivan con digitos no alfanumericos en su codigo.
		minivan m1= new minivan("+++-+-++-+-+-+-+-+-+-+-+-+-****//**/*/*/*/*kernelloverrrr098","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		f.RegisMin(vom);
		///Acierto: is se ingresa una matricula con digistos no alfanumericos efectivamente salta error. bien ahi pa.
	}

}
