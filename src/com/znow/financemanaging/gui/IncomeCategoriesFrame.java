package com.znow.financemanaging.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			categoriesPane.add(incomeCatButton);
		}
		
		add(categoriesPane);
		
		JButton addIncomeCatButton = new JButton("Add income category");
		addIncomeCatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		add(addIncomeCatButton);
	}
	
}
