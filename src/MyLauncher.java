import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class MyLauncher {

	public static void main(String[] args) {
		TreasureDash myProgram = new TreasureDash();
        new LwjglApplication( myProgram );
	}

}
