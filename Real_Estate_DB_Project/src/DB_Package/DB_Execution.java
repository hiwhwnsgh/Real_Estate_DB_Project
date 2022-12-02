package DB_Package;

import java.sql.*;
import java.util.*;
import Entity.*;

public class DB_Execution {
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
			broker.setCount(i++);
			broker.setAddress(rs.getString(i++));
			broker.setPhoneNumber(rs.getString(i));
			i = 1;
			VBroker.add(broker);
		}
		return VBroker;
	}

	public Vector BuildingSearch(String sqlQuery) throws SQLException {
		rs = dbConnect.resultExecuteQuery(sqlQuery);
		i = 2;
		Vector<Building> VBuilding = new Vector<>();
		Building building;
		while (rs.next()) {
			building = new Building();
			building.setAddress(rs.getString(i++));
			building.setCompletionTime(rs.getInt(i++));
			building.setShape(rs.getString(i++));
			building.setSellPrice(rs.getInt(i++));
			building.setCompany(rs.getString(i++));
			building.setSellerId(rs.getString(i++));
			building.setBrokerId(rs.getString(i++));
			i=2;
			VBuilding.add(building);
		}
		return VBuilding;
	}
}
