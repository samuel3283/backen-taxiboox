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
import pe.com.microservice.taxiboot.model.BeanResponse;
import pe.com.microservice.taxiboot.model.Conductor;
import pe.com.microservice.taxiboot.model.Equipo;
import pe.com.microservice.taxiboot.model.HeaderRq;
import pe.com.microservice.taxiboot.model.Session;
import pe.com.microservice.taxiboot.model.TransactionRs;
import pe.com.microservice.taxiboot.service.ConductorService;
import pe.com.microservice.taxiboot.service.SessionService;
import pe.com.microservice.taxiboot.web.util.Constants;

@RestController
@RequestMapping(Constants.URL_APP_BASE)
public class SessionController {

	private final Logger logger = LoggerFactory
			.getLogger(SessionController.class);

	@Autowired
	private SessionService sessionService;

	@Autowired
	private HeaderRqUtil headerRqUtil;

	@RequestMapping(value ="/genera", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<BeanResponse> genera(
			@RequestBody BeanResponse request) {
		
		logger.info("genera....");
		TransactionRs<BeanResponse> response = new TransactionRs<BeanResponse>();
		
		try {
			BeanResponse respuesta = new BeanResponse();
			respuesta.setValor(request.getValor());
			response.setRespuesta(respuesta);
			
		} catch (Exception e) {
			logger.error("Error validar. ",e.getMessage());
		}
		
		return response;
	}

	@RequestMapping(value ="/service/validaSession", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<Session> validaSession(
			@RequestHeader HttpHeaders headers, @RequestBody Conductor request) {
		
		logger.info("validaSession....");
		TransactionRs<Session> response = new TransactionRs<Session>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			request.setDevice(headerRq.getDevice());
			request.setDeviceType(headerRq.getDeviceType());
			response.setRespuesta(sessionService.validaSession(request));
			
		} catch (Exception e) {
			logger.error("Error validaSession. ",e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error Session not found");
		}
		
		return response;
	}

	@RequestMapping(value ="/service/exitSession", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<Session> exitSession(
			@RequestHeader HttpHeaders headers) {
		
		logger.info("exitSession.");
		TransactionRs<Session> response = new TransactionRs<Session>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			sessionService.deleteSession(headerRq.getToken());
			
		} catch (Exception e) {
			logger.error("Error validaSession. ",e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error Session not found");
		}
		
		return response;
	}

	
	@RequestMapping(value ="/service/changeStatus", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<Session> changeStatus(
			@RequestHeader HttpHeaders headers, @RequestBody Session request) {
		
		logger.info("changeStatus.");
		TransactionRs<Session> response = new TransactionRs<Session>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			Session session = new Session(headerRq.getToken());
			session.setEstadoViaje(request.getEstadoViaje());
			sessionService.updEstViajeSession(session);
			
		} catch (Exception e) {
			logger.error("Error validaSession. ",e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error Session not found");
		}
		
		return response;
	}


	@RequestMapping(value ="/service/updateConductor", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<Session> updateConductor(
			@RequestHeader HttpHeaders headers, @RequestBody Conductor request) {
		
		logger.info("updateConductor....");
		TransactionRs<Session> response = new TransactionRs<Session>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			logger.info("objeto...."+request.toString());
			Session session = new Session();
			session.setToken(headerRq.getToken());
			session.setNombre(request.getNombre());
			session.setApellido(request.getApellido());
			session.setEmail(request.getEmail());
			sessionService.updateDatosSession(session);
			
		} catch (Exception e) {
			logger.error("Error updateConductor. ",e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error Session not found");
		}
		
		return response;
	}

	
	
	@RequestMapping(value ="/service/sendOlvido", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<BeanResponse> sendOlvido(
			@RequestHeader HttpHeaders headers, @RequestBody Conductor request) {
		
		logger.info("sendOlvido....");
		TransactionRs<BeanResponse> response = new TransactionRs<BeanResponse>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			
			if(request.getEmail()==null){
				throw new Exception("Error not found");
			}
			
			BeanResponse respuesta = new BeanResponse();
			respuesta.setValor(sessionService.generaCodeEmail(request));
			response.setRespuesta(respuesta);
			
		} catch (Exception e) {
			logger.error("Error sendOlvido. ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}

	@RequestMapping(value ="/service/validateOlvido", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs validateOlvido(
			@RequestHeader HttpHeaders headers, @RequestBody Conductor request) {
		
		logger.info("validateOlvido....");
		TransactionRs response = new TransactionRs();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			
			sessionService.validaCodeEmail(request);
			
		} catch (Exception e) {
			logger.error("Error validateOlvido. ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}

	@RequestMapping(value ="/service/updatePassword", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs updatePassword(
			@RequestHeader HttpHeaders headers, @RequestBody Conductor request) {
		
		logger.info("updatePassword....");
		TransactionRs response = new TransactionRs();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
						
			sessionService.upddateClaveConductor(request);
			
		} catch (Exception e) {
			logger.error("Error updatePassword. ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}

}
