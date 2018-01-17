import java.util.ArrayList;

public class TreasureChests {
	
	private ArrayList<Treasure> treasureChests;
	
	TreasureChests(){ 
		treasureChests=new ArrayList<Treasure>(); 
	}
	public void addTreasure(Treasure a)
	{
		treasureChests.add(a); 
		
	}
	Treasure getTreasure(int index) 
	{
		return treasureChests.get(index);
	}
	public void treasureCollected(int index)
	{
		treasureChests.remove(index);
	}
	public int enemiesArrayListSize()
	{
		return treasureChests.size();
	}

}
