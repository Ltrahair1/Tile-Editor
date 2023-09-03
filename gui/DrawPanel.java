package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import utility.*;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class DrawPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public int tx;
	public int ty;
	public int camx=0,camy=0;
	//current tile position of the mouse
	public Vertex Tpos;
	
	//the previous position of the mouse
	public Vertex pTpos;
	
	//the list of tiles
	public ITileList t;
	
	//the mouse button that is being used
	private int mouseB;
	
	//the index of the tile brush
	
	ITileList getList() {
		return t;
	}	
	//constructor
	public DrawPanel() {
		
		
		//sets the index of the tile brush and the mouse button
		mouseB=-1;
		
		//creates and sets the vertexes that are mouse position
		Tpos=new Vertex(0,0);
		pTpos=new Vertex(0,0);

		Tpos.setX(-1);
		Tpos.setY(-1);
		pTpos.setX(-1);
		pTpos.setY(-1);
		
		//creates a tile list that draws tiles
		t=new ITileList(50,50,50,50);
		

		// makes the draw panel double buffer so it flickers less
		this.setDoubleBuffered(true);
		
		//checks when the mouse is pressed and released
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseB=e.getButton();
				addTile(e);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mouseB=-1;
			}
		});
		
		//checks if a mouse has been moved or dragged
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mouse(e);
				display();
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				mouse(e);
				addTile(e);
				//tx=e.getX();
				//ty=e.getY();
			}
		});

	}
	
	// sets the pen index
	public void setPen(int index) {GVars.brush.setBrush(index);}
	public void moveCam(int x,int y) {
		System.out.println("nom");
	}
	//adds and removes tiles
	public void addTile(MouseEvent e) {
		//creates a tile to be used

		if(GVars.brush.size()>0&& GVars.brush.getIndex()>-1) {

		ITile d=new ITile(GVars.brush.getTile());

		//gets the tile x and y
		tx=(e.getX()/50)+camx;
		ty=(e.getY()/50)+camy;
		
		//adds or deletes tiles
		if(GVars.placeState==1) {
		t.add(tx, ty,d);
		}
		else if(GVars.placeState==2) {
			t.remove(tx, ty);
		}
		//displays the tiles
		display();
		}
		
	}
	
	// displays the tiles
	public void display() {
		Graphics g=getGraphics();
		g.clearRect(pTpos.getX(), pTpos.getY(),50,50);
		t.display(g,camx,camy);
		g.setColor(Color.cyan);
		g.fillRect(this.Tpos.getX(),this.Tpos.getY() , 50, 50);
	}
	
	//the general mouse event
	public void mouse(MouseEvent e) {
		//gets the current position
		int x=this.Tpos.getX();
		int y=this.Tpos.getY();
		
		//sets tpos to the current mouse position
		this.Tpos=TMath.toGrid(e.getX(), e.getY(), 50, 50);
		//checks of the current position and previous one are different and if so,
		//set pTpos to a different place
		if(x!=this.Tpos.getX()||y!=this.Tpos.getY()) {
			pTpos.setX(x);
			pTpos.setY(y);
		}
		//gets the tile x and y
		this.tx=e.getX()/50;
		this.ty=e.getY()/50;
	}

}
