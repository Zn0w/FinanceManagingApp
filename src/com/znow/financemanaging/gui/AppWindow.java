package com.znow.financemanaging.gui;

import com.znow.financemanaging.business_logic.category.CategoryKey;

@SuppressWarnings("serial")
public class AppWindow extends Window {
	
	public AppWindow() {
		init();
	}
	
	public void drawMainFrame() {
		MainFrame mainFrame = new MainFrame(this);
		setContentPane(mainFrame);
		pack();
	}
	
	public void drawIncomeCategoriesFrame() {
		CategoriesFrame incomeCatFrame = new CategoriesFrame(this, CategoryKey.INCOME_CATEGORIES);
		setContentPane(incomeCatFrame);
		pack();
	}
	
	public void drawExpenseCategoriesFrame() {
		CategoriesFrame expenseCatFrame = new CategoriesFrame(this, CategoryKey.EXPENSE_CATEGORIES);
		setContentPane(expenseCatFrame);
		pack();
	}
	
	public void drawReportsFrame() {
		ReportsFrame reportsFrame = new ReportsFrame(this);
		setContentPane(reportsFrame);
		pack();
	}
	
}
