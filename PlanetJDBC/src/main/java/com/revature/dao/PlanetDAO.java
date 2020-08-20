package com.revature.dao;

import java.util.List;

import com.revature.model.Planet;

public interface PlanetDAO {
	
	/*
	 * DAO - Data Access Object
	 * 
	 * Provide CRUD Operations
	 */
	
	//CREATE
	public void insertPlanet(Planet p);
	
	//UPDATE
	public void updatePlanet(Planet p);
	
	//READ
	public List<Planet> selectAllPlanets();
	
	public Planet selectPlanetByName(String name);
	
	public Planet selectPlanetByID(int id);
	
	//DELETE
	public void deletePlanet(Planet p);
}
