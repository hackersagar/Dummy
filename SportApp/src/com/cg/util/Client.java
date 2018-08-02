package com.cg.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.dao.SportRep;
import com.cg.dao.SportRepImpl;
import com.cg.service.SportService;
import com.cg.service.SportServiceImpl;


public class Client {
	static Scanner sc = new Scanner(System.in);
	SportRep repo = new SportRepImpl();
	SportService service = new SportServiceImpl(repo);

	public static void main(String[] args) {
		Client c = new Client();
		String opt = "";
		while (true) {
			System.out.println("1. Add Day Schedule");
			System.out.println("2. Retrive Games on this Day");
			System.out
					.println("3. Retrive Days on whicn This game will be played");
			System.out.println("4. Exit");
			System.out.println("Enter choice:");
			opt = sc.nextLine();
			switch (opt) {
			case "1":
				c.addData();
				break;
			case "2":
				c.retriveByDay();
				break;
			case "3":
				c.retriveByGame();
				break;
			case "4":
				System.exit(0);
				break;
			}
		}
	}

	private void addData() {

		Day d1 = new Day();
		List<Game> day1 = new ArrayList<Game>();

		Game g11 = new Game();
		g11.setName("Badminton");
		Game g12 = new Game();
		g12.setName("Cricket");
		
		day1.add(g11);
		day1.add(g12);
		

		d1.setName("Day 1");
		d1.setGame(day1);

		System.out.println(service.addDay(d1).getName() + " Details are Added");

		////////////////////////////////////////////////////////////////
		Day d2 = new Day();
		List<Game> day2 = new ArrayList<Game>();

		Game g21 = new Game();
		g21.setName("Carroms");
		Game g22 = new Game();
		g22.setName("Surfing");
		Game g23 = new Game();
		g23.setName("Volley Ball");
		Game g24 = new Game();
		g24.setName("Cricket");
		day2.add(g21);
		day2.add(g22);
		day2.add(g23);
		day2.add(g24);

		d2.setName("Day 2");
		d2.setGame(day2);

		System.out.println(service.addDay(d2).getName() + " Details are Added");

		/////////////////////////////////////////////////////////////////////
		Day d3 = new Day();
		List<Game> day3 = new ArrayList<Game>();

		Game g31 = new Game();
		g31.setName("Kabaddi");
		Game g32 = new Game();
		g32.setName("Volley Ball");
		Game g33 = new Game();
		g33.setName("Cricket");
		Game g34 = new Game();
		g34.setName("Disc Throw");
		day3.add(g31);
		day3.add(g32);
		day3.add(g33);
		day3.add(g34);

		d3.setName("Day 3");
		d3.setGame(day3);

		System.out.println(service.addDay(d3).getName() + " Details are Added");

		//////////////////////////////////////////////////////////////////////
		Day d4 = new Day();
		List<Game> day4 = new ArrayList<Game>();

		Game g41 = new Game();
		g41.setName("Kabaddi");
		Game g42 = new Game();
		g42.setName("Surfing");
		Game g43 = new Game();
		g43.setName("Ice Hockey");
		Game g44 = new Game();
		g44.setName("Chess");
		Game g45 = new Game();
		g45.setName("Rubiks cube Challenge");

		day4.add(g41);
		day4.add(g42);
		day4.add(g43);
		day4.add(g44);
		day4.add(g45);

		d4.setName("Day 4");
		d4.setGame(day4);

		System.out.println(service.addDay(d4).getName() + " Details are Added");

		//////////////////////////////////////////////////////////////////////////
	}

	private void retriveByDay() {

		String dayName = "";
		System.out.println("Enter the Day:");
		dayName = sc.nextLine();
		Day day = service.findByDay(dayName);
		System.out.println(day.getGame());

	}

	private void retriveByGame() {

		String gameName = "";
		System.out.println("Enter Name of the Game:");
		gameName = sc.nextLine();
		List<Day> dayList = service.findByGame(gameName);

		for (Day day : dayList) {
			System.out.println(day.getName());
		}
	}
}
