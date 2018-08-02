package com.cg.service;

import java.util.List;

import com.cg.bean.Day;

public interface SportService {
	Day addDay(Day day);
	Day findByDay(String name);
	List<Day> findByGame(String name);
	
}
