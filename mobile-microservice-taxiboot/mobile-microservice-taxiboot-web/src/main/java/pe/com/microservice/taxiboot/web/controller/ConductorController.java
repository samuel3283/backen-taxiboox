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
import pe.com.microservice.taxiboot.model.TransactionRs;
import pe.com.microservice.taxiboot.service.ConductorService;
import pe.com.microservice.taxiboot.service.EquipoService;
import pe.com.microservice.taxiboot.web.util.Constants;

@RestController
@RequestMapping(Constants.URL_APP_BASE)
public class ConductorController {

	private final Logger logger = LoggerFactory
			.getLogger(ConductorController.class);

	@Autowired
	private ConductorService conductorService;
	
	@Autowired
	private HeaderRqUtil headerRqUtil;

	@RequestMapping(value ="/service/generaConductor", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<BeanResponse> generaConductor(
			@RequestHeader HttpHeaders headers, @RequestBody Conductor request) {
		
		logger.info("generaConductor");
		TransactionRs<BeanResponse> response = new TransactionRs<BeanResponse>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			request.setDevice(headerRq.getDevice());
			request.setDeviceType(headerRq.getDeviceType());
			conductorService.insertConductor(request);
			
		} catch (Exception e) {
			logger.error("Error generaConductor: ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}


	@RequestMapping(value ="/service/getConductor", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<BeanResponse> getConductor(
			@RequestHeader HttpHeaders headers, @RequestBody Conductor request) {
		
		logger.info("getConductor....");
		TransactionRs<BeanResponse> response = new TransactionRs<BeanResponse>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			
		} catch (Exception e) {
			logger.error("Error generaSms. ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}


	
	@RequestMapping(value ="/service/viajesConductor", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<BeanResponse> viajesConductor(
			@RequestHeader HttpHeaders headers, @RequestBody Conductor request) {
		
		logger.info("viajesConductor");
		TransactionRs<BeanResponse> response = new TransactionRs<BeanResponse>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			logger.info("viajesConductor:::"+headerRq.getToken());
			
		} catch (Exception e) {
			logger.error("Error viajesConductor: ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}

}
