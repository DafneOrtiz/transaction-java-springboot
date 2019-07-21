package com.clip.transactions.model;

import java.util.List;
import java.util.UUID;


public interface ITransactionRepository {
	
	public Transaction save(Transaction transaction, int userId) throws Exception;
	public List<Transaction> findAll(int userId) throws Exception;
	public Transaction findById(UUID transactionId, int userId) throws Exception;
	public double sum(int userId)throws Exception;
	
}
