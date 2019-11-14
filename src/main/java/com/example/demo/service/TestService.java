package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	private static String TAG = "TestService";
	
	public void activiti() {
		System.out.println(TAG+" 任务已经执行。。。。。。。。。。。。");
	}
	
	public void activiti123() {
		System.out.println(TAG+" 任务已经执行123-------------");
	}
	
	public List<String> user() {
		System.out.println(TAG+" user--------------");
		
		return Arrays.asList("xiaoming", "xiaohong");
	}

}
