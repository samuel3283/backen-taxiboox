package pe.com.microservice.taxiboot.service.util;

public class Demo {

	public static void main(String[] args) {

		try {
			 String cleartext = "982571568-4181831000";
			 System.out.println("Texto encriptado: "+StringEncrypt.encrypt(cleartext));
			 System.out.println("Texto desencriptado: "+StringEncrypt.decrypt(StringEncrypt.encrypt(cleartext)));
			 
		} catch (Exception e) {
			System.out.println("==>"+e.getMessage());
		}
	}

}
