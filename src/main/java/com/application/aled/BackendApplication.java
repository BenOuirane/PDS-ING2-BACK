package com.application.aled;

import com.application.aled.entity.Resident;
import com.application.aled.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

/*
 * SpringBootApplication that will be launched
 */
@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

	@Autowired
	public  ResidentRepository residentRepository;

	public static void main(String[] args) { SpringApplication.run(BackendApplication.class, args); }
	@Override
	public void run(String... args) throws Exception {

		
		Random rand = new Random();
		String[] firstName = {"MOUNIER", "VERNET", "TAPIFFO", "DENIS", "DUPONT", "DUMUR", "HALTIER", "MORRY", "DUBOIS", "DELATOUR", "DUCHEMIN", "PIPER", "WALKER", "TONY", "DUCELIER", "DEROSNE", "BERIAT", "DUFOUR", "TUNDER", "WOLF"};
		String[] lastName = {"Celine", "Mathilde", "Carine", "Jean", "Jacques", "Aristote", "Christian", "Jeanne", "Adeline", "Edouard", "Sullin", "Gisele", "Caroline", "Judith", "Pauline", "Noemie", "Manuel", "thibault", "Frederic", "Sarah"};

		for (int i = 0; i < 10; i++) {
			residentRepository.save(new Resident(firstName[rand.nextInt(20)], lastName[rand.nextInt(20)], 60+rand.nextInt(140-60), 1+rand.nextInt(10-1), 1+rand.nextInt(150-1), 1+rand.nextInt(1500-1)));

		}

	}
}



