package Execution;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.sql.*;

public class UserModify {
	private JPanel contentPane;
	private JFrame frame;
	private JLabel idLabel;
	private JLabel pwLabel;
	private JLabel capitalLabel;
	private JLabel hopeCityLabel;
	private JLabel conditionLabel;
	private String[] ConditionString = {"월세","전세","매매"};
	private JTextField idTextField;
	private JTextField pwTextField;
	private JTextField capitalTextField;
	private JLabel CheckPwLabel;
	private JTextField checkPwTextField;
	private JComboBox comboBox;
	private String[] PriceString = {"만원","억원"};
	private String[] RegionString = {"서울", "경기", "인천", "부산", "춘천", "대전", "대구", "전남", "전북", "경북", "경남", "강원", "제주"};
	public UserModify() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("회원정보 수정");
		frame.setBounds(100, 100, 439, 577);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("회원정보 수정");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(137, 25, 163, 40);
		titleLabel.setFont(new Font("맑은 고딕",Font.BOLD,22));
		frame.getContentPane().add(contentPane);
		frame.getContentPane().add(titleLabel);
		
		idLabel = new JLabel("아이디");
		idLabel.setBounds(45, 100, 50, 15);
		frame.getContentPane().add(idLabel);
		
		pwLabel = new JLabel("비밀번호");
		pwLabel.setBounds(45, 165, 50, 15);
		frame.getContentPane().add(pwLabel);
		
		capitalLabel = new JLabel("자본금");
		capitalLabel.setBounds(45, 285, 50, 15);
		frame.getContentPane().add(capitalLabel);
		
		hopeCityLabel = new JLabel("희망도시");
		hopeCityLabel.setBounds(45, 345, 50, 15);
		frame.getContentPane().add(hopeCityLabel);
		
		conditionLabel = new JLabel("계약조건");
		conditionLabel.setBounds(45, 405, 50, 15);
		frame.getContentPane().add(conditionLabel);
		
		JComboBox conditionComboBox = new JComboBox(ConditionString);
		conditionComboBox.setBounds(45, 425, 250, 23);
		frame.getContentPane().add(conditionComboBox);
		
		idTextField = new JTextField();
		idTextField.setEnabled(false);
		idTextField.setBounds(45, 125, 250, 21);
		frame.getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		pwTextField = new JTextField();
		pwTextField.setColumns(10);
		pwTextField.setBounds(45, 185, 250, 21);
		frame.getContentPane().add(pwTextField);
		
		capitalTextField = new JTextField();
		capitalTextField.setColumns(10);
		capitalTextField.setBounds(45, 305, 250, 21);
		frame.getContentPane().add(capitalTextField);
		
		CheckPwLabel = new JLabel("비밀번호 재확인");
		CheckPwLabel.setBounds(45, 225, 125, 15);
		frame.getContentPane().add(CheckPwLabel);
		
		checkPwTextField = new JTextField();
		checkPwTextField.setColumns(10);
		checkPwTextField.setBounds(45, 245, 250, 21);
		frame.getContentPane().add(checkPwTextField);
		
//		JButton IdCheckButton = new JButton("중복 확인");
//		IdCheckButton.setBounds(307, 124, 91, 23);
//		frame.getContentPane().add(IdCheckButton);
		
		JButton SignUpButton = new JButton("수정");
		SignUpButton.setBounds(45, 475, 250, 40);
		frame.getContentPane().add(SignUpButton);
		
		comboBox = new JComboBox(PriceString);
		comboBox.setBounds(307, 304, 91, 23);
		frame.getContentPane().add(comboBox);
		
		JComboBox regionComboBox = new JComboBox(RegionString);
		regionComboBox.setBounds(45, 370, 250, 23);
		frame.getContentPane().add(regionComboBox);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
