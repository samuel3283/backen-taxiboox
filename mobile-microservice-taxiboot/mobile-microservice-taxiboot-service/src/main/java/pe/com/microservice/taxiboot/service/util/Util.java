package pe.com.microservice.taxiboot.service.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {


	public final static String PATTERN_DD_MM_YY_HH_MI_SS = "dd/MM/yyyy HH:mm:ss";	
	public final static String PATTERN_DD_MM_YY = "dd/MM/yyyy";	
	public final static String PATTERN_HH_MI_SS = "HH:mm:ss";	
	public final static String PATTERN_HH_MI_AM = "hh:mm a";	
	public final static String PATTERN_DEFAULT = "dd/MM/yyyy";
	public final static String PATTERN_DD_MM_YYYY_TIME = "dd/MM/yyyy HH:mm:ss,SSS";	
	public final static String PATTERN_TIME_HHmmss = "HHmmss";
	public final static String PATTERN_TIME_hhmm_a = "hh:mm a";
	
	public final static String PATTERN_DEFAULT_DDMMYY = "dd-MM-yyyy";
	public final static String PATTERN_DEFAULT_YYMMDD = "yyyy-MM-dd";
	
	public static String getDateToFormat(String dateInString, String formatinput, String formatOutput) {
		
		SimpleDateFormat formatter = new SimpleDateFormat(formatinput);
		String fecha ="";
		 
	    try {
	         Date date = formatter.parse(dateInString);	            
	         fecha = Util.getTimeFormat(date, formatOutput);
	    } catch (ParseException e) {
	            e.printStackTrace();
	    }
	        
		return fecha;
	}


	public static String completar(int numero) {
		
		String valor = String.valueOf(numero);
		if(valor.length()==1)	valor = "00000".concat(valor);
		else if(valor.length()==2)	valor = "0000".concat(valor);
		else if(valor.length()==3)	valor = "000".concat(valor);
		else if(valor.length()==4)	valor = "00".concat(valor);
		else if(valor.length()==5)	valor = "0".concat(valor);
		return valor;
	}

	public static String getDateToFormat(String dateInString) {
		
		SimpleDateFormat formatter = new SimpleDateFormat(Util.PATTERN_DEFAULT_DDMMYY);
		String fecha ="";
		 
	    try {
	         Date date = formatter.parse(dateInString);	            
	         fecha = Util.getTimeFormat(date, Util.PATTERN_DEFAULT_YYMMDD);
	    } catch (ParseException e) {
	            e.printStackTrace();
	    }
	        
		return fecha;
	}
	
	public static String getFechaOperacion(String valor){
		String date=null;
		String day=null;
		String moth=null;
		String year=null;
		String[] d=null;
		if(valor!=null && !valor.isEmpty()){
			try{		
			d=valor.split("/");
			if(d!=null && d.length==3){
				day=d[0];
				moth=getDescripcionMes(d[1]) ;
				year=d[2];
				
				if (day!=null && moth!=null && year!=null){
					date =day +" "+ moth +" " + year;
				}
			}
			} catch (Exception e) {
				date=null;
				//LoggerService.logException("Error DataUtil - getFormatoFechaMail", e);
			}
		}
		return date;
	}

	/**
	 * Metodo Obtener Hora de Operacion en el formato 
	 * @param horaOperacion
	 * @return horaOperacion
	 * @author 
	 * @since 01/03/2017
	 */
	public static String getHoraOperacion(String horaOperacion) {
		SimpleDateFormat sdf;
		DateFormat formatter;
		Date date = new Date();
		try {
			sdf = new SimpleDateFormat(PATTERN_TIME_hhmm_a);
			formatter = new SimpleDateFormat(PATTERN_TIME_HHmmss);
			date = formatter.parse(horaOperacion);
			return sdf.format(date);
		} catch (Exception e) {
			//LoggerService.logException("Error DataUtil - getHoraOperacion", e);
			return null;
		}
	}

	
	/**
	 * M�todo para obtener la descripcion del Mes
	 * @param numero del mes
	 * @return descripcion del mes
	 * @author 
	 * @since 01/03/2017
	 */
	public static String getDescripcionMes(String mes) {
		String descripcionMes = null;
		int m = 0;
		try {
			m = Integer.parseInt(mes);
			switch (m) {
			case 1:
				descripcionMes = "Ene";
				break;
			case 2:
				descripcionMes = "Feb";
				break;
			case 3:
				descripcionMes = "Mar";
				break;
			case 4:
				descripcionMes = "Abr";
				break;
			case 5:
				descripcionMes = "May";
				break;
			case 6:
				descripcionMes = "Jun";
				break;
			case 7:
				descripcionMes = "Jul";
				break;
			case 8:
				descripcionMes = "Ago";
				break;
			case 9:
				descripcionMes = "Sep";
				break;
			case 10:
				descripcionMes = "Oct";
				break;
			case 11:
				descripcionMes = "Nov";
				break;
			case 12:
				descripcionMes = "Dic";
				break;
			default:
				descripcionMes = null;
				break;
			}
		} catch (Exception e) {
			m = 0;
			descripcionMes = null;
			//LoggerService.logException("Error DataUtil - getDescripcionMes", e);
		}
		return descripcionMes;
	}

	public static String getTime(String format) {
	    Date ahora = new Date();
		SimpleDateFormat sm = new SimpleDateFormat(format);
		return sm.format(ahora);
	}

	public static String getTimetoDate(String dateInString) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String fecha ="";
		 
	    try {
	         Date date = formatter.parse(dateInString);	            
	         fecha = Util.getTimeFormat(date, Util.PATTERN_DEFAULT_DDMMYY);
	    } catch (ParseException e) {
	            e.printStackTrace();
	    }
	        
		return fecha;
	}

	public static String getTimeFormat(Date fecha, String format) {
		SimpleDateFormat sm = new SimpleDateFormat(format);
		return sm.format(fecha);
	}
	
	public static String getTime() {
	    Date ahora = new Date();
		SimpleDateFormat sm = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sm.format(ahora);
	}

	public static String completa(String cadena, int rango) {
	    		
		for(int i=0;i<rango;i++) 
			cadena = "0".concat(cadena);

		return cadena;
	}

}
