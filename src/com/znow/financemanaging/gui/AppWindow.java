package com.znow.financemanaging.gui;

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
		System.out.println("draw income cat frame");
	}
	
	public void drawExpenseCategoriesFrame() {
		System.out.println("draw expense cat frame");
	}
	
	public void drawReportsFrame() {
		System.out.println("draw reports frame");
	}
	
}
