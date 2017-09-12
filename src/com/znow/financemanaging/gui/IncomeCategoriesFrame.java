package com.znow.financemanaging.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.znow.financemanaging.controllers.IncomeCategoriesFrameController;

class IncomeCategoriesFrame extends JPanel{
	
	private IncomeCategoriesFrameController controller;
	
	IncomeCategoriesFrame(AppWindow appWindow) {
		controller = new IncomeCategoriesFrameController(appWindow);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		String[] incomeCategories = controller.getIncomeCategories();
		
		JPanel categoriesPane = new JPanel();
		JScrollPane scrollPane = new JScrollPane(categoriesPane);
		
		categoriesPane.setLayout(new BoxLayout(categoriesPane, BoxLayout.Y_AXIS));
		
		for (String incomeCategory : incomeCategories) {
			JButton incomeCatButton = new JButton(incomeCategory);
		}
		
		add(categoriesPane);
	}
	
}
