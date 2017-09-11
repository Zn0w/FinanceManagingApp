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
		
		JButton incomeCatButton = new JButton("Income categories");
		incomeCatButton.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(incomeCatButton);
		
		JButton expenseCatButton = new JButton("Expense categories");
		expenseCatButton.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(expenseCatButton);
		
		JButton reportsButton = new JButton("See income/expense reports");
		reportsButton.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(reportsButton);
		
		JPanel buttonPane = new JPanel();
		
		JButton addIncomeButton = new JButton("Add income");
		buttonPane.add(addIncomeButton);
		
		JButton addExpenseButton = new JButton("Add Expense");
		buttonPane.add(addExpenseButton);
		
		buttonPane.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(buttonPane);
	}
	
}
