package org.activiti.designer.test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.junit.Test;


public class ProcessTestMyProcess {

	private String filename = "B:/Desarrollo Java/Proyectos/SimpleLeave-Process/src/main/resources/diagrams/SimpleLeaveProcess.bpmn";

	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();

	@Test  
	public void startProcess() throws Exception {
		RepositoryService repositoryService = activitiRule. getRepositoryService();    
		repositoryService.createDeployment().addInputStream("SimpleLeaveProcess.bpmn20.xml", new FileInputStream(filename)).deploy();    
		RuntimeService runtimeService = activitiRule. getRuntimeService();    
		Map<String, Object> variableMap = new HashMap<String, Object>();    
		variableMap.put("Empname", "Irshad");    
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess", variableMap);    
		assertNotNull(processInstance.getId());    
		System.out.println("id " + processInstance.getId() + " "      + processInstance.getProcessDefinitionId());  
	} 
}