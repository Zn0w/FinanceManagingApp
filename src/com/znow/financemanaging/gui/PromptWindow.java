package com.znow.financemanaging.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.znow.financemanaging.controllers.MainFrameController;
import com.znow.financemanaging.controllers.category_frame_controller.CategoriesFrameController;

@SuppressWarnings("serial")
public class PromptWindow extends Window {
	
	public PromptWindow() {
		init();
	}
	
	public void drawMoneyTransferPrompt(MainFrameController controller, String transfer) {
		JPanel root = new JPanel();
		root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
		setContentPane(root);
		
		// CategorySelector
		
		JLabel guideLabelAmount = new JLabel("Amount:");
		add(guideLabelAmount);
		
		JTextField amountTxt = new JTextField();
		add(amountTxt);
		
		JLabel guideLabelComment = new JLabel("Comment:");
		add(guideLabelComment);
		
		JTextField commentTxt = new JTextField();
		add(commentTxt);
		
		// DateSelector
		
		JButton submitButton = new JButton("Add " + transfer);
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
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
