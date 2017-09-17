package pe.com.microservice.taxiboot.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.com.microservice.taxiboot.core.HeaderRqUtil;
import pe.com.microservice.taxiboot.dao.EquipoRepository;
import pe.com.microservice.taxiboot.model.BeanResponse;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;
import pe.com.microservice.taxiboot.model.HeaderRq;
import pe.com.microservice.taxiboot.model.Paginado;
import pe.com.microservice.taxiboot.model.Pasajero;
import pe.com.microservice.taxiboot.model.Servicio;
import pe.com.microservice.taxiboot.model.TransactionRs;
import pe.com.microservice.taxiboot.service.ConductorService;
import pe.com.microservice.taxiboot.service.EquipoService;
import pe.com.microservice.taxiboot.service.ServicioService;


@RestController
@RequestMapping("/rest")
public class ServiciosController {

	private final Logger logger = LoggerFactory
			.getLogger(ServiciosController.class);

	@Autowired
	private Environment env;

	@Autowired
	private ServicioService servicioService;
	
	@Autowired
	private HeaderRqUtil headerRqUtil;

	@RequestMapping(value ="/service/getService", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<Servicio> getService(
			@RequestHeader HttpHeaders headers/*, @RequestBody Servicio request*/) {
		
		logger.info("getService");
		TransactionRs<Servicio> response = new TransactionRs<Servicio>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			Servicio respuesta = null;

			/*
			if(request.getCodigo()==null){
				logger.info("getService::::"+request.getCodigo());
			}
			*/
			respuesta = servicioService.getServicio(new Servicio());
				
			response.setRespuesta(respuesta);
			
		} catch (Exception e) {
			logger.error("Error getService: ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}

	
	@RequestMapping(value ="/service/listService", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<List<Servicio>> listService(
			@RequestHeader HttpHeaders headers, @RequestBody Paginado request) {
		
		logger.info("listService");
		TransactionRs<List<Servicio>> response = new TransactionRs<List<Servicio>>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			List<Servicio> respuesta = null;
			/*
			if(request.getCodigo()==null){
				logger.info("getService::::"+request.getCodigo());
			}
			*/
			if(request.getPagina()!=null && request.getRango()!=null)
				respuesta = servicioService.listServicio(request);
			else
				respuesta = servicioService.listServicio(new Servicio());
				
			response.setRespuesta(respuesta);
			
		} catch (Exception e) {
			logger.error("Error listService: ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}

	@RequestMapping(value = "/service/getImage", method = RequestMethod.POST, produces = MediaType.IMAGE_PNG_VALUE)
	public @ResponseBody byte[] getImage(@RequestHeader HttpHeaders headers,
			@RequestBody Pasajero request) throws Exception,
			IOException {
		logger.info("Obteniendo imágenes.");

		HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
	
		InputStream in = null;
		byte[] imagen = null;

		try {
			String path = env.getProperty("path.user.dir");
			String pathImgPasajero = path + File.separator + "pasajero";
			String pathImg = pathImgPasajero + File.separator + request.getFoto();
			
			logger.info("Obteniendo imágenes."+pathImg);
			//String pathImg = "C:/Apps/taxiboox/pasajero/"request.getFoto();
			if (pathImg != null && !pathImg.isEmpty()) {
				Path ruta = Paths.get(pathImg);
				in = Files.newInputStream(ruta);
				imagen = IOUtils.toByteArray(in);
			}
			
		} catch (Exception e) {
			logger.error("Error obteniendo imágenes", e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return imagen;
	}

	
}
