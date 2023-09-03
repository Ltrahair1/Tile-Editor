package utility;
import java.awt.Image;
import java.awt.image.*;
public class TMath {
	//takes an input and spits out a grid aligned output.
	public static Vertex toGrid(int x,int y,int tileX,int tileY) {
		Vertex ret=new Vertex(0,0);
		ret.setX(x-(x%tileX));
		ret.setY(y-(y%tileY));
		return ret;
	}
	public static String imageToString(Image I) {
		BufferedImage i=(BufferedImage)I;
		String ret=i.getWidth()+"//"+i.getHeight()+"(s)";
		for(int j=0;j<i.getWidth();j++) {
			for(int k=0;k<i.getHeight();k++) {
				ret+=Integer.toHexString(i.getRGB(j, k));
			}
		}
		return ret;
	}
}
