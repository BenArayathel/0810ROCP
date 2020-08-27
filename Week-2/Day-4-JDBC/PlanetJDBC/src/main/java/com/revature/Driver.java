package main.java.com.revature;

import java.util.List;

import main.java.com.revature.dao.PlanetDAO;
import main.java.com.revature.dao.PlanetDAOImpl;
import main.java.com.revature.model.Planet;

public class Driver {

	public static void main(String[] args) {
	
		PlanetDAO pDao = new PlanetDAOImpl();
		
		List<Planet> myListOfPlanet = pDao.selectAllPlanets();
		
//		pDao.insertPlanet(new Planet(0, "Test","Test", false, 100));
		
		System.out.println(myListOfPlanet);
	}

}
