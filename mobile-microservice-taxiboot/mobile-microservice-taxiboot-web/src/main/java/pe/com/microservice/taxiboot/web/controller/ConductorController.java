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
import pe.com.microservice.taxiboot.model.BeanRequest;
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
	private EquipoService equipoService;

	@Autowired
	private HeaderRqUtil headerRqUtil;

	@RequestMapping(value ="/service/generarConductor", 
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


	@RequestMapping(value ="/service/registraConductor", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<BeanResponse> registraConductor(
			@RequestHeader HttpHeaders headers, @RequestBody BeanRequest request) {
		
		logger.info("registraConductor::"+request);
		TransactionRs<BeanResponse> response = new TransactionRs<BeanResponse>();
		Equipo equipo = new Equipo();
		Conductor conductor = new Conductor();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			logger.info("headerRq==>Device:"+headerRq.getDevice()+"==>DeviceTyoe:"+headerRq.getDeviceType());
			String device = headerRq.getDevice();
			String deviceType = headerRq.getDeviceType();
			
			if(request!=null) {
			logger.info("equipo==>"+request.getEquipo().toString());
			logger.info("conductor==>"+request.getConductor().toString());
			
				if(request.getEquipo()!=null && request.getConductor()!=null) {	
				logger.info("not null");	
				equipo.setDevice(device);
				equipo.setDeviceType(deviceType);
				equipo.setEstado(new Integer(0));
				equipo.setSms(request.getEquipo().getSms());
				logger.info("==>equipo==>"+request.getEquipo().toString());
				equipoService.validaEquipo(equipo);
				
				conductor.setDevice(device);
				conductor.setDeviceType(deviceType);
				conductor.setNombre(request.getConductor().getNombre());
				conductor.setApellido(request.getConductor().getApellido());
				conductor.setEmail(request.getConductor().getEmail());
				conductor.setNumDoc(request.getConductor().getNumDoc());
				conductor.setTipoDoc(request.getConductor().getTipoDoc());
				conductor.setPais(request.getConductor().getPais());
				conductor.setTelefono(request.getConductor().getTelefono());
				conductor.setPassword(request.getConductor().getPassword());
				logger.info("==>conductor==>"+request.getConductor().toString());
				conductorService.insertConductor(conductor);

				if(request.getVehiculo()!=null) {	
					logger.info("vehiculo==>"+request.getVehiculo().toString());
				}

				}
				logger.info("fin");	
			
			}			
		} catch (Exception e) {
			try {
			equipoService.deleteEquipo(equipo);
			conductorService.deleteConductor(conductor);
			} catch (Exception f) {
				logger.error("Error registraConductor.....", f.getMessage());				
			}
			logger.error("Error registraConductor: ", e.getMessage());
			response.setCodigoError("5000");
			response.setDescripcion("Error interno");
		}
		
		return response;
	}


	
	
	@RequestMapping(value ="/service/generaConductor", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public TransactionRs<BeanResponse> registrarConductor(
			@RequestHeader HttpHeaders headers, @RequestBody BeanRequest request) {
		
		logger.info("registraConductor::");
		TransactionRs<BeanResponse> response = new TransactionRs<BeanResponse>();
		Equipo equipo = new Equipo();
		Conductor conductor = new Conductor();
		
		try {
			HeaderRq headerRq = headerRqUtil.getHttpHeader(headers);
			logger.info("headerRq==>Device:"+headerRq.getDevice()+"==>DeviceTyoe:"+headerRq.getDeviceType());
			String device = headerRq.getDevice();
			String deviceType = headerRq.getDeviceType();
			
			if(request!=null) {			
				logger.info("not null");					
				conductor.setDevice(device);
				conductor.setDeviceType(deviceType);
				conductor.setNombre(request.getConductor().getNombre());
				conductor.setApellido(request.getConductor().getApellido());
				conductor.setEmail(request.getConductor().getEmail());
				conductor.setNumDoc(request.getConductor().getNumDoc());
				conductor.setTipoDoc(request.getConductor().getTipoDoc());
				conductor.setPais(request.getConductor().getPais());
				conductor.setTelefono(request.getConductor().getTelefono());
				conductor.setPassword(request.getConductor().getPassword());
				logger.info("equipo==>"+request.getEquipo().toString());
				logger.info("conductor==>"+request.getConductor().toString());
				conductorService.insertConductor(conductor);
				
				logger.info("fin");	
			
			}			
		} catch (Exception e) {
			try {
			equipoService.deleteEquipo(equipo);
			conductorService.deleteConductor(conductor);
			} catch (Exception f) {
				logger.error("Error registraConductor.....", f.getMessage());				
			}
			logger.error("Error registraConductor: ", e.getMessage());
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
