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

	public boolean sqlCallableStatement(String ID1) throws SQLException {	//아이디중복체크 메소드
		con = dbConnect.getConnection();
		cstmt = con.prepareCall("{call OVERLAP_CHECK(?, ?)}");
		try {
			cstmt.setString(1, ID1);	// SignUp 파일에서 매개변수를 넘겨 받을 후 프로시저 호출
			cstmt.registerOutParameter(2, Types.INTEGER);	// 아웃 파라미터 저장
			cstmt.executeQuery();
			System.out.println(cstmt.getInt(2));
			if(cstmt.getInt(2) == 0) {	// getInt(2) 가 0일때는 중복된 아이디가 없다는 뜻(중복된 아이디 갯수가 0)
				System.out.println("성공");
				return true;		// true 값 반환하여 SignUp 파일로 전달
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
	
	public void ContractBuilding(String Broker, String ID1, int B_Num) throws SQLException{	//건물계약 메소드
		con = dbConnect.getConnection();
		con.setAutoCommit(false);	// 트랜잭션 오토커밋 끄기
		cstmt = con.prepareCall("{call BUY_BUILDING(?, ?, ?)}");
		try {
			cstmt.setString(1, Broker);		//중개사아이디
			cstmt.setString(2, ID1);	//고객아이디
			cstmt.setInt(3, B_Num);		//건물일련번호
			cstmt.executeQuery();
			con.commit();		// 커밋
			System.out.println("계약성공!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void SqlModifyBuilding(String ID, String PW, String City, long Money, String terms) throws SQLException {
		con = dbConnect.getConnection();
		cstmt = con.prepareCall("{call MODIFY_USER(?, ?, ?, ?, ?)}");
		try {
			cstmt.setString(1, ID);	//고객아이디
			cstmt.setString(2, PW);
			cstmt.setString(3, City);
			cstmt.setLong(4, Money);		//건물일련번호
			cstmt.setString(5, terms);
			cstmt.executeQuery();
			System.out.println("회원정보수정 성공!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
