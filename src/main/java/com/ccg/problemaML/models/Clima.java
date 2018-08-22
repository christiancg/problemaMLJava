package com.ccg.problemaML.models;

public class Clima {
    public String weather;
    public double rainQty;
    public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public double getRainQty() {
		return rainQty;
	}
	public void setRainQty(double rainQty) {
		this.rainQty = rainQty;
	}
	public Clima(String weather, double rainQty)
    {
        this.weather = weather;
        this.rainQty = rainQty;
    }
}
