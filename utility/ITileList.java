package utility;
import java.awt.Graphics;
import java.util.ArrayList;

public class ITileList {
ITile[][] grid;
ArrayList<Vertex> dispList;
int tile_w,tile_h;
public ITileList() {
	grid=new ITile[10000][10000];
	dispList=new ArrayList<Vertex>();
	this.tile_h=50;
	this.tile_w=50;
	
}
public ITileList(int x,int y,int tile_w,int tile_h) {
	this.tile_h=tile_h;
	this.tile_w=tile_w;

	grid=new ITile[x][y];
	dispList=new ArrayList<Vertex>();

}

public void add(int x,int y,ITile i) {
	/*if(y>=grid.size()) {
		while(grid.size()<=y) {
			grid.add(new ArrayList<ITile>(xsize));
		}
	}
	if(x>=xsize) {
		for(int m=0;m<grid.size();m++) {
		grid.get(m).ensureCapacity(x);
		}
	}
	*/
	i.setX(x*tile_w);
	i.setY(y*tile_h);
	if(grid[y][x]==null) {
		Vertex v=new Vertex(x,y);
		dispList.add(v);
	}

	grid[y][x]=i;	
	
}
public ITile getTile(int x,int y) {
	return grid[y][x];
}
public void remove(int x,int y) {
	int index=-1;
	Vertex v=new Vertex(x,y);
	for(int i=0;i<dispList.size();i++) {
		if(dispList.get(i).getX()==x&&dispList.get(i).getY()==y) {index=i;}
	}
	if(index>-1) {
		dispList.remove(index);
		grid[y][x]=null;
	}
}
public void setSize(int w,int h) {
	Vertex v;
	for(int i=0;i<dispList.size();i++) {
		v=dispList.get(i);
		ITile is= grid[v.getY()][v.getX()];
		is.setWidth(w);
		is.setHeight(h);
		is.setX(w*v.getX());
		is.setY(h*v.getY());
		grid[v.getY()][v.getX()]=is;
	}
}
public String toString() {
	String ret="";
	for(int i=0;i<dispList.size();i++) {
		Vertex v=dispList.get(i);
		ret+=v.getX()+","+v.getY()+","+grid[v.getY()][v.getX()].getId()+"|";
	}
	return ret;
}
public void display(Graphics g,int camx,int camy) {
	Vertex v;
	for(int i=0;i<dispList.size();i++) {
		v=dispList.get(i);
		grid[v.getY()][v.getX()].display(g,camx*tile_w,camy*tile_h);
	}
}
}
