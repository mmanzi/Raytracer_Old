package Light;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;


import Utility.RGBColor;

/**
 * It is assumed this light is at the origin (0,0,0) and is white
 * @author Manzi
 *
 */

public class DirectionalLight extends Light{

	Vector3f direction;
	RGBColor color;
	
	public DirectionalLight(Vector3f p, RGBColor c){
		direction = p;
		direction.normalize();
		color = c;	
	}
	
	@Override
	public Vector3f getIncomingRay(Point3f p) {
		
		return direction;
	}
	
	@Override
	public RGBColor getColor() {
		return new RGBColor(color);
	}

	@Override
	public float getAttenuation(float d) {
		return 1.f;
	}

}
