package com.revature;

import java.util.List;

import com.revature.dao.PlanetDAO;
import com.revature.dao.PlanetDAOImpl;
import com.revature.model.Planet;

public class Driver {

	public static void main(String[] args) {
	
		PlanetDAO pDao = new PlanetDAOImpl();
		Planet earth = new Planet();
		earth.setName("Earth");
		earth.setDescription("home of humans");
		earth.setNumberOfMoons(1);
		earth.setRings(true);
		
//		List<Planet> myListOfPlanets = pDao.selectAllPlanets();
		
//		Planet planetInfo = pDao.selectPlanetByName("Jupiter");
		
//		Planet planetInfo = pDao.selectPlanetById(3);
		
		pDao.updatePlanet(earth);
		
//		pDao.deletePlanet("alt_earth");
				
//		System.out.println(planetInfo);
	}

}
