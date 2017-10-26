package swagatasengupta.mavendemo1.abstractdemo;

public class PyramidFigure extends Figure {

	public PyramidFigure(String shape) {
		super(shape);
	}
	
	@Override
	public double calculateArea(double l, double b, double h) {
		return ((l*b)+(l*Math.sqrt((b*b/4)+h*h)) + (b*Math.sqrt((l*l/4)+h*h)));
	}

	@Override
	public double calculateVolume(double l, double b, double h) {
		return (l*b*h)/3;
	}

	public static void main(String[] args) {
		
		PyramidFigure p = new PyramidFigure("Pyramid");
		System.out.println("Area of pyramid = " + p.calculateArea(4, 5, 6));
		System.out.println("Vol of pyramid = " + p.calculateVolume(4, 5, 6));
		

	}

}
