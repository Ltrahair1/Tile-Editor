package utility;

import java.awt.Color;
import java.awt.Graphics;

public class CTile extends ATile{
	private Color color;
	
	//constructor with variables
	public CTile(int x, int y, int w, int h,Color c) {
		super(x, y,  w,  h);
		this.color=c;
	}
	// copy constructor 
	public CTile(CTile c) {
		super(c);
		this.color=c.color;
	}
	
	// copy constructor with different type of tile
	public CTile(ATile c) {
		super(c);
		this.color=Color.BLACK;
	}
	//default constructor
	public CTile() {
		super();
		this.color=Color.BLACK;
	}
	
	//gets and sets color
	public void setColor(Color c) {color=c;}
	public Color getColor() {return color;}
	
	@Override
	public void update() {
		
	}

	//displays the tile
	@Override
	public void display(Graphics g) {
		Color temp=g.getColor();
		g.setColor(color);
		g.fillRect(this.position.getX(), this.position.getY(), this.size.getX(), this.size.getY());	
		g.setColor(temp);
	}
}
