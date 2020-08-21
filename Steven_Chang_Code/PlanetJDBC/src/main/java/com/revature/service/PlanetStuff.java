package com.revature.service;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.*;
import com.revature.model.Planet;

public class PlanetStuff {
	
	public void destroyAllPlanets() {
		PlanetDAO pDao = new PlanetDAOImpl();
		List<Planet> planets = pDao.selectAllPlanets();
		for (Planet current:planets) {
			System.out.println("Deleting " + current.getName());
			pDao.deletePlanet(current);
		}
	}
	
	public void celeberatePlanet(String name) {
		PlanetDAO pDao = new PlanetDAOImpl();
		System.out.println("Hooray! " + pDao.selectPlanetByName(name).getName());
	}
	
	public void conquerPlanet() {
		PlanetDAO pDao = new PlanetDAOImpl();
		Scanner sc = new Scanner(System.in);
		
		Planet conquering = null;
		String name = null;
		do {
			System.out.println("Name of planet to be conquered?");
			
			name = sc.nextLine();
			conquering = pDao.selectPlanetByName(name);
		} while (conquering == null);
		
		conquering.setDescription(conquering.getDescription() + ", now conquered");
		pDao.updatePlanet(conquering);
		
		System.out.println(pDao.selectPlanetByName(name));
		
	}
	
	public void enginnerAPlanet() {
		
	}
}
