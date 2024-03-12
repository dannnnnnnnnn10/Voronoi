package Voronoi2D;

public class Point {

	public int x = 0, y = 0;
	private int label;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() { }
	
	@Override
	public String toString() {

		return "(" + x + ", " + y + ")";
	}

	public double distance(int x, int y) {

		return Math.sqrt(Math.pow(this.x - x, 2.0) + Math.pow(this.y - y, 2.0));
	}

	public void setLabel(int label) {

		this.label = label;
	}
	
	public int getLabel() {

		return label;
	}

	public double distance(Point point) {

		return distance(point.x, point.y);
	}
}
