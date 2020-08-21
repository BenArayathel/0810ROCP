package com.revature;

import java.util.List;

import com.revature.dao.PlanetDAOImplementation;
import com.revature.dao.PlanetDAOInterface;
import com.revature.model.Planet;

public class Driver {
	public static void main(String[] args) {
		
		PlanetDAOInterface pDao = new PlanetDAOImplementation();
		
		List<Planet> myListOfPlanet = pDao.selectAllPlanets();
		
//		pDao.insertPlanet(new Planet(0, "Test","Test", false, 100));
		
		System.out.println(myListOfPlanet);
	}

}
