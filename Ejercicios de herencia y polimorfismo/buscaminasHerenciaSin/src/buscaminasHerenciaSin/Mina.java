package buscaminasHerenciaSin;

public class Mina {
	private int posicionHorizontal;
	private int posicionVertical;
	
	//public Mina(){}
	public Mina(int horizontal, int vertical){
		this.posicionHorizontal = horizontal;
		this.posicionVertical = vertical;
	}
	public boolean comprobar(int horizontal, int vertical){
		if(this.posicionHorizontal == horizontal){
			if(this.posicionVertical == vertical){
				return true;
			}
		}
		return false;
	}
}
