package access1;

//import com.revature.dao.PlanetDAO;
//import com.revature.dao.PlanetDAOImpl;

public class ClassB {
	public static void main(String[] args) {
		//PlanetDAO pDao = new PlanetDAOImpl();
		ClassA objectClassA = new ClassA();
		System.out.println(objectClassA.i);
		System.out.println(objectClassA.s);
	}
}
