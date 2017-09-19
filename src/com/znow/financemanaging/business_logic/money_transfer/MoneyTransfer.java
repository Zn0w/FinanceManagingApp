package com.znow.financemanaging.business_logic.money_transfer;

import com.znow.financemanaging.business_logic.category.CategoryKey;

public class MoneyTransfer {
	
	private CategoryKey key;
	private String category;
	private String amount;
	private String comment;
	private String date;
	
	public MoneyTransfer(CategoryKey key, String category, String amount, String comment, String date) {
		this.key = key;
		this.category = category;
		this.amount = amount;
		this.comment = comment;
		this.date = date;
	}
	
	public CategoryKey getKey() {
		return key;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public String getComment() {
		return comment;
	}
	
	public String getDate() {
		return date;
	}
	
}
