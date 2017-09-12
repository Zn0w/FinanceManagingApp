package com.znow.financemanaging.gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.znow.financemanaging.controllers.IncomeCategoriesFrameController;

class IncomeCategoriesFrame extends JPanel{
	
	private IncomeCategoriesFrameController controller;
	
	IncomeCategoriesFrame(AppWindow appWindow) {
		controller = new IncomeCategoriesFrameController(appWindow);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
}
