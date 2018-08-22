package com.ccg.problemaML.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ccg.problemaML.entities.ClimaDiario;
import com.ccg.problemaML.models.*;
import com.ccg.problemaML.service.IClimaCalculatorService;
import com.ccg.problemaML.service.IClimaDiarioService;
import com.ccg.problemaML.views.*;

@RestController
public class ClimaController {

	@Autowired
	private IClimaDiarioService climaDiario;

	@Autowired
	private IClimaCalculatorService climaCalcultator;

	private Planet vulcano = new Vulcano();
	private Planet betasoide = new Betasoide();
	private Planet ferengi = new Ferengi();

	// GET api/clima
	@GetMapping("clima")
	public ClimaResponse getClima(@RequestParam("dia") int day) {
		Clima auxClima = climaCalcultator.calculateClimate(ferengi, betasoide, vulcano, day);
		return new ClimaResponse(day, auxClima.getWeather());
	}

	// GET api/clima
	@GetMapping("climaFromDb")
	public ClimaResponse getClimaFromDb(@RequestParam("dia") int day) {
		ClimaDiario auxClima = climaDiario.getByDay(day);
		return new ClimaResponse(auxClima.getDia(), auxClima.getClima());
	}

	// GET api/clima/extended
	@GetMapping("clima/extended")
	public ExtendedClimaResponse getClimaExtended(@RequestParam("dia") int days) {
		Clima auxClima = climaCalcultator.calculateClimate(ferengi, betasoide, vulcano, days);
		Point posFerengi = new Point(ferengi.getDistance(), ferengi.getAngle());
		Point posBetasoide = new Point(betasoide.getDistance(), betasoide.getAngle());
		Point posVulcano = new Point(vulcano.getDistance(), vulcano.getAngle());
		return new ExtendedClimaResponse(auxClima, ferengi, posFerengi, vulcano, posVulcano, betasoide, posBetasoide);
	}

	// GET api/clima/simulacionDiezAnios
	@GetMapping("clima/simulacionDiezAnios")
	public TenYearSimulationResponse getSimulacionDiezAnios() {
		int days = 3650;
		List<Clima> auxL = new ArrayList<Clima>();
		for (int i = 0; i < days; i++) {
			auxL.add(climaCalcultator.calculateClimate(ferengi, betasoide, vulcano, i));
		}
		long sequia = auxL.stream().filter(x -> x.getWeather().compareTo("sequia") == 0).count();
		long lluvia = auxL.stream().filter(x -> x.getWeather().compareToIgnoreCase("lluvia") == 0).count();
		long condOptimas = auxL.stream().filter(x -> x.getWeather().compareToIgnoreCase("optimo") == 0).count();
		String auxS = "";
		int cantPerSequia = 0, cantPerLLuvia = 0, cantPerCondOptimas = 0, cantPerIndet = 0;
		for (Clima item : auxL) {
			if (auxS != item.getWeather()) {
				if (auxS == "sequia")
					cantPerSequia++;
				else if (auxS == "lluvia")
					cantPerLLuvia++;
				else if (auxS == "optimo")
					cantPerCondOptimas++;
				else if (auxS == "indeterminado")
					cantPerIndet++;
				auxS = item.getWeather();
			}
		}
		long indet = auxL.stream().filter(x -> x.getWeather().compareToIgnoreCase("indeterminado") == 0).count();
		final Comparator<Clima> comp = (c1, c2) -> Double.compare(c1.getRainQty(), c2.getRainQty());
		double mayorLluvia = auxL.stream().max(comp).get().getRainQty();
		Clima diaMayorLluvia = auxL.stream().filter(x -> x.getRainQty() == mayorLluvia).findFirst().get();
		int index = auxL.indexOf(diaMayorLluvia);
		return new TenYearSimulationResponse((int) sequia, (int) cantPerSequia, (int) lluvia, (int) cantPerLLuvia,
				(int) condOptimas, (int) cantPerCondOptimas, (int) indet, (int) cantPerIndet, index);
	}

	// GET api/clima/vulcano
	@GetMapping("clima/vulcano/{dia}")
	public PositionResponse getPositionVulcano(int dia) {
		vulcano.ResetPosition();
		vulcano.OrbitDays(dia);
		return new PositionResponse(vulcano, new Point(vulcano.getDistance(), vulcano.getAngle()));
	}

	// GET api/clima/betasoide
	@GetMapping("clima/betasoide/{dia}")
	public PositionResponse getPositionBetasoide(int dia) {
		betasoide.ResetPosition();
		betasoide.OrbitDays(dia);
		return new PositionResponse(betasoide, new Point(betasoide.getDistance(), betasoide.getAngle()));
	}

	// GET api/clima/ferengi
	@GetMapping("clima/ferengi/{dia}")
	public PositionResponse getPositionFerengi(int dia) {
		ferengi.ResetPosition();
		ferengi.OrbitDays(dia);
		return new PositionResponse(ferengi, new Point(ferengi.getDistance(), ferengi.getAngle()));
	}
}
