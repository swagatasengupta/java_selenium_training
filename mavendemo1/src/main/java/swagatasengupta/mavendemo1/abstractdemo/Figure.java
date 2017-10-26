package swagatasengupta.mavendemo1.abstractdemo;

public abstract class Figure {

	public String shape;
	public double length;
	public double breadth;
	public double height;
	
	public String getShape() {
		return this.shape;
	}
	public Figure(String shape) {
		this.shape = shape;
		this.length = 0;
		this.breadth = 0;
		this.height = 0;
	}
	public void setDimensions(double length, double breadth, double height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	public abstract double calculateArea(double x, double y, double z);
	public abstract double calculateVolume(double x, double y, double z);
	
}
