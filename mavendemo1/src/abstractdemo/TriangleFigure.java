package abstractdemo;
import java.lang.Math;

public class TriangleFigure extends Figure {

	public TriangleFigure(String shape) {
		super(shape);
	}
	@Override
	public double calculateArea(double x, double y, double z) {

		double perim = (x + y + z)/2;
		return Math.sqrt(perim * (perim - x)* (perim - y)* (perim - z));
	}

	@Override
	public double calculateVolume(double x, double y, double z) {
		return 0;
	}

	public static void main(String[] args) {
		TriangleFigure t = new TriangleFigure("Triangle");
		System.out.println(t.getShape());
		//t.setDimensions(12, 6.4, 7.4);
		System.out.println("Area of triangle: " + t.calculateArea(12, 6.4, 7.4));

	}

}
