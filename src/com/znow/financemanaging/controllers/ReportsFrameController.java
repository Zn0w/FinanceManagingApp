package com.znow.financemanaging.controllers;

import java.util.HashMap;
import java.util.Map;

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
	}
	
	public void onBackButton() {
		appWindow.drawMainFrame();
	}
	
}
