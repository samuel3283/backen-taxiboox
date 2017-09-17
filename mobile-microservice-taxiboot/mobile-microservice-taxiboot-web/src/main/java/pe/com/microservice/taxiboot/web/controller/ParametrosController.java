package pe.com.microservice.taxiboot.web.controller;

import java.util.List;
import java.util.Map;

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
import pe.com.microservice.taxiboot.model.Equipo;
import pe.com.microservice.taxiboot.model.HeaderRq;
import pe.com.microservice.taxiboot.model.Parametro;
import pe.com.microservice.taxiboot.model.TransactionRs;
import pe.com.microservice.taxiboot.service.EquipoService;
import pe.com.microservice.taxiboot.service.ParametroService;
import pe.com.microservice.taxiboot.web.util.Constants;

@RestController
@RequestMapping(Constants.URL_APP_BASE)
public class ParametrosController {

	private final Logger logger = LoggerFactory
			.getLogger(ParametrosController.class);

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private HeaderRqUtil headerRqUtil;

	@RequestMapping(value ="/service/listEstadosViajes", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<List<Parametro>> listEstadosViajes(
			@RequestHeader HttpHeaders headers) {
		
		logger.info("listEstadosViajes....");
		TransactionRs<List<Parametro>> response = new TransactionRs<List<Parametro>>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);

			List<Parametro> respuesta = parametroService.listParametro(Constants.TIPO_ESTADO_VIAJE);
			response.setRespuesta(respuesta);
			
		} catch (Exception e) {
			logger.error("Error listEstadosViajes. ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}



	@RequestMapping(value ="/service/listEstadosServicios", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<List<Parametro>> listEstadosServicios(
			@RequestHeader HttpHeaders headers) {
		
		logger.info("listEstadosServicios....");
		TransactionRs<List<Parametro>> response = new TransactionRs<List<Parametro>>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);

			List<Parametro> respuesta = parametroService.listParametro(Constants.TIPO_ESTADO_SERVICIO);
			response.setRespuesta(respuesta);
			
		} catch (Exception e) {
			logger.error("Error listEstadosServicios. ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}

	@RequestMapping(value ="/service/listAll", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<Map<String, List<Parametro>>> listAll(
			@RequestHeader HttpHeaders headers) {
		
		logger.info("listEstadosServicios....");
		TransactionRs<Map<String, List<Parametro>>> response = new TransactionRs<Map<String, List<Parametro>>>();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			response.setRespuesta(parametroService.listAll());
			
		} catch (Exception e) {
			logger.error("Error listEstadosServicios. ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}
	 
	
}
