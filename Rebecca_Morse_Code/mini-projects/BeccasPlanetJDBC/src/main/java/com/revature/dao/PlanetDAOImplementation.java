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

public class PlanetDAOImplementation implements PlanetDAOInterface{

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
	try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "UPDATE planets SET planet_name = ?, planet_description = ?, has_rings = ?, number_of_moons = ? WHERE planet_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setBoolean(3, p.isRings());
			ps.setInt(4, p.getNumberOfMoons());
			ps.setInt(5, p.getId());
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Planet> selectAllPlanets() {
		
		List<Planet> planets = new ArrayList<>();
		
		Connection conn = ConnectionFactory.getConnection(); //establising a connection
		
		String sql = " SELECT * FROM planets" ; //sql statement 
		
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
List<Planet> planets  = new ArrayList<>(); //I might not have a unique constraint, so be prepared for a set.
		
		try(Connection conn = ConnectionFactory.getConnection()){ //have a guess (best practice)
			String sql = "SELECT * FROM planets WHERE planet_name = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				planets.add(new Planet(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getBoolean(4),
				rs.getInt("number_of_moons")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return planets.get(0); //return the first value of the set
	}

	@Override
	public void deletePlanet(Planet p) {
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "DELETE FROM planets where planet_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Planet selectPlanetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
