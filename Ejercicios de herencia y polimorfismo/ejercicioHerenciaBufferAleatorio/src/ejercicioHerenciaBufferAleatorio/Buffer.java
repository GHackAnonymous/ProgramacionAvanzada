package ejercicioHerenciaBufferAleatorio;

import java.util.ArrayList;
import java.util.List;

public class Buffer<T> {
	
	private List<T> lista;
	private final int INDICE = 0;
	private final int MAX = 4;
	private int i = 0;
	
	public Buffer(){
		lista = new ArrayList<T>();
		
	}
	public void put(T valor) throws ListaException{
		if(i<=MAX){
			lista.add(valor);
			i++;
		}else{
			throw new ListaException( "No hay artefactos");
		}
		
	}
	public T get() throws ListaException{
		T objeto = lista.get(INDICE);
		lista.remove(INDICE);
		i--;
		return objeto;
	}
}
