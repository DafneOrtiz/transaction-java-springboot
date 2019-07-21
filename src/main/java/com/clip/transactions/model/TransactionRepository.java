package com.clip.transactions.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository implements ITransactionRepository{
	
	@Override
	public Transaction save(Transaction transaction,int userId)throws Exception  {
		BufferedWriter bw = new BufferedWriter( new FileWriter(userId+".txt",true) );
		bw.write(transaction.toString());
		bw.flush();
		bw.newLine();
		bw.close();	
		return transaction;
	}

	@Override
	public List<Transaction> findAll(int userId)throws Exception {
		BufferedReader br = new BufferedReader( new FileReader(userId+".txt") );
		String record;
		List<Transaction> transactions = new ArrayList<>();
		while( ( record = br.readLine() ) != null ) {
			StringTokenizer st = new StringTokenizer(record,",");
			
				Transaction t = new Transaction();
				t.setId(UUID.fromString(st.nextToken()));
				t.setAmount(Double.parseDouble(st.nextToken()));
				t.setDescription(st.nextToken());
				t.setDate(st.nextToken());
				t.setUserId(Integer.parseInt(st.nextToken()));
				
				transactions.add(t);
			
		}
		br.close();	
		
		Collections.sort(transactions, new Comparator<Transaction>() { 
		    public int compare(Transaction o1, Transaction o2) { 
		     return o1.getDate().compareTo(o2.getDate()); 
		    } 
		});
		
		return transactions;
	}

	@Override
	public Transaction findById(UUID transactionId, int userId)throws Exception {
		
		BufferedReader br = new BufferedReader( new FileReader(userId+".txt") );
		String record;
		Transaction trans = new Transaction();
		while( ( record = br.readLine() ) != null ) {
			StringTokenizer st = new StringTokenizer(record,",");
			if( record.contains(transactionId.toString()) ) {
				trans.setId(UUID.fromString(st.nextToken()));
				trans.setAmount(Double.parseDouble(st.nextToken()));
				trans.setDescription(st.nextToken());
				trans.setDate(st.nextToken());
				trans.setUserId(Integer.parseInt(st.nextToken()));
			}
		}
		br.close();	
		return trans;
	}

	@Override
	public double sum(int userId)throws Exception {
		BufferedReader br = new BufferedReader( new FileReader(userId+".txt") );
		String record;
		double sum =0;
		
		while( ( record = br.readLine() ) != null ) {
			String[] parts = record.split(",");
			sum = sum + Double.parseDouble(parts[1]);
		}
		br.close();	
		return sum;
	}

}
