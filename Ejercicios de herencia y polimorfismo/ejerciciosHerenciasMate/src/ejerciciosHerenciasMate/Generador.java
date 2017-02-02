package ejerciciosHerenciasMate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generador implements InterMath{
	
	private int cantidad;
	private int cuantosNun;
	private List<Integer> lista;
	private Random rd;
	
	public Generador(int cantidad, int cuantosNun){
		this.cantidad = cantidad;
		this.cuantosNun = cuantosNun;
		rd = new Random();
	}
	
	public ArrayList<Integer> programa(int opcion){

		switch(opcion){
		case 1:
			primo();
			break;
		case 2:
			capicua();
			break;
		case 3:
			suma13();
			break;
		}
		return (ArrayList<Integer>) lista;
	}
	
	@Override
	public void capicua() {
		lista = new ArrayList<Integer>();
		for(int i = cantidad;i>=0;){
			int numero = rd.nextInt(cuantosNun);
			int numeroAnalizar = numero;
			int resto = 0;
			int numeroInvertido =0;
			while(numero!=0){
				resto=numero%10;
				numeroInvertido=numeroInvertido*10+resto;
				numero=numero/10;
			}
			if(numeroAnalizar == numeroInvertido){
				lista.add(numeroAnalizar);
				i--;
			}
		}
	}

	@Override
	public void primo() {
		lista = new ArrayList<Integer>();
		for(int i = 0;i<cantidad;){
			int numero = rd.nextInt(cuantosNun);
			int valorResto = numero%2;
			if(valorResto == 0){
				lista.add(numero);
				i++;
			}
		}
	}

	@Override
	public void suma13() {
		lista = new ArrayList<Integer>();
		int resultado = 0;
		for(int i = 0;i<cantidad;){
			int otroI = rd.nextInt(cuantosNun);
			int numeroAnalizar = otroI;
			resultado = 0;
			while (otroI > 0){
	            resultado += otroI % 10;
	            otroI = otroI / 10;
	        }
			if(resultado == 13){
				lista.add(numeroAnalizar);
				i++;
			}		
			//i++;
		}
	}
}
