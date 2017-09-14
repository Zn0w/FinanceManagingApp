package com.znow.financemanaging.controllers;

import com.znow.financemanaging.data_access.IncomeCategoriesDao;
import com.znow.financemanaging.gui.AppWindow;
import com.znow.financemanaging.gui.PromptWindow;

// todo: make this controller for both income and expense category frames!!!
public class IncomeCategoriesFrameController {
	
	private AppWindow appWindow;
	
	public IncomeCategoriesFrameController(AppWindow appWindow) {
		this.appWindow = appWindow;
	}
	
	public String[] getIncomeCategories() {
		return new IncomeCategoriesDao().readIncomeCategoriesFile().toArray(new String[0]);
	}
	
	public void onIncomeCategoryButton(String category) {
		// open income category window
	}
	
	public void onAddIncomeCategoryButton() {
		PromptWindow prompt = new PromptWindow();
		prompt.drawAddIncomeCategoryPrompt(this);
	}
	
	public void onSubmitIncomeCategoryButton(String category) {
		// assert value and save income category to file
	}
	
}
