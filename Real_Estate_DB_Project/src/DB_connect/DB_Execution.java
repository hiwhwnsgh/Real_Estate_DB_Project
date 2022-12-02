package DB_connect;
import java.sql.*;

class DB_Execution {
	DB_Connect dbConnect = new DB_Connect();
	ResultSet rs = null;
	public void sqlrun(String sqlQuery) throws SQLException {
		rs = dbConnect.resultExecuteQuery(sqlQuery);
		while(rs.next()) {
			System.out.println(rs.getString("고객id"));
		}
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DB_Execution db = new DB_Execution();
		db.sqlrun("select * from 고객");
	}
}
