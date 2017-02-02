public class Modelo{
	
	private double resultado;
	
	
	public Modelo(){
		resultado = 0;
	}
	public void reset(){
		resultado = 0;
	}
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double valor) {
		this.resultado = valor;
	}
	public void calcular(double valor, String op){
		switch(op){
			case "+":
				this.suma(valor);
				break;
			case "-":
				this.resta(valor);
				break;
			case "*":
				this.multiplicar(valor);
				break;
			case "/":
				this.dividir(valor);
				break;
		}
	}
	private void suma(double valor){
		resultado += valor;
	}
	private void resta(double valor){
		resultado -= valor;
	}
	private void multiplicar(double valor){
		resultado *= valor;
	}
	private void dividir(double valor){
		resultado /= valor;
	}
}
