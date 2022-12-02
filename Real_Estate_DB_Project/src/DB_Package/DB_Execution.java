package DB_Package;

import java.sql.*;
import java.util.*;
import Entity.*;

public class DB_Execution {
	DB_Connect dbConnect = new DB_Connect();
	ResultSet rs = null;
	public Vector BrokerSearch(String sqlQuery) throws SQLException {
		rs = dbConnect.resultExecuteQuery(sqlQuery);
		System.out.println(rs);
		Vector<Broker> VBroker = new Vector<>();
		Broker broker;
		int i = 1;
		while (rs.next()) {
			broker = new Broker();
			broker.setName(rs.getString(i++));
			broker.setPhoneNumber(rs.getString(i++));
			broker.setAddress(rs.getString(i));
			i = 1;
			VBroker.add(broker);
		}
		return VBroker;
	}
}
