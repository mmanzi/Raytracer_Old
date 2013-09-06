package Camera;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import Tracers.Tracer;
import Utility.RGBColor;

/**
 * The abstract camera class, each derived class needs a render scene method
 * @author manzi
 *
 */
public abstract class Camera {

	public abstract RGBColor[][] renderScene(RGBColor[][] img, Tracer rt);


	
	Point3f eye;	//eye: not used now
	Point3f lookat;	//lookat point: not used now
	Vector3f up;	//up vector: not used now
	int hres, vres; 
	
	Vector3f x, y, z;
	public Camera(Point3f eye, Point3f lookat, Vector3f up, int hres, int vres){
		this.eye = eye;
		this.lookat = lookat;
		this.up = up;
		this.hres = hres;
		this.vres = vres;
		x = new Vector3f();
		y = new Vector3f();
		z = new Vector3f();
		setupCoordSystem();
	}

	
	
	private void setupCoordSystem(){
		//dummy
	}
	
	
	
}
