package com.ccg.problemaML.service;

import com.ccg.problemaML.entities.ClimaDiario;

public interface IClimaDiarioService {
	public ClimaDiario getByDay(int day);
	public boolean insertClimaDiario(ClimaDiario toInsert);
	public long getLastInsertedDay();
}
