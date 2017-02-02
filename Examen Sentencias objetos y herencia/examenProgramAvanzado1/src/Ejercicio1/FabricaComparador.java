package Ejercicio1;

public class FabricaComparador {
	
	public static Comparador getComparadorAprobados(){
		return new ComparadorAprobados();
	}
	public static Comparador getComparadorAprobadosyPoblacion(){
		return new ComparadorAprobadosyPoblacion();
	}

	public static Comparador getComparadorAprobadosySexo(){
		return new ComparadorAprobadosySexo();
	}
	public static class ComparadorAprobados implements Comparador {

		@Override
		public boolean comparar(Alumno a, String valor) {
			if(a.getNota() >= 5){
				return true;
			}
			return false;
		}

	}
	public static class ComparadorAprobadosyPoblacion implements Comparador {

		@Override
		public boolean comparar(Alumno a, String valor) {
			
			if(a.getNota() >= 5 && a.getPoblacion().equalsIgnoreCase(valor)){
				return true;
			}
			return false;
		}

	}
	public static class ComparadorAprobadosySexo implements Comparador {

		@Override
		public boolean comparar(Alumno a, String valor) {
			if(a.getNota() >= 5 && a.getSexo().equalsIgnoreCase(valor)){
				return true;
			}
			return false;
		}

	}
}
