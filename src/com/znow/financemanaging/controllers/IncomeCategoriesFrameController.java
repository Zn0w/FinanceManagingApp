package com.znow.financemanaging.controllers;

import com.znow.financemanaging.data_access.IncomeCategoriesDao;
import com.znow.financemanaging.gui.AppWindow;

public class IncomeCategoriesFrameController {
	
	private AppWindow appWindow;
	
	public IncomeCategoriesFrameController(AppWindow appWindow) {
		this.appWindow = appWindow;
	}
	
	public String[] getIncomeCategories() {
		return new IncomeCategoriesDao().readIncomeCategoriesFile().toArray(new String[0]);
	}
	
}
