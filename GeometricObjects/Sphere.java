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
		HitRecord hit = new HitRecord();
		float a = ray.direction.dot(ray.direction);

		Vector3f vectorCE = createVectorAB(center, ray.origin);
		Vector3f doubleDirection = doubleVector(ray.direction);
		float b = doubleDirection.dot(vectorCE);

		float c = (float) (vectorCE.dot(vectorCE) - radius * radius);

		float discriminant = b * b - 4 * a * c;

		Float t = null;
		if (discriminant == 0) {
			t = -b / 2 * a;
		} else if (discriminant > 0) {
			float t1 = (-b - (float) Math.sqrt(discriminant)) / 2 * a;
			float t2 = (-b + (float) Math.sqrt(discriminant)) / 2 * a;

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
