package Execution;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;

public class moreInformation extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JLabel AddressLabel;
	private JTextField AddressTextField;
	private JTextField completionTextField;
	private JTextField ShapeTextField;
	private JTextField PriceTextField;
	private JTextField CompanyTextField;
	private JLabel ConditionLabel;
	private JTextField ConditionTextField;
	public moreInformation(String buildingId) {
		System.out.println(buildingId);
		frame = new JFrame("상세정보");
		frame.setBounds(100, 100, 450, 550);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		
		JLabel TitleLabel = new JLabel("상세 정보");
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		TitleLabel.setBounds(112, 10, 216, 36);
		contentPane.add(TitleLabel);
		
		AddressLabel = new JLabel("주소");
		AddressLabel.setHorizontalAlignment(SwingConstants.LEFT);
		AddressLabel.setBounds(47, 70, 53, 21);
		contentPane.add(AddressLabel);
		
		AddressTextField = new JTextField();
		AddressTextField.setEnabled(false);
		AddressTextField.setBounds(112, 70, 274, 21);
		contentPane.add(AddressTextField);
		AddressTextField.setColumns(10);
		
		JLabel completionLabel = new JLabel("완공시기");
		completionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		completionLabel.setBounds(47, 110, 53, 21);
		contentPane.add(completionLabel);
		
		completionTextField = new JTextField();
		completionTextField.setEnabled(false);
		completionTextField.setColumns(10);
		completionTextField.setBounds(112, 110, 274, 21);
		contentPane.add(completionTextField);
		
		JLabel ShapeLabel = new JLabel("건물 형태");
		ShapeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ShapeLabel.setBounds(47, 150, 53, 21);
		contentPane.add(ShapeLabel);
		
		ShapeTextField = new JTextField();
		ShapeTextField.setEnabled(false);
		ShapeTextField.setColumns(10);
		ShapeTextField.setBounds(112, 150, 274, 21);
		contentPane.add(ShapeTextField);
		
		JLabel PriceLabel = new JLabel("판매 금액");
		PriceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		PriceLabel.setBounds(47, 190, 53, 21);
		contentPane.add(PriceLabel);
		
		PriceTextField = new JTextField();
		PriceTextField.setEnabled(false);
		PriceTextField.setColumns(10);
		PriceTextField.setBounds(112, 190, 274, 21);
		contentPane.add(PriceTextField);
		
		JLabel CompanyLabel = new JLabel("건설사");
		CompanyLabel.setHorizontalAlignment(SwingConstants.LEFT);
		CompanyLabel.setBounds(47, 230, 53, 21);
		contentPane.add(CompanyLabel);
		
		CompanyTextField = new JTextField();
		CompanyTextField.setEnabled(false);
		CompanyTextField.setColumns(10);
		CompanyTextField.setBounds(112, 230, 274, 21);
		contentPane.add(CompanyTextField);
		
		ConditionLabel = new JLabel("계약 조건");
		ConditionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ConditionLabel.setBounds(47, 270, 53, 21);
		contentPane.add(ConditionLabel);
		
		ConditionTextField = new JTextField();
		ConditionTextField.setEnabled(false);
		ConditionTextField.setColumns(10);
		ConditionTextField.setBounds(112, 270, 274, 21);
		contentPane.add(ConditionTextField);
		
		JButton contractButton = new JButton("건물 계약");
		contractButton.setBorderPainted(false);
		contractButton.setBackground(new Color(255, 228, 196));
		contractButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		contractButton.setBounds(47, 335, 339, 45);
		contentPane.add(contractButton);
		frame.setVisible(true);
	}
}
