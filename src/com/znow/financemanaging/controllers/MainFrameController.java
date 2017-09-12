package com.znow.financemanaging.controllers;

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
		PromptWindow incomePrompt = new PromptWindow();
		incomePrompt.drawAddIncomePrompt();
	}
	
	public void onAddExpenseButton() {
		PromptWindow expensePrompt = new PromptWindow();
		expensePrompt.drawAddExpensePrompt();
	}
	
}
