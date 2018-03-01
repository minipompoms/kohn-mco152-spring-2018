package kohn.physics;

public class Projectile {

	private double velocity;
	private double angle;
	private double time;

	public Projectile(double angle, double velocity) {
		this.velocity = velocity;
		this.angle = angle;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getVelocity() {
		return this.velocity;
	}

	public double getAngle() {
		return this.angle;
	}

	public double getTime() {
		return this.time;
	}

	public double getX() {
		double x = Math.cos(Math.toRadians(angle)) * velocity * time;

		return x;
	}

	public double getY() {
		double y = Math.sin(Math.toRadians(angle)) * velocity * time - (.5 * 9.8 * time * time);
		return y;
	}

}
