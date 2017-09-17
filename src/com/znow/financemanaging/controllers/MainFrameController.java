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
		PromptWindow prompt = new PromptWindow();
		prompt.drawMoneyTransferPrompt(this, "income");
	}
	
	public void onAddExpenseButton() {
		PromptWindow prompt = new PromptWindow();
		prompt.drawMoneyTransferPrompt(this, "expense");
	}
	
	public void onSubmitMoneyTransfer(String transfer) {
		
	}
	
}
