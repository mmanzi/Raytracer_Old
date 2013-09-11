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
public class Scene2 extends World{

	
	protected void build(Tracer t){
		
		//define image resolution
		hres = 1000;
		vres = 1000;
		
		//define camera
		camera = new PinholeCamera(new Point3f(0.f, 5.f, 20.f), 		// eye
										new Point3f(0.f, 0.f, 0.f),  // look-at
										new Vector3f(0.f, 1.f,0.f),	//up
										hres,						//horizontal resolution
										vres,						//vertical resolution
										Math.PI / 4); 						
		
		//define background color
		background_color = new RGBColor(0.5f,0.5f,0.1f);
		
		//define used ray tracer
		
		//Add objects

//		Material redMat = new PhongMaterial(new RGBColor(1f, 0.f, 0f));
//		Material redMat = new PhongMaterial(new RGBColor(1f, 0.f, 0f), new RGBColor(0.0f, 0.01f, 0.0f), new RGBColor(0f, 1f, 0.5f), 300.f);
		Material redMat = new RefractingPhongMaterial(new RGBColor(1f, 1.f, 1f), new RGBColor(0.0f, 0.f, 0.0f), new RGBColor(0f, 0f, 0f), 300.f,0.0f,t,1.5f);

	//	Material redMat = new DiffuseMaterial(new RGBColor(1.f, 0.5f, 0f));
		
		
		Sphere sphere = new Sphere(redMat, new Point3f(0f, 0f, 0f), 2f);
		objects.add(sphere);
		

		//Material blueMat = new DiffuseMaterial(new RGBColor(0.0f, 0.0f, 1.f));
		Material blueMat = new MirrorPhongMaterial(new RGBColor(1f, 1f, 1f), new RGBColor(0.0f, 0.01f, 0.0f), new RGBColor(0f, 1f, 0.5f), 300.f,0.4f,t);
		Plane bluePlane = new Plane(blueMat, new Point3f(0.f,-2f,0.f), new Vector3f(0.f, 1.f, 0.f));
		objects.add(bluePlane);

		//Add light sources
		Light light = new MovableLight(new Point3f(0f,8f,0f),new RGBColor(1f,1f,1f));
		lights.add(light);
//		Light lightd = new DirectionalLight(new Vector3f(0.f,-1.f,0.f),new RGBColor(0.8f,0.8f,0.8f));
//		lights.add(lightd);
	}
}
