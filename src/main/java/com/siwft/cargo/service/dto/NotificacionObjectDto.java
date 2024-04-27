package com.siwft.cargo.service.dto;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Builder
public class NotificacionObjectDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6552178687524913163L;
	
	private String cedulaCliente;
	private String tipo;
	private String process;
	private String codigoProceso;
	private String numeroOperacion;
	private String numeroOperacionMadre;
	private String imagenBase64;
	private String mensaje;
	private String titulo;
	private String estado;
	private Timestamp fecha;

	

}