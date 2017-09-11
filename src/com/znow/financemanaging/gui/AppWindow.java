package com.znow.financemanaging.gui;

public class AppWindow extends Window {
	
	public AppWindow() {
		init();
	}
	
	public void drawMainFrame() {
		MainFrame mainFrame = new MainFrame();
		setContentPane(mainFrame);
		pack();
	}
	
}
