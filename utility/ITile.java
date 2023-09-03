package utility;

import java.awt.Graphics;
import java.awt.Image;

public class ITile extends ATile{
	public Image image;
	private int id=0;
	private Image dispImage;
	//constructor with variables
	public ITile(int x, int y, int w, int h,Image I) {
		super(x, y,  w,  h);
		image=I;
		dispImage=I.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
	}
	public void setId(int id) {this.id=id;}
	public int getId() {return id;}
	//copy constructor
	public ITile(ITile I) {
		super(I);
		this.image=I.image;
		this.dispImage=I.dispImage;
		this.id=I.id;
	}
	//default constructor
	public ITile() {
		super();
		image=null;
	}
	public Image getImage() {return image;}
	//sets width and image width
	@Override
	public void setWidth(int w) {
		size.setX(w);
		dispImage=image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
	}
	//sets height and image height
	@Override
	public void setHeight(int h) {
		size.setY(h);
		dispImage=image.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
	}
	@Override
	public void update() {
		
	}
	// draws the image
	@Override
	public void display(Graphics g) {
		g.drawImage(dispImage, this.getX(),this.getY(),null);
	}
	public void display(Graphics g,int xoff,int yoff) {
		g.drawImage(dispImage, this.getX()+xoff,this.getY()+yoff,null);

	}
}
