package com.znow.financemanaging.controllers.category_frame_controller;

import com.znow.financemanaging.data_access.ExpenseDao;
import com.znow.financemanaging.data_access.IncomeDao;
import com.znow.financemanaging.gui.AppWindow;
import com.znow.financemanaging.gui.PromptWindow;

public class CategoriesFrameController {
	
	private AppWindow appWindow;
	private CategoryFrameControllerKey key;
	
	public CategoriesFrameController(AppWindow appWindow, CategoryFrameControllerKey key) {
		this.appWindow = appWindow;
		this.key = key;
	}
	
	public String[] getCategories() {
		if (key == CategoryFrameControllerKey.INCOME_CATEGORIES)
			return new IncomeDao().readIncomeCategoriesFile().toArray(new String[0]);
		else if (key == CategoryFrameControllerKey.EXPENSE_CATEGORIES)
			return new ExpenseDao().readExpenseCategoriesFile().toArray(new String[0]);
		else
			return new String[5];
	}
	
	public void onCategoryButton(String category) {
		// open income category window
	}
	
	public void onBackButton() {
		appWindow.drawMainFrame();
	}
	
	public void onAddCategoryButton() {
		PromptWindow prompt = new PromptWindow();
		
		if (key == CategoryFrameControllerKey.INCOME_CATEGORIES)
			prompt.drawAddCategoryPrompt(this, "income");
		else if (key == CategoryFrameControllerKey.EXPENSE_CATEGORIES)
			prompt.drawAddCategoryPrompt(this, "expense");
	}
	
	public void onSubmitCategoryButton(String category) {
		// assert value and save category to file
	}
	
}
