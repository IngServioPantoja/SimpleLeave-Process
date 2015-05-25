package co.com.core;

import javax.persistence.PersistenceException;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class Conection {
	public Conection(){
		
	}
	
	public ProcessEngine getConection() throws PersistenceException{
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration()
				.setJdbcDriver("com.mysql.jdbc.Driver")
				.setJdbcUrl("jdbc:mysql://localhost:3306/activity")
				.setJdbcPassword("desarrollo").setJdbcUsername("desarrollo")
				.setDatabaseSchemaUpdate("false")
				.buildProcessEngine();
		return processEngine;
	}
}
