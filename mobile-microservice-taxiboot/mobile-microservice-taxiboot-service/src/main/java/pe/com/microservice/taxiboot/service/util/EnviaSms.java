package pe.com.microservice.taxiboot.service.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class EnviaSms {

	public void sendSms() {
		
		//Se fija el tiempo m´aximo de espera para conectar con el servidor (5000)
		//Se fija el tiempo m´aximo de espera de la respuesta del servidor (60000)
		RequestConfig config = RequestConfig.custom()
		.setConnectTimeout(5000)
		.setSocketTimeout(60000)
		.build();
		//Se inicia el objeto HTTP
		HttpClientBuilder builder = HttpClientBuilder.create();
		builder.setDefaultRequestConfig(config);
		CloseableHttpClient httpClient = builder.build();
		//Se fija la URL sobre la que enviar la petici´on POST
		//Como ejemplo la petici´on se env´ıa a www.altiria.net/sustituirPOSTsms
		//Se debe reemplazar la cadena ’/sustituirPOSTsms’ por la parte correspondiente
		//de la URL suministrada por Altiria al dar de alta el servicio
		//HttpPost post = new HttpPost("http://www.altiria.net/sustituirPOSTsms");
		HttpPost post = new HttpPost("http://www.altiria.net/api/http");
		/*
		 domainId: demopr
login: samuel3283
passwd: nfbrppau
senderId (remitente opcional): NO disponible, no utilizar
		 */

		int numeroAleatorio = (int) (Math.random()*999998+1);		
		String sms = Util.completar(numeroAleatorio);
		String mensaje="Bienvenido su c&oacute;digo de verificación es "+sms+"";
		 
		//Se crea la lista de par´ametros a enviar en la petici´on POST
		List<NameValuePair> parametersList = new ArrayList <NameValuePair>();
		//XX, YY y ZZ se corresponden con los valores de identificaci´on del
		//usuario en el sistema.
		parametersList.add(new BasicNameValuePair("cmd", "sendsms"));
		parametersList.add(new BasicNameValuePair("domainId", "demopr"));
		parametersList.add(new BasicNameValuePair("login", "samuel3283"));
		parametersList.add(new BasicNameValuePair("passwd", "nfbrppau"));
		parametersList.add(new BasicNameValuePair("dest", "51982571568"));
		//parametersList.add(new BasicNameValuePair("dest", "346yyyyyyyy"));
		parametersList.add(new BasicNameValuePair("msg", mensaje));
		//Remitente autorizado por Altiria al dar de alta el servicio.
		//Omitir el parametro si no se cuenta con ninguno.
		//parametersList.add(new BasicNameValuePair("senderId", "remitente"));
		
		try {
			//Se fija la codificacion de caracteres de la peticion POST
			post.setEntity(new UrlEncodedFormEntity(parametersList,"UTF-8"));
			}
			catch(UnsupportedEncodingException uex) {
			System.out.println("ERROR: codificaci´on de caracteres no soportada");
			}
			CloseableHttpResponse response = null;
			try {
				System.out.println("Enviando petici´on");
				//Se env´ıa la petici´on
				response = httpClient.execute(post);
				//Se consigue la respuesta
				String resp = EntityUtils.toString(response.getEntity());
				//Error en la respuesta del servidor
				if (response.getStatusLine().getStatusCode()!=200){
				System.out.println("ERROR: C´odigo de error HTTP: " + response.getStatusLine().getStatusCode());
				System.out.println("Compruebe que ha configurado correctamente la direccion/url ");
				System.out.println("suministrada por Altiria");
				return;
				}else {
				//Se procesa la respuesta capturada en la cadena ’response’
				if (resp.startsWith("ERROR")){
				System.out.println(resp);
				System.out.println("C´odigo de error de Altiria. Compruebe las especificaciones");
				} else
				System.out.println(resp);
				}
				}
				catch (Exception e) {
				System.out.println("Excepcion"+e.getMessage());
				e.printStackTrace();
				return;
				}
	
			finally {
				//En cualquier caso se cierra la conexi´on
				post.releaseConnection();
				if(response!=null) {
				try {
				response.close();
				}
				catch(IOException ioe) {
				System.out.println("ERROR cerrando recursos"+ioe.getMessage());
				}
				}
				}				
			}
		

}
