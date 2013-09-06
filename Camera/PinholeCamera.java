package Camera;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import Tracers.Tracer;
import Utility.RGBColor;
import Utility.Ray;

/**
 * TO BE IMPLEMENTED!
 */
public class PinholeCamera extends Camera{

	public PinholeCamera(Point3f eye, Point3f lookat, Vector3f up, int hres, int vres) {
		super(eye, lookat, up, hres, vres);
	}

	@Override
	
	
	public RGBColor[][] renderScene(RGBColor[][] img, Tracer rt) {
		Ray ray = new Ray();		
		for(int x=0; x<hres; x++) 
			for(int y=0; y<vres; y++){
				ray = generateRay(x,y);			
				img[x][y] = rt.trace(ray);
			}
		return img;
	}
	
	private Ray generateRay(int x, int y){
		Ray ray = new Ray();
		ray.origin = new Point3f(0.f,0.f,0.f);
		ray.direction = new Vector3f((x+0.5f)/hres - 0.5f, -(y+0.5f)/vres + 0.5f, -1);
		return ray;
	}
}
