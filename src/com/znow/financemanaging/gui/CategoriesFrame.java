package com.znow.financemanaging.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.znow.financemanaging.controllers.category_frame_controller.CategoriesFrameController;
import com.znow.financemanaging.controllers.category_frame_controller.CategoryFrameControllerKey;

@SuppressWarnings("serial")
class CategoriesFrame extends JPanel {
	
	private CategoriesFrameController controller;
	
	CategoriesFrame(AppWindow appWindow, CategoryFrameControllerKey key) {
		controller = new CategoriesFrameController(appWindow, key);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		String[] categories = controller.getCategories();
		
		JPanel categoriesPane = new JPanel();
		categoriesPane.setLayout(new BoxLayout(categoriesPane, BoxLayout.Y_AXIS));
		JScrollPane scrollPane = new JScrollPane(categoriesPane);
		scrollPane.setPreferredSize(new Dimension(100, 100));
		
		for (String category : categories) {
			JButton categoryButton = new JButton(category);
			categoryButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					controller.onCategoryButton(category);
				}
			});
			categoriesPane.add(categoryButton);
		}
		
		add(scrollPane);
		
		String keyStr = "";
		if (key == CategoryFrameControllerKey.INCOME_CATEGORIES)
			keyStr = "income";
		else if (key == CategoryFrameControllerKey.EXPENSE_CATEGORIES)
			keyStr = "expense";
		else
			keyStr = "null";
		
		JButton addIncomeCatButton = new JButton("Add " + keyStr + " category");
		addIncomeCatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.onAddCategoryButton();
			}
		});
		add(addIncomeCatButton);
		
		JButton backButton = new JButton("Go back to the main frame");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onBackButton();
			}
		});
		add(backButton);
	}
	
}
