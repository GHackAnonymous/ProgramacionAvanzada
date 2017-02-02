package ejerciciosZodiaco;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Zodiaco_PruebaEjiciencia_fallida {
	private Date  fecha;
	private final String OFIUCO = "ofiuco"; //30 novi a 18 dicien
	private final String SAGITARIO = "sagitario"; // 19 dicien a 20 enero
	private final String CAPRICORNIO = "capricornio"; // 21 enero a 16 febre
	private final String ACUARIO = "acuario"; //17 febre al 12 marzo
	private final String PISCIS = "piscis"; //13 marzo al 18 abril
	private final String ARIES = "aries"; //19 abril al 14 mayo
	private final String TAURO = "tauro"; // 15 mayo al 21 jinio
	private final String GEMINIS = "geminis"; // 22 linio  al 20 jilio
	private final String CANCER = "cancer";//21 jilio al 10 agosto
	private final String LEO = "leo";//11 agosto al 16 setiembre
	private final String VIRGO = "virgo";//17 setiembre al 31 octubre
	private final String LIBRA = "libra";//1 de novienbre al 23 noviembre
	private final String ESCORPIO = "escorpio"; //24 noviembre al 29 noviembre
	private final int TOTALSIG = 13; 
	
	private String[] nombreSignos = {
									"DATEOFIUCOINI",
									"DATEOFIUCOACABA",
									"DATESAGITARIOINI",
									"DATESAGITARIOACABA", 
									"DATEAPRICORNIOINI",
									"DATEAPRICORNIOACABA",
									"DATEACUARIOINI",
									"DATEACUARIOACABA", 
									"DATEPISCISINI",
									"DATEPISCISACABA",  
									"DATEARIESINI",  
									"DATEARIESACABA",  
									"DATETAUROINI",  
									"DATETAUROACABA",  
									"DATEGEMINISINI",  
									"DATEGEMINISACABA",
									"DATECANCERINI",  
									"DATECANCERACABA", 
									"DATELEOINI",  
									"DATELEOACABA",  
									"DATEVIRGOINI", 
									"DATEVIRGOACABA",
									"DATELIBRAINI",
									"DATELIBRAACABA",  
									"DATEESCORPIOINI",
									"DATEESCORPIOACABA"};
	
	SimpleDateFormat sdf;
	private final Date DATEOFIUCOINI; 
	private final Date DATEOFIUCOACABA; 
	private final Date DATESAGITARIOINI; 
	private final Date DATESAGITARIOACABA; 
	private final Date DATEAPRICORNIOINI; 
	private final Date DATEAPRICORNIOACABA;
	private final Date DATEACUARIOINI; 
	private final Date DATEACUARIOACABA; 
	private final Date DATEPISCISINI;  
	private final Date DATEPISCISACABA;  
	private final Date DATEARIESINI;  
	private final Date DATEARIESACABA;  
	private final Date DATETAUROINI;  
	private final Date DATETAUROACABA;  
	private final Date DATEGEMINISINI;  
	private final Date DATEGEMINISACABA;
	private final Date DATECANCERINI;  
	private final Date DATECANCERACABA; 
	private final Date DATELEOINI;  
	private final Date DATELEOACABA;  
	private final Date DATEVIRGOINI; 
	private final Date DATEVIRGOACABA;
	private final Date DATELIBRAINI;
	private final Date DATELIBRAACABA;  
	private final Date DATEESCORPIOINI;
	private final Date DATEESCORPIOACABA;  
	
	public Zodiaco_PruebaEjiciencia_fallida(Date  fecha) throws ParseException{
		 this.fecha = fecha;
		 sdf = new SimpleDateFormat("MM-dd"); 
		 DATEOFIUCOINI = sdf.parse("11-30"); 
		 DATEOFIUCOACABA = sdf.parse("12-18"); 
		 DATESAGITARIOINI = sdf.parse("12-19"); 
		 DATESAGITARIOACABA = sdf.parse("01-20"); 
		 DATEAPRICORNIOINI = sdf.parse("01-21"); 
		 DATEAPRICORNIOACABA = sdf.parse("02-16");
		 DATEACUARIOINI = sdf.parse("02-17"); 
		 DATEACUARIOACABA = sdf.parse("03-12"); 
		 DATEPISCISINI = sdf.parse("03-13");  
		 DATEPISCISACABA = sdf.parse("04-18");  
		 DATEARIESINI = sdf.parse("04-19");  
		 DATEARIESACABA = sdf.parse("05-14");  
		 DATETAUROINI = sdf.parse("05-15");  
		 DATETAUROACABA = sdf.parse("06-21");  
		 DATEGEMINISINI = sdf.parse("06-22");  
		 DATEGEMINISACABA = sdf.parse("07-20");
		 DATECANCERINI = sdf.parse("07-21");  
		 DATECANCERACABA = sdf.parse("08-10"); 
		 DATELEOINI = sdf.parse("08-11");  
		 DATELEOACABA = sdf.parse("09-16");  
		 DATEVIRGOINI = sdf.parse("09-17"); 
		 DATEVIRGOACABA = sdf.parse("10-31");
		 DATELIBRAINI = sdf.parse("11-01");
		 DATELIBRAACABA = sdf.parse("11-23");  
		 DATEESCORPIOINI = sdf.parse("11-24");
		 DATEESCORPIOACABA = sdf.parse("11-29");   
	}
	public String saberSignoZodiaco(){
		/*for(String sig : nombreSignos){
			if(fecha.equals("DATE"+sig+"INI") || 
			   fecha.after("DATE"+sig+"INI") && fecha.before("DATE"+sig+"CABA") ||
			   fecha.equals("DATE"+sig+"CABA")){
					return sdf.parse(sig);
			}
		}*/
		return null;
	}
}
