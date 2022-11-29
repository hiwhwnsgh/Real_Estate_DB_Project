package Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Execution.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField ID_textField;
	private JTextField PW_textField;
	private JButton btnSignUp;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		lblNewLabel.setBounds(120, 27, 101, 49);
		contentPane.add(lblNewLabel);
		
		ID_textField = new HintTextField("ID");
		ID_textField.setBounds(50, 112, 175, 27);
		contentPane.add(ID_textField);
		
		
		
		PW_textField = new HintTextField("PassWord");
		PW_textField.setBounds(50, 149, 175, 27);
		contentPane.add(PW_textField);
		PW_textField.setColumns(10);
		
		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new main();
			}
		});
		btnLogin.setBounds(237, 114, 85, 62);
		contentPane.add(btnLogin);
		
		btnSignUp = new JButton("회원가입");
		btnSignUp.setBounds(124, 198, 97, 23);
		contentPane.add(btnSignUp);
		setVisible(true);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUp();
			}			
		});
	}
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


