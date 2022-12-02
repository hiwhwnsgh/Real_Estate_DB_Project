package DB_Package;

import java.sql.*;
import java.util.*;
import Entity.*;

public class DB_Execution {
	DB_Connect dbConnect = new DB_Connect();
	ResultSet rs = null;
	String sqlQuery;
	public Vector BrokerSearch() throws SQLException {
		sqlQuery = "select * from 중개사";
		rs = dbConnect.resultExecuteQuery(sqlQuery);
		Vector<Broker> VBroker = new Vector<>();
		Broker broker;
		int i = 1;
		while (rs.next()) {
			broker = new Broker();
			broker.setBrokerId(rs.getString(i++));
			broker.setName(rs.getString(i++));
			broker.setCount(rs.getInt(i++));
			broker.setAddress(rs.getString(i++));
			broker.setPhoneNumber(rs.getString(i));
			i = 1;
			VBroker.add(broker);
		}
		return VBroker;
	}
}
