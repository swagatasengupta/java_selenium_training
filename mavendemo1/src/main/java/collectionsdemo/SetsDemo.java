package collectionsdemo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetsDemo {

	public static void main(String[] args) {
		
		// HashSet - Does not maintain order in which elements are added.
		//It is important to note that HashSet does not guarantee the order of its elements, because
		//the process of hashing doesn’t usually lend itself to the creation of sorted sets.
		Set<String> set = new HashSet<String>();
		
		set.add("BMW");
		set.add("Audi");
		set.add("Honda");
		set.add("Honda"); //HashSet wont add as it already has it. It will not throw any exception though.
		set.add("Datsun");
		
		// System.out.println(set); //this is one more way to print a set directly without any for loop 
		System.out.println("Hash Set ***");
		for (String item: set) {
			System.out.println(item);
		}
		
		// LinkedHashSet - It maintains the order in which the elements are added
		Set<String> lHSet = new LinkedHashSet<String>();
		lHSet.add("BMW");
		lHSet.add("Audi");
		lHSet.add("Honda");
		lHSet.add("Datsun");
		System.out.println("Linked Hash Set ***");
		for (String item: lHSet) {
			System.out.println(item);
		}
		
		// TreeSet - It maintains the natural sorting 1, 2, 3... alphabetical
		//creates a collection that uses a tree for storage. Objects are stored in sorted, ascending order. Access
		// and retrieval times are quite fast, which makes TreeSet an excellent choice when storing large
		// amounts of sorted information that must be found quickly
		Set<String> tSet = new TreeSet<String>();
		tSet.add("BMW");
		tSet.add("Audi");
		tSet.add("Honda");
		tSet.add("Datsun");
		System.out.println("Tree Set ***");
		for (String item: tSet) {
			System.out.println(item);
		}
		
		List<String> list = new ArrayList<String>();
		System.out.println("Array List ***");
		list.add("BMW");
		list.add("Audi");
		list.add("Honda");
		list.add("Honda");
		list.add("Datsun");
		System.out.println(list);
		
	}

}
