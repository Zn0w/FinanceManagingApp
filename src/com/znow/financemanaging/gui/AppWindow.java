package com.znow.financemanaging.gui;

import com.znow.financemanaging.controllers.category_frame_controller.CategoryFrameControllerKey;

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
		CategoriesFrame incomeCatFrame = new CategoriesFrame(this, CategoryFrameControllerKey.INCOME_CATEGORIES);
		setContentPane(incomeCatFrame);
		pack();
	}
	
	public void drawExpenseCategoriesFrame() {
		CategoriesFrame expenseCatFrame = new CategoriesFrame(this, CategoryFrameControllerKey.EXPENSE_CATEGORIES);
		setContentPane(expenseCatFrame);
		pack();
	}
	
	public void drawReportsFrame() {
		ReportsFrame reportsFrame = new ReportsFrame();
		setContentPane(reportsFrame);
		pack();
	}
	
}
