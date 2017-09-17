package pe.com.microservice.taxiboot.service.util;

import java.io.File;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Demo {

	public static void main(String[] args) {
		
		String fecha="10/07/2017 14:33:27";
		System.out.println("===>"+Util.getDateToFormat(fecha,Util.PATTERN_DD_MM_YY_HH_MI_SS,Util.PATTERN_HH_MI_AM));
		System.out.println("===>"+Util.getDateToFormat(fecha,Util.PATTERN_DD_MM_YY_HH_MI_SS,Util.PATTERN_DD_MM_YY));

		// TODO Auto-generated method stub
		InitialContext ctx;
		String fileName = null;
	    System.out.println("dato:"+File.separator+"XXXX");
		 
		try {
		    ctx = new InitialContext();
		    fileName = (String) ctx.lookup("pathlogo");
		    System.out.println("dato:"+fileName);
		   }
		catch (NamingException e) {
		    System.out.println("error:"+e.getMessage());
		}
		
	}

}
