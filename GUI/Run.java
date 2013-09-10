package GUI;

import Utility.*;
import World.*;

public class Run {

	/**
	 * The main class of the raytracer.
	 */

	public static void main(String[] args) {
		
<<<<<<< HEAD
		//World myWorld = new TestScene();
		World myWorld = new TestScene();
=======
		World myWorld = new TestScene();
		//World myWorld = new Scene1();
	//World myWorld = new Scene2();
>>>>>>> 72fbfe2a6730950111df82cefad12b95bb524d2e
		
		RGBColor[][] rendered_image = myWorld.render_scene();
		new GUI(rendered_image);
	}

}
