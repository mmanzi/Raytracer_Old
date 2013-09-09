package World;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import GeometricObjects.*;
import Light.*;
import Material.*;
import Utility.*;
import Camera.*;
import Tracers.*;
/**
 * A simple test scene
 * @author mmanzi
 *
 */
public class TestScene extends World{

	
	protected void build(){
		
		//define image resolution
		hres = 1000;
		vres = 1000;
		
		//define camera
		camera = new TrivialCamera(new Point3f(0.f, 0.f, 0.f), 		// eye
										new Point3f(0.f,0.f,-1.f),  // look-at
										new Vector3f(1.f,0.f,0.f),	//up
										hres,						//horizontal resolution
										vres); 						//vertical resolution
		
		//define background color
		background_color = new RGBColor(0.1f,0.1f,0.1f);
		
		//define used ray tracer
		rt = new MultipleObjects(this);
		
		//Add objects
		Material blueMat = new DiffuseMaterial(new RGBColor(0.0f, 0.0f, 1.f));
		Plane bluePlane = new Plane(blueMat, new Point3f(0.f,-0.5f,0.f), new Vector3f(0.f, 1.f, 0.f));
		objects.add(bluePlane);
		Material redMat = new DiffuseMaterial(new RGBColor(1.0f, 0.0f, 0.f));
		Plane redPlane = new Plane(redMat, new Point3f(0.f,0.5f,0.f), new Vector3f(0.f, 1.f, 0.f));
		objects.add(redPlane);
		//Add light sources
		//Light light = new MovableLight(new Vector3f(0.f,0.f,-2.5f),new RGBColor(0.2f,0.2f,0.8f));
		//lights.add(light);
		Light lightd = new DirectionalLight(new Vector3f(1.f,1.f,-2.5f),new RGBColor(0.5f,0.8f,0.8f));
		lights.add(lightd);
	}
}
