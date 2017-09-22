package com.znow.financemanaging.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.znow.financemanaging.business_logic.category.CategoryKey;
import com.znow.financemanaging.business_logic.report_analysis.ReportAnalyser;
import com.znow.financemanaging.business_logic.report_analysis.TimePeriod;
import com.znow.financemanaging.gui.AppWindow;

public class ReportsFrameController {
	
	private AppWindow appWindow;
	
	public ReportsFrameController(AppWindow appWindow) {
		this.appWindow = appWindow;
	}
	
	public void onGetReportButton(CategoryKey key, String timePeriodStr) {
		TimePeriod timePeriod = null;
		if (timePeriodStr.equals("Year"))
			timePeriod = TimePeriod.YEAR;
		else if (timePeriodStr.equals("Month"))
			timePeriod = TimePeriod.MONTH;
		else if (timePeriodStr.equals("Day"))
			timePeriod = TimePeriod.DAY;
		else if (timePeriodStr.equals("Global"))
			timePeriod = TimePeriod.GLOBAL;
		
		ReportAnalyser reportAnalyser = new ReportAnalyser();
		HashMap<String, Double> report =  reportAnalyser.getReport(key, timePeriod);
		
		for(Map.Entry mm : report.entrySet()){
			System.out.println(mm.getKey()+" "+mm.getValue());
		}
		
		JFrame reportFrame = new JFrame();
		reportFrame.setLocationRelativeTo(null);
		reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel root = new JPanel();
		root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
		
		for(Map.Entry mm : report.entrySet()){
			JLabel reportLabel = new JLabel(mm.getKey() + ": " + mm.getValue());
			root.add(reportLabel);
		}
		
		reportFrame.setContentPane(root);
		reportFrame.pack();
		reportFrame.setVisible(true);
	}
	
	public void onBackButton() {
		appWindow.drawMainFrame();
	}
	
}
