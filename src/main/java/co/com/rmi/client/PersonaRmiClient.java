package co.com.rmi.client;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import co.com.sp.dto.OrdenCompra;
import co.com.sp.interfaces.MensajeServiceRemote;



public class PersonaRmiClient  implements JavaDelegate{

	@SuppressWarnings("rawtypes")
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Se esta llamando a la clase pertienente");
		System.out.println("Iniciando llamada al EJB desde el cliente\n");
		Context jndi = new InitialContext();
		MensajeServiceRemote mensajeService = (MensajeServiceRemote) jndi.lookup("java:global/proyectoweb/PersonaServiceImpl!co.com.sp.interfaces.MensajeServiceRemote");
		OrdenCompra orden = new OrdenCompra();
		orden.setId((long)1);
		orden.setNombreSocio("Servio Pantoja");
		orden.setNumeroOrden("11111");
		orden = mensajeService.enviarMensaje(orden);
		System.out.println(orden.getId()+" "+orden.getNombreSocio()+" "+orden.getNumeroOrden()+" "+" Procesado cliente");

	}
	
}
