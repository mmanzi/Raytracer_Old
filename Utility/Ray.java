package Utility;
/**
 * This class represents a ray consisting of a direction and an origin
 * @author manzi
 *
 */
import javax.vecmath.*;

public class Ray {
	public Point3f origin;
	public Vector3f direction;
	
	/**
	 * default constructor
	 */
	public Ray(){
		this.origin = new Point3f(0.f,0.f,0.f);
		this.direction = new Vector3f(0.f,0.f,0.f);
	}
	
	/**
	 * constructor
	 */
	public Ray(Point3f o, Vector3f d){
		this.origin = o;
		this.direction = d;
	}
	
	/**
	 * copy constructor
	 */
	public Ray(Ray charles){
		this.origin = charles.origin;
		this.direction = charles.direction;
	}
	
	
	
}
