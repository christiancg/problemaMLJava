package com.ccg.problemaML.models;

public class Planet {
	public int angularVelocity;
    public int angle;
    public int distance;
    public boolean clockwise;
    public int getAngularVelocity() {
		return angularVelocity;
	}
	public void setAngularVelocity(int angularVelocity) {
		this.angularVelocity = angularVelocity;
	}
	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public boolean isClockwise() {
		return clockwise;
	}
	public void setClockwise(boolean clockwise) {
		this.clockwise = clockwise;
	}
    protected Planet(int vel, int dis, boolean dir)
    {
        angularVelocity = vel;
        distance = dis;
        clockwise = dir;
        angle = dir ?  0 : 360; 
    }
    public void Orbit()
    {
        if (clockwise)
        {
            if (angle + angularVelocity > 360)
                angle = angularVelocity;
            else
                angle += angularVelocity;
        }
        else
        {
            if (angle - angularVelocity < 0)
                angle = 360 - angularVelocity;
            else
                angle -= angularVelocity;
        }
    }
    public void OrbitDays(int days)
    {
        for (int i = 0; i < days; i++)
        {
            Orbit();
        }
    }
    public void ResetPosition()
    {
        angle = clockwise ? 0 : 360;
    }
}
