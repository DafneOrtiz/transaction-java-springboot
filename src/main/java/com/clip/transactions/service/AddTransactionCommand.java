package com.clip.transactions.service;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.clip.transactions.model.ErrorDTO;
import com.clip.transactions.model.ITransactionRepository;
import com.clip.transactions.model.Transaction;

@Service("addtransactioncommand")
public class AddTransactionCommand implements ICommand{
	
	private static final Logger logger = LoggerFactory.getLogger(AddTransactionCommand.class);

	@Autowired
	ITransactionRepository iTransactionRepository;
	
	@Override
	public String process(Map<String, Object> arguments) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			   if(!arguments.containsKey("transaction")) {
					return new ErrorDTO(1,"Error, argument transaction not found").toString();
			   }
			   if(!arguments.containsKey("userid")) {
					return new ErrorDTO(2,"Error, argument userId not found").toString();
			   }
		
			int userId = Integer.parseInt(arguments.get("userid").toString());
			String jsonInString = arguments.get("transaction").toString();
			Transaction transaction = mapper.readValue(jsonInString, Transaction.class);
			transaction.setId(UUID.randomUUID());
			
			if(!Util.validateNull(transaction)){
				if(transaction.getUserId()!=0 &&transaction.getUserId()==userId) {
					Transaction transactionsave = iTransactionRepository.save(transaction,userId);
					return mapper.writeValueAsString(transactionsave);
				}
				logger.error("ERROR AddTransactionCommand, the userid of the transaction does not correspond to that of the argument");
				return new ErrorDTO(3,"Error, the userid of the transaction does not correspond to that of the argument").toString();
			}
			
				logger.error("ERROR AddTransactionCommand, all transaction fields are required");
				return new ErrorDTO(4,"Error, all transaction fields are required").toString();
			}catch (Exception e) {
				logger.error("ERROR AddTransactionCommand: " + e);
				return new ErrorDTO(e.hashCode(),"Error adding a transaction").toString();
			}
	  }
	
}
