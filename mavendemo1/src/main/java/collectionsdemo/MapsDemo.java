package collectionsdemo;
import java.util.HashMap;
import java.util.Map;

public class MapsDemo {

	public static void main(String[] args) {
		// Stores in pair, key -> value : Entry
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "BMW");
		map.put(6, "Audi");
		map.put(4, "Honda");
		
		System.out.println("Item with key 4: " + map.get(4));
		
		String value1 = map.get(1);
		System.out.println("Item with key 1: " + value1);
		
		// Keys are unique, value can be duplicated
		map.put(2, "BMW");
		map.put(4, "Merc"); // this will overwrite Honda
		String value2 = map.get(4);
		System.out.println("Item with key 4: " + value2);
		System.out.println("full map \n" + map.toString());
	}
}