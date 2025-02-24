package logica.fachada;

public class Monitor {
		///Atributos
		private int cantlectores;
		private boolean escribiendo;
		///Constructor
		public Monitor(int cantlectores, boolean escribiendo) {
			super();
			this.cantlectores = 0;
			this.escribiendo = false;
		}
		///Metodos
		public synchronized void comienzoLectura (){
			while(escribiendo) {
				try {
					wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			cantlectores++;
		}
		
		public synchronized void terminoLectura (){
			cantlectores--;
			if (cantlectores == 0) {
					notify();
			}
		}
		
		public synchronized void comienzoEscritura (){
			while(cantlectores > 0 || escribiendo) {
				try {
					wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
			escribiendo = true;
		}
		
		public synchronized void terminoEscritura (){
			escribiendo = false;
			notify();
		}
				
}
