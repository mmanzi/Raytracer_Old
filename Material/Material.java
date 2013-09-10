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
	
	public float reflectivity,refractionindex=1.0f,refractivity=1.0f;
	
	public abstract RGBColor shade(HitRecord hit, Light l);
	
	public abstract RGBColor mirrorshade(HitRecord hit, Tracer t);
	
	public abstract RGBColor refractionshade(HitRecord hit, Tracer t);

}
