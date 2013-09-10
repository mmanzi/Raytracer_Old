package Material;

import Light.Light;
import Tracers.Tracer;
import Utility.HitRecord;
import Utility.RGBColor;
/**
 * Material for now all a material must do is shade 
 * @author mmanzi
 *
 */

public abstract class Material {
	
	public float reflectivity;
	
	public float getreflectivity(){return reflectivity;}
	
	public abstract RGBColor shade(HitRecord hit, Light l);
	
	public abstract RGBColor mirrorshade(HitRecord hit, Tracer t);

}
