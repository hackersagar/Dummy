package com.cg.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cg.bean.Day;
import com.cg.bean.Game;

public class SportRepImpl implements SportRep {
	Map<String, Day> data = new HashMap<String, Day>();

	@Override
	public Day save(Day day) {
		
		data.put(day.getName(), day);
		return day;
	}

	@Override
	public Day findByDayName(String name) {
		
		if (data.containsKey(name)) {
			return data.get(name);
		} else {
			return null;
		}
	}

	@Override
	public List<Day> findByGameName(String name) {
		

		List<Day> dayList = new ArrayList<Day>();
		for (Day day : data.values()) {
			List<Game> list = day.getGame();
			for (Game game : list) {
				if(game.getName().equals(name)){
					dayList.add(day);
				}
			}
		}
		return dayList;
	}

}
