package com.znow.financemanaging.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.znow.financemanaging.business_logic.category.CategoryKey;
import com.znow.financemanaging.business_logic.money_transfer.MoneyTransfer;
import com.znow.financemanaging.controllers.CategoriesFrameController;
import com.znow.financemanaging.controllers.MainFrameController;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

@SuppressWarnings("serial")
public class PromptWindow extends Window {
	
	public PromptWindow() {
		init();
	}
	
	public void drawMoneyTransferPrompt(MainFrameController controller, CategoryKey key) {
		JPanel root = new JPanel();
		root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
		setContentPane(root);
		
		String[] categories = controller.getCategories(key);
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox categorySelector = new JComboBox(categories);
		categorySelector.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		add(categorySelector);
		
		JLabel guideLabelAmount = new JLabel("Amount:");
		add(guideLabelAmount);
		
		JTextField amountTxt = new JTextField();
		add(amountTxt);
		
		JLabel guideLabelComment = new JLabel("Comment:");
		add(guideLabelComment);
		
		JTextField commentTxt = new JTextField();
		add(commentTxt);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		 
		add(datePicker);
		
		String transferStr = "null";
		if (key == CategoryKey.INCOME_CATEGORIES)
			transferStr = "income";
		else if (key == CategoryKey.EXPENSE_CATEGORIES)
			transferStr = "expense";
		
		JButton submitButton = new JButton("Add " + transferStr);
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
				MoneyTransfer transfer = new MoneyTransfer(key, amountTxt.getText(), 
						commentTxt.getText(), datePicker.getModel().getValue().toString());
				
				controller.onSubmitMoneyTransfer(transfer);
			}
		});
		add(submitButton);
		
		pack();
	}
	
	public void drawCategoryPrompt(CategoriesFrameController controller, String category) {
		JPanel root = new JPanel();
		root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
		setContentPane(root);
		
		JLabel guideLabel = new JLabel("Do you want to delete '" + category + "'?");
		add(guideLabel);
		
		JButton yesButton = new JButton("Yes");
		yesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.onDeleteCategoryButton(category);
				dispose();
			}
		});
		add(yesButton);
		
		JButton noButton = new JButton("No");
		noButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(noButton);
		
		pack();
	}
	
	public void drawAddCategoryPrompt(CategoriesFrameController controller, String key) {
		JPanel root = new JPanel();
		root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
		setContentPane(root);
		
		JLabel guideLabel = new JLabel("Enter " + key + " category name:");
		add(guideLabel);
		
		JTextField categoryNameTxt = new JTextField();
		add(categoryNameTxt);
		
		JButton submitButton = new JButton("Add " + key + " category");
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onSubmitCategoryButton(categoryNameTxt.getText());
				dispose();
			}
		});
		add(submitButton);
		
		pack();
	}
	
}
