package com.example.demo;

import java.util.List;import javax.sound.sampled.TargetDataLine;

import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiDemo2ApplicationTests {

	@Autowired
	RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private IdentityService identitiService;
	
	@Autowired
	private RepositoryService RepositoryService;
	
	@Autowired
	private ProcessEngine processEngine;
	
	@Autowired
	private HistoryService historyService;
//	
	private static final Logger log = LoggerFactory.getLogger(ActivitiDemo2ApplicationTests.class);

	@Test
	public void TestStartProcess() {
		System.out.println("jingyi start.....");
		ProcessInstance pInstance = runtimeService.startProcessInstanceByKey("myProcess");
		System.out.println("流程启动成功 id:"+pInstance.getId());
		
//		Task task = taskService.createTaskQuery().processInstanceId(pInstance.getId()).singleResult();
//		System.out.println("任务: "+ task);
		
		List<Task> resultTaskList = taskService.createTaskQuery().processInstanceId(pInstance.getId()).list();
		System.out.println("任务列表: "+ resultTaskList.toString());
		for (Task task : resultTaskList) {
			taskService.complete(task.getId());
		}
		resultTaskList = taskService.createTaskQuery().processInstanceId(pInstance.getId()).list();
		System.out.println("任务列表: "+ resultTaskList.toString());
	}
//	
//	@Test
//	public void contextLoads() {
//		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("my-process");
//		log.info("processInstance = {}", processInstance);
//	}

}
