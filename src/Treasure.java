
public class Treasure {
	private int currentXpos; 
	private int currentYpos; 
	private int width; 
	private int height; 
	
	
	Treasure(int x, int y, int w, int h )
	{
		currentXpos=x; 
		currentYpos=y; 
		width=w; 
		height=h; 
				
	}
	public int getCurrentX(){
		return currentXpos;
	}
	
	public int getCurrentY(){
		return currentYpos;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	

}
