import java.util.Random;
import java.util.Scanner;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EjerciciosSentencias {
	
	Scanner teclado = new Scanner(System.in);
	
	public void ParInpar () {
		
		System.out.print("Introduce un numero: ");
		int numero = teclado.nextInt();
		
		int resultado = numero % 2;
		
		if(resultado == 0){
			System.out.println("Par");
		}else{
			System.out.println("Inpar");
		}
	}
	
	public void Inpar10 () {
		
		for(int i = 0; i <= 10; i++){
		
			int resultado = i % 2;
		
			if(resultado != 0){
				System.out.print(i+" ");
			}
		}
	}
	
	public void SumaPar10 () {
		
		int resultadoFinal = 0;
		
		for(int i = 0; i <= 10; i++){
		
			int resultado = i % 2;
			
			if(resultado == 0){
				resultadoFinal += i;
			}
		}
		System.out.print("Resultado es: "+ resultadoFinal);
	}
	
	public void Primo () {
		
		//Scanner teclado2 = new Scanner(System.in);
		System.out.println("Instroduce un numero: ");
		
		int numero = teclado.nextInt();
		
		int resultado = 0;
		int i = 2;
		for (i = 2; i < numero;i++ ){
			resultado = 0;
			resultado = numero % i;
			if(resultado == 0){
				System.out.println("No es primo");
				break;
			}
		}
		
		if (i == numero){
			System.out.println("Es primo");
		}
		
	}
	
	public void Inversa() {
		System.out.println("Instroduce un numero: ");
		
		int[] numero = new int[10];
		for (int a = 0; a < numero.length; a++){
			numero[a] = teclado.nextInt();
		}
		
		
		for (int i = numero.length-1; i >= 0; i--){
			System.out.print(numero[i] + " ");
		}
		
	}
	
	public void Media() {
		
		int[] numero = new int[10];
		for (int a = 0; a < numero.length; a++){
			System.out.println("Instroduce un numero: ");
			numero[a] = teclado.nextInt();
		}
		
		int suma = 0;
		for (int i = 0; i < numero.length; i++){
			suma += numero[i];
		}
		
		int media = suma / (numero.length+1);
		
		for (int e = 0; e < numero.length;e++){
			if(e < media){
				System.out.print(" "+numero[e]);
			}
		}
	}
	
	public void Repetidos(){
		
		int[] numeros = new int[10];
		for (int i = 0; i < numeros.length; i++){
			System.out.println("Instroduce un numero por encima del 0: ");
			numeros[i] = teclado.nextInt();
		}
		
		int[] numerosNoRepetidos = new int[10];
		for (int i = 0;i < numerosNoRepetidos.length; i++){
			numerosNoRepetidos[i] = -1;
		}
		
		boolean repetido = true;
		for (int i = 0;i < numeros.length; i++){
			numerosNoRepetidos[i] = numeros[i];
			for (int e = 0;e < numeros.length; e++){ 
				if(i == e){
					continue;
				}
				if(numerosNoRepetidos[i] == numeros[e]){
					repetido = false;
					break;
				}
			}
			
			if(repetido == false){
				numerosNoRepetidos[i] = -1; 
				repetido = true;
			}
	
		}
		for (int i = 0;i < numerosNoRepetidos.length; i++){
			if(numerosNoRepetidos[i] != -1){
				System.out.print(numerosNoRepetidos[i]+" ");
			}
		}
		
	}
	
	public void Bonoloto(){
		
		int[] tuBonoloto = new int[6];
		for (int i = 0; i < tuBonoloto.length; i++){
			System.out.println("Instroduce un numero "+i+" de tu cupon: ");
			tuBonoloto[i] = teclado.nextInt();
		}
		
		int[] bonolotoGanador = new int[6];
		int[] numerosPremiados = new int[6];
		for (int i = 0;i < numerosPremiados.length; i++){
			numerosPremiados[i] = -1;
		}
		
		
		Random rd = new Random();
		for (int i = 0;i < bonolotoGanador.length; i++){
			bonolotoGanador[i] = rd.nextInt(10);
		}
		
		for (int i = 0;i < tuBonoloto.length; i++){
			for (int e = 0;e < tuBonoloto.length; e++){
				if(bonolotoGanador[i] == tuBonoloto[e]){
					numerosPremiados[i] = tuBonoloto[e];
				}
			}
		}
		for (int i = 0;i < numerosPremiados.length; i++){
			if(numerosPremiados[i] != -1){
				System.out.print(numerosPremiados[i]+" ");
			}
		}
		
	}
	
	
	public void Fecha(){


    	int[] numerosFecha = new int[3];
    	
			System.out.println("Instroduce el  dia Ej(3): ");
			numerosFecha[0] = teclado.nextInt();
			
			System.out.println("Instroduce el  mes Ej(12): ");
			numerosFecha[1] = teclado.nextInt();
			
			System.out.println("Instroduce el  año Ej(1993): ");
			numerosFecha[2] = teclado.nextInt();
		

	    	try{
	    		
	    		LocalDate printfecha = LocalDate.of(numerosFecha[2], numerosFecha[1], numerosFecha[0]);
	            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	            System.out.println(formato.format(printfecha));
				
	    	}catch (DateTimeException e){
	    		System.err.println("Fecha no valida");
	    		
	    	};
	
	}

	

	public static void main(String[] args) {

		EjerciciosSentencias programa = new EjerciciosSentencias();
		programa.ParInpar();
		System.out.println();
		programa.Inpar10();
		System.out.println();
		programa.SumaPar10();
		System.out.println();
		programa.Primo();
		System.out.println();
		programa.Inversa();
		System.out.println();
		programa.Media();
		System.out.println();
		programa.Repetidos();
		System.out.println();
		programa.Bonoloto();
		System.out.println();
		programa.Fecha();
		
	}

}