package com.ccg.problemaML.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ccg.problemaML.entities.ClimaDiario;
import com.ccg.problemaML.models.Betasoide;
import com.ccg.problemaML.models.Clima;
import com.ccg.problemaML.models.Ferengi;
import com.ccg.problemaML.models.Planet;
import com.ccg.problemaML.models.Vulcano;
import com.ccg.problemaML.service.IClimaCalculatorService;
import com.ccg.problemaML.service.IClimaDiarioService;

@Component
public class ScheduledTasks {

	@Autowired
	private IClimaDiarioService climaDiario;

	@Autowired
	private IClimaCalculatorService climaCalcultator;

	private Planet vulcano = new Vulcano();
	private Planet betasoide = new Betasoide();
	private Planet ferengi = new Ferengi();

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	private final int days = 3650;

	@Scheduled(fixedRate = 10000)
	public void populateDatabase() {
		log.info("executing populateDatabase for ten years at {}", dateFormat.format(new Date()));
		Clima auxClima = null;
		ClimaDiario auxCD = null;
		long lastInserted = climaDiario.getLastInsertedDay();
		if (lastInserted != days) {
			for (int i = 0; i < 3650; i++) {
				auxClima = climaCalcultator.calculateClimate(ferengi, betasoide, vulcano, i);
				auxCD = new ClimaDiario();
				auxCD.setDia(i);
				auxCD.setClima(auxClima.getWeather());
				climaDiario.insertClimaDiario(auxCD);
			}
			log.info("all data inserted at {}", dateFormat.format(new Date()));
		} else
			log.info("already inserted", dateFormat.format(new Date()));

	}

}
