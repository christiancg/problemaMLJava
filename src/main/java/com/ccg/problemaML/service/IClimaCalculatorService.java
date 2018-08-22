package com.ccg.problemaML.service;

import com.ccg.problemaML.models.Clima;
import com.ccg.problemaML.models.Planet;

public interface IClimaCalculatorService {
	public Clima calculateClimate(Planet ferengi, Planet betasoide, Planet vulcano, int days);
}
