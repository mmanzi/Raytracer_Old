package Material;

import Light.Light;
import Utility.HitRecord;
import Utility.RGBColor;
/**
 * Material for now all a material must do is shade 
 * @author mmanzi
 *
 */

public abstract class Material {

	public abstract RGBColor shade(HitRecord hit, Light l); 
}
