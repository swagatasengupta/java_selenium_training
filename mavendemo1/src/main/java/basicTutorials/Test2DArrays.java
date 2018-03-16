package basicTutorials;

public class Test2DArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String arr[][] = {{"A","B","C"},{"D","F"},{"G","H","I"},{"J","K","L"}};
		System.out.println(arr.length);
		System.out.println(arr[1].length);
		int itemCount =0;
		for (int i=0; i<arr.length;i++) {
			for (int j=0; j<arr[i].length;j++) {
				System.out.println(arr[i][j]);
				itemCount++;
			}
		}
		System.out.println(itemCount);
		
	//String arr2[][];
	}
}
