package com.clip.transactions.controller;

import java.util.Arrays;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.clip.transactions.model.ErrorDTO;
import com.clip.transactions.service.ICommand;
import com.clip.transactions.service.ICommandHandler;
import com.clip.transactions.service.Util;

@Service
public class CommandReciver  implements ApplicationRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(CommandReciver.class);
	
	@Autowired
	@Qualifier("addtransactioncommand")
	ICommand addTransactionCommand;
	
	@Autowired
	@Qualifier("showtransactioncommand")
	ICommand showTransactionCommand;
	
	@Autowired
	@Qualifier("sumtransactioncommand")
	ICommand sumTransactionCommand;
	
	@Autowired
	@Qualifier("listtransactioncommand")
	ICommand listTransactionCommand;
	
	@Autowired
	@Qualifier("commandhandler")
	ICommandHandler commandHandler;
	

	 
	@Override
	public void run(ApplicationArguments args) throws Exception {
		 
		logger.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
	
		Map<String, Object> arguments = Util.getNotOptionArguments(args);
		
		if(arguments.containsKey("command")) {
	
			commandHandler.register("add", addTransactionCommand);
			commandHandler.register("show", showTransactionCommand);
			commandHandler.register("sum", sumTransactionCommand);
			commandHandler.register("list", listTransactionCommand);
			
			System.out.println(commandHandler.process(arguments));
		}
		else {
			ErrorDTO error = new ErrorDTO();
			error.setCode(1);
			error.setMessage("ERROR, incorrect command line arguments");
			logger.error(error.toString());
		}
		
	}
	
}