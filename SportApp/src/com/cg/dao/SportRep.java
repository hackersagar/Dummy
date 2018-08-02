package com.cg.dao;

import java.util.List;

import com.cg.bean.Day;

public interface SportRep {
	Day save(Day day);
	Day findByDayName(String name);
	List<Day> findByGameName(String name);

}
