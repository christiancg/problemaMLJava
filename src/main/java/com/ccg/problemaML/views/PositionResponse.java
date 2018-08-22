package com.ccg.problemaML.views;

import com.ccg.problemaML.models.Planet;

public class PositionResponse {
    public Planet planet;
    public Point positionFromSun;
    public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public Point getPositionFromSun() {
		return positionFromSun;
	}
	public void setPositionFromSun(Point positionFromSun) {
		this.positionFromSun = positionFromSun;
	}
	public PositionResponse(Planet planet, Point position)
    {
        this.planet = planet;
        this.positionFromSun = position;
    }
}
