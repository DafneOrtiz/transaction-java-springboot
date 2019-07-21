package com.clip.transactions.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.clip.transactions.model.ErrorDTO;

@Service("commandhandler")
public class CommandHandler implements ICommandHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CommandHandler.class);
	
	private final Map<String, ICommand> commandMap = new HashMap<>();
    
    public void register(String commandName, ICommand command) {
        commandMap.put(commandName, command);
    }
    
    public String process(Map<String, Object> arguments) {
        ICommand command = commandMap.get(arguments.get("command"));
        if (command == null) {
        	logger.error("ERROR command" + arguments.get("command") +"not supported");
			ErrorDTO error = new ErrorDTO();
			error.setMessage("ERROR command" + arguments.get("command") +"not supported");
			return error.toString();
        }
        return command.process(arguments);
    }
	
}
