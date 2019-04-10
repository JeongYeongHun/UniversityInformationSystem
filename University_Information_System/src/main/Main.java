package main;

import javax.swing.JFrame;

import mvc.controller.LoginHandler;
import mvc.view.LoginPanel;
import mvc.view.MainFrame;

/**
 * @author 정영훈
 *
 */

public class Main {

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		LoginPanel loginPanel = new LoginPanel();
		MainFrame ui = new MainFrame(loginPanel);
		new LoginHandler(ui);
		ui.setVisible(true);
	}

}
