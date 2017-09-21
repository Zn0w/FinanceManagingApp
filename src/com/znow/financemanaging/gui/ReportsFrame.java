package com.znow.financemanaging.gui;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.znow.financemanaging.business_logic.category.CategoryKey;
import com.znow.financemanaging.business_logic.report_analysis.ReportAnalyser;
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
		
		ReportAnalyser reportAnalyser = new ReportAnalyser();
		reportAnalyser.getGlobalReport(CategoryKey.EXPENSE_CATEGORIES);
		reportAnalyser.getGlobalReport(CategoryKey.INCOME_CATEGORIES);
	}
	
}
