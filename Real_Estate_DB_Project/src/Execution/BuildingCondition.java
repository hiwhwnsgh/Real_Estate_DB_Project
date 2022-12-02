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
import javax.swing.JScrollPane;

public class BuildingCondition extends JFrame {
	private JFrame frame;
	private JScrollPane brokerScroll;
	private JPanel contentPane;
	private JTextField textField;
	private JTable brokerTable;
	private String[] brokerHeader = { "이름", "전화번호", "위치" };
	private String[] buildingHeader = {"건물형태","주소","계약조건"};
	private int [] columnsSize = {90,150,165};
	private JScrollPane BuildingScroll;
	private JTable buildingTable;
	public BuildingCondition() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("메인화면");
		frame.setBounds(100, 100, 880, 395);
		frame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 10, 82, 29);
		contentPane.add(comboBox);

		textField = new JTextField();
		textField.setBounds(106, 11, 232, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton SeacrchButton = new JButton("검색");
		SeacrchButton.setBounds(350, 10, 62, 29);
		contentPane.add(SeacrchButton);
		DefaultTableModel model = new DefaultTableModel(brokerHeader, 0) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		;
		brokerTable = new JTable(model);
		brokerTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		brokerScroll = new JScrollPane(brokerTable);
		brokerScroll.setBounds(12, 62, 400, 284);
		brokerScroll.setPreferredSize(new Dimension(500, 90));
		contentPane.add(brokerScroll);
		
		
		model.setDataVector(null, buildingHeader);
		buildingTable = new JTable(model);
		BuildingScroll = new JScrollPane(buildingTable);
		BuildingScroll.setBounds(454, 64, 400, 284);
		contentPane.add(BuildingScroll);
		
		
	}
}
