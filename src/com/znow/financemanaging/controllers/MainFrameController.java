package com.znow.financemanaging.controllers;

import com.znow.financemanaging.business_logic.category.CategoryKey;
import com.znow.financemanaging.business_logic.money_transfer.MoneyTransfer;
import com.znow.financemanaging.data_access.CategoriesDao;
import com.znow.financemanaging.data_access.MoneyTransferDao;
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
		prompt.drawMoneyTransferPrompt(this, CategoryKey.INCOME_CATEGORIES);
	}
	
	public void onAddExpenseButton() {
		PromptWindow prompt = new PromptWindow();
		prompt.drawMoneyTransferPrompt(this, CategoryKey.EXPENSE_CATEGORIES);
	}
	
	public void onSubmitMoneyTransfer(MoneyTransfer transfer) {
		System.out.println(transfer.getKey());
		System.out.println(transfer.getAmount());
		System.out.println(transfer.getComment());
		System.out.println(transfer.getDate());
		
		MoneyTransferDao moneyTransferDao = new MoneyTransferDao();
		moneyTransferDao.createMoneyTransfer(transfer);
	}
	
	public String[] getCategories(CategoryKey key) {
		return new CategoriesDao(key).readCategoriesFile().toArray(new String[0]);
	}
	
}
