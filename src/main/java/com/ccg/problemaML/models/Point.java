package com.ccg.problemaML.models;

public class Point {
    public double x;
    public double y;
    public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public Point(int radius, int angle)
    {
        this.x = Math.round((double)(radius * Math.cos((90 - angle) * (Math.PI / 180))));
        this.y = Math.round((double)(radius * Math.sin((90 - angle) * (Math.PI / 180))));
    }
}
