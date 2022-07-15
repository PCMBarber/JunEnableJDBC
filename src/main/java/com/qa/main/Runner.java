package com.qa.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {
	public static void main(String[] args) {
		JDBC dbCon = new JDBC("root", "root");
		int a = 0;
		
		try (Connection con = dbCon.getConnection();
				Statement state = con.createStatement();) {
			
			a = state.executeUpdate("insert into trainee values(0, 'Piers', 'Trainer');");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(a);
		
		try (Connection con = dbCon.getConnection();
				Statement state = con.createStatement();) {
			
			a = state.executeUpdate("delete from trainee where id=1;");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(a);
		
		try (Connection con = dbCon.getConnection();
				Statement state = con.createStatement();) {
			
			ResultSet rs = state.executeQuery("select * from trainee;");
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String course = rs.getString("course");
				
				System.out.println("Trainee ID="+id+", Name="+name+", course="+course);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
