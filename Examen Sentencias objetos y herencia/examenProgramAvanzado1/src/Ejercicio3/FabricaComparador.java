package Ejercicio3;

public class FabricaComparador {
	
	public static Comparador getComparadorAprobadosyPoblacion(){
		return new ComparadorAprobadosyPoblacion();
	}

	public static class ComparadorAprobadosyPoblacion implements Comparador {

		@Override
		public boolean comparar(Alumno a, String valor) {
			
			if(a.getPoblacion().equalsIgnoreCase(valor)){
				return true;
			}
			return false;
		}

	}
}
