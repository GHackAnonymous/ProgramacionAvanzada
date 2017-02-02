import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Modelo2{
	private List<Integer> listaPrimos;
	private final int CUOTA = 35000; //35000
	private final int CATIDADBOTONES = 36;
	private Random rd;
	
	public Modelo2(){
		rd = new Random();
		listaPrimos = new ArrayList<>();
		
		/*for(int i = 0; i<CATIDADBOTONES; i++){
			listaPrimos.add(rd.nextInt(CUOTA));
		}*/
		
		for(int i = 0; i<CATIDADBOTONES; i++){
			if(rd.nextBoolean()){
				listaPrimos.add(rd.nextInt(CUOTA));
			}else{
				listaPrimos.add(0);
			}
		}
		
	}
	public int damePrimo() {
		int esteNumero = rd.nextInt(listaPrimos.size());
		
		return listaPrimos.get(esteNumero);
	}

}
