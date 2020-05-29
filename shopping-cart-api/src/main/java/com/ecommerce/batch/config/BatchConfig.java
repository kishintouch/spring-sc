package com.ecommerce.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ecommerce.batch.listener.JobCompletionListener;
import com.ecommerce.batch.processor.Processor;
import com.ecommerce.batch.reader.Reader;
import com.ecommerce.batch.writer.Writer;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory ;
	
	@Bean
	public Job processJob() {	
		Job job = jobBuilderFactory.get("Get Order")
				                   .incrementer(new RunIdIncrementer())
				                   .listener(listener())
				                   .flow(createStep())
				                   .end()
				                   .build();			
		return job;
	}
	
	@Bean
	public Step createStep() {
		return stepBuilderFactory.get("orderStep1")
								.<String, String> chunk(1)
								.reader(new Reader())
								.processor(new Processor())
								.writer(new Writer())
								.build();
	}
	
	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
}
