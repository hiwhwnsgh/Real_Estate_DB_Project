package Login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DB_Package.DB_CallableStatement;
import DB_Package.DB_PrepareStatement;


public class SignUp extends JFrame {
	DB_PrepareStatement DBpstmt = new DB_PrepareStatement();
	DB_CallableStatement DBcstmt = new DB_CallableStatement();
	private JPanel contentPane;
	private JFrame frame;
	private JLabel idLabel;
	private JLabel pwLabel;
	private JLabel capitalLabel;
	private JLabel hopeCityLabel;
	private JLabel conditionLabel;
	private String[] ConditionString = {"월세","전세","매매"};
	private JTextField idTextField;
	private TextField pwTextField;
	private JTextField capitalTextField;
	private JLabel CheckPwLabel;
	private TextField checkPwTextField;
	private JComboBox comboBox, regionComboBox, conditionComboBox;
	private String[] PriceString = {"만원","억원"};
	private String[] RegionString = {"서울", "경기", "인천", "부산", "춘천", "대전", "대구", "전남", "전북", "경북", "경남", "강원", "제주"};
	protected String ID1;
	public SignUp() {
		initialize();
	}

	// 프레임 초기화
	private void initialize() {
		frame = new JFrame("회원가입");
		frame.setBounds(100, 100, 439, 577);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("회원 가입");
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
		
		conditionComboBox = new JComboBox(ConditionString);
		conditionComboBox.setBounds(45, 425, 250, 23);
		frame.getContentPane().add(conditionComboBox);
		
		idTextField = new JTextField();
		idTextField.setBounds(45, 125, 250, 21);
		frame.getContentPane().add(idTextField);
		idTextField.setColumns(10);
		
		pwTextField = new TextField();
		pwTextField.setEchoChar('*');
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
		
		checkPwTextField = new TextField();
		checkPwTextField.setEchoChar('*'); // 암호화
		checkPwTextField.setColumns(10);
		checkPwTextField.setBounds(45, 245, 250, 21);
		frame.getContentPane().add(checkPwTextField);
		
		JButton IdCheckButton = new JButton("중복 확인");
		IdCheckButton.setBounds(307, 124, 91, 23);
		frame.getContentPane().add(IdCheckButton);
		IdCheckButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ID1 = idTextField.getText();
				try {
					if(DBcstmt.sqlCallableStatement(ID1) == true)	// 중복체크를 위한 CallableStatement 함수 호출
						JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
					
					else	// 함수호출 리턴값이 false일때 (회원가입 불가능)
						JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.", "경고", JOptionPane.WARNING_MESSAGE);
					
				} catch (SQLException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		
		JButton SignUpButton = new JButton("가입하기");
		SignUpButton.setBounds(45, 475, 250, 40);
		frame.getContentPane().add(SignUpButton);
		SignUpButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String IID = idTextField.getText();
				String IPW = pwTextField.getText();
				String IPW2 = checkPwTextField.getText();
				if(!IPW.equals(IPW2)) {		// 비밀번호 똑같은지 확인
					JOptionPane.showMessageDialog(null, "비밀번호 불일치!", "경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
					
				long Imoney = Integer.parseInt(capitalTextField.getText());
				
				if(comboBox.getSelectedItem().toString() == "만원") 
					Imoney *= 10000;
				else
					Imoney *= 100000000;
				
				String Icity = regionComboBox.getSelectedItem().toString();
				String Iterms = conditionComboBox.getSelectedItem().toString();
				
						
				try {
					if(DBcstmt.sqlCallableStatement(ID1) == true) {	
					System.out.println("작동");
					DBpstmt.sqlPreparementStatement(IID, IPW, Icity, Imoney, Iterms);
					JOptionPane.showMessageDialog(null, "회원가입 성공", "알림", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.", "경고", JOptionPane.WARNING_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		comboBox = new JComboBox(PriceString);
		comboBox.setBounds(307, 304, 91, 23);
		frame.getContentPane().add(comboBox);
		frame.setLocationRelativeTo(null);
		regionComboBox = new JComboBox(RegionString);
		regionComboBox.setBounds(45, 370, 250, 23);
		frame.getContentPane().add(regionComboBox);
	}
}
