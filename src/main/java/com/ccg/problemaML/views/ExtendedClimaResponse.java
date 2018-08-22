package com.ccg.problemaML.views;

import com.ccg.problemaML.models.Clima;
import com.ccg.problemaML.models.Planet;
import com.ccg.problemaML.models.Point;

public class ExtendedClimaResponse {
    public Clima clima;
    public Planet ferengi;
    public Point posFerengi;
    public Planet vulcano;
    public Point posVulcano;
    public Planet betasoide;
    public Point posBetasoide;
    public Clima getClima() {
		return clima;
	}
	public void setClima(Clima clima) {
		this.clima = clima;
	}
	public Planet getFerengi() {
		return ferengi;
	}
	public void setFerengi(Planet ferengi) {
		this.ferengi = ferengi;
	}
	public Point getPosFerengi() {
		return posFerengi;
	}
	public void setPosFerengi(Point posFerengi) {
		this.posFerengi = posFerengi;
	}
	public Planet getVulcano() {
		return vulcano;
	}
	public void setVulcano(Planet vulcano) {
		this.vulcano = vulcano;
	}
	public Point getPosVulcano() {
		return posVulcano;
	}
	public void setPosVulcano(Point posVulcano) {
		this.posVulcano = posVulcano;
	}
	public Planet getBetasoide() {
		return betasoide;
	}
	public void setBetasoide(Planet betasoide) {
		this.betasoide = betasoide;
	}
	public Point getPosBetasoide() {
		return posBetasoide;
	}
	public void setPosBetasoide(Point posBetasoide) {
		this.posBetasoide = posBetasoide;
	}
	public ExtendedClimaResponse(Clima clima, Planet ferengi, Point posFerengi, Planet vulcano, Point posVulcano, Planet betasoide, Point posBetasoide)
    {
        this.clima = clima;
        this.ferengi = ferengi;
        this.posFerengi = posFerengi;
        this.vulcano = vulcano;
        this.posVulcano = posVulcano;
        this.betasoide = betasoide;
        this.posBetasoide = posBetasoide;
    }
}
