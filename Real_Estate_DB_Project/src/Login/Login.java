package Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB_Package.DB_PrepareStatement;
import Execution.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField ID_textField;
	private JTextField PW_textField;
	private String inputPW = "";
	private String star="";
	private JButton btnSignUp;
	private DB_PrepareStatement DBpstmt=new DB_PrepareStatement();
	public String ID;
	ImageIcon img = new ImageIcon("images/SignUpImage.png");
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginLabel.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		loginLabel.setBounds(120, 27, 101, 49);
		contentPane.add(loginLabel);
		
		ID_textField = new HintTextField("ID");
		ID_textField.setBounds(50, 112, 175, 27);
		contentPane.add(ID_textField);
		
		
		
		PW_textField = new HintTextField("PassWord");
		PW_textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				star="";
				if(e.getKeyCode()==8) {//백스페이스(지우기)키 눌렀을때
					try {
						inputPW=inputPW.substring(0,inputPW.length()-1);
					}catch(StringIndexOutOfBoundsException se) {
						//빈칸인경우(지울 문자열 없음)
						inputPW="";
					}
				}		
				else //문자 아무꺼나 입력됐을 경우
					inputPW+=e.getKeyChar();
				
				//문자열의 길이만큼의 *을 화면에 출력
				for(int i=0; i<inputPW.length(); i++)
					star+="*";
				PW_textField.setText(star);
			}
		});
		PW_textField.setBounds(50, 149, 175, 27);
		contentPane.add(PW_textField);
		PW_textField.setColumns(10);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID=ID_textField.getText();
				String PW=inputPW;
				try {
					System.out.println(ID);
					if(DBpstmt.IsIDPWTrue(ID,PW)) {
						new main(ID_textField.getText());
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 다시 확인해 주세요.", "로그인 실패", JOptionPane.INFORMATION_MESSAGE);
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(237, 114, 85, 62);
		contentPane.add(btnLogin);
		setLocationRelativeTo(null);
		btnSignUp = new JButton(img);
		btnSignUp.setBorderPainted(false);
		btnSignUp.setFocusPainted(false);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBounds(120, 188, 97, 23);
		contentPane.add(btnSignUp);
		setVisible(true);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUp();
			}			
		});
	}

//	public String id() {
//		return ID;
//	}
	class HintTextField extends JTextField {  

		Font gainFont = new Font("Tahoma", Font.PLAIN, 11);  
		  Font lostFont = new Font("Tahoma", Font.ITALIC, 11);  
		  public HintTextField(final String hint) {  
		    setText(hint);  
		    setFont(lostFont);  
		    setForeground(Color.GRAY);
		    this.addFocusListener(new FocusAdapter() {  
		      @Override  
		      public void focusGained(FocusEvent e) {  
		        if (getText().equals(hint)) {  
		          setText("");  
		          setFont(gainFont);  
		        } else {  
		          setText(getText());  
		          setFont(gainFont);  
		        }  
		      }  
		      @Override  
		      public void focusLost(FocusEvent e) {  
		        if (getText().equals(hint)|| getText().length()==0) {  
		          setText(hint);  
		          setFont(lostFont);  
		          setForeground(Color.GRAY);  
		        } else {  
		          setText(getText());  
		          setFont(gainFont);  
		          setForeground(Color.BLACK);  
		        }
		      }
		    });  
		  }  
		}  
}


