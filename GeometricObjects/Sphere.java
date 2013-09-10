package GeometricObjects;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import Material.Material;
import Utility.HitRecord;
import Utility.Ray;

public class Sphere extends GeometricObject {

	Point3f center;
	float radius;

	public Sphere(Material mat, Point3f center, float radius) {
		super(mat);
		this.center = center;
		this.radius = radius;
	}

	@Override
	public HitRecord hit(Ray ray) {
		
	/*	float t;
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
				}
				return hit;
			}
		}		*/	

		HitRecord hit = new HitRecord();
		float a = ray.direction.dot(ray.direction);

		Vector3f vectorCE = createVectorAB(center, ray.origin);
		Vector3f doubleDirection = doubleVector(ray.direction);
		float b = doubleDirection.dot(vectorCE);

		float c = (float) (vectorCE.dot(vectorCE) - radius * radius);

		float discriminant = b * b - 4 * a * c;

		Float t = null;
		if (discriminant == 0) {
			t = -b / (2 * a);
		} else if (discriminant > 0) {
			float t1 = (-b - (float) Math.sqrt(discriminant)) / (2 * a);
			float t2 = (-b + (float) Math.sqrt(discriminant)) / (2 * a);

			if (t1 > 0 || t2 > 0) {
				float closerT = Math.min(t1, t2);
				if (closerT < 0) {
					closerT = Math.max(t1, t2);
				}
				t = closerT;
			}
		}

		if (t != null && t > tmin) {
			// ray.origin + t*ray.direction
			Point3f hitPoint = new Point3f(ray.direction);
			hitPoint.scale(t);
			hitPoint.add(ray.origin);
			
			// record hit
			Vector3f surfaceNormal = createVectorAB(center, hitPoint);
			surfaceNormal.normalize();
			hit.recordHit(this, ray, surfaceNormal, hitPoint, t);
		}

		return hit;
	}

	private Vector3f doubleVector(Vector3f vec) {
		Vector3f doubleDirection = new Vector3f(vec);
		doubleDirection.scale(2);
		return doubleDirection;
	}

	private Vector3f createVectorAB(Point3f pointA, Point3f pointB) {
		Vector3f vectorAB = new Vector3f(pointB);
		vectorAB.sub(pointA);
		return vectorAB;
	}

}
