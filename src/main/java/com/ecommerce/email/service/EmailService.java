package com.ecommerce.email.service;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.email.utility.SendEmailUtility;

@Service
public class EmailService {

	Logger logger = LoggerFactory.getLogger(getClass());
	 
	@Autowired
	SendEmailUtility emailUtil;
	
	public void  send(String toEmail, String subject, String body) {
		// creating a thread pool with 10 threads, max alive time is 1 seconds, and linked blocking queue for unlimited queuing of requests.
        // if you want to process with 100 threads then replace both instances of 10 with 100, rest can remain same...
        // this should be a singleton
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        // inside your getSalesUserData() method
        executor.execute(new Runnable() {
            @Override
            public void run() {
                emailUtil.sendEmail(toEmail,subject, body);
            }
        });
	}
}
