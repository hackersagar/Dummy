package com.cg.service;

import java.util.List;

import com.cg.bean.Day;
import com.cg.dao.SportRep;

public class SportServiceImpl implements SportService{
	
	private SportRep repo;
	
	public SportServiceImpl(SportRep repo) {
		
		this.repo = repo;
	}

	@Override
	public Day addDay(Day day) {
		
		return repo.save(day);
	}

	@Override
	public Day findByDay(String name) {
		
		return repo.findByDayName(name);
	}

	@Override
	public List<Day> findByGame(String name) {
		
		return repo.findByGameName(name);
	}

}
