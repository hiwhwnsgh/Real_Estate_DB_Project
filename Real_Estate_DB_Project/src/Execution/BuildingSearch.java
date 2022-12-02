package Execution;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class BuildingSearch extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField;
	private String[] ConditionString = {"월세","전세","매매"};
	private String[] PriceString = {"만원","억원"};
	private String[] buildingHeader = {"이름","주소","조건","가격"};
	private String[] RegionString = {"전체","서울", "경기", "인천", "부산", "춘천", "대전", "대구", "전남", "전북", "경북", "경남", "강원", "제주"};
	private JTable table;
	public BuildingSearch() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame("건물 검색");
		frame.setBounds(100, 100, 450, 570);
		frame.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		frame.getContentPane().add(contentPane);
		
		JLabel areaLabel = new JLabel("지역");
		areaLabel.setBounds(18, 10, 57, 15);
		contentPane.add(areaLabel);
		
		JComboBox cityComboBox = new JComboBox(RegionString);
		cityComboBox.setBounds(18, 35, 101, 23);
		contentPane.add(cityComboBox);
		
		JLabel conditionLabel = new JLabel("조건");
		conditionLabel.setBounds(18, 68, 57, 15);
		contentPane.add(conditionLabel);
		
		JComboBox conditionComboBox = new JComboBox(ConditionString);
		conditionComboBox.setBounds(18, 93, 101, 23);
		contentPane.add(conditionComboBox);
		
		JLabel PriceLabel = new JLabel("가격");
		PriceLabel.setBounds(18, 126, 57, 15);
		contentPane.add(PriceLabel);
		
		textField = new JTextField();
		textField.setBounds(18, 145, 101, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox PriceComboBox = new JComboBox(PriceString);
		PriceComboBox.setBounds(128, 145, 57, 23);
		contentPane.add(PriceComboBox);
		DefaultTableModel model = new DefaultTableModel(buildingHeader, 0) {
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		;
		table = new JTable(model);
		table.setBounds(0, 0, 1, 1);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(18, 211, 400, 275);
		contentPane.add(scrollPane);
		
		JRadioButton UpRadioButton = new JRadioButton("높은순");
		UpRadioButton.setBounds(265, 145, 68, 23);
		contentPane.add(UpRadioButton);
		
		JRadioButton DownRadioButton = new JRadioButton("낮은순");
		DownRadioButton.setBounds(193, 145, 68, 23);
		contentPane.add(DownRadioButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(DownRadioButton);
		bg.add(UpRadioButton);
		
		JButton SearchButton = new JButton("조회");
		SearchButton.setBounds(18, 178, 71, 23);
		contentPane.add(SearchButton);
		
		JButton cancelButton = new JButton("닫기");
		cancelButton.setBounds(321, 500, 97, 23);
		contentPane.add(cancelButton);
		
		
	}
}