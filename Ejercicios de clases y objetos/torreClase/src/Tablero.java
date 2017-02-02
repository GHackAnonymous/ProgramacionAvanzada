
public class Tablero {
	private int tablero [][] = new int[8][8];
	private int cordenadas[] = new int[2];
	
	final int MAXCASILLASTABLERO = 8;
	
	public Tablero(){
		for (int i1= 0; i1 < MAXCASILLASTABLERO; i1++){
			for(int i2 = 0; i2 < MAXCASILLASTABLERO; i2++){
				tablero[i1][i2] = 0;
			}
		}
		tablero[0][0] = 1;
	}
	
	public int[] cordenadasActuales(){
		for (int i1= 0; i1 < MAXCASILLASTABLERO; i1++){
			for(int i2 = 0; i2 < MAXCASILLASTABLERO; i2++){
				if(tablero[i1][i2] == 1){
					cordenadas[0] = i1;
					cordenadas[1] = i2;
					break;
				}
			}
		}
		return cordenadas;
	}
	
	public int[][] mostar() {
		
		int copia[][] =
				new int[MAXCASILLASTABLERO][MAXCASILLASTABLERO];
		
		for (int i1= 0; i1 < MAXCASILLASTABLERO; i1++){
			for(int i2 = 0; i2 < MAXCASILLASTABLERO; i2++){
				copia[i1][i2] = tablero[i1][i2];
			}
		}
		return copia;
	}
	
	public void mover(int opcionMenu,int numCalillas){
		for (int i1= 0; i1 < MAXCASILLASTABLERO; i1++){
			for(int i2 = 0; i2 < MAXCASILLASTABLERO; i2++){
				if(tablero[i1][i2] == 1){
					switch(opcionMenu){
						case 1:
							tablero[i1][i2] = 0;
							tablero[i1][i2+numCalillas] = 1;
							opcionMenu = 0;
						break;
						case 2:
							tablero[i1][i2] = 0;
							tablero[i1][i2-numCalillas] = 1;
							opcionMenu = 0;
						break;
						case 3:
							tablero[i1][i2] = 0;
							tablero[i1+numCalillas][i2] = 1;
							opcionMenu = 0;
						break;
						case 4:
							tablero[i1][i2] = 0;
							tablero[i1-numCalillas][i2] = 1;
							opcionMenu = 0;
						break;
						default:
						break;
					}
					break;
				}
			}
		}
	}
	
	public int[][] getTablero() {
		return tablero;
	}

	public void setTablero(int[][] tablero) {
		this.tablero = tablero;
	}

	public int[] getCordenadas() {
		return cordenadas;
	}

	public void setCordenadas(int[] cordenadas) {
		this.cordenadas = cordenadas;
	}
}
