package Material;

import javax.vecmath.Vector3f;

import Light.Light;
import Utility.HitRecord;
import Utility.RGBColor;

/**
 *  A trivial unicolor material
 */
public  class DiffuseMaterial extends Material{

	RGBColor color;
	
	public DiffuseMaterial(RGBColor color){
		this.color = color;
	}
	
	/**
	 * Trivial simply returns the materials color
	 **/
	@Override
	public RGBColor shade(HitRecord hit, Light l) {
		RGBColor lc = new RGBColor(l.getColor());
		RGBColor mc = new RGBColor(color);
		Vector3f n = new Vector3f(hit.getNormal());
		Vector3f theta = new Vector3f(l.getIncomingRay(hit.getHitPos()));
		mc.mult(l.getAttenuation(theta.length()));
		theta.normalize();
		n.negate();
		mc.mult(lc);
		mc.mult(Math.abs(n.dot(theta)));
		return mc;
	}


}

