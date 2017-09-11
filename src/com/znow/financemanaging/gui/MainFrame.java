package com.znow.financemanaging.gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MainFrame extends JPanel {
	
	MainFrame() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel balanceLabel = new JLabel("Your balance:");
		balanceLabel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(balanceLabel);
		
		JPanel categoriesButtonsPane = new JPanel();
		JButton incomeCatButton = new JButton("Income categories");
		categoriesButtonsPane.add(incomeCatButton);
		JButton expenseCatButton = new JButton("Expense categories");
		categoriesButtonsPane.add(expenseCatButton);
		categoriesButtonsPane.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(categoriesButtonsPane);
		
		JButton reportsButton = new JButton("See income/expense reports");
		reportsButton.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(reportsButton);
		
		JPanel addButtonsPane = new JPanel();
		JButton addIncomeButton = new JButton("Add income");
		addButtonsPane.add(addIncomeButton);
		JButton addExpenseButton = new JButton("Add Expense");
		addButtonsPane.add(addExpenseButton);
		addButtonsPane.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(addButtonsPane);
	}
	
}
