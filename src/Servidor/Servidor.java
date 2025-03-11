package Servidor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;
import logica.fachada.*;

public class Servidor {

	public Servidor() {
	}

	public static void main(String[] args) {
		try{
			LocateRegistry.createRegistry(1099);
			IFachada fachada = new Fachada();
			try {
				fachada.recuperardatos();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();
			String nomArch = "config/txt.properties";
			prop.load (new FileInputStream (nomArch));
			String ip = prop.getProperty("ip");
			String puerto = prop.getProperty("puerto");
			System.out.println ("Registro Pendiente");
			Naming.rebind("//"+ip+":"+puerto+"/fachada", fachada);
			System.out.println ("Registro Correcto");
		}
		catch (RemoteException e)
		{ e.printStackTrace(); }
		catch (MalformedURLException e)
		{ e.printStackTrace(); 
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
