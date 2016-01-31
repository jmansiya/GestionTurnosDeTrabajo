package gestion.turnos.transversal.seguridad.Impl;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;

import gestion.turnos.transversal.seguridad.IJWTwebTokens;
import gestion.turnos.transversal.seguridad.dto.UsuarioDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTWebTokenImpl implements IJWTwebTokens {
	
	private final String CLAVE_CODIFICADORA = "GESTION_TURNOS_TRABAJO";
	
	private static final Logger log = Logger.getLogger(JWTWebTokenImpl.class);
	
	public String createJWT(UsuarioDTO usuario, long ttlMillis) {
		// The JWT signature algorithm we will be using to sign the token
		if (usuario == null) {
			log.info("Usuario NULO, no se puede crear el token!");
			return null;
		} else {
			log.info(usuario.toString());
		}

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(CLAVE_CODIFICADORA);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		JwtBuilder builder = Jwts.builder().setId("" + (usuario.getIdPersona()))
		                                .setIssuedAt(now)
		                                .setSubject(usuario.getUsername())
		                                .claim("idPersona", usuario.getIdPersona())
		                                .claim("nombre", usuario.getNombre())
		                                .claim("apellido1", usuario.getApellido1())
		                                .claim("apellido2", usuario.getApellido2())
		                                .claim("roles", usuario.getIdPerfil())
		                                .signWith(signatureAlgorithm, signingKey);

		// if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		
		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public UsuarioDTO parseJWT(String jwt) {
		// TODO Auto-generated method stub
		UsuarioDTO usuario = new UsuarioDTO();

		try {
			Claims claims = Jwts.parser()         
					   .setSigningKey(DatatypeConverter.parseBase64Binary(CLAVE_CODIFICADORA))
					   .parseClaimsJws(jwt).getBody();
            
			usuario.setNombre((String) claims.get("nombre"));
			usuario.setIdPerfil(claims.get("roles") == null ? -1 : ((Integer) claims.get("roles")).intValue());
			usuario.setApellido1((String) claims.get("apellido1"));
			usuario.setApellido2((String) claims.get("apellido2"));
			usuario.setIdPersona(claims.get("idPersona") == null ? -1 : ((Integer) claims.get("idPersona")).intValue());
			usuario.setFechaAutenticacion(claims.getIssuedAt());
			usuario.setFechaExpiracion(claims.getExpiration());

			log.info("ROLE obtenido :: " + usuario.getIdPerfil());

			log.info("USUARIO logado : " + usuario);
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
