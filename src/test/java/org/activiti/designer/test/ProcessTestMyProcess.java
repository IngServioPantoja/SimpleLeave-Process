package org.activiti.designer.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Test;

import co.com.core.Conection;

public class ProcessTestMyProcess {

	private String filename = "B:/Desarrollo Java/Proyectos/SimpleLeave-Process/src/main/resources/diagrams/aumentoSaldoCorto.bpmn";

//	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();
//	
	@Test  
	public void startProcess() throws Exception {
		
		/* Configuración con base de datos */
		Conection conection = new Conection();
		
		ProcessEngine processEngine = conection.getConection();
		IdentityService identityService = processEngine.getIdentityService();
		identityService.setAuthenticatedUserId("servio");
		RepositoryService repositoryService = processEngine.getRepositoryService();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
//		TaskService taskService = processEngine.getTaskService();
//		taskService.claim(, "fozzie");
//		List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("kermit").list();
//		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("accountancy").list();
//		taskService.complete(task.getId());

//		repositoryService.createDeployment().addInputStream("aumentoSaldoCorto.bpmn20.xml", new FileInputStream(filename)).deploy();    
		
//		Map<String, Object> variableMap = new HashMap<String, Object>();    
//		variableMap.put("idOrden", "1");      
//		variableMap.put("idsSoporte", "x,y");  
//		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("aumentoDeSaldo",variableMap);
////		System.out.println("id " + processInstance.getId() + " "      + processInstance.getProcessDefinitionId());  
//		
//		Execution subProcess = runtimeService.createExecutionQuery().parentId(processInstance.getId()).singleResult();
//		
//		
//		
//		List<Execution> lstValidarDocumento = runtimeService.createExecutionQuery().parentId(subProcess.getId()).list();
//		List<Task> ordenTasks = new ArrayList<Task>();
		TaskService taskService = processEngine.getTaskService();
//		TaskQuery query = taskService.createTaskQuery().taskCandidateGroup("AsistenteSupervisorGM");
//		List<Task> tasks = query.list();	
//			
//		for (Execution execution : lstValidarDocumento) {
//			for (Task task : tasks) {
//				ExecutionEntity executionEntity = (ExecutionEntity) runtimeService.createExecutionQuery()
//						.executionId(task.getExecutionId()).singleResult();
//				if(execution.getId().equals(executionEntity.getSuperExecutionId())){
//					ordenTasks.add(task);
//					break;
//				}
//			}
//				
//		}
//		
//		for (Task task : ordenTasks) {
//			System.out.println("Tarea id:"+task.getId());
//			System.out.println("Necesito matching");
//		}

		taskService.setAssignee("830525","leonardo");
		taskService.setAssignee("830536","leonardo");
		

		HashMap<String, Object> variables = new HashMap<String, Object>();
		variables.put("conciliarEstracto", "VE");
//		variables.put("idOrden", "1");
//		taskService.setVariable(tasks.get(0).getId(), "idOrden", "1");
		taskService.complete("830536",variables);
		
		HashMap<String, Object> variables2 = new HashMap<String, Object>();
		variables2.put("conciliarEstracto", "VE");
//		variables2.put("idOrden", "1");
//		taskService.setVariable(tasks.get(1).getId(), "idOrden", "1");
		taskService.complete("830525",variables2);
		
		System.out.println("830525 leonardo");
		System.out.println("830536: leonardo");
		
//		System.out.println(tasks.get(0).getExecutionId());
//		
//		Execution exetarea = runtimeService.createExecutionQuery().executionId(tasks.get(48).getExecutionId()).singleResult();
//		
//		ExecutionEntity executionEntity = (ExecutionEntity) exetarea;
//		System.out.println(executionEntity.getSuperExecutionId()+"");
		
//		System.out.println("tamaño ");
//		System.out.println(tasks.size());
//		System.out.println("id " + processInstance.getId() + " "      + processInstance.getProcessDefinitionId());  
	} 
}