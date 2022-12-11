package Execution;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DB_Package.*;
import Entity.*;
import java.util.*;

public class BuildingCondition extends JFrame {
	private JFrame frame;
	private JScrollPane brokerScroll;
	private JPanel contentPane;
	private JTable brokerTable;
	private String[] brokerHeader = { "이름", "전화번호","매물개수", "위치" };
	private String[] buildingHeader = { "건물형태", "주소", "계약조건" };
	private String[] RegionString = { "전체", "서울", "진주", "인천", "부산", "포항", "대전", "대구", "마산", "광주", "전북", "울산", "제주",
			"제주" };
	private int[] columnsSize = { 90, 150, 165 };
	private JScrollPane BuildingScroll;
	private JTable buildingTable;
	private DefaultTableModel brokerModel;
	private DefaultTableModel buildingModel;
	private DB_Statement dExecution = new DB_Statement();
	private JComboBox comboBox;
	private Vector<Broker> brokerList = new Vector<>();
	private Vector<Building> buildingList = new Vector<>();
	private String sql;
	private String userId;
	private String brokerId;

	public BuildingCondition(String userId) throws SQLException {
		this.userId = userId;
		initialize();
	}

	private void initialize() throws SQLException {
		frame = new JFrame("메인화면");
		frame.setBounds(100, 100, 880, 400);
		frame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		frame.setLocationRelativeTo(null);
		comboBox = new JComboBox(RegionString);
		comboBox.setBounds(12, 31, 326, 21);
		contentPane.add(comboBox);

		JButton SearchButton = new JButton("검색");
		SearchButton.setBounds(350, 31, 62, 21);
		SearchButton.addActionListener(new RegionSearch());
		contentPane.add(SearchButton);
		brokerModel = new DefaultTableModel(brokerHeader, 0) {
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
		brokerTable.addMouseListener(new BuildingSearch());
		contentPane.add(brokerScroll);

		buildingModel = new DefaultTableModel(buildingHeader, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		;
		buildingTable = new JTable(buildingModel);
		buildingTable.addMouseListener(new DoubleMouseListener());
		BuildingScroll = new JScrollPane(buildingTable);
		BuildingScroll.setBounds(454, 64, 400, 284);
		contentPane.add(BuildingScroll);

	}

	class RegionSearch implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Regionstr = comboBox.getSelectedItem().toString();
			if (Regionstr.equals("전체")) {
				sql = "select * from 중개사";
			} else {
				sql = "select * from 중개사 where \"중개소위치\" like '" + Regionstr + "%'";
			}
			try {
				brokerList = dExecution.BrokerSearch(sql);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			brokerModel.setNumRows(0);
			for (int i = 0; i < brokerList.size(); i++) {
				Object obj[] = { brokerList.get(i).getName(), brokerList.get(i).getPhoneNumber(),brokerList.get(i).getCount(),
						brokerList.get(i).getAddress() };
				brokerModel.addRow(obj);
			}
		}
	}

	class BuildingSearch extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			JTable buildingTable = (JTable) e.getSource();

			// 클릭한 행 및 컬럼 위치 확보
			int clickedTableRow = buildingTable.getSelectedRow(); // 행
			brokerId = brokerList.get(clickedTableRow).getId();
			sql = "select 건물.건물형태,건물.주소,건물.계약조건 from 건물 where 계약여부 = 0 AND 건물.\"중개사ID\" = '"	// 계약여부가 0인 건물들만 출력
					+ brokerId + "'" ;
			try {
				buildingList = dExecution.BuildingSearch(sql);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			buildingModel.setNumRows(0);
			for (int i = 0; i < buildingList.size(); i++) {
				Object obj[] = { buildingList.get(i).getShape(), buildingList.get(i).getAddress(),
						buildingList.get(i).getCondition()};
				buildingModel.addRow(obj);
			}
		}
	}
	class DoubleMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {
				JTable buildingInfoTable = (JTable) e.getSource();
				int Row = buildingInfoTable.getSelectedRow(); // 행
				String addressSelected = buildingInfoTable.getModel().getValueAt(Row, 1).toString();
				try {
					new moreInformation(addressSelected,brokerId,userId);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
