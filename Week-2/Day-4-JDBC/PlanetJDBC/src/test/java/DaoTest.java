import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.dao.PlanetDAO;
import com.revature.dao.PlanetDAOImpl;
import com.revature.model.Planet;

public class DaoTest {
	
	public PlanetDAO pdao = new PlanetDAOImpl();
	
	@Test
	public void testSelectByName() {
		
		Planet testPlanet = new Planet(0, "Testing", "Always test", true,0);
		
		pdao.insertPlanet(testPlanet);
		
		Planet databasePlanet = pdao.selectPlanetByName("Testing");
		
		pdao.deletePlanet(databasePlanet);
		
		assertEquals(testPlanet.getName(), databasePlanet.getName());
//		assertEquals(testPlanet.getDescription(), pdao.selectPlanetByName("Testing").getDescription());
		
		
		
	}

}
