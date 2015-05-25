package org.activiti.designer.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.com.sp.dto.OrdenCompra;
import co.com.sp.interfaces.MensajeServiceRemote;

public class ClientePersonaService {
	public static void main(String[] args) {
			System.out.println("Se esta llamando a la clase pertienente");
			System.out.println("Iniciando llamada al EJB desde el cliente\n");
			Context jndi = null;
			try {
				jndi = new InitialContext();
				MensajeServiceRemote mensajeService = (MensajeServiceRemote) jndi.lookup("java:global/proyectoweb/PersonaServiceImpl!co.com.sp.interfaces.MensajeServiceRemote");
				OrdenCompra orden = new OrdenCompra();
				orden.setId((long)1);
				orden.setNombreSocio("Servio Pantoja");
				orden.setNumeroOrden("11111");
				orden = mensajeService.enviarMensaje(orden);
				System.out.println(orden.getId()+" "+orden.getNombreSocio()+" "+orden.getNumeroOrden()+" "+" Procesado cliente");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
