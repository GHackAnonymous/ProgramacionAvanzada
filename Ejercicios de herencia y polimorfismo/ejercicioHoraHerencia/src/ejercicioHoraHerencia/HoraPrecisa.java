package ejercicioHoraHerencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HoraPrecisa extends Hora{
	
	private Date hhPrecisa;
	private String horaFormato = "HH:mm:ss";

	public HoraPrecisa(String hh) {
		super(hh);
		try {
			this.hhPrecisa = new SimpleDateFormat(horaFormato).parse(hh);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}
