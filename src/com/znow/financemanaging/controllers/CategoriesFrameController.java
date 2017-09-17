package com.znow.financemanaging.controllers;

import com.znow.financemanaging.business_logic.category.CategoryKey;
import com.znow.financemanaging.data_access.CategoriesDao;
import com.znow.financemanaging.gui.AppWindow;
import com.znow.financemanaging.gui.PromptWindow;

public class CategoriesFrameController {
	
	private AppWindow appWindow;
	private CategoryKey key;
	
	public CategoriesFrameController(AppWindow appWindow, CategoryKey key) {
		this.appWindow = appWindow;
		this.key = key;
	}
	
	public String[] getCategories() {
		return new CategoriesDao(key).readCategoriesFile().toArray(new String[0]);
	}
	
	public void onCategoryButton(String category) {
		PromptWindow prompt = new PromptWindow();
		prompt.drawCategoryPrompt(this, category);
	}
	
	public void onBackButton() {
		appWindow.drawMainFrame();
	}
	
	public void onAddCategoryButton() {
		PromptWindow prompt = new PromptWindow();
		
		if (key == CategoryKey.INCOME_CATEGORIES)
			prompt.drawAddCategoryPrompt(this, "income");
		else if (key == CategoryKey.EXPENSE_CATEGORIES)
			prompt.drawAddCategoryPrompt(this, "expense");
	}
	
	public void onSubmitCategoryButton(String category) {
		CategoriesDao categoriesDao = new CategoriesDao(key);
		categoriesDao.createCategory(category);
		
		if (key == CategoryKey.EXPENSE_CATEGORIES)
			appWindow.drawExpenseCategoriesFrame();
		else if (key == CategoryKey.INCOME_CATEGORIES)
			appWindow.drawIncomeCategoriesFrame();
	}
	
	public void onDeleteCategoryButton(String category) {
		CategoriesDao categoriesDao = new CategoriesDao(key);
		categoriesDao.deleteCategory(category);
		
		if (key == CategoryKey.EXPENSE_CATEGORIES)
			appWindow.drawExpenseCategoriesFrame();
		else if (key == CategoryKey.INCOME_CATEGORIES)
			appWindow.drawIncomeCategoriesFrame();
	}
	
}
