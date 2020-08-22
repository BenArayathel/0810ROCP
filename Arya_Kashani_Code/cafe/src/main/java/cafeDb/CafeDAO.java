
package cafeDb;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cafe.Items;
import cafe.Order;

public interface CafeDAO {
	
	//CREATE
	public void insertItem(Items i);
	
	//UPDATE
	public void updateItems(Items i, int id, String d);
	
	//READ
	public Set<Items> selectAllItems();
	
	public Items selectItemByName(String name);
	
	public Items selectItemById(int id);
	
	//DELETE
	public void deleteItem(int id);
	
	
	
	//create
	public void insertOrder(Order o);
	
	//read
	public List<Order> selectAllOrders(CafeDAO cafe);

	public float whatsTotal(Map<Items, Integer> order);
	
	//update
	
	
	//delete
	
}
