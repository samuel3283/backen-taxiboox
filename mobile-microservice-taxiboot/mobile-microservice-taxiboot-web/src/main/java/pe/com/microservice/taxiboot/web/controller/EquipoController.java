package pe.com.microservice.taxiboot.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import pe.com.microservice.taxiboot.model.Response;
import pe.com.microservice.taxiboot.model.RespuestaSms;
import pe.com.microservice.taxiboot.model.TransactionRs;
import pe.com.microservice.taxiboot.service.EquipoService;
import pe.com.microservice.taxiboot.web.util.Constants;

@RestController
@RequestMapping(Constants.URL_APP_BASE)
public class EquipoController {

	private final Logger logger = LoggerFactory
			.getLogger(EquipoController.class);

	@Autowired
	private EquipoService equipoService;

	@Autowired
	private HeaderRqUtil headerRqUtil;

	@RequestMapping(value ="/service/generaSms", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<Response> generaSms(
			@RequestHeader HttpHeaders headers, @RequestBody Equipo request) {
		
		logger.info("generaSms....");
		TransactionRs<Response> response = new TransactionRs<Response>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			request.setDevice(headerRq.getDevice());
			request.setDeviceType(headerRq.getDeviceType());
			
			Response respuesta = new Response();
			
			Conductor conductor = equipoService.getConductorByPhone(request);
			
			if(conductor==null) {
				RespuestaSms code = new  RespuestaSms(equipoService.ingresarEquipo(request));
				//respuesta.setValor(equipoService.ingresarEquipo(request));
				respuesta.setCode(code);
				response.setRespuesta(respuesta);			
			} else {
				System.out.println("getConductorByPhone");
				Equipo equipo = equipoService.getEquipoxPhone(request);
				respuesta.setValor(null);
				respuesta.setEquipo(equipo);
				respuesta.setConductor(conductor);
				response.setRespuesta(respuesta);
				response.setCodigoError("0001");
				response.setDescripcion("Usuario conductor ya se encuentra registrado");

			}

			
		} catch (Exception e) {
			System.out.println("...Error generaSms. "+ e.getMessage());
			logger.error("Error generaSms. ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}

	@RequestMapping(value ="/service/generaSmsV2", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<BeanResponse> generaSmsV2(
			@RequestHeader HttpHeaders headers, @RequestBody Equipo request) {
		
		logger.info("generaSms....");
		TransactionRs<BeanResponse> response = new TransactionRs<BeanResponse>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			request.setDevice(headerRq.getDevice());
			request.setDeviceType(headerRq.getDeviceType());

			BeanResponse respuesta = new BeanResponse();
			respuesta.setValor(equipoService.ingresarEquipo(request));
			response.setRespuesta(respuesta);
			
		} catch (Exception e) {
			logger.error("Error generaSms. ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}

	@RequestMapping(value ="/service/reenviarSms", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<BeanResponse> reenviaSms(
			@RequestHeader HttpHeaders headers, @RequestBody Equipo request) {
		
		logger.info("reenviaSms.");
		TransactionRs<BeanResponse> response = new TransactionRs<BeanResponse>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			request.setDevice(headerRq.getDevice());
			request.setDeviceType(headerRq.getDeviceType());

			BeanResponse respuesta = new BeanResponse();
			respuesta.setValor(equipoService.reenviarEquipo(request));
			response.setRespuesta(respuesta);
			
		} catch (Exception e) {
			logger.error("Error reenviaSms. ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}


	@RequestMapping(value ="/service/validaSms", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<BeanResponse> validaSms(
			@RequestHeader HttpHeaders headers, @RequestBody Equipo request) {
		
		logger.info("validaSms....");
		TransactionRs<BeanResponse> response = new TransactionRs<BeanResponse>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			request.setDevice(headerRq.getDevice());
			request.setDeviceType(headerRq.getDeviceType());
			equipoService.validaEquipo(request);
			
		} catch (Exception e) {
			logger.error("Error validaSms. ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Not Found");
		}
		
		return response;
	}
	
	
	
	
}
