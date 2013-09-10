package GeometricObjects;

import java.util.HashMap;
import java.util.Map;

import javax.vecmath.Point3f;

import Material.Material;
import Utility.HitRecord;
import Utility.Ray;

public class Cuboid extends AbstractGeometricObject{

	Point3f origin;
	float length, width, height;
	Map<String, Rectangle> faces = new HashMap<String, Rectangle>();
	
	public Cuboid(Material mat, Point3f origin, float length, float width, float height) {
		super(mat);
		this.origin = origin;
		this.length = length;
		this.width = width;
		this.height = height;
		
		setUpFaces();
	}

	private void setUpFaces() {
		Rectangle  
	}
	
	@Override
	public HitRecord hit(Ray ray) {
		
	}

}
