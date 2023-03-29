package com.kce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kce.model.Register;
import com.kce.util.DBUtil;

import java.sql.Statement;
import java.util.ArrayList;

public class RegisterDao {
	public RegisterDao() {
		createTable();
	}
	public void createTable() {
		String query=""
				+ "CREATE TABLE IF NOT EXISTS Register("
				+ "firstName VARCHAR(50) NOT NULL,"
				+ "lastName VARCHAR(50) NOT NULL,"
				+ "birthDay VARCHAR(50) NOT NULL,"
				+ "gender VARCHAR(7) NOT NULL,"
				+ "Email VARCHAR(50) NOT NULL PRIMARY KEY,"
				+ "phoneNumber VARCHAR(50) NOT NULL,"
				+ "memberShip VARCHAR(8) NOT NULL"
				+ ")";
		Connection connection = DBUtil.createConnection();
		if(connection!=null) {
			try {
				Statement statemant = connection.createStatement();
				statemant.execute(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean insertRegistration(Register registerationInfo) {
		Connection connection = DBUtil.createConnection();
		String query="INSERT INTO Register VALUES (?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, registerationInfo.getFirstName());
			preparedStatement.setString(2, registerationInfo.getLastName());
			preparedStatement.setString(3, registerationInfo.getBirthDay());
			preparedStatement.setString(4, registerationInfo.getGender());
			preparedStatement.setString(5, registerationInfo.getEmail());
			preparedStatement.setString(6, registerationInfo.getPhoneNumber());
			preparedStatement.setString(7, registerationInfo.getMemberShip());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Register> getRegisterationDetailsList() {
		ArrayList<Register> registeredUsers = new ArrayList<Register>();
		Connection connection = DBUtil.createConnection();
		String query="SELECT * FROM Register";
		try {
			Statement statemant = connection.createStatement();
			ResultSet resultSet = statemant.executeQuery(query);
			while(resultSet.next()) {
				Register user = new Register();
				user.setFirstName(resultSet.getString(1));
				user.setLastName(resultSet.getString(2));
				user.setBirthDay(resultSet.getString(3));
				user.setGender(resultSet.getString(4));
				user.setEmail(resultSet.getString(5));
				user.setPhoneNumber(resultSet.getString(6));
				user.setMemberShip(resultSet.getString(7));
				registeredUsers.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registeredUsers;
	}
	
	public boolean deleteUser(String emailId) {
		Connection connection = DBUtil.createConnection();
		String query="DELETE FROM Register WHERE Email=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,emailId);
			int rowsAffected = preparedStatement.executeUpdate();
			if(rowsAffected==0) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateUser(Register registerationInfo) {
		Connection connection = DBUtil.createConnection();
		String query="UPDATE Register SET firstName=?,lastName=?,birthDay=?,gender=?,phoneNumber=? WHERE Email=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, registerationInfo.getFirstName());
			preparedStatement.setString(2, registerationInfo.getLastName());
			preparedStatement.setString(3, registerationInfo.getBirthDay());
			preparedStatement.setString(4, registerationInfo.getGender());
			preparedStatement.setString(5, registerationInfo.getPhoneNumber());
			preparedStatement.setString(6, registerationInfo.getEmail());
			int rowsAffected = preparedStatement.executeUpdate();
			if(rowsAffected==0) return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
