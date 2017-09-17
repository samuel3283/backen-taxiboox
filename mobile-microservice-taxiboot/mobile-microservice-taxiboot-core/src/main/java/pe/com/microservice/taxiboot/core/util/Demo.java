package pe.com.microservice.taxiboot.core.util;

public class Demo {

	public static void main(String[] args) {

		String fecha = "10/07/2017 14:20:45";
		String fechaMes = pe.com.microservice.taxiboot.core.util.Util.getDateToFormat(fecha,Util.PATTERN_DD_MM_YY_HH_MI_SS,Util.PATTERN_TIME_MM);
		String fechaAnio = pe.com.microservice.taxiboot.core.util.Util.getDateToFormat(fecha,Util.PATTERN_DD_MM_YY_HH_MI_SS,Util.PATTERN_TIME_YYYY);
		String mes = Util.getDescripcionMes(fechaMes);
		
		System.out.println("==>fechaMes:"+fechaMes+"==>fechaAnio:"+fechaAnio+"==>mes:"+mes);
		
	}

}
