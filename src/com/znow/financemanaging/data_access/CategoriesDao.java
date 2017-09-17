package com.znow.financemanaging.data_access;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.znow.financemanaging.business_logic.category.CategoryKey;

public class CategoriesDao {
	
	private File categoriesFile;
	
	public CategoriesDao(CategoryKey key) {
		if (key == CategoryKey.INCOME_CATEGORIES)
			categoriesFile = new File("resources/incomeCategories.txt");
		else if (key == CategoryKey.EXPENSE_CATEGORIES)
			categoriesFile = new File("resources/expenseCategories.txt");
	}
	
	public ArrayList<String> readCategoriesFile() {
		BufferedReader reader;
		ArrayList<String> categories = new ArrayList<String>();
		
		try {
			reader = new BufferedReader(new FileReader(categoriesFile));
			
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				categories.add(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return categories;
	}
	
	public void createCategory(String category) {
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(categoriesFile, true);
			writer.write("\n" + category);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void deleteCategory(String category) {
		BufferedReader reader;
		FileWriter writer;
		
		ArrayList<String> categories = new ArrayList<String>();
		
		try {
			reader = new BufferedReader(new FileReader(categoriesFile));
			
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				if (line.equals(category))
					continue;
				
				categories.add(line);
			}
			
			writer = new FileWriter(categoriesFile, false);
			
			for (String eachCategory : categories) {
				if (categories.indexOf(eachCategory) == 0) {
					writer.write(eachCategory);
					writer.flush();
				}
				else {
					writer.write("\n" + eachCategory);
					writer.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
