import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Modelo{
	private List<String> listaImagen;
	private final int CUOTA = 12;
	private Random rd;
	private String[][] tableroCorrecto;
	private String[][] tableroAleatorio;
	private int index1 = 0;
	private int index2 = 0;
	private int posicionFila = 0;
	private int posicionColumna = 0;
	
	public Modelo(){
		rd = new Random();
		listaImagen = new ArrayList<>();
		tableroCorrecto = new String[4][3];
		tableroAleatorio = new String[4][3];
		
		for(int i = 0; i<CUOTA; i++){
			int index = i;
			listaImagen.add("tigre"+(index+1));
		}
		for(int i = 0; i<4; i++){
			for(int e = 0; e < 3; e++){
				int index = i;
				switch(i){
					case 1:
						index += 2; 
					break;
					case 2:
						index += 4;
					break;
					case 3:
						index += 6;
					break;
				}
				index += (e+1);
				tableroCorrecto[i][e] = "tigre"+(index);
			}
		}
		for(int i = 0; i<4; i++){
			for(int e = 0; e < 3; e++){
				tableroAleatorio[i][e] = dameimagenParaInit();
			}
		}
	}
	public void saverPosicion(String nomnbre) {
		for(int i = 0; i<4; i++){
			for(int e = 0; e < 3; e++){
				if(tableroAleatorio[i][e].equalsIgnoreCase(nomnbre)){
					posicionFila = e;
					posicionColumna = i;
				}
			}
		}
	}
	public boolean validarMovimientoPuzzle(){
		int posicionFilaTigre12 = 0;
		int posicionColumnaTigre12 = 0;
		for(int i = 0; i<4; i++){
			for(int e = 0; e < 3; e++){
				if(tableroAleatorio[i][e].equalsIgnoreCase("tigre12")){
					posicionFilaTigre12 = e;
					posicionColumnaTigre12 = i;
				}
			}
		}
		if(((posicionFila+1) == posicionFilaTigre12 && posicionColumna ==  posicionColumnaTigre12) || ((posicionFila-1) == posicionFilaTigre12 && posicionColumna ==  posicionColumnaTigre12)){
			// mover el la matrizAleatorio
			String aux = tableroAleatorio[posicionColumna][posicionFila]; 
			if((posicionFila+1) == posicionFilaTigre12){
				tableroAleatorio[posicionColumna][posicionFila+1] = aux;
				tableroAleatorio[posicionColumna][posicionFila] = "tigre12";
			}else{
				tableroAleatorio[posicionColumna][posicionFila-1] = aux;
				tableroAleatorio[posicionColumna][posicionFila] = "tigre12";
			}
			return true;
		}
		if(((posicionColumna+1) == posicionColumnaTigre12 && posicionFila==posicionFilaTigre12) || ((posicionColumna-1) == posicionColumnaTigre12 && posicionFila==posicionFilaTigre12)){
			// mover el la matrizAleatorio
			String aux = tableroAleatorio[posicionColumna][posicionFila]; 
			if((posicionColumna+1) == posicionColumnaTigre12){
				tableroAleatorio[posicionColumna+1][posicionFila] = aux;
				tableroAleatorio[posicionColumna][posicionFila] = "tigre12";
			}else{
				tableroAleatorio[posicionColumna-1][posicionFila] = aux;
				tableroAleatorio[posicionColumna][posicionFila] = "tigre12";
			}
			return true;
		}
		return false;
	}
	public String dameimagenParaInit() {
		int estaImagen = rd.nextInt(listaImagen.size());
		String estaImagenString = listaImagen.get(estaImagen);
		listaImagen.remove(estaImagen);
		return estaImagenString;
	}
	public String dameimagen() {
		String nomFoto = tableroAleatorio[index2][index1];
		if(index1<2){
			index1++;
		}else{
			index1 = 0;
			index2++;
		}
		
		return nomFoto;
	}
	public boolean comprobarTablero() {
		// comprobar con el dobre for comparadondo las dos madrices
		int enPosicion = 0;
		for(int i = 0; i<4; i++){
			for(int e = 0; e < 3; e++){
				if(tableroAleatorio[i][e].equalsIgnoreCase(tableroCorrecto[i][e])){
					enPosicion++;
				}
			}
		}
		if(enPosicion == 12){
			return true;
		}
		return false;
	}
	public void verTablero() {
		for(int i = 0; i<4; i++){
			for(int e = 0; e < 3; e++){
				System.out.print(tableroAleatorio[i][e]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
