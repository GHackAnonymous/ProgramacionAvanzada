package bonolotoClases;

public class Bonoloto {
	
	
	Boleto[] boletos;
	Boleto boletoGanador;
	final int NUMNUMBOLETOS = 6;
	
	public Bonoloto(int cantidad){
		boletos = new Boleto[cantidad];
		boletoGanador = new Boleto();
	}
	
	public int[] comprobar(int boletoAcomprobar){
		int numerosGanadores[] = new int[NUMNUMBOLETOS];
		for (int i = 0;i < numerosGanadores.length; i++){
			numerosGanadores[i] = -1;
		}
		
		int[] tuBonoloto = boletos[boletoAcomprobar].getBoleto();
		
		for (int i = 0;i < tuBonoloto.length; i++){
			for (int e = 0;e < tuBonoloto.length; e++){
				if(boletoGanador.boleto[i] == tuBonoloto[e]){
					numerosGanadores[i] = tuBonoloto[e];
				}
			}
		}
		return numerosGanadores;
	}

	public Boleto[] getBoletos() {
		return boletos;
	}
	public void setBoletos(Boleto[] boletos) {
		this.boletos = boletos;
	}

	public Boleto getBoletoGanador() {
		return boletoGanador;
	}

	public void setBoletoGanador(Boleto boletoGanador) {
		this.boletoGanador = boletoGanador;
	}
	
}
