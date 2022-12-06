package Execution;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.SignUp;

class mainJPanel extends JPanel {
	private JButton ConditionButton;
	private JButton SearchBuilding;
	private JButton UserEditButton;
	private MainPanel frame;

	public mainJPanel(MainPanel framem,String userId) {
		this.frame = frame;

		setLayout(null);
		ConditionButton = new JButton("건물 계약");
		ConditionButton.setForeground(Color.BLACK);
		ConditionButton.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		ConditionButton.setBounds(60, 55, 264, 60);
		ConditionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new BuildingCondition(userId);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}			
		});
		add(ConditionButton);

		SearchBuilding = new JButton("건물 조회");
		SearchBuilding.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		SearchBuilding.setBounds(60, 175, 264, 60);
		add(SearchBuilding);
		SearchBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuildingSearch(userId);
			}			
		});
	}

}

class userPanel extends JPanel {
	private JButton UserEditButton;
	private MainPanel frame;
	public userPanel(MainPanel frame,String userId) {
		this.frame = frame;
		UserEditButton = new JButton("회원 정보 수정");
		UserEditButton.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		UserEditButton.setBounds(60, 295, 264, 200);
		add(UserEditButton);
		UserEditButton.addActionListener(new ActionListener() {	// 회원정보 수정 창띄우기
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UserModify(userId);
			}
		});
	}

}
class MainPanel extends JPanel {
	public MainPanel() {
	}
	public mainJPanel mJPanel = null;
	public userPanel uJPanel = null;

	public void change(String panelName) {
		if (panelName.equals("mainPanel")) {
			remove(uJPanel);
			add(mJPanel,BorderLayout.CENTER);
			revalidate();
			repaint();
		} else {
			remove(mJPanel);
			add(uJPanel,BorderLayout.CENTER);
			revalidate();
			repaint();
		}
	}
}
