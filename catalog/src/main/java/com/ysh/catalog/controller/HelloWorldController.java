package com.ysh.catalog.controller;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
	volatile static int n=0;
	volatile static int m=0;
	
	Executor executor = Executors.newFixedThreadPool(1); 

    @RequestMapping(value = "/hello/{nPath}")
    String home(@PathVariable(value = "nPath") int nPath ) {   
    	
    	final int sPath=nPath;
    	
    	Runnable task = new Runnable() {  
    	    @Override  
    	    public void run() {  
    	    	System.out.println("hello当前线程："+Thread.currentThread().getName());
    	    	System.out.println("hello请求数量："+(sPath));
    	    	try {
    				Thread.sleep(500);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    	    	System.out.println("hello处理完成："+(sPath));
    	    }  
    	};  
    	executor.execute(task); 
    	
    	
        return "Hello World!"+n;
    }
    
    @RequestMapping(value = "/user")
    String user() {    
    	
    	System.out.println("user当前线程："+Thread.currentThread().getName());
    	System.out.println("user请求数量："+(++m));
    	
    	System.out.println("user处理完成："+(m));
        return "Hello User!"+m;
    }
    
    
}
