package utils;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

public class VectorUtils {
	public static Vector3f doubleVector(Vector3f vec) {
		Vector3f doubleDirection = new Vector3f(vec);
		doubleDirection.scale(2);
		return doubleDirection;
	}

	public static Vector3f createVectorAB(Point3f pointA, Point3f pointB) {
		Vector3f vectorAB = new Vector3f(pointB);
		vectorAB.sub(pointA);
		return vectorAB;
	}
	
	public static Vector3f createCrossVector(Vector3f vectorA, Vector3f vectorB) {
		Vector3f crossVector = new Vector3f();
		crossVector.cross(vectorA, vectorB);
		return crossVector;
	}
	
}
