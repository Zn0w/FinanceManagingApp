package com.znow.financemanaging.data_access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ExpenseDao {
	
	private File expenseCategoriesFile = new File("resources/expenseCategories.txt");
	
	public ArrayList<String> readExpenseCategoriesFile() {
		BufferedReader reader;
		ArrayList<String> expenseCategories = new ArrayList<String>();
		
		try {
			reader = new BufferedReader(new FileReader(expenseCategoriesFile));
			
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				expenseCategories.add(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return expenseCategories;
	}
	
}
