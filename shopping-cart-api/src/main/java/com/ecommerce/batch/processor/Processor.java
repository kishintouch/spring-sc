package com.ecommerce.batch.processor;
import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String> {

	@Override
	public String process(String data) throws Exception {
		return data.toUpperCase();
	}

}