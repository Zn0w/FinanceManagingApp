package com.znow.financemanaging.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.znow.financemanaging.business_logic.category.CategoryKey;
import com.znow.financemanaging.controllers.ReportsFrameController;

@SuppressWarnings("serial")
class ReportsFrame extends JPanel {
	
	private ReportsFrameController controller;
	
	ReportsFrame(AppWindow appWindow) {
		controller = new ReportsFrameController(appWindow);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		String[] reportCategories = { "Incomes", "Expenses" };
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox categorySelector = new JComboBox(reportCategories);
		add(categorySelector);
		
		JLabel timeLbl = new JLabel("Time period:");
		add(timeLbl);
		
		String[] timePeriods = { "Year", "Month", "Day", "Global" };
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox timeSelector = new JComboBox(timePeriods);
		add(timeSelector);
		
		JButton getReportButton = new JButton("Get report");
		getReportButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CategoryKey key;
				if (((String) categorySelector.getSelectedItem()).equals("Incomes"))
					key = CategoryKey.INCOME_CATEGORIES;
				else if (((String) categorySelector.getSelectedItem()).equals("Expenses"))
					key = CategoryKey.EXPENSE_CATEGORIES;
				controller.onGetReportButton(key, (String) timeSelector.getSelectedItem());
			}
		});
		add(getReportButton);
		
		JButton backButton = new JButton("Go back to the main frame");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onBackButton();
			}
		});
	}
	
}
