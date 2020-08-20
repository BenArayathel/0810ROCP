package com.revature;

import com.revature.dao.PlanetDAO;
import com.revature.dao.PlanetDAOImpl;
import com.revature.model.Planet;

public class Driver {

	public static void main(String[] args) {
		PlanetDAO pDao = new PlanetDAOImpl();
		
		System.out.println(pDao.selectAllPlanets());
		
//		pDao.insertPlanet(new Planet(0, "Test", "Test",false, 100));

	}

}
