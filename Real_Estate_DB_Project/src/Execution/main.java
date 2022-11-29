package Execution;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class main extends JFrame {

	private MainPanel contentPane;
	private JPanel westPanel;

	private JFrame frame;
	private JButton mainButton;
	ImageIcon img = new ImageIcon("images/Home.png");
	ImageIcon img2 = new ImageIcon("images/Home2.png");
	ImageIcon img3 = new ImageIcon("images/Home3.png");
	ImageIcon userimg = new ImageIcon("images/user.png");
	ImageIcon userimg2 = new ImageIcon("images/user2.png");
	ImageIcon userimg3 = new ImageIcon("images/user3.png");
	private JButton userButton;
	

	
	
	public main() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("메인화면");
		frame.setBounds(100, 100, 465, 330);
		frame.setVisible(true);
		
		contentPane = new MainPanel();
		contentPane.mJPanel = new mainJPanel(contentPane);
		contentPane.uJPanel = new userPanel(contentPane);
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		westPanel = new JPanel();
		westPanel.setPreferredSize(new Dimension(60,20));
		westPanel.setBackground(Color.LIGHT_GRAY);
		westPanel.setBorder(new EmptyBorder(0,0,0,0));
		mainButton = new JButton(img);
		mainButton.setPressedIcon(img2);
		mainButton.setBorderPainted(false);
		mainButton.setFocusPainted(false);
		mainButton.setContentAreaFilled(false);
		mainButton.setActionCommand("main");
		mainButton.addActionListener(new MyActionListener());
		
		contentPane.add(westPanel,BorderLayout.WEST);
		contentPane.add(contentPane.mJPanel,BorderLayout.CENTER);
		westPanel.add(mainButton);

		userButton = new JButton(userimg3);
		userButton.setActionCommand("user");
		userButton.setPressedIcon(userimg2);
		userButton.setBorderPainted(false);
		userButton.setFocusPainted(false);
		userButton.setContentAreaFilled(false);
		userButton.addActionListener(new MyActionListener());
		westPanel.add(userButton);
	}
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn.getActionCommand()=="main") {
				contentPane.change("mainPanel");
				mainButton.setIcon(img);
				userButton.setIcon(userimg3);
			}
			else {
				contentPane.change("userPanel");
				userButton.setIcon(userimg);
				mainButton.setIcon(img3);
			}
		}
	}
}
 