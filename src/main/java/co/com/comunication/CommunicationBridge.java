package co.com.comunication;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import co.com.sp.interfaces.MensajeServiceRemote;

public class CommunicationBridge   implements JavaDelegate{
	
	private MensajeServiceRemote mensajeService;
	
	static Long solicitudes = (long) 0;
	
	public CommunicationBridge(){System.out.println("Instancia CommunicationBridge");
		
	}

	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Se esta llamando a la clase pertienente");
		System.out.println("Iniciando llamada al EJB desde el cliente\n");
		execution.setVariable("paso", "resutlado varr");
//		Context jndi = new InitialContext();
//		mensajeService = (MensajeServiceRemote) jndi.lookup("java:global/proyectoweb/PersonaServiceImpl!co.com.sp.interfaces.MensajeServiceRemote");
		
	}
	
	public String subirAprobacion(){System.out.println("Proceso subir aprobacion");
		String grupo = "";
			if(solicitudes==0){
				grupo = "SupervisorGM";
				
			}else if(solicitudes==1){
				grupo = "GerenciaGM";
			}
			System.out.println("Se sube a"+grupo);
		return grupo;
	}
}
