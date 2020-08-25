package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Planet;
import com.util.ConnectionFactory;

public class PlanetDAOImpl implements PlanetDAO {

	@Override
	public void insertPlanet(Planet p) {
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO planets (planet_name, planet_description, has_rings, number_of_moons) values " + "(?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setBoolean(3, p.isRings());
			ps.setInt(4, p.getNumberOfMoons());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePlanet(Planet p) {
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "UPDATE planets SET planet_name = ?, planet_description = ?, has_rings = ?, number_of_moons = ? where planet_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  p.getName());
			ps.setString(2,  p.getDescription());
			ps.setBoolean(3, p.isRings());
			ps.setInt(4, p.getNumberOfMoons());
			ps.setInt(5, p.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Planet> selectAllPlanets() {
		List<Planet> planets = new ArrayList<>();
		
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM planets";
		
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while (rs.next()) {
				planets.add(new Planet(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getBoolean(4),
					rs.getInt("number_of_moons")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return planets;
	}

	@Override
	public Planet selectPlanetByName(String name) {
		Planet planet = new Planet();
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "SELECT * FROM planets where planet_name = '" + name + "'";
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				planet.setId(rs.getInt(1));
				planet.setName(rs.getString(2));
				planet.setDescription(rs.getString(3));
				planet.setRings(rs.getBoolean(4));
				planet.setNumberOfMoons(rs.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return planet;
	}

	@Override
	public void deletePlanet(int id) {
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "DELETE from planets WHERE planet_id = " + id;
		
		try {
			Statement s = conn.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
