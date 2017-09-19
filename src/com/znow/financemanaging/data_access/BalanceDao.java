package com.znow.financemanaging.data_access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.znow.financemanaging.business_logic.category.CategoryKey;
import com.znow.financemanaging.business_logic.money_transfer.MoneyTransfer;

public class BalanceDao {
	
	private File file = new File("resources/balance.txt");
	
	public String getCurrentBalance() {
		BufferedReader reader;
		String balance = "";
		
		try {
			reader = new BufferedReader(new FileReader(file));
			
			String line = "";
			
			if ((line = reader.readLine()) != null)
				balance = line;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return balance;
	}
	
	public void registerMoneyTransfer(MoneyTransfer transfer) {
		double amount = 0;
		if (transfer.getKey() == CategoryKey.EXPENSE_CATEGORIES)
			amount = Double.valueOf(transfer.getAmount()) * -1;
		else if (transfer.getKey() == CategoryKey.INCOME_CATEGORIES)
			amount = Double.valueOf(transfer.getAmount());
		
		double balance = Double.valueOf(getCurrentBalance());
		balance += amount;
		
		saveCurrentBalance(String.valueOf(balance));
	}
	
	private void saveCurrentBalance(String balance) {
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(file, false);
			writer.write(balance);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
