package basicTutorials;

import java.util.Arrays;

public class ArraysDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[20];
		a[0]=11;
		a[1]=12;
		int i=0;
		for(i = 0; i<20; i++) {
			a[i] = 2*i;
		}
		System.out.println("The count for i at the end of for loop is: " + i);
		
		int[] b = {16,2,13,40,15,60,7,48,9,10};
		
		for (i=0; i<20; i++) {
			System.out.println("Value of a["+i+"]: "+ a[i]);
		}
		
		Arrays.sort(b);
		for (i=0; i<b.length; i++) {
			System.out.println("Value of b["+i+"]: "+ b[i]);
		}
		
		
		CustomClass01[] CustomClass01Object = new CustomClass01[5];
		for (i=0;i< CustomClass01Object.length; i++) {
			CustomClass01Object[i] = new CustomClass01();
			CustomClass01Object[i].attrib1 = 10+i;
		}
		for (i=0;i< CustomClass01Object.length; i++) {
			System.out.println("CustomClass01Object[" + i + "].attrib1 = " + CustomClass01Object[i].attrib1);
		}
		
		
	}

}

class CustomClass01{
	int attrib1;
	CustomClass01(){
		System.out.println("This is the constructor of CustomClass01");
		attrib1=0;
	}
	
}