package grafica;
import java.rmi.RemoteException;
import java.time.LocalTime;
import java.util.List;

import logica.colecciones.*;
import logica.excepciones.LogicaException;
import logica.excepciones.PersistenciaException;
import logica.excepciones.RegistroException;
import logica.excepciones.RegistroExceptionII;
import logica.fachada.Fachada;
import logica.negocio.*;
import logica.valueobject.*;
public class TestFachada {

	public static void main(String[] args) throws LogicaException, RegistroException, RemoteException, RegistroExceptionII, PersistenciaException {
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
		/*
		minivan m1= new minivan("+kernelloverrrr098","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		f.RegisMin(vom);
		*/
		///Acierto: is se ingresa una matricula con digistos no alfanumericos efectivamente salta error. bien ahi pa.
		///Prueba 4:Listado de una minivan(Testing positivo)
		/*
		minivan m1= new minivan("GAB7654","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		minivan m2= new minivan("LOA4522","Toyota","Prius",30);
		VOminivan vom1 = new VOminivan(m2.getMatricula(),m2.getMarca(),m2.getModelo(),m2.getCantasientos());
		minivan m3= new minivan("MMC5566","Toyota","Prius",30);
		VOminivan vom2 = new VOminivan(m3.getMatricula(),m3.getMarca(),m3.getModelo(),m3.getCantasientos());
		minivan m4= new minivan("NOPA99","Toyota","Prius",30);
		VOminivan vom3 = new VOminivan(m4.getMatricula(),m4.getMarca(),m4.getModelo(),m4.getCantasientos());
		f.RegisMin(vom);
		f.RegisMin(vom1);
		f.RegisMin(vom2);
		f.RegisMin(vom3);
		List<VOminivanlistado> l= f.LisMin();
		System.out.println("=== Detalles de las Minivans ===");
        for (VOminivan minivan : l) {
            System.out.println("Matrícula: " + minivan.getMatricula());
            System.out.println("Marca: " + minivan.getMarca());
            System.out.println("Modelo: " + minivan.getModelo());
            System.out.println("Cantidad de Asientos: " + minivan.getCantasientos());
            System.out.println("-----------------------------");
        }
        */
		///Acierto:lista funciona correctamente.
		///Prueba 5: listar una minivan que no tiene asignado ningun paseo:(Testing negativo)
		/*
		paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		minivan m1= new minivan("GAB7654","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		minivan m2= new minivan("LOA4522","Toyota","Prius",30);
		VOminivan vom1 = new VOminivan(m2.getMatricula(),m2.getMarca(),m2.getModelo(),m2.getCantasientos());
		minivan m3= new minivan("MMC5566","Toyota","Prius",30);
		VOminivan vom2 = new VOminivan(m3.getMatricula(),m3.getMarca(),m3.getModelo(),m3.getCantasientos());
		minivan m4= new minivan("NOPA99","Toyota","Prius",30);
		VOminivan vom3 = new VOminivan(m4.getMatricula(),m4.getMarca(),m4.getModelo(),m4.getCantasientos());
		f.RegisMin(vom);
		f.RegisMin(vom1);
		f.RegisMin(vom2);
		f.RegisMin(vom3);
		List<VOpaseolistado> l= f.LisPasAsMin(p2.getCodigo());
		*/
		//Acierto: efectivamente da error.
		///Prueba 5.1:listar una minivan si asignada al sistema(Testung positivo):
		/*
		paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		minivan m1= new minivan("GAB7654","Toyota","Prius",30);
		VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
		m1.insertarPaseo(p2);
		f.RegisMin(vom);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		List<VOpaseolistado> l= f.LisPasAsMin(m1.getMatricula());
		*/
		///Error: ocuerre un error en las asignaciones de las variables y la insercion de los paseos en la minvan es aparentemente incorrecta.
		///Prueba 6:Listar paseos por su destino:(Testing positivo)
		/*
		paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
		paseo p3 = new paseo("NegroDelTunel11","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
		paseo p4 = new paseo("PokimaneCheta0456","PuntaDelDiablo",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
		f.RegisPas(p4.getCodigo(),p4.getDestino(),p4.getHorallegada(),p4.getHorasalida(),p4.getPrecio(),p4.getMaxboletos());
		List<VOpaseolistado> l= f.LisPasDes(p2.getDestino());
		 for (VOpaseolistado pas : l) {
	            System.out.println("Codigo: " + pas.getCodigo());
	            System.out.println("Destino: " + pas.getDestino());
	            System.out.println("Salida: " + pas.getHorasalida());
	            System.out.println("Llegada: " + pas.getHorallegada());
	            System.out.println("Precio: " + pas.getPrecio());
	            System.out.println("Cantidadmaximadeboletos: " + pas.getMaxboletos());
	            System.out.println("-----------------------------");
	        }
	    */
		//Acierto: imprime correctamente la cantidad correcta de paseos por pantalla de los paseos con el destino correcto.
		 ///Para poder probar listarboletospordisponibilidad,listadoporvoletosvendidos y montorecaudado hay que arreglar ventaboleto y verificar la insercion de boletos a los paseos correspondientes.
	///Prueba 7:Guardar la realidad en un archivo respaldando los datos(Testing positivo)
	/*
		 	paseo p2 = new paseo("Salus1","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
			f.RegisPas(p2.getCodigo(),p2.getDestino(),p2.getHorallegada(),p2.getHorasalida(),p2.getPrecio(),p2.getMaxboletos());
			paseo p3 = new paseo("NegroDelTunel11","Castillos",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
			f.RegisPas(p3.getCodigo(),p3.getDestino(),p3.getHorallegada(),p3.getHorasalida(),p3.getPrecio(),p3.getMaxboletos());
			paseo p4 = new paseo("PokimaneCheta0456","PuntaDelDiablo",LocalTime.of(13,30),LocalTime.of(22,45),100.5f,12);
			f.RegisPas(p4.getCodigo(),p4.getDestino(),p4.getHorallegada(),p4.getHorasalida(),p4.getPrecio(),p4.getMaxboletos());
			minivan m1= new minivan("GAB7654","Toyota","Prius",30);
			VOminivan vom = new VOminivan(m1.getMatricula(),m1.getMarca(),m1.getModelo(),m1.getCantasientos());
			minivan m2= new minivan("LOA4522","Toyota","Prius",30);
			VOminivan vom1 = new VOminivan(m2.getMatricula(),m2.getMarca(),m2.getModelo(),m2.getCantasientos());
			minivan m3= new minivan("MMC5566","Toyota","Prius",30);
			VOminivan vom2 = new VOminivan(m3.getMatricula(),m3.getMarca(),m3.getModelo(),m3.getCantasientos());
			minivan m4= new minivan("NOPA99","Toyota","Prius",30);
			VOminivan vom3 = new VOminivan(m4.getMatricula(),m4.getMarca(),m4.getModelo(),m4.getCantasientos());
			f.RegisMin(vom);
			f.RegisMin(vom1);
			f.RegisMin(vom2);
			f.RegisMin(vom3);
			f.respaldardatos();
	*/
			///Error: dan multiples errores en simultaneo, puntualmente en la fachada. parece que no se respaldan correctamente los archivos, puntualmente a la hora de obtener el mensaje y en el nombramiento del archivo.
			///Prueba 8:Recuperacion de los datos:(Testing positivo):
			f.recuperardatos();
			///Error: errores parecidos en la parte de respaldo tambien los hay en la parte de recuperar. hay algo q no funciona correctamente en la capa de persistencia.
	}

}
