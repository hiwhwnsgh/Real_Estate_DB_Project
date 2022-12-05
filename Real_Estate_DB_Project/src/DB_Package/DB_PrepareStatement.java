package DB_Package;

import java.sql.*;
import java.util.Vector;

import Entity.Building;

public class DB_PrepareStatement {
	DB_Connect dbConnect = new DB_Connect();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	public void sqlPreparementStatement(String ID, String PW, String city, long money, String terms) throws SQLException{
		String sql = "INSERT INTO 고객 VALUES (?,?,?,?,?)";
		con = dbConnect.getConnection();
		pstmt = con.prepareStatement(sql);
		
		try {
			pstmt.setString(1, ID);
			pstmt.setString(2, PW);
			pstmt.setString(3, city);
			pstmt.setLong(4, money);
			pstmt.setString(5, terms);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("회원가입 실패!");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	public Vector BulidingSearch(String city, String condition, long money, String order) throws SQLException{
		Vector<Building> VBuilding = new Vector<>();
<<<<<<< HEAD
		String sql = "select 임대인.판매자ID,건물.주소,임대인.계약조건,건물.판매금액"
				+ " from 건물,임대인 where 건물.주소 = ?"
				+ " and 임대인.계약조건 = ? and 건물.판매금액 = ?";
		con = dbConnect.getConnection();
		pstmt = con.prepareStatement(sql);
		try {
			pstmt.setString(1, "서울시 종로구 100번지");
			pstmt.setString(2, "전세");
			pstmt.setLong(3, 1200000000);
=======
		//select 임대인.판매자ID,건물.주소,임대인.계약조건,건물.판매금액 from 건물,임대인 where 건물.주소 = '서울시 종로구 100번지' and 임대인.계약조건 = '전세' and 건물.판매금액 = 1200000000
		//String sql = "select 임대인.판매자ID,건물.주소,임대인.계약조건,건물.판매금액"
		//		+ " from 건물,임대인 where 건물.주소 = ?"
		//		+ " and 임대인.계약조건 = ? and 건물.판매금액 = ?";
		String sql = "select 임대인.판매자ID,건물.주소,임대인.계약조건,건물.판매금액"
				+ " from 건물,임대인 where 건물.주소 like ?"
				+ " and 임대인.계약조건 = '전세'"
				+ " and 건물.판매금액 = ?";
		con = dbConnect.getConnection();
		pstmt = con.prepareStatement(sql);
		try {
			pstmt.setString(1, city+"%");
			//pstmt.setString(2, "전세");
			pstmt.setLong(2, money);
>>>>>>> f7d3ae95739ad04b7633d6a41f9bd3216cb019e5
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int i = 1;
		Building building;
		while (rs.next()) {
<<<<<<< HEAD
			System.out.print(rs.getString(3));
=======
>>>>>>> f7d3ae95739ad04b7633d6a41f9bd3216cb019e5
			building = new Building();
			building.getSeller().setSellerId(rs.getString(i++));
			building.setAddress(rs.getString(i++));
			building.getSeller().setCondition(rs.getString(i++));
			building.setSellPrice(rs.getInt(i++));
			i = 1;
			VBuilding.add(building);
		}
		return VBuilding;
	}
<<<<<<< HEAD
=======

>>>>>>> f7d3ae95739ad04b7633d6a41f9bd3216cb019e5
}
