package com.clip.transactions.service;

import java.util.Map;

public interface ICommand {
	
	public String process(Map<String, Object> arguments);

}
