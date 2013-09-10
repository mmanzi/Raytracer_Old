package Material;


import Light.Light;
import Tracers.Tracer;
import Utility.HitRecord;
import Utility.RGBColor;

/**
 *  A trivial unicolor material
 */
public  class TrivialMaterial extends Material{

	RGBColor color;
	
	public TrivialMaterial(RGBColor color){
		this.color = color;
		this.reflectivity=0f;
	}
	
	/**
	 * Trivial simply returns the materials color
	 **/
	@Override
	public RGBColor shade(HitRecord hit, Light l) {
		return color;
	}

	@Override
	public RGBColor mirrorshade(HitRecord hit,Tracer t) {
		return new RGBColor(0f,0f,0f);
	}

	@Override
	public RGBColor refractionshade(HitRecord hit, Tracer t) {
		return new RGBColor(0f,0f,0f);
	}


}
