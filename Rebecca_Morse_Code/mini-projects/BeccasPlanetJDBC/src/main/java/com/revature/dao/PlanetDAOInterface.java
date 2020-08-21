package com.revature.dao;

import java.util.List;

import com.revature.model.Planet;

public interface PlanetDAOInterface {

	public void insertPlanet(Planet p);

	public void updatePlanet(Planet p);

	public List<Planet> selectAllPlanets();

	public Planet selectPlanetByName(String name);

	public Planet selectPlanetById(int id);

	public void deletePlanet(Planet p);
}
