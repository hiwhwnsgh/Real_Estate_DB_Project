package DB_Package;

import java.sql.*;

class DB_Connect {
	Connection con = null;
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "realEstate";
	String password = "1234";
	Connection conn = null;
	Statement stmt = null;

	public DB_Connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn= DriverManager.getConnection(url, id, password);
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
	}

	public ResultSet resultExecuteQuery(String sql) {
		// SQL문 실행하기 위한 메소드 - Parameter : String객체로 만든 SQL문
		// 실행결과는 ResultSet으로 반환
		ResultSet src = null;
		try {
			src = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("SQL 실행 에러");
			return null;
		}

		return src;
	}
	public Connection getConnection() {
		// PreparedStatement이용해 SQL 작성할 경우 Connection 객체가 필요해 만든 메소드
		if (conn != null) {
			return conn;
		} else {
			return null;
		}

	}
}
