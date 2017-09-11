package com.znow.financemanaging.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.znow.financemanaging.controllers.Controller;

class MainFrame extends JPanel {
	
	private Controller controller = new Controller();
	
	MainFrame() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel balanceLabel = new JLabel("Your balance:");
		balanceLabel.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(balanceLabel);
		
		JPanel categoriesButtonsPane = new JPanel();
		JButton incomeCatButton = new JButton("Income categories");
		incomeCatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("income cat");
			}
		});
		categoriesButtonsPane.add(incomeCatButton);
		JButton expenseCatButton = new JButton("Expense categories");
		expenseCatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("expense cat");
			}
		});
		categoriesButtonsPane.add(expenseCatButton);
		categoriesButtonsPane.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(categoriesButtonsPane);
		
		JButton reportsButton = new JButton("See income/expense reports");
		reportsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("see reports");
			}
		});
		reportsButton.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(reportsButton);
		
		JPanel addButtonsPane = new JPanel();
		JButton addIncomeButton = new JButton("Add income");
		addIncomeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("add income");
			}
		});
		addButtonsPane.add(addIncomeButton);
		JButton addExpenseButton = new JButton("Add Expense");
		addExpenseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("add expense");
			}
		});
		addButtonsPane.add(addExpenseButton);
		addButtonsPane.setAlignmentX(JPanel.CENTER_ALIGNMENT);
		add(addButtonsPane);
	}
	
}
