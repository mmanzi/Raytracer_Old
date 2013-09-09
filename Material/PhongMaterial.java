package Material;

import javax.vecmath.Vector3f;

import Light.Light;
import Utility.HitRecord;
import Utility.RGBColor;

/**
 *  A trivial unicolor material
 */
public  class PhongMaterial extends Material{

	RGBColor diffusecolor,ambientcolor,specularcolor;
	float shininess;
	
	public PhongMaterial(RGBColor dcolor,RGBColor acolor,RGBColor scolor,float s){
		this.diffusecolor = dcolor;
		this.ambientcolor = acolor;
		this.specularcolor = scolor;
		this.shininess = s;
	}
	
	/**
	 * Trivial simply returns the materials color
	 **/
	@Override
	public RGBColor shade(HitRecord hit, Light l) {
		RGBColor erg=new RGBColor(0,0,0);
		
		RGBColor lc = new RGBColor(l.getColor());
		RGBColor diffusec = new RGBColor(diffusecolor);
		Vector3f n = new Vector3f(hit.getNormal());
		Vector3f theta = new Vector3f(l.getIncomingRay(hit.getHitPos()));
		diffusec.mult(l.getAttenuation(theta.length()));
		theta.normalize();
		n.negate();
		diffusec.mult(lc);
		diffusec.mult(Math.abs(n.dot(theta)));
		erg.add(diffusec);
		
		RGBColor specularc = new RGBColor(specularcolor);
		Vector3f Lightdir = new Vector3f(l.getIncomingRay(hit.getHitPos()));
		Lightdir.negate();
		Vector3f Camdir = new Vector3f(hit.getRay().direction);
		Camdir.negate();
		Vector3f h=new Vector3f(Camdir);
		h.add(Lightdir);
		h.normalize();
		specularc.mult((float)Math.pow(h.dot(n),shininess));
		specularc.mult(lc);
		erg.add(specularc);
		
		erg.add(ambientcolor);
		
		return erg;
	}


}

