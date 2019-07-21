package com.clip.transactions.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clip.transactions.model.ErrorDTO;
import com.clip.transactions.model.ITransactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("listtransactioncommand")
public class ListTransactionCommand implements ICommand{
	
	private static final Logger logger = LoggerFactory.getLogger(ListTransactionCommand.class);

	@Autowired
	ITransactionRepository iTransactionRepository;

	@Override
	public String process(Map<String, Object> arguments) {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();
	    final byte[] data;
		try {
		
			if(!arguments.containsKey("userid")) {
					logger.error("ERROR, argument userid not found");
					return new ErrorDTO(5,"Error, argument userid not found").toString();
			   }
			int userId = Integer.parseInt(arguments.get("userid").toString());
			
			File archivo = new File(userId+".txt");
			if (!archivo.exists()) {
				logger.error("ERROR the user id does not exist");
				return new ErrorDTO(6,"ERROR the user id does not exist").toString();
			}
			
		    mapper.writeValue(out, iTransactionRepository.findAll(userId));
		    data= out.toByteArray();
			return new String(data);
			
			}catch (Exception e) {
				logger.error("ERROR ListTransactionCommand: " + e);
				return new ErrorDTO(e.hashCode(),"Error in findall transactions").toString();
			}
	}
}
