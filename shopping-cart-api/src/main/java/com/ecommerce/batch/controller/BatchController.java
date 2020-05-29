package com.ecommerce.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchController {
	
	@Autowired
	public JobLauncher jobLauncher;
	
	@Autowired
	public Job processJob;
	
	@RequestMapping(path = "/startBatchProcess/{id}" ,method = RequestMethod.GET)
	public String processJob(@PathVariable("id") String id) throws Exception  {
		
         
		System.out.println("id " + id );
		if(id.equals("1")) {
			 JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
	                 .toJobParameters();
	         jobLauncher.run(processJob, jobParameters);
			return "Batch job has been invoked";
		}else {
			return "Batch job has not been invoked" ;
		}
			
	 
	        
		
		
	}

}
