package DB_Package;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;

public class DB_CallableStatement {
	DB_Connect dbConnect = new DB_Connect();
	Connection con = null;
	CallableStatement cstmt = null;
	ResultSet rs = null;

	public boolean sqlCallableStatement(String ID1) throws SQLException {
		con = dbConnect.getConnection();
		cstmt = con.prepareCall("{call OVERLAP_CHECK(?, ?)}");
		try {
			cstmt.setString(1, ID1);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.executeQuery();
			System.out.println(cstmt.getInt(2));
			if(cstmt.getInt(2) == 0) {
				System.out.println("성공");
				return true;
			}
			else {
				System.out.println("실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			try {
//				cstmt.close();
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
		return false;
	}


}
