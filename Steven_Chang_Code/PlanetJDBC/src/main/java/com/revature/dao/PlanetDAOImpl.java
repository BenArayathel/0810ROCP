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

public class PlanetDAOImpl implements PlanetDAO {

	@Override
	public void insertPlanet(Planet p) {
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "insert into planets (planet_name, planet_description, has_rings, number_of_moons) values"
					+ "(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setBoolean(3, p.isRings());
			ps.setInt(4, p.getNumberOfMoons());
			
			ps.execute();
//			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updatePlanet(Planet p) {
		
		
		String sql = "update planets set planet_name = ?, planet_description = ?, has_rings = ?, number_of_moons = ? where planet_id = " + p.getId();
		
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setBoolean(3, p.isRings());
			ps.setInt(4, p.getNumberOfMoons());
			
			ps.execute();
//			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Planet> selectAllPlanets() {
		List<Planet> planets = new ArrayList<>();
		
		String sql = "SELECT * FROM planets";
		try (Connection conn = ConnectionFactory.getConnection()) {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			conn.close();
			while(rs.next()) {
				planets.add(new Planet(
					rs.getInt(1),
					rs.getString(2),
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
		Planet selected = null;
		
		String sql = "select * from planets where planet_name = " + "(?)";
		
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
//			conn.close();
			rs.next();
			selected = new Planet(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selected;
	}
	
	@Override
	public Planet selectPlanetByID(int id) {
		Planet selected = null;
		
		String sql = "select * from planets where planet_id = " + "(?)";
		
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
//			conn.close();
			
			selected = new Planet(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getInt(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selected;
	}

	@Override
	public void deletePlanet(Planet p) {
		
		String sql = "delete from planets where "
					+ "planet_name = " + p.getName() + " and "
					+ "planet_description = " + p.getDescription() + " and "
					+ "has_rings = " + p.isRings() + " and " 
					+ "number_of_moons = " + p.getNumberOfMoons();
		try (Connection conn = ConnectionFactory.getConnection()) {
			Statement s = conn.createStatement();
			s.execute(sql);
//			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
