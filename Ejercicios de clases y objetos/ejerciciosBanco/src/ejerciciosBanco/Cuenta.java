package ejerciciosBanco;

import java.util.Arrays;

public class Cuenta {
	private int numeroCuenta[];
	private String titulo;
	private int saldo;
	
	public Cuenta(int[] numeroCuenta, String titulo, int saldo){
		this.numeroCuenta = numeroCuenta;
		this.titulo = titulo;
		this.saldo = saldo;
	}
	
	public int meterDinero(int dinero){
		saldo = saldo + dinero;
		return saldo;
	}
	
	public int sacarSaldo(int dinero){
		if(saldo > dinero){
			saldo = saldo - dinero;
			return saldo;
		}
		return 0;
	}
	public int verSaldo(){
		return saldo;
	}

	@Override
	public String toString() {
		return "Cuenta -> " + Arrays.toString(numeroCuenta) +"\n"+
				"Titular -> " + titulo + "\n"+
				"Saldo de la cuenta -> " + saldo + "\n";
	}
	
}
