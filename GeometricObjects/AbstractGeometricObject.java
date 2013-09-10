package GeometricObjects;


import Material.Material;
import Utility.HitRecord;
import Utility.Ray;

/**
 * Abstract class for Objects. Each derived class needs at least an intersection method and an associated material
 * @author manzi
 *
 */
public abstract class AbstractGeometricObject {

	Material mat;
<<<<<<< HEAD
	final protected float tmin = 0.01f;
=======
	final protected float tmin = 0.0001f;
>>>>>>> 72fbfe2a6730950111df82cefad12b95bb524d2e
	
	
	public AbstractGeometricObject(Material mat){
		this.mat = mat;
	}
	
	/**
	 * Intersection Method. Checks if and where a ray intersects with the object
	 * @param ray
	 * @return A HitRecord Object that records relevant information
	 */
	public abstract HitRecord hit(Ray ray);

	
	public Material getMaterial() {
		return mat;
	}

}
