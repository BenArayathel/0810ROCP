package com;

import java.util.List;

import com.dao.PlanetDAO;
import com.dao.PlanetDAOImpl;
import com.model.Planet;

public class Driver {

	public static void main(String[] args) {
		PlanetDAO pDao = new PlanetDAOImpl();
		pDao.insertPlanet(new Planet(0, "Planet X", "unknown planet", false, 0));
		System.out.println(pDao.selectAllPlanets());
		List<Planet> planets = pDao.selectAllPlanets();
		Planet updatedPlanet = planets.get(9);
		updatedPlanet.setDescription("updated description");
		pDao.updatePlanet(updatedPlanet);
		System.out.println(planets);
//		System.out.println(pDao.selectPlanetByName("Jupiter"));
		Planet planetX = pDao.selectPlanetByName("Planet X");
		pDao.deletePlanet(planetX.getId());
		System.out.println(pDao.selectAllPlanets());
	}

}
