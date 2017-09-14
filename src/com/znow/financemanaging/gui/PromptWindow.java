package com.znow.financemanaging.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.znow.financemanaging.controllers.IncomeCategoriesFrameController;

@SuppressWarnings("serial")
public class PromptWindow extends Window {
	
	public PromptWindow() {
		init();
	}
	
	public void drawAddIncomePrompt() {
		
	}
	
	public void drawAddExpensePrompt() {
		
	}
	
	public void drawAddIncomeCategoryPrompt(IncomeCategoriesFrameController controller) {
		JPanel root = new JPanel();
		root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
		setContentPane(root);
		
		JLabel guideLabel = new JLabel("Enter income category name:");
		add(guideLabel);
		
		JTextField incomeCategoryNameTxt = new JTextField();
		add(incomeCategoryNameTxt);
		
		JButton submitButton = new JButton("Add income category");
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.onSubmitIncomeCategoryButton(incomeCategoryNameTxt.getText());
			}
		});
		add(submitButton);
		
		pack();
	}
	
}
