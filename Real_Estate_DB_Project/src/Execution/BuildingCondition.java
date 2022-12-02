package Execution;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import DB_Package.*;
import Entity.*;
import java.util.*;

public class BuildingCondition extends JFrame {
	private JFrame frame;
	private JScrollPane brokerScroll;
	private JPanel contentPane;
	private JTable brokerTable;
	private String[] brokerHeader = { "이름", "전화번호", "위치" };
	private String[] buildingHeader = {"건물형태","주소","계약조건"};
	private String[] RegionString = {"전체","서울", "경기", "인천", "부산", "춘천", "대전", "대구", "전남", "전북", "경북", "경남", "강원", "제주"};
	private int [] columnsSize = {90,150,165};
	private JScrollPane BuildingScroll;
	private JTable buildingTable;
	private DefaultTableModel brokerModel;
	private DefaultTableModel buildingModel;
	private DB_Execution dExecution;
	private JComboBox comboBox;
	private Vector<Broker> vBroker = new Vector<>();
	public BuildingCondition() throws SQLException {
		initialize();
	}

	private void initialize() throws SQLException {
		frame = new JFrame("메인화면");
		frame.setBounds(100, 100, 880, 395);
		frame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);

		comboBox = new JComboBox(RegionString);
		comboBox.setBounds(12, 31, 326, 21);
		contentPane.add(comboBox);

		JButton SearchButton = new JButton("검색");
		SearchButton.setBounds(350, 31, 62, 21);
		SearchButton.addActionListener(new RegionSearch());
		contentPane.add(SearchButton);
		brokerModel = new DefaultTableModel(brokerHeader,0){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		;
		brokerTable = new JTable(brokerModel);
		brokerTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		brokerScroll = new JScrollPane(brokerTable);
		brokerScroll.setBounds(12, 62, 400, 284);
		brokerScroll.setPreferredSize(new Dimension(500, 90));
		contentPane.add(brokerScroll);
		
		buildingModel = new DefaultTableModel(buildingHeader,0) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		;
		buildingTable = new JTable(buildingModel);
		BuildingScroll = new JScrollPane(buildingTable);
		BuildingScroll.setBounds(454, 64, 400, 284);
		contentPane.add(BuildingScroll);
		
	}
	class RegionSearch implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String Regionstr = comboBox.getSelectedItem().toString();
			String sql;
			if(Regionstr.equals("전체")) {
				sql = "select 이름,전화번호,중개소위치 from 중개사";
			}
			else {
				sql = "select 이름,전화번호,중개소위치 from 중개사 where \"중개소위치\" like '"+Regionstr+"%'";
			}
			dExecution = new DB_Execution();
			try {
				vBroker = dExecution.BrokerSearch(sql);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			brokerModel.setNumRows(0);
			System.out.println(vBroker.size());
			for(int i=0;i<vBroker.size();i++) {
				Object obj[] = {vBroker.get(i).getName(),vBroker.get(i).getPhoneNumber(),vBroker.get(i).getAddress()};
				brokerModel.addRow(obj);
			}
		}
	}
}
