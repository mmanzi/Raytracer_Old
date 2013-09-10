package Tracers;

import java.util.Iterator;

import GeometricObjects.AbstractGeometricObject;
import Light.Light;
import Utility.HitRecord;
import Utility.RGBColor;
import Utility.Ray;
import World.World;

public class MultipleObjects extends Tracer{

	public MultipleObjects(World w) {
		super(w);
	}

	/**
	 * This simple tracer iterates over all objects and light sources
	 * @param ray: The ray that is traced
	 * @return The shading color of the closest intersection (if there was any) 
	 */
	public RGBColor trace(Ray ray){
		//tracing
		HitRecord hit = new HitRecord();
		Iterator<AbstractGeometricObject> objItr= world_ptr.getObjectIterator();	
		
		while(objItr.hasNext()){
			HitRecord new_hit = objItr.next().hit(ray);
			if(hit.getHitDist()>new_hit.getHitDist()) 
				hit = new_hit;
		}		
		
		//shading
		if(hit.anyHit()){
			RGBColor color = new RGBColor();
			Iterator<Light> lightItr= world_ptr.getLightIterator();
			while(lightItr.hasNext())
				// intersection mit ray.origin = hit.getHitPos() ray.direction = hit.get
				color.add(hit.shade(lightItr.next()));
			return color;
		}
		else {
			return world_ptr.getBackgroundColor();
		}
	}
}
