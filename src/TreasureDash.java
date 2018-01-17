import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.utils.Array;

public class TreasureDash extends Game {
	
	public Stage mainStage; 
	private BaseActor pirate; 
    private BaseActor backgroundImage;
    private BaseActor treasure;
    boolean hitTreasure = false;
    TreasureChests treasureList= new TreasureChests(); 
    
    public void create() 
    {        //creates sprites
    	
        mainStage= new Stage(); 
        //create actors
        pirate = new BaseActor(); 
        pirate.setTexture( new Texture(Gdx.files.internal("assets/pirate.jpg")) ); 
        pirate.setPosition(10, 200); 
        mainStage.addActor( pirate );
        
        treasure=new BaseActor(); 
        treasure.setTexture( new Texture(Gdx.files.internal("assets/gifTreasure.gif")) ); 
        treasure.setPosition(500, 200); 
        mainStage.addActor( treasure );
        
        backgroundImage=new BaseActor(); 
        backgroundImage.setTexture( new Texture(Gdx.files.internal("assets/grass.jpg")) ); 
        backgroundImage.setPosition(0,0); 
        mainStage.addActor( backgroundImage );
        
    }

    public void render()   
    {    
    	 pirate.velocityX = 0;
         pirate.velocityY = 0;
         // detecting key press
         if (Gdx.input.isKeyPressed(Keys.LEFT)) 
             pirate.velocityX -= 100;
         if (Gdx.input.isKeyPressed(Keys.RIGHT))
             pirate.velocityX += 100;
         if (Gdx.input.isKeyPressed(Keys.UP)) 
             pirate.velocityY += 100;
         if (Gdx.input.isKeyPressed(Keys.DOWN)) 
             pirate.velocityY -= 100;
         
         //create rectangle
         Rectangle treasureRectangle = treasure.getBoundingRectangle();
         Rectangle pirateRectangle = pirate.getBoundingRectangle();
         //detect hit
         hitTreasure = treasureRectangle.overlaps(pirateRectangle);
         //remove treasure if pirate is overlapping chest
         if (hitTreasure)
         {
        	 Treasure t= treasureList.getTreasure(0); 
        	 t.treasureCollected(); 
        	 
         }
        
        float dt = Gdx.graphics.getDeltaTime();
        mainStage.act(dt);
         
        Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        mainStage.draw();
    }
}
