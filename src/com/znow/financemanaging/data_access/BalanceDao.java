package com.znow.financemanaging.data_access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BalanceDao {
	
	File file = new File("resources/balance.txt");
	
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
	
}
