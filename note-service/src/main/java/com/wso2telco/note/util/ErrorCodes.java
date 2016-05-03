package com.wso2telco.note.util;

public enum ErrorCodes {

	ERROR_DATABASE_CONNECTION_INITIALIZATION("NS-0001", "error in database connection initialization"),
	ERROR_DATABASE_CONNECTION_CLOSE("NS-0002", "error in database connection closing"),
	ERROR_RESULTSET_CLOSE("NS-0003", "error in resultset closing"),
	ERROR_STATEMENT_CLOSE("NS-0004", "error in statement closing"),
	ERROR_NETTY_TRANSPORTS_YAML_NOT_FOUND("NS-0005", "netty-transports.yml file not found"),
	ERROR_NETTY_TRANSPORTS_YAML_READ("NS-0006", "error in reading netty-transports.yml"),
	ERROR_DATABASE_OPERATION("NS-0007", "error in database operation"),
	ERROR_INVALID_HTTP_PORT_ID("NS-0008", "invalid http port id"),
	ERROR_HTTP_PORT_ID_NOT_FOUND("NS-0009", "http port id not found"),
	ERROR_HTTP_PORT_NOT_FOUND("NS-0010", "http port not found"),
	ERROR_INVALID_NETTY_TRANSPORTS_YAML_FORMAT("NS-0011", "invalid format of netty-transports.yml"),
	ERROR_UNREADABLE_NETTY_TRANSPORTS_YAML("NS-0012", "unreadable format of netty-transports.yml"),
	ERROR_HTTP_PORT_INITIALIZATION("NS-0013", "error in http port initialization"),
	ERROR_INVALID_HTTPS_PORT_ID("NS-0014", "invalid https port id"),
	ERROR_HTTPS_PORT_ID_NOT_FOUND("NS-0015", "https port id not found"),
	ERROR_HTTPS_PORT_NOT_FOUND("NS-0016", "https port not found"),
	ERROR_HTTPS_PORT_INITIALIZATION("NS-0017", "error in https port initialization"),
	ERROR_INVALID_DATASOURCE("NS-0018", "invalid datasource"),
	ERROR_DATASOURCE_NOT_FOUND("NS-0019", "datasource not found"),
	ERROR_DATABASE_DRIVER_NOT_FOUND("NS-0020", "database driver not found"),
	ERROR_DATABASE_CONNECTION_URL_NOT_FOUND("NS-0021", "database connection url not found"),
	ERROR_DATABASE_HOST_NOT_FOUND("NS-0022", "database host not found"),
	ERROR_DATABASE_PORT_NOT_FOUND("NS-0023", "database port not found"),
	ERROR_DATABASE_NAME_NOT_FOUND("NS-0024", "database name not found"),
	ERROR_DATABASE_AUTO_RECONNECT_CONFIGURATION_NOT_FOUND("NS-0025", "database autoReconnect configuration not found"),
	ERROR_DATABASE_USERNAME_NOT_FOUND("NS-0026", "database username not found"),
	ERROR_DATABASE_PASSWORD_NOT_FOUND("NS-0027", "database password not found"),
	ERROR_DATABASE_CONFIGURATION_INITIALIZATION("NS-0028", "error in database configuration initialization"),
	ERROR_DATABASE_CONNECTION_INSTANTIATION("NS-0029", "error in database connection instantiation"),
	ERROR_DATABASE_ACCESS("NS-0030", "error in database access"),
	ERROR_DATABASE_CLASS_NOT_FOUND("NS-0031", "database class not found"),
	ERROR_DATABASE_REQUESTED_RESOURCE_NOT_FOUND("NS-0031", "requested resource not found in database");
	
	private String errorCode;
	private String errorDescription;
	
	ErrorCodes(String errorCode, String errorDescription){
		
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
	public String getErrorCode(){
		
		return this.errorCode;
	}
	
	public String getErrorDescription(){
		
		return this.errorDescription;
	}
}