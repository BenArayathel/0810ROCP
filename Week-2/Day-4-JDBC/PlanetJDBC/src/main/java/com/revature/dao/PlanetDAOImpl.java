package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.revature.model.Planet;
import com.revature.util.ConnectionFactory;

public class PlanetDAOImpl implements PlanetDAO{

	@Override
	public void insertPlanet(Planet p) {
		Connection conn = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO planets (planet_name, planet_description, has_rings, number_of_moons) values "
				+ "(?, ?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, p.getId());
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setBoolean(3, p.isRings());
			ps.setInt(4, p.getNumberOfMoons());
			//System.out.println(ps);
			ps.execute();
			
			//SQL injection "Johnny Drop table students"
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePlanet(Planet p) {
		// TODO Auto-generated method stub
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "UPDATE planets SET planet_name =?, planet_description =?, has_rings =?,"
					+ "number_of_moons = ? WHERE planet_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,p.getName());
			ps.setString(2, p.getDescription());
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
		// TODO Auto-generated method stub
		Connection conn = ConnectionFactory.getConnection();
		//Planet newP = new Planet()
		String sql = "SELECT * FROM planets WHERE planet_name = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3, p.getDescription());
			ps.setBoolean(4, p.isRings());
			ps.setInt(5, p.getNumberOfMoons());

			ps.execute();
			newP=new Planet(ps.getInt(1), ((ResultSet) ps).getString(2), ps.getString(3), ps.getBoolean(4), ps.getInt(5));
			//SQL injection "Johnny Drop table students"
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newP;
	}




	@Override
	public void deletePlanet(Planet p) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public Planet selectPlanetById(int id) {
		// TODO Auto-generated method stub
		return null;
		//delete * from planets where pianet_id = id;
		/*
		Connection conn = ConnectionFactory.getConnection();
		String sql = "SELECT * FROM planets WHERE planet_id = id";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,0);
			ps.setString(2, "");
			ps.setString(3, "");
			ps.setBoolean(4, false);
			ps.setInt(5, 0);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
	}

}
