package gestion.turnos.transversal.excepciones.utils;

import org.springframework.http.HttpStatus;

public class ErrorMessagesUtils {
	
	public static enum ErrorsRestServicesFichaColegial {
		ERSFC_401_001 (401001,"Usuario no autenticado en el sistema.", HttpStatus.UNAUTHORIZED),
		ERSFC_401_002 (401002,"El tiempo de sesión del usuario ha expirado.", HttpStatus.UNAUTHORIZED),
		ERSFC_401_003 (401003,"Error al autenticar al usuario en el sistema.", HttpStatus.UNAUTHORIZED),
		ERSFC_401_004 (401004,"Error obteniendo el token de seguridad del usuario.", HttpStatus.UNAUTHORIZED);
//		
//		ERSFC_404_001 (404001,"No se ha encontrado informaci�n general para el colegiado seleccionado.", HttpStatus.NOT_FOUND),
//		ERSFC_404_002 (404002,"No se ha encontrado informaci�n colegial para el colegiado seleccionado", HttpStatus.NOT_FOUND),
//		ERSFC_404_003 (404003,"No se ha encontrado informaci�n del CV para el colegiado", HttpStatus.NOT_FOUND),
//		ERSFC_404_004 (404004,"No se ha encontrado informaci�n de las cuentas bancarias para el colegiado", HttpStatus.NOT_FOUND),
//		ERSFC_404_005 (404005,"No se ha encontrado informaci�n de las direcciones para el colegiado", HttpStatus.NOT_FOUND), //Esto podr�a ser gen�rico para todas las consultas.
//		ERSFC_404_006 (404006,"No se ha encontrado la direcci�n seleccionada", HttpStatus.NOT_FOUND),
//		ERSFC_404_007 (404007,"No se ha encontrado el cat�logo solicitado", HttpStatus.NOT_FOUND),
//		ERSFC_404_008 (404008,"No se ha encontrado el cat�logo de tipos de identificaci�n solicitado", HttpStatus.NOT_FOUND),
//		ERSFC_404_009 (404009,"No se ha encontrado el cat�logo de tratamientos personales solicitado", HttpStatus.NOT_FOUND),
//		
//		ERSFC_500_001 (500001,"Se ha producido un error al recuperar las direcciones", HttpStatus.INTERNAL_SERVER_ERROR),
//		ERSFC_500_002 (500002,"Se ha producido un error al actualizar la informaci�n general para el colegiado", HttpStatus.INTERNAL_SERVER_ERROR),
//		ERSFC_500_003 (500003,"Se ha producido un error al actualizar la informaci�n colegial para el colegiado", HttpStatus.INTERNAL_SERVER_ERROR),
//		ERSFC_500_004 (500004,"Se ha producido un error al recuperar las cuotas colegiales", HttpStatus.INTERNAL_SERVER_ERROR),
//		ERSFC_500_005 (500005,"Se ha producido un error al recuperar las facturas", HttpStatus.INTERNAL_SERVER_ERROR),
//		ERSFC_500_006 (500006,"Se ha producido un error al recuperar los pedidos", HttpStatus.INTERNAL_SERVER_ERROR),
//		ERSFC_500_007 (500007,"Se ha producido un error al recuperar los productos", HttpStatus.INTERNAL_SERVER_ERROR),
//		ERSFC_500_008 (500008,"Se ha producido un error al recuperar los servicios", HttpStatus.INTERNAL_SERVER_ERROR),
//		ERSFC_500_009 (500009,"Se ha producido un error al recuperar las guardias asignadas para el colegiado", HttpStatus.INTERNAL_SERVER_ERROR),
//		ERSFC_500_010 (500010,"Se ha producido un error al recuperar los turnos inscritos para el colegiado", HttpStatus.INTERNAL_SERVER_ERROR),
//		ERSFC_500_011 (500011,"Se ha producido un error al recuperar los datos del cat�logo seleccionado", HttpStatus.INTERNAL_SERVER_ERROR),
//		ERSFC_500_012 (500012,"Se ha producido un error al limpiar la cach� de los cat�logos", HttpStatus.INTERNAL_SERVER_ERROR);
		
		private String mensajeError = null;
		private final int codigo;   
		private HttpStatus estado;

		private ErrorsRestServicesFichaColegial(int codigo, String mensajeError, HttpStatus estado) {
			this.codigo = codigo;
			this.mensajeError = mensajeError;
			this.estado = estado;
		}
		
		public int getCodigo() {
			return codigo;
		}
		
		public String getMensajeError() {
			return mensajeError;
		}

		public HttpStatus getEstado() {
			return estado;
		}
		
	}

}
