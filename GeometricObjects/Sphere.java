package GeometricObjects;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import Material.Material;
import Utility.HitRecord;
import Utility.Ray;

public class Sphere extends GeometricObject{

	public Point3f center;
	private float radius;

	public Sphere(Material mat, Point3f center, float radius){
		super(mat);
		this.center = center;
		this.radius = radius;
	}
		
	@Override
	public HitRecord hit(Ray ray) {
		float t;
		Point3f position = new Point3f();
		Vector3f normal = new Vector3f(); 
		Vector3f temp= new Vector3f(ray.origin); 
		HitRecord hit = new HitRecord();
		temp.sub(center);
		
		float a = ray.direction.dot(ray.direction);
		float b = 2.f * temp.dot(ray.direction);
		float c = temp.dot(temp) - radius*radius;
		float disc = b*b - 4.f*a*c;

		if(disc<0.f)
			return hit;
		else{
			float e = (float)Math.sqrt(disc);
			float denom = 2.f*a;
			
			//compute smaller root
			t = (-b-e) / denom;			
			if(t>tmin){
				//compute normal
				normal.set(ray.direction);
				normal.scale(t);
				normal.add(temp);
				normal.scale(1.f/radius);
				normal.normalize();
				//compute position
				position.set(ray.direction);
				position.scale(t);
				position.add(ray.origin);
				//store HitRecord
				hit.recordHit(this, ray, normal, position, t);
				return hit;
			}
			//compute bigger root
			else{
				t = (-b+e) / denom;
				//compute normal
				normal.set(ray.direction);
				normal.scale(t);
				normal.add(temp);
				normal.scale(1.f/radius);
				normal.normalize();
				//compute position
				position.set(ray.direction);
				position.scale(t);
				position.add(ray.origin);
				//store HitRecord
				hit.recordHit(this, ray, normal, position, t);
				return hit;
			}			
		}
	}
}
