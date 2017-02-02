package buscaminasHerenciaSin;

import java.util.Random;

public class Tablero {
	final int DINTABLERO = 10;
	final int NUMMINAS = 20;
	final int DIMESIONTABLERO = 9;
	Celda[][] tablero;
	Random rd;
	int numMinas = 0;
	
	public Tablero(){
		tablero = new Celda[DINTABLERO][DINTABLERO];
		rd = new Random();
	}
	public void InicializarTableroA0(){
		for(int i = 0; i < DINTABLERO; i++){
			for(int e = 0; e < DINTABLERO; e++){
				tablero[i][e] = new Celda();
			}
		}
	}
	/*public void monstarTablero(){ // esto es probisional
		for(int i = 0; i < DINTABLERO; i++){
			for(int e = 0; e < DINTABLERO; e++){
				if(tablero[i][e].hayMina(i, e) == true){
					System.out.print("1 ");
				}else{
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}*/
	public int obtenerRandom(){
		return rd.nextInt(DINTABLERO);
	}
	public void InicializarMinas(){
		for(int i = 0; i < NUMMINAS; i++){
			int posicionHorizontal = obtenerRandom();
			int posicionVertical = obtenerRandom();
			if(tablero[posicionHorizontal][posicionVertical].hayMina(posicionHorizontal, posicionVertical) == false){
					tablero[posicionHorizontal][posicionVertical].meterMina(new Mina(posicionHorizontal, posicionVertical));
					numMinas++;
			}else{
				i--;
			}
		}
	}
	public boolean comprobarSiTieneMina(int pHorizontal, int pVertical){
		boolean hayMina = tablero[pHorizontal][pVertical].hayMina(pHorizontal, pVertical);
		if(hayMina != true){
			return false;
		}else{
			return true;
		}
	}
	public int comprobarMinaCercanas(int pHorizontal, int pVertical){
		return cuantasMinas(pHorizontal, pVertical);
	}
	public int comprobarIf(int pHorizontal,int pVertical){
		if(tablero[pHorizontal][pVertical].hayMina(pHorizontal, pVertical) != false){
			return 1;
		}
		return 0;
	}
	public int neutralizarMina(int horizontal, int vertical) {
		tablero[horizontal][vertical].neutalizarMina();
		numMinas--;
		return numMinas;
	}
	public int cuantasMinas(int pHorizontal, int pVertical) {
		int countMinas  = 0;
		if(pHorizontal>0 && pHorizontal<DIMESIONTABLERO && pVertical>0 && pVertical<DIMESIONTABLERO ){
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical);
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical);
			countMinas = countMinas + comprobarIf(pHorizontal, pVertical+1);
			countMinas = countMinas + comprobarIf(pHorizontal, pVertical-1);
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical+1);
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical-1);
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical+1);
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical-1);
		}else if(pHorizontal == 0 && pVertical>0 && pVertical<DIMESIONTABLERO){
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical);
			countMinas = countMinas + comprobarIf(pHorizontal, pVertical+1);
			countMinas = countMinas + comprobarIf(pHorizontal, pVertical-1);
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical+1);
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical-1);
		}else if(pHorizontal == 0 && pVertical == 0){
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical);
			countMinas = countMinas + comprobarIf(pHorizontal, pVertical+1);
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical+1);
		}else if(pHorizontal == 0 && pVertical == DIMESIONTABLERO){
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical);
			countMinas = countMinas + comprobarIf(pHorizontal, pVertical-1);
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical-1);
		}else if(pHorizontal == DIMESIONTABLERO && pVertical == 0){
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical);
			countMinas = countMinas + comprobarIf(pHorizontal, pVertical+1);
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical+1);
		}else if(pHorizontal == DIMESIONTABLERO && pVertical == DIMESIONTABLERO){
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical);
			countMinas = countMinas + comprobarIf(pHorizontal, pVertical-1);
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical-1);
		}else if(pHorizontal == DIMESIONTABLERO && pVertical>0 && pVertical<DIMESIONTABLERO){
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical);
			countMinas = countMinas + comprobarIf(pHorizontal, pVertical+1);
			countMinas = countMinas + comprobarIf(pHorizontal, pVertical-1);
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical-1);
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical+1);
		}else if(pHorizontal>0 && pHorizontal<DIMESIONTABLERO && pVertical == 0){
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical);
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical);
			countMinas = countMinas + comprobarIf(pHorizontal, pVertical+1);
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical+1);
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical+1);
		}else if(pHorizontal>0 && pHorizontal<DIMESIONTABLERO && pVertical == DIMESIONTABLERO){
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical);
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical);
			countMinas = countMinas + comprobarIf(pHorizontal, pVertical-1);
			countMinas = countMinas + comprobarIf(pHorizontal-1, pVertical-1);
			countMinas = countMinas + comprobarIf(pHorizontal+1, pVertical-1);
		}
		return countMinas;
	}
}
