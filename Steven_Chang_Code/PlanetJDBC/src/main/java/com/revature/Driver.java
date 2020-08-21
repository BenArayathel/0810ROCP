package com.revature;

import com.revature.dao.PlanetDAO;
import com.revature.dao.PlanetDAOImpl;
import com.revature.model.Planet;
import com.revature.service.PlanetStuff;

public class Driver {

	public static void main(String[] args) {
		PlanetDAO pDao = new PlanetDAOImpl();
		
		pDao.insertPlanet(new Planet(0, "Test Planetew", "new descript2",false, 100));
		System.out.println(pDao.selectAllPlanets());
//		System.out.println(pDao.selectPlanetByName("Earth"));
		
		PlanetStuff pStuff = new PlanetStuff();
		pStuff.celeberatePlanet("Venus");
//		pStuff.conquerPlanet();
	}

}
