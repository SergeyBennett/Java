import java.awt.Color;
import java.util.Random;

import ua.princeton.lib.StdDraw;

public class Ball{
	private double rx, ry; // position
	private double vx, vy; // velocity
	private final double radius; // radius
	private final double minVelocity = 0.001;
	private final double maxVelocity = 0.05;
	private final Color ballColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
	public Ball(){ 
		this.radius=Math.random()*0.1+0.01;
		this.rx= Math.random()*(1-radius*2)+radius;
		this.ry= Math.random()*(1-radius*2)+radius;
		this.vx = Math.random()*(maxVelocity-minVelocity)+minVelocity;
		this.vy = Math.random()*(maxVelocity-minVelocity)+minVelocity;
	}
	public void move(double dt){
		if ((rx + vx*dt < radius) || (rx + vx*dt > 1.0 - radius)) {vx = -vx;}
		if ((ry + vy*dt < radius) || (ry + vy*dt > 1.0 - radius)) { vy = -vy; }
		rx = rx + vx*dt;
		ry = ry + vy*dt;
	}
	public void draw(){ 
		StdDraw.setPenColor(ballColor);
		StdDraw.filledCircle(rx, ry, radius); 
	}
}
