package com.clip.transactions.service;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.transactions.model.ErrorDTO;
import com.clip.transactions.model.ITransactionRepository;
import com.clip.transactions.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("showtransactioncommand")
public class ShowTransactionCommand implements ICommand{
	
	private static final Logger logger = LoggerFactory.getLogger(AddTransactionCommand.class);

	@Autowired
	ITransactionRepository iTransactionRepository;

	@Override
	public String process(Map<String, Object> arguments) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			if(!arguments.containsKey("transaction")) {
					logger.error("Error, argument transaction not found");
					return new ErrorDTO(7,"Error, argument transaction not found").toString();
			   }
			
			UUID id =  UUID.fromString(arguments.get("transaction").toString())  ;
			if(!arguments.containsKey("userid")) {
					logger.error("Error, argument userid not found");
					return new ErrorDTO(8,"Error, argument userid not found").toString();
			   }
		
			int userId = Integer.parseInt(arguments.get("userid").toString());
			
			File archivo = new File(userId+".txt");
			if (!archivo.exists()) {
				logger.error("ERROR, the userid does not exist");
				return new ErrorDTO(9,"ERROR, the userid does not exist").toString();
			}
			
			Transaction transaction = iTransactionRepository.findById(id, userId);
			
			if (transaction.getId() == null) {
				logger.error("ERROR, the trasaction id does not exist for this user");
				return new ErrorDTO(10,"ERROR, the trasaction id does not exist for this user").toString();
			}
			
			return mapper.writeValueAsString(transaction);
		
			}catch (Exception e) {
				logger.error("ERROR showtransactioncommand: " + e);
				return new ErrorDTO(11,"Error in show transaction").toString();
			}
	}
	
	

}
