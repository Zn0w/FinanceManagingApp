package com.znow.financemanaging.data_access;

import java.io.File;
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
		
		// get money transfers from file
		return null;
	}
	
	public void createMoneyTransfer(MoneyTransfer transfer) {
		File file;
		if (transfer.getKey() == CategoryKey.EXPENSE_CATEGORIES)
			file = new File("resources/expenseTransfers.txt");
		else if (transfer.getKey() == CategoryKey.INCOME_CATEGORIES)
			file = new File("resources/incomeTransfers.txt");
		
		// save money transfer info into the file
	}
	
}
