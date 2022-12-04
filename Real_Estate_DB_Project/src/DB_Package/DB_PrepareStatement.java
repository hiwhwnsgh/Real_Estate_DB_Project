package DB_Package;

import java.sql.*;

public class DB_PrepareStatement {
	DB_Connect dbConnect = new DB_Connect();
	Connection con = null;
	PreparedStatement pstmt = null;
	
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


}
