package com.znow.financemanaging.controllers;

import com.znow.financemanaging.business_logic.category.CategoryKey;
import com.znow.financemanaging.data_access.CategoriesDao;
import com.znow.financemanaging.gui.AppWindow;
import com.znow.financemanaging.gui.PromptWindow;

public class MainFrameController {
	
	private AppWindow appWindow;
	
	public MainFrameController(AppWindow appWindow) {
		this.appWindow = appWindow;
	}
	
	public void onIncomeCatButton() {
		appWindow.drawIncomeCategoriesFrame();
	}
	
	public void onExpenseCatButton() {
		appWindow.drawExpenseCategoriesFrame();
	}
	
	public void onReportsButton() {
		appWindow.drawReportsFrame();
	}
	
	public void onAddIncomeButton() {
		PromptWindow prompt = new PromptWindow();
		prompt.drawMoneyTransferPrompt(this, "income");
	}
	
	public void onAddExpenseButton() {
		PromptWindow prompt = new PromptWindow();
		prompt.drawMoneyTransferPrompt(this, "expense");
	}
	
	public void onSubmitMoneyTransfer(String transfer) {
		
	}
	
	public String[] getCategories(CategoryKey key) {
		return new CategoriesDao(key).readCategoriesFile().toArray(new String[0]);
	}
	
}
