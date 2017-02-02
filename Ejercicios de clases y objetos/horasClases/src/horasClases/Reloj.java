package horasClases;

public class Reloj {
	
	private int h1 = 0;
	private int h2 = 0;
	
	public Reloj(){}
	
	public int minutos(){
		
		int horas = 0;
		
		if (h1 < h2){
			horas = h2 - h1;
		}else{
			horas = h1 - h2;
		}
		int minutos = horas * 60;
		
		return minutos;
	}
	
	public int getH1() {
		return h1;
	}
	public void setH1(int h1) {
		this.h1 = h1;
	}
	public int getH2() {
		return h2;
	}
	public void setH2(int h2) {
		this.h2 = h2;
	}
}
