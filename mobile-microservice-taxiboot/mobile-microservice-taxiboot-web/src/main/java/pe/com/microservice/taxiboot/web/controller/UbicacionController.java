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
import pe.com.microservice.taxiboot.model.HeaderRq;
import pe.com.microservice.taxiboot.model.Session;
import pe.com.microservice.taxiboot.model.TransactionRs;
import pe.com.microservice.taxiboot.model.Ubicacion;
import pe.com.microservice.taxiboot.service.ConductorService;
import pe.com.microservice.taxiboot.service.SessionService;
import pe.com.microservice.taxiboot.service.UbicacionService;
import pe.com.microservice.taxiboot.web.util.Constants;

@RestController
@RequestMapping(Constants.URL_APP_BASE)
public class UbicacionController {

	private final Logger logger = LoggerFactory
			.getLogger(UbicacionController.class);

	@Autowired
	private UbicacionService ubicacionService;

	@Autowired
	private HeaderRqUtil headerRqUtil;


	@RequestMapping(value ="/service/addUbicacion", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<Ubicacion> addUbicacion(
			@RequestHeader HttpHeaders headers, @RequestBody Ubicacion request) {
		
		logger.info("validaSession....");
		TransactionRs<Ubicacion> response = new TransactionRs<Ubicacion>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			Session session = new Session();
			session.setToken(headerRq.getToken());
			ubicacionService.insertUbicacion(request, session);
			
		} catch (Exception e) {
			logger.error("Error validaSession. ",e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error Session not found");
		}
		
		return response;
	}


}
