package Light;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;


import Utility.RGBColor;


public class PointLight extends Light{

	Point3f position;
	RGBColor color;
	
	public PointLight(Point3f position, RGBColor color){
		this.position = position;
		this.color = color;
	}
	
	@Override
	public Vector3f getIncomingRay(Point3f p) {
		Vector3f inc = new Vector3f(p);
		inc.sub(position);
		return inc;
	}
	
	@Override
	public RGBColor getColor() {
		return color;
	}

}
