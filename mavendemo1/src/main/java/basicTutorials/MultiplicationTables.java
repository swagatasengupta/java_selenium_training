package basicTutorials;

public class MultiplicationTables
{
	public static void main(String[] args) 
	{
		int i = 20;
		int j = 20;


		System.out.println("Print even Numbers");
		for(i=1;i<=20;i++) 
			if( i % 2 != 0) 
			{
				System.out.println("Odd numbers between1 to 20 is:" +i);
			}

		System.out.println("Print Odd Numbers");
		for(j=1;j<=20;j++)
			if(j % 2==0)
			{
				System.out.println("Odd numbers between1 to 20 is:" +j);
			}

		System.out.println("Print MultiplicationTables");
		for(int k=5; k <= 12; k++)
		{
			for(int l=1; l <=10; l++)
			{
				int c = k * l;
				System.out.println(k + " * " +l+"  = " + c);

				//System.out.println(k + " * " +l+"  = " + k * l);

			}
		}
	}
}