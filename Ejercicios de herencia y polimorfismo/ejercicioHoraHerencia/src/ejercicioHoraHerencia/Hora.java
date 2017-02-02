package ejercicioHoraHerencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hora implements Comparable<Hora>{
	private Date hh;
	private String horaFormato = "HH:mm";

	public Hora(String hh){
		try {
			this.hh = new SimpleDateFormat(horaFormato).parse(hh);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	 @Override
     public int compareTo(Hora h){
		if(h.hh.after(this.hh)){
			return -1;
		}else if(h.hh.before(this.hh)){
			return 1;
		}
		return 0;
	}
	public Date getHh() {
		return hh;
	}
	public void setHoraFormato(String horaFormato) {
		this.horaFormato = horaFormato;
	}
}
