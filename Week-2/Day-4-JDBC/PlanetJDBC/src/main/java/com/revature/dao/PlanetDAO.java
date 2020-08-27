package main.java.com.revature.dao;

import java.util.List;

import main.java.com.revature.model.Planet;

public interface PlanetDAO {
	
	/*
	 * DAO - Data Access Object 
	 * 
	 * Design pattern in Java
	 * 
	 * Introduces a database layer and seperates database interaction
	 * with business logic. 
	 * 
	 * Provide CRUD Operations
	 * 
	 */
	
	//CREATE
	public void insertPlanet(Planet p);
	
	//UPDATE
	public void updatePlanet(Planet p);
	
	//READ
	public List<Planet> selectAllPlanets();
	
	public Planet selectPlanetByName(String name);
	
	public Planet selectPlanetById(int id);
	
	//DELETE
	public void deletePlanet(Planet p);

}
