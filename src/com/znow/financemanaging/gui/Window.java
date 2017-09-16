package com.znow.financemanaging.gui;

import javax.swing.JFrame;

@SuppressWarnings("serial")
class Window extends JFrame {
	
	protected void init() {
		setTitle("Finance Managing App");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
}
