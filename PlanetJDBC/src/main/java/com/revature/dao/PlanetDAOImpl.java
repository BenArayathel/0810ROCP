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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updatePlanet(Planet p) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Planet> selectAllPlanets() {
		List<Planet> planets = new ArrayList<>();
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM planets";
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePlanet(Planet p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Planet selectPlanetByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
