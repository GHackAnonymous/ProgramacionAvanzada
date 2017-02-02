package ejercicioHerenciaBufferAleatorio;

import java.util.Random;

public class Principal {

	private Random rd;
	private int valor;
	private Buffer<Integer> buffer;
	private int NUMVECES = 25;
	
	public Principal(){
		rd = new Random();
		buffer = new Buffer();
	}
	
	private void operacionGet() throws ListaException{
		System.out.println("Se saca: "+buffer.get());
	}
	
	private void operacionPut() throws ListaException{
		valor = rd.nextInt(100);
		buffer.put(valor);
	}
	
	public void programa(){
		try{
			for(int i = 0; i < NUMVECES; i++){
				int opcion = rd.nextInt(2);
				
				switch(opcion){
				case 0:
					try {
						operacionGet();
					} catch (IndexOutOfBoundsException e) {
						System.out.println("La lista esta vacia");
					}
					break;
				case 1:
					try {
						operacionPut();
					} catch (ListaException e) {
						System.out.println("La lista esta llena");
					}
					break;
				}
			}
		}catch(Exception e){
			System.out.println("No se que a pasado");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Principal p = new Principal();
		p.programa();

	}

}
