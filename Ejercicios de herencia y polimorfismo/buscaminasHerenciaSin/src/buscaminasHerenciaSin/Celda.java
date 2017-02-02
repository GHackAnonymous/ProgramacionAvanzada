package buscaminasHerenciaSin;

public class Celda {
	private Mina mina;
	//private int numMinasRededor;
	
	public Celda(){
		//mina = new Mina();
		//numMinasRededor = 0;
	}
	
	public void meterMina(Mina mina){
		this.mina = mina;
	}
	public boolean hayMina(int pHorizontal, int pVertical){
		if(this.mina == null){
			return false;
		}else{
			return true;
		}
	}
	public void neutalizarMina(){
		mina = null;
	}
}
