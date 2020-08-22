package com.revature;

//import java.util.List;

import com.revature.dao.PlanetDAO;
import com.revature.dao.PlanetDAOImpl;
//import com.revature.model.Planet;

public class Driver {

	public static void main(String[] args) {
	
		PlanetDAO pDao = new PlanetDAOImpl();
		
		//List<Planet> myListOfPlanet = pDao.selectAllPlanets();
		
		//System.out.println(myListOfPlanet);
		
		//pDao.insertPlanet(new Planet(0, "Test","Test", false, 100));
		
		//System.out.println(pDao.selectAllPlanets());
		
//		Planet p = pDao.selectPlanetByName("Venus");
//		System.out.println(p);
		
		//Planet p = pDao.selectPlanetById(10);
		
//		Planet p = new Planet(11, "Ziba", "the Dog planet", true, 7);
//		
//		pDao.updatePlanet(p);
//		
		
		//pDao.deletePlanet(p);
		
		System.out.println(pDao.selectAllPlanets());
		
		
	}

}
