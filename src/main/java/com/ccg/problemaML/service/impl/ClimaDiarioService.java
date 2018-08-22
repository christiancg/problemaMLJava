package com.ccg.problemaML.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccg.problemaML.dao.ClimaDiarioRepository;
import com.ccg.problemaML.entities.ClimaDiario;
import com.ccg.problemaML.service.IClimaDiarioService;

@Service
public class ClimaDiarioService implements IClimaDiarioService {

	@Autowired
	private ClimaDiarioRepository climaDiarioDao;

	@Override
	public ClimaDiario getByDay(int day) {
		return climaDiarioDao.findByDia(day);
	}

	@Override
	public boolean insertClimaDiario(ClimaDiario toInsert) {
		return climaDiarioDao.save(toInsert) != null ? true : false;
	}

	@Override
	public long getLastInsertedDay() {
		return climaDiarioDao.count();
	}

}
