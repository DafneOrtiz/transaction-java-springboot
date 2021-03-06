package com.clip.transactions;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.clip.transactions.controller.CommandReciver;

@SpringBootApplication
public class TransactionsApplication{

private static final Logger logger = LoggerFactory.getLogger(CommandReciver.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TransactionsApplication.class, args);
	}


}
