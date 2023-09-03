package utility;

import java.util.ArrayList;

public class TileBrush{
	private int index;
	private ArrayList<ITile> tiles;
	public TileBrush() {index=-1;
			tiles=new ArrayList<ITile>(); 
			
	}
	public void add(ITile I) {
		if(index==-1) {index=0;}
		ITile addition=new ITile(I);
		tiles.add(addition);
		
	}
	public void delete(int index) {
		tiles.remove(index);
		if(tiles.size()<1) {index=-1;}
	}
	public int size() {
		return tiles.size();
	}
	public void setBrush(int index) {this.index=index;}
	public ITile getTile() {return new ITile(tiles.get(this.index));}
	public ITile getTilePoint() {return tiles.get(index);}
	public int getIndex() {return this.index;}
	
}
