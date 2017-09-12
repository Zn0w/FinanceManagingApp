package com.znow.financemanaging.gui;

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
		IncomeCategoriesFrame incomeCatFrame = new IncomeCategoriesFrame(this);
		setContentPane(incomeCatFrame);
		pack();
	}
	
	public void drawExpenseCategoriesFrame() {
		ExpenseCategoriesFrame expenseCatFrame = new ExpenseCategoriesFrame();
		setContentPane(expenseCatFrame);
		pack();
	}
	
	public void drawReportsFrame() {
		ReportsFrame reportsFrame = new ReportsFrame();
		setContentPane(reportsFrame);
		pack();
	}
	
}
