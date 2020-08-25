package com.dao;

import java.util.List;

import com.model.Planet;

public interface PlanetDAO {
//	Create
	public void insertPlanet(Planet p);
	
//	Update
	public void updatePlanet(Planet p);
	
//	Read
	public List<Planet> selectAllPlanets();
	
	public Planet selectPlanetByName(String name);
	
//	Delete
	public void deletePlanet(int id);
}
