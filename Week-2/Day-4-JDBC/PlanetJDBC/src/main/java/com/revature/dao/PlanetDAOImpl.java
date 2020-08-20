package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Planet;
import com.revature.util.ConnectionFactory;

public class PlanetDAOImpl implements PlanetDAO{

	@Override
	public void insertPlanet(Planet p) {
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO planets (planet_name, planet_description, has_rings, number_of_moons) values "
				+ "(?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setBoolean(3, p.isRings());
			ps.setInt(4, p.getNumberOfMoons());
			
			ps.execute();
			
			//SQL injection "Johnny Drop table students"
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePlanet(Planet p) {
		Connection conn = ConnectionFactory.getConnection();
		
//		System.out.println(p.isRings());
		
		String sql = "UPDATE planets set planet_name = ?, planet_description = ?, has_rings = ?, number_of_moons = ?"
				+ "where planet_name = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setBoolean(3, p.isRings());
			ps.setInt(4, p.getNumberOfMoons());
			ps.setString(5, p.getName());
			
			ps.execute();
			
			//SQL injection "Johnny Drop table students"
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Planet> selectAllPlanets() {
		
		List<Planet> planets = new ArrayList<>();
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = " SELECT * FROM planets";
		
		try {
			Statement s = conn.createStatement(); //Allows us to send SQL statements
			ResultSet rs = s.executeQuery(sql); //We are executing our SQL statement
			
			while(rs.next()) {
				planets.add(new Planet(
				rs.getInt("planet_id"),
				rs.getString("planet_name"),
				rs.getString(3),
				rs.getBoolean(4),
				rs.getInt("number_of_moons")
						));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return planets;
	}

	@Override
	public Planet selectPlanetByName(String name) {
		
		Connection conn = ConnectionFactory.getConnection();
		
		Planet planet = null;
		String sql = "SELECT * FROM planets where planet_name = '" + name + "'";
		
		try {
			Statement s = conn.createStatement(); //Allows us to send SQL statements
			ResultSet rs = s.executeQuery(sql); //We are executing our SQL statement
			
			if (rs.next()) {
				planet = new Planet(
				rs.getInt("planet_id"),
				rs.getString("planet_name"),
				rs.getString(3),
				rs.getBoolean(4),
				rs.getInt("number_of_moons")
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return planet;
	}

	@Override
	public String deletePlanet(String name) {
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "DELETE FROM planets where planet_name = '" + name + "'";
		
		try {
			Statement s = conn.createStatement(); //Allows us to send SQL statements
			s.executeUpdate(sql); //We are executing our SQL statement
			
//			while(rs.next()) {
//				planets.add(new Planet(
//				rs.getInt("planet_id"),
//				rs.getString("planet_name"),
//				rs.getString(3),
//				rs.getBoolean(4),
//				rs.getInt("number_of_moons")
//						));
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Planet " + name + " is deleted.";
		
	}

	@Override
	public Planet selectPlanetById(int id) {
		
		Connection conn = ConnectionFactory.getConnection();
		
		Planet planet = null;
		String sql = "SELECT * FROM planets where planet_id = '" + id + "'";
		
		try {
			Statement s = conn.createStatement(); //Allows us to send SQL statements
			ResultSet rs = s.executeQuery(sql); //We are executing our SQL statement
			
			if (rs.next()) {
				planet = new Planet(
				rs.getInt("planet_id"),
				rs.getString("planet_name"),
				rs.getString(3),
				rs.getBoolean(4),
				rs.getInt("number_of_moons")
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return planet;
	}

	@Override
	public Planet updatePlanet(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
