package com.znow.financemanaging.business_logic.report_analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.znow.financemanaging.business_logic.category.CategoryKey;
import com.znow.financemanaging.business_logic.money_transfer.MoneyTransfer;
import com.znow.financemanaging.data_access.CategoriesDao;
import com.znow.financemanaging.data_access.MoneyTransferDao;

public class ReportAnalyser {
	
	public HashMap<String, Double> getReport(CategoryKey key, TimePeriod timePeriod) {
		CategoriesDao categoriesDao = new CategoriesDao(key);
		ArrayList<String> categories = categoriesDao.readCategoriesFile();
		
		HashMap<String, Double> categoryCounts = new HashMap<String, Double>();
		for (String category : categories) {
			categoryCounts.put(category, 0.0);
		}
		
		MoneyTransferDao moneyTransferDao = new MoneyTransferDao();
		List<MoneyTransfer> moneyTransfers = moneyTransferDao.getMoneyTransfers(key);
		
		if (timePeriod == TimePeriod.GLOBAL) {
			for (MoneyTransfer moneyTransfer : moneyTransfers) {
				categoryCounts.put(moneyTransfer.getCategory(), categoryCounts.get(moneyTransfer.getCategory()) + 
				Double.valueOf(moneyTransfer.getAmount()));
			}
		}
		else if (timePeriod == TimePeriod.YEAR) {
			
		}
		else if (timePeriod == TimePeriod.MONTH) {
			
		}
		else if (timePeriod == TimePeriod.DAY) {
			
		}
		
		return categoryCounts;
	}
	
}
