public class Modelo{
	private double resultado = 0.0;
	
	public Modelo(){
	}
	public double conversionCelsius(double valor) {
		resultado = 0.0;
		resultado = 5*((valor-32)/9);
		
		return resultado;
	}
	public double conversionFarenheit(double valor) {
		resultado = 0.0;
		resultado = 32+((9*valor)/5);
		
		return resultado;
	}
}
