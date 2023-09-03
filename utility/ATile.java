package utility;

import java.awt.Graphics;

public abstract class ATile {
	protected Vertex position;
	protected Vertex size;
	
	//creates Atile with initial coordinates
	public ATile(int x, int y, int w, int h) {
		position =new Vertex(x,y);
		size=new Vertex(w,h);
	}
	//default constructor
	public ATile() {
		position=new Vertex(0,0);
		size=new Vertex(0,0);
	}
	
	//copy constructor
	public ATile(ATile a) {
		this.position=new Vertex(a.position);
		this.size=new Vertex(a.size);
	}
	
	// sets specific variables
	public void setX(int x) {position.setX(x);}
	public void setY(int y) {position.setY(y);}
	public void setWidth(int w) {size.setX(w);}
	public void setHeight(int h) {size.setY(h);}
	
	//returns specific variables
	public int getX() {return position.getX();}
	public int getY() {return position.getY();}
	public int getWidth() {return size.getX();}
	public int getHeight() {return size.getY();}
	
	
	// changes the tile in some way depending on the tile type
	public abstract void update();
	
	//displays the tile
	public abstract void display(Graphics g);
	
}
