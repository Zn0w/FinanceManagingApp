package com.znow.financemanaging.gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.znow.financemanaging.controllers.ReportsFrameController;

@SuppressWarnings("serial")
class ReportsFrame extends JPanel {
	
	private ReportsFrameController controller;
	
	ReportsFrame(AppWindow appWindow) {
		controller = new ReportsFrameController(appWindow);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
	}
	
}
