package com.ccg.problemaML.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccg.problemaML.entities.ClimaDiario;

@Repository
public interface ClimaDiarioRepository extends JpaRepository<ClimaDiario, Integer> {
	ClimaDiario findByDia(int day);
}
