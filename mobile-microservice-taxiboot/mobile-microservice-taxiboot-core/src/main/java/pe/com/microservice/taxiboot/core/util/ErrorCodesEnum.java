package pe.com.microservice.taxiboot.core.util;


public enum ErrorCodesEnum {
	  GENERAL_ERROR_CODE ("4000", "Error General"), 
	  ERR_REQUEST_INVALID("4001", "Error Request inválido"),
	  ERR_SESSION_EXPIRED("4002", "Lo sentimos su sesión ha expirado."),
	  ERR_INVALID_TOKEN("4003", "Token de sesión inválido"),
	  ERROR_VALIDATION_SERVICE("4004", "Error de acceso al servicio"),
	  ERR_DATABASE("4005", "Error de Base de Datos"),
	  ERROR_NOT_FOUND("4006", "Error, no encontrado"),
	  ERR_CANNOT_CREATE("006", "error.006"),
	  ERR_CANNOT_FIND("007", "error.007"),
	  ERR_CANNOT_UPDATE("008", "error.008"),
	  ERR_CANNOT_DELETE("009", "error.009"),
	  ERR_JMS_CANNOT_SEND("010", "error.010"),
	  ERROR_CANNOT_LOAD_CONF_PARAMETER("0286", "error.012"),
	  ERROR_PARSER_OBJECT("0287", "error.2970");
	 
	  private final String code;
	  private final String message;

	  ErrorCodesEnum(String code, String message) {
	     this.code = code;
	     this.message = message;
	  }

	  public String getCode() { return code; }
	  
	  public String getMessage() {
		  return message;		  
	  }
}
