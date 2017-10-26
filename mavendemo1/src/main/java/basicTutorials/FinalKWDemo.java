package basicTutorials;

public class FinalKWDemo {

	private final String str;
	
	FinalKWDemo(String str){
		this.str = str;
	}
	FinalKWDemo(){
		this.str = null;
	}
	
	public String getString(){
		return str;
	}
	
/*	public void setString(String str) {
		this.str = str;
	}
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalKWDemo obj = new FinalKWDemo("Test String");
		System.out.println(obj.getString());
	}

}
