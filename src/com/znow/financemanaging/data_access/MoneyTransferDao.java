package com.znow.financemanaging.data_access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.znow.financemanaging.business_logic.category.CategoryKey;
import com.znow.financemanaging.business_logic.money_transfer.MoneyTransfer;

public class MoneyTransferDao {
	
	public List<MoneyTransfer> getMoneyTransfers(CategoryKey key) {
		File file;
		if (key == CategoryKey.EXPENSE_CATEGORIES)
			file = new File("resources/expenseTransfers.txt");
		else if (key == CategoryKey.INCOME_CATEGORIES)
			file = new File("resources/incomeTransfers.txt");
		else
			file = new File("");
		
		BufferedReader reader;
		List<MoneyTransfer> moneyTransfers = new ArrayList<MoneyTransfer>();
		
		try {
			reader = new BufferedReader(new FileReader(file));
			
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				String[] components = line.split(";");
				
				MoneyTransfer moneyTranfer = new MoneyTransfer(key,components[0], components[1], 
						components[2], components[3]);
				moneyTransfers.add(moneyTranfer);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return moneyTransfers;
	}
	
	public void createMoneyTransfer(MoneyTransfer transfer) {
		File file;
		if (transfer.getKey() == CategoryKey.EXPENSE_CATEGORIES)
			file = new File("resources/expenseTransfers.txt");
		else if (transfer.getKey() == CategoryKey.INCOME_CATEGORIES)
			file = new File("resources/incomeTransfers.txt");
		else
			file = new File("");
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(file, true);
			writer.write("\n" + transfer.getCategory() + ";" + transfer.getAmount() + "; " + 
			transfer.getComment() + ";" + transfer.getDate());
			writer.flush();
			
			BalanceDao balanceDao = new BalanceDao();
			balanceDao.registerMoneyTransfer(transfer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
