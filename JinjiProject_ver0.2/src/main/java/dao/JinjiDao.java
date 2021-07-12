package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Gakusei;
import dbManager.JinjiDBManager;

public class JinjiDao {

	public static List<Gakusei> getGakusei(String sql){
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Gakusei> gakusei_list = null;
		
		try {
			connection = JinjiDBManager.getConnection();

			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();

			gakusei_list = new ArrayList<Gakusei>();
			while(resultSet.next()) {
				Gakusei gakusei = new Gakusei();
				gakusei.setID(resultSet.getString("ID"));
				gakusei.setName(resultSet.getString("Name"));
				gakusei_list.add(gakusei);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			JinjiDBManager.close(statement);
			JinjiDBManager.close(resultSet);
			JinjiDBManager.close(connection);
		}

		return gakusei_list;
	}
	
	public static Boolean updateGakusei(String sql) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Boolean updateOK = false;

		try {
			connection = JinjiDBManager.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			connection.commit();
			updateOK = true;			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			JinjiDBManager.close(statement);
			JinjiDBManager.close(resultSet);
			JinjiDBManager.close(connection);
		}	
		
		return updateOK;
	}
}