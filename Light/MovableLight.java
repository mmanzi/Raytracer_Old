package Light;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;


import Utility.RGBColor;

/**
 * It is assumed this light is at the origin (0,0,0) and is white
 * @author Manzi
 *
 */

public class MovableLight extends Light{

	Vector3f location;
	RGBColor color;
	
	public MovableLight(Vector3f p, RGBColor c){
		location = p;
		color = c;	
	}
	
	@Override
	public Vector3f getIncomingRay(Point3f p) {
		Vector3f v = new Vector3f(p);
		v.sub(location);
		return v;
	}
	
	@Override
	public RGBColor getColor() {
		return new RGBColor(color);
	}

	@Override
	public float getAttenuation(float d) {
		return 1.f/(d*d);
	}

}
