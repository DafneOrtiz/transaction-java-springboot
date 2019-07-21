package com.clip.transactions.service;

import java.io.File;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clip.transactions.model.ErrorDTO;
import com.clip.transactions.model.ITransactionRepository;

@Service("sumtransactioncommand")
public class SumTransactionCommand implements ICommand{
	private static final Logger logger = LoggerFactory.getLogger(SumTransactionCommand.class);

	@Autowired
	ITransactionRepository iTransactionRepository;

	@Override
	public String process(Map<String, Object> arguments) {
		try {
			
			if(!arguments.containsKey("userid")) {
					logger.error("Error, argument userid not found");
					return new ErrorDTO(12,"Error, argument userid not found").toString();
			   }
		
			int userId = Integer.parseInt(arguments.get("userid").toString());
			
			File archivo = new File(userId+".txt");
			if (!archivo.exists()) {
				logger.error("ERROR, the user id does not exist");
				return new ErrorDTO(13,"ERROR, the user id does not exist").toString();
			}
			return "{\"userId\":"+userId+",\"amount\":"+iTransactionRepository.sum(userId)+"}";
			
			}catch (Exception e) {
				logger.error("ERROR SumTransactionCommand: " + e);
				return new ErrorDTO(14,"Error in sum transaction").toString();
			}
	}
}
