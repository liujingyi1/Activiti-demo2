package com.example.demo.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DelegateService implements JavaDelegate {

	
	private static final Logger log = LoggerFactory.getLogger(DelegateService.class);
	
	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("run delegateService........");
	}

}
