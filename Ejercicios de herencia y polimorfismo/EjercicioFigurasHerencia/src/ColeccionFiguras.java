import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ColeccionFiguras {
	List<Figura> listaFigura;
	
	public ColeccionFiguras(){
		listaFigura = new ArrayList<Figura>();
	}
	public void addCirculo(int puntoX, int PuntoY, String caracteristica, int radio){
		listaFigura.add(new Circulo(puntoX, PuntoY, caracteristica, radio));
	}
	public void addCuadrado(int puntoX, int PuntoY, String caracteristica, int lado){
		listaFigura.add(new Cuadrado(puntoX, PuntoY, caracteristica, lado));
	}
	public void addRectangilo(int puntoX, int PuntoY, String caracteristica, int lado1, int lado2){
		listaFigura.add(new Rectangulo(puntoX, PuntoY, caracteristica, lado1, lado2));
	}
	public void addTriangulo(int puntoX, int PuntoY, String caracteristica, int base, int altura){
		listaFigura.add(new Triangulo(puntoX, PuntoY, caracteristica, base, altura));
	}
	public ArrayList<Figura> mostarfiguras(){
		ArrayList<Figura> copia = new ArrayList<Figura>(listaFigura);
		return copia;
	}
	public void listaOrdenadoArea(){
		Collections.sort(listaFigura, new Comparator<Figura>() {
		    @Override
		    public int compare(Figura f1, Figura f2) {
		        return Double.compare(f1.area(), f2.area());
		    }
		});
	}
	public void listaOrdenadoCordenadas(){
		Collections.sort(listaFigura, new Comparator<Figura>() {
		    @Override
		    public int compare(Figura f1, Figura f2) {
		        return Double.compare((f1.getPuntoX()+f1.getPuntoY()),(f2.getPuntoX()+f2.getPuntoY()));
		    }
		});
	}
}
