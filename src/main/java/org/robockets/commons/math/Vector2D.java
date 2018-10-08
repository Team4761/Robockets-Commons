package org.robockets.commons.math;

public class Vector2D {
	private double magnitude, angle;
	private double xComponent, yComponent;
	
	public double getMagnitude()  { return magnitude; }
	public double getAngle()      { return angle; }
	public double getXComponent() { return xComponent; }
	public double getYComponent() { return yComponent; }
	
	public void setMagnitude(double magnitude) { this.magnitude = magnitude; update2dComponents(); }
	public void setAngle(double angle)         { this.angle = angle;         update2dComponents(); }
	
	public Vector2D(double magnitude, double angle) {
		this.magnitude = magnitude;
		this.angle = angle;
		update2dComponents();
	}
	
	private void update2dComponents() {
		this.xComponent = magnitude * Math.cos(angle);
		this.yComponent = magnitude * Math.sin(angle);
	}
	
	public static double getMagnitude(double xComponent, double yComponent) {
		return Math.sqrt(Math.pow(xComponent, 2) + Math.pow(yComponent, 2));
	}
	
	public static double getAngle(double xComponent, double yComponent) {
		return Math.atan2(yComponent, xComponent);
	}

	public void setComponents(double xComponent, double yComponent) {
		this.xComponent = xComponent;
		this.yComponent = yComponent;

		magnitude = getMagnitude(xComponent, yComponent);
		angle = getAngle(xComponent, yComponent);
	}

	public Vector2D add(Vector2D vec) {
		double xComponent = this.getXComponent() + vec.getXComponent();
		double yComponent = this.getYComponent() + vec.getYComponent();
		double magnitude = getMagnitude(xComponent, yComponent);
		double angle     = getAngle(xComponent, yComponent);
		return new Vector2D(magnitude, angle);
	}

	public double dotProduct(Vector2D vec) {
		double xProd = this.getXComponent() * vec.getXComponent();
		double yProd = this.getYComponent() * vec.getYComponent();

		return xProd + yProd;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Vector2D) {
			Vector2D vector = (Vector2D) obj;
			return this.getMagnitude() == vector.getMagnitude() && this.getAngle() == vector.getAngle();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("Vector (%g units magnitude, %g radians above the x-axis)", this.magnitude, this.angle);
	}
	
	
}
