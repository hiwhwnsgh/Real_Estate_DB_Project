package DB_Package;

import java.sql.*;
import java.util.*;
import Entity.*;

public class DB_Statement {
	DB_Connect dbConnect = new DB_Connect();
	ResultSet rs = null;
	int i;

	public Vector BrokerSearch(String sqlQuery) throws SQLException {
		rs = dbConnect.resultExecuteQuery(sqlQuery);
		Vector<Broker> VBroker = new Vector<>();
		Broker broker;
		i = 1;
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

	public Vector BuildingSearch(String sqlQuery) throws SQLException {
		rs = dbConnect.resultExecuteQuery(sqlQuery);
		i = 1;
		Vector<Building> VBuilding = new Vector<>();
		Building building;
		while (rs.next()) {
			building = new Building();
			building.setShape(rs.getString(i++));
			building.setAddress(rs.getString(i++));
			building.getSeller().setCondition(rs.getString(i));
			i=1;
			VBuilding.add(building);
		}
		return VBuilding;
	}
	
}
