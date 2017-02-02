
public class Torre {
	
	public Torre(){}

	//debuggear por que no tengo todas con migo que las condiciones esten vien
	/*
	 * 1.- si las cordenadas si las cordenadas son menores que 7 para no salirse del tablero
	 * 
	 * 2.- si las cordenaras primeras son iguales entonces siempre esta en esa fila
	 * 
	 * 3.- si las cordenaras segundas son diferentes entonces de muebe de fila por que 
	 * no se puede quedar en la misma fila
	 * 
	 * 4.- mirar si va hacia alante o hacia atras
	 * 
	 * 5.- comprovar que la resta enrte cordenadas de menor a las cordenada nuevas 
	 * para ver si hay posiciones para moverse
	 * */
	
	final int COORDENADASVERTICAL = 1;
	final int COORDENADASHORIZONTOAL = 0;
	final int MAXCASILLASTABLERO = 8;
	
	public boolean movimientoValido(int opcionMenu ,
			int numCasillas ,int coordenadasActuales[]){
		
		boolean validez = false;
		int casillas = 0;
		
		switch (opcionMenu){
			case 1:
				casillas = coordenadasActuales[COORDENADASVERTICAL]
						+ numCasillas;
				if(casillas < MAXCASILLASTABLERO){
					validez = true;
				}
			break;
			case 2:
				casillas = coordenadasActuales[COORDENADASVERTICAL]
						- numCasillas;
				if(casillas > 0){
					validez = true;
				}
			break;
			case 3:
				casillas = coordenadasActuales[COORDENADASHORIZONTOAL]
						+ numCasillas;
				if(casillas < MAXCASILLASTABLERO){
					validez = true;
				}
			break;
			case 4:
				casillas = coordenadasActuales[COORDENADASHORIZONTOAL]
						- numCasillas;
				if(casillas > 0){
					validez = true;
				}
			break;
			default:
			break;
		}
		
		return validez;
	}
	
}
