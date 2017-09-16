
package com.znow.financemanaging.data_access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class IncomeDao {
	
	private File incomeCategoriesFile = new File("resources/incomeCategories.txt");
	
	public ArrayList<String> readIncomeCategoriesFile() {
		BufferedReader reader;
		ArrayList<String> incomeCategories = new ArrayList<String>();
		
		try {
			reader = new BufferedReader(new FileReader(incomeCategoriesFile));
			
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				incomeCategories.add(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return incomeCategories;
	}
	
	public void deleteCategory(String category) {
		
	}
	
}
