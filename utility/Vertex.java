package utility;


// a class that stores a point and allows change to that point
public class Vertex {
	private int x;
	private int y;
	
	// constructor with initial values
	public Vertex(int x, int y) {
		this.x=x;
		this.y=y;
	}
	// default constructor
	public Vertex() {
		this.x=0;
		this.y=0;
	}
	// copy constructor
	public Vertex(Vertex v) {
		this.x=v.x;
		this.y=v.y;
	}
	
	//sets the values of x and y
	public void setX(int x) {this.x=x;}
	public void setY(int y) {this.y=y;}
	
	//gets the values of x and y
	public int getX() {return x;}
	public int getY() {return y;}


}
