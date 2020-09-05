package com.revature;

import java.util.List;

import com.revature.dao.PlanetDAO;
import com.revature.dao.PlanetDAOImpl;
import com.revature.model.Planet;

public class Driver {

	public static void main(String[] args) {
	
		PlanetDAO pDao = new PlanetDAOImpl();
		
		List<Planet> myListOfPlanet = pDao.selectAllPlanets();
		
//		pDao.insertPlanet(new Planet(0, "Test","Test", false, 100));
		
		System.out.println(myListOfPlanet);
	}

}
