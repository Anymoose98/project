package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.demo.db.entity.Robot;
import com.example.demo.db.entity.TeamRobotica;
import com.example.demo.db.entity.Torneo;
import com.example.demo.db.repo.RobotRepo;
import com.example.demo.db.repo.TeamRoboticaRepo;
import com.example.demo.db.repo.TorneoRepo;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(RobotRepo robotRepo, TeamRoboticaRepo teamRoboticaRepo, TorneoRepo torneoRepo) {
		return (args) -> {

			// team robotica west
			TeamRobotica team1 = new TeamRobotica("Titanium Titans", 3, 0, 0);
			TeamRobotica team2 = new TeamRobotica("Cyber Crushers", 3, 0, 0);
			TeamRobotica team3 = new TeamRobotica("Metal Marauders", 3, 0, 0);
			TeamRobotica team4 = new TeamRobotica("Robo Rampagers", 3, 0, 0);

			// team robotica east
			TeamRobotica team5 = new TeamRobotica("Steel Sentinels", 3, 0, 0);
			TeamRobotica team6 = new TeamRobotica("Mecha Maulers", 3, 0, 0);
			TeamRobotica team7 = new TeamRobotica("Iron Invaders", 3, 0, 0);
			TeamRobotica team8 = new TeamRobotica("Galactic Guardians", 3, 0, 0);
			teamRoboticaRepo.saveAll(Arrays.asList(team1, team2, team3, team4, team5, team6, team7, team8));

			// Torneo west
			Torneo torneoWest = new Torneo("Western Robotics Showdown", "01-08-2024", "31-06-2025", "West");
			Torneo torneoEast = new Torneo("Eastern Mech MadneCC", "01-08-2024", "31-06-2025", "East");
			Torneo torneoGlobal = new Torneo("Ultimate Robot Rumble", "01-07-2025", "31-09-2025", "Global");
			torneoRepo.saveAll(Arrays.asList(torneoWest, torneoEast, torneoGlobal));

			// Robot west
			// Team 1 -> Titanium Titans
			Robot robot1 = new Robot("Titanium Thunder", "TT-01", "Titanium, Carbon Fiber", 100.0, 1.80,
					"KickBoxing, Lame su arti", 25.0, 0);
			robot1.setTeamRobotica(team1);
			robot1.setTornei(Arrays.asList(torneoWest));

			Robot robot2 = new Robot("Metallic Mamba", "TT-01", "Steel, Aluminum", 120.0, 1.90,
					"Taekwondo, Sputa Acido", 20.0, 0);
			robot2.setTeamRobotica(team1);
			robot2.setTornei(Arrays.asList(torneoWest));

			Robot robot3 = new Robot("Golden Sentinel", "TT-01", "Gold, Carbon Fiber", 80.0, 1.70,
					"Capoeira, Lanciafiamme su arti inferiori", 40.0, 0);
			robot3.setTeamRobotica(team1);
			robot3.setTornei(Arrays.asList(torneoWest));

			// Team 2 -> Cyber Crushers
			Robot robot4 = new Robot("Cyber Cyclone", "CC-02", "Silver, Titanium", 95.0, 1.85,
					"Karate, Scudi Elettrici", 23.0, 0);
			robot4.setTeamRobotica(team2);
			robot4.setTornei(Arrays.asList(torneoWest));

			Robot robot5 = new Robot("Nano Knight", "CC-02", "Aluminum, Carbon Fiber", 110.0, 1.75,
					"Judo, Cannoni ad Energia", 28.0, 0);
			robot5.setTeamRobotica(team2);
			robot5.setTornei(Arrays.asList(torneoWest));

			Robot robot6 = new Robot("Copper Crusher", "CC-02", "Copper, Composite", 130.0, 1.95, "Boxe, Missili", 22.0,
					0);
			robot6.setTeamRobotica(team2);
			robot6.setTornei(Arrays.asList(torneoWest));

			// Team 3 -> Metal Marauders
			Robot robot7 = new Robot("Quantum Quake", "MM-05", "Platinum, Carbon Fiber", 85.0, 1.78,
					"Kung Fu, Onde d'Urto", 30.0, 0);
			robot7.setTeamRobotica(team3);
			robot7.setTornei(Arrays.asList(torneoWest));

			Robot robot8 = new Robot("Metal Killer", "MM-05", "Titanium, Graphene", 105.0, 1.82, "Aikido, Laser", 26.0,
					0);
			robot8.setTeamRobotica(team3);
			robot8.setTornei(Arrays.asList(torneoWest));

			Robot robot9 = new Robot("Mecha Monster", "MM-05", "Steel, Carbon Fiber", 125.0, 1.88,
					"Muay Thai, Cannoni ad Acqua", 24.0, 0);
			robot9.setTeamRobotica(team3);
			robot9.setTornei(Arrays.asList(torneoWest));

			// Team 4 -> Robo Rampagers
			Robot robot10 = new Robot("Robo Ripper", "RR-08", "Aluminum, Carbon Fiber", 90.0, 1.79,
					"Wing Chun, Lanciafiamme", 35.0, 0);
			robot10.setTeamRobotica(team4);
			robot10.setTornei(Arrays.asList(torneoWest));

			Robot robot11 = new Robot("Steel Samurai", "RR-08", "Steel, Titanium", 115.0, 1.83,
					"Jiu Jitsu, Cannoni a Proiettile", 29.0, 0);
			robot11.setTeamRobotica(team4);
			robot11.setTornei(Arrays.asList(torneoWest));

			Robot robot12 = new Robot("Mecha Menace", "RR-08", "Titanium, Carbon Fiber", 135.0, 1.87,
					"Krav Maga, Lanciafiamme su arti", 21.0, 0);
			robot12.setTeamRobotica(team4);
			robot12.setTornei(Arrays.asList(torneoWest));

			// Robot east
			// Team 5 -> Steel Sentinels
			Robot robot13 = new Robot("Steel Storm", "SS-03", "Steel, Titanium", 100.0, 1.80,
					"KickBoxing, Lame su arti", 25.0, 0);
			robot13.setTeamRobotica(team5);
			robot13.setTornei(Arrays.asList(torneoEast));

			Robot robot14 = new Robot("Ironclad Guardian", "SS-03", "Steel, Aluminum", 120.0, 1.90, "Taekwondo, Acido",
					20.0, 0);
			robot14.setTeamRobotica(team5);
			robot14.setTornei(Arrays.asList(torneoEast));

			Robot robot15 = new Robot("Chromium Charger", "SS-03", "Chrome, Carbon Fiber", 80.0, 1.70,
					"Kung fu, Pugni caricati", 40.0, 0);
			robot15.setTeamRobotica(team5);
			robot15.setTornei(Arrays.asList(torneoEast));

			// Team 6 -> Mecha Maulers
			Robot robot16 = new Robot("Mecha Monster", "MM-07", "Aluminum, Titanium", 95.0, 1.85,
					"Karate, Scudi Elettrici", 23.0, 0);
			robot16.setTeamRobotica(team6);
			robot16.setTornei(Arrays.asList(torneoEast));

			Robot robot17 = new Robot("Titanic Terror", "MM-07", "Aluminum, Carbon Fiber", 110.0, 1.75,
					"Judo, Cannoni ad Energia", 28.0, 0);
			robot17.setTeamRobotica(team6);
			robot17.setTornei(Arrays.asList(torneoEast));

			Robot robot18 = new Robot("Giga Gladiator", "MM-07", "Steel, Composite", 130.0, 1.95, "Boxe, Missili", 22.0,
					0);
			robot18.setTeamRobotica(team6);
			robot18.setTornei(Arrays.asList(torneoEast));

			// Team 7 -> Iron Invaders
			Robot robot19 = new Robot("Ironclad Inferno", "II-09", "Platinum, Carbon Fiber", 85.0, 1.78,
					"Kung Fu, Onde d'Urto", 30.0, 0);
			robot19.setTeamRobotica(team7);
			robot19.setTornei(Arrays.asList(torneoEast));

			Robot robot20 = new Robot("Steel Striker", "II-09", "Steel, Graphene", 105.0, 1.82, "Aikido, Laser", 26.0,
					0);
			robot20.setTeamRobotica(team7);
			robot20.setTornei(Arrays.asList(torneoEast));

			Robot robot21 = new Robot("Metallic Marauder", "II-09", "Composite, Carbon Fiber", 125.0, 1.88,
					"Muay Thai, Cannoni ad Acqua", 24.0, 0);
			robot21.setTeamRobotica(team7);
			robot21.setTornei(Arrays.asList(torneoEast));

			// Team 8 -> Galactic Guardians
			Robot robot22 = new Robot("Cosmic Crusher", "GG-11", "Aluminum, Carbon Fiber", 90.0, 1.79,
					"Wing Chun, Cannone ad Antimateria", 35.0, 0);
			robot22.setTeamRobotica(team8);
			robot22.setTornei(Arrays.asList(torneoEast));

			Robot robot23 = new Robot("Astro Sentinel", "GG-11", "Steel, Titanium", 115.0, 1.83,
					"Jiu Jitsu, Crea Buchi Neri", 29.0, 0);
			robot23.setTeamRobotica(team8);
			robot23.setTornei(Arrays.asList(torneoEast));

			Robot robot24 = new Robot("Nebula Knight", "GG-11", "Titanium, Carbon Fiber", 135.0, 1.87,
					"Krav Maga, Laser Protonico", 21.0, 0);
			robot24.setTeamRobotica(team8);
			robot24.setTornei(Arrays.asList(torneoEast));

			robotRepo.saveAll(Arrays.asList(robot1, robot2, robot3, robot4, robot5, robot6, robot7, robot8, robot9,
					robot10, robot11, robot12, robot13, robot14, robot15, robot16, robot17, robot18, robot19, robot20,
					robot21, robot22, robot23, robot24));

		};

	}
}
