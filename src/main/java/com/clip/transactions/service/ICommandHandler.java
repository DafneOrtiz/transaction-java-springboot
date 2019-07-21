package com.clip.transactions.service;

import java.util.Map;

public interface ICommandHandler {
	
	void register(String commandName, ICommand command);
	String process (Map<String, Object> process);

}
