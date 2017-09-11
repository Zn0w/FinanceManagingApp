package com.znow.financemanaging.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.znow.financemanaging.controllers.MainFrameController;

class MainFrame extends JPanel {
	
	private MainFrameController controller;
	
	MainFrame(AppWindow appWindow) {
		controller = new MainFrameController(appWindow);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel balanceLabel = new JLabel("Your balance:");
		balanceLabel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(balanceLabel);
		
		JPanel categoriesButtonsPane = new JPanel();
		JButton incomeCatButton = new JButton("Income categories");
		incomeCatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.onIncomeCatButton();
			}
		});
		categoriesButtonsPane.add(incomeCatButton);
		JButton expenseCatButton = new JButton("Expense categories");
		expenseCatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.onExpenseCatButton();
			}
		});
		categoriesButtonsPane.add(expenseCatButton);
		categoriesButtonsPane.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(categoriesButtonsPane);
		
		JButton reportsButton = new JButton("See income/expense reports");
		reportsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.onReportsButton();
			}
		});
		reportsButton.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(reportsButton);
		
		JPanel addButtonsPane = new JPanel();
		JButton addIncomeButton = new JButton("Add income");
		addIncomeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.onAddIncomeButton();
			}
		});
		addButtonsPane.add(addIncomeButton);
		JButton addExpenseButton = new JButton("Add Expense");
		addExpenseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.onAddExpenseButton();
			}
		});
		addButtonsPane.add(addExpenseButton);
		addButtonsPane.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(addButtonsPane);
	}
	
}
