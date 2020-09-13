package com.revature;

import java.util.List;

import com.revature.dao.PlanetDAO;
import com.revature.dao.PlanetDAOImpl;
import com.revature.model.Planet;

public class Driver {

	public static void main(String[] args) {
	
		PlanetDAO pDao = new PlanetDAOImpl();
		System.out.println(pDao.selectAllPlanets());
		//pDao.updatePlanet(new Planet(45, "test40", "Updates", true, 2));
		//pDao.insertPlanet(new Planet(100,"test40","do40", true, 2));
		//pDao.insertPlanet(new Planet(30,"test30","do not be too close", true, 2));	
		//pDao.insertPlanet(new Planet(26, "test_26", "first test planet", false, 0));
		//List<Planet> myListOfPlanet = pDao.selectAllPlanets();
		
	//	pDao.insertPlanet(new Planet(0, "Test","Test", false, 100));
		
//		System.out.println(myListOfPlanet);
	}

}
