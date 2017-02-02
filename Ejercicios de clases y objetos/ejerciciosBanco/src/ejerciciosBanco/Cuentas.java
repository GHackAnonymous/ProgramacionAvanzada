package ejerciciosBanco;

public class Cuentas {
	final int MAXNUMEROSCUENTAS = 100;
	private int numCuentas;
	private Cuenta[] cuentas;
	private int ultimacuenta;
	
	public Cuentas(){
		this.numCuentas++;
		cuentas = new Cuenta[MAXNUMEROSCUENTAS];
		this.ultimacuenta = 0;
	}
	public boolean comprobarNumCuentas (int numCuentasAcomprobar){
		return (numCuentasAcomprobar < MAXNUMEROSCUENTAS);
	}
	public void meterCuenta(String titulo, int numeroCuenta[], int saldo){
		Cuenta newCuenta = new Cuenta(numeroCuenta,titulo,saldo);
		cuentas[this.ultimacuenta] = newCuenta;
		this.ultimacuenta++;
	}
	public int ingresarSaldo(int queCuenta, int cantidad){
		return (cuentas[queCuenta].meterDinero(cantidad));	
	}
	public int sacarSaldo(int queCuenta, int cantidad){
		return (cuentas[queCuenta].sacarSaldo(cantidad));	
	}
	public int VerSaldo(int queCuenta){
		return (cuentas[queCuenta].verSaldo());	
	}
	public int tranferencia(int deQueCuenta, int aQueCuenta, int cantidad){
		 cuentas[deQueCuenta].sacarSaldo(cantidad);
		 int saldoTodalEnCienta = cuentas[aQueCuenta].meterDinero(cantidad);
		 
		 return cantidad; //El sando que se a ingresado
	}
	public Cuenta[] getCuentas(){
		int cantidad = numCuentas;
		Cuenta[] copia = new Cuenta[++cantidad];
		System.arraycopy(cuentas, 0, copia, 0, cantidad);
		
		return copia;
	}
}
