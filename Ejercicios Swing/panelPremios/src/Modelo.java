import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Modelo{
	private List<Integer> listaPrimos;
	private final int CUOTA = 35000;
	private Random rd;
	
	public Modelo(){
		rd = new Random();
		listaPrimos = new ArrayList<>();
		
		for(int i = 0; i<CUOTA; i++){
			if(isPrime(i)){
				listaPrimos.add(i);
			}
		}
	}
	public int damePrimo() {
		int esteNumero = rd.nextInt(listaPrimos.size());
		
		return listaPrimos.get(esteNumero);
	}
	private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
}
}
