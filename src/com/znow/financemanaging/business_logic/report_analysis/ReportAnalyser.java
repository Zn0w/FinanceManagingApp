package com.znow.financemanaging.business_logic.report_analysis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
			for (MoneyTransfer moneyTransfer : moneyTransfers) {
				if (isSame(moneyTransfer.getDate(), TimePeriod.YEAR)) {
					categoryCounts.put(moneyTransfer.getCategory(), categoryCounts.get(moneyTransfer.getCategory()) + 
					Double.valueOf(moneyTransfer.getAmount()));
				}
			}
		}
		else if (timePeriod == TimePeriod.MONTH) {
			for (MoneyTransfer moneyTransfer : moneyTransfers) {
				if (isSame(moneyTransfer.getDate(), TimePeriod.MONTH)) {
					categoryCounts.put(moneyTransfer.getCategory(), categoryCounts.get(moneyTransfer.getCategory()) + 
					Double.valueOf(moneyTransfer.getAmount()));
				}
			}
		}
		else if (timePeriod == TimePeriod.DAY) {
			for (MoneyTransfer moneyTransfer : moneyTransfers) {
				if (isSame(moneyTransfer.getDate(), TimePeriod.DAY)) {
					categoryCounts.put(moneyTransfer.getCategory(), categoryCounts.get(moneyTransfer.getCategory()) + 
					Double.valueOf(moneyTransfer.getAmount()));
				}
			}
		}
		
		return categoryCounts;
	}
	
	private boolean isSame(String date, TimePeriod timePeriod) {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String currentDate = dateFormat.format(new Date());
		
		System.out.println(date);
		System.out.println(currentDate);
		
		String[] dateApart = date.split("\\.");
		String[] currentDateApart = currentDate.split("\\.");
		
		System.out.println(dateApart.length);
		System.out.println(currentDateApart.length);
		
		if (timePeriod == TimePeriod.DAY)
			return dateApart[0].equals(currentDateApart[0]) && dateApart[1].equals(currentDateApart[1]) 
					&& dateApart[2].equals(currentDateApart[2]);
		else if (timePeriod == TimePeriod.MONTH)
			return dateApart[1].equals(currentDateApart[1]) && dateApart[2].equals(currentDateApart[2]);
		else if (timePeriod == TimePeriod.YEAR)
			return dateApart[2].equals(currentDateApart[2]);
		else
			return false;
	}
	
}
