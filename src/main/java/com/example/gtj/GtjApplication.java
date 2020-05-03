package com.example.gtj;

import com.example.gtj.clubs.Club;
import com.example.gtj.clubs.ClubRepo;
import com.example.gtj.footballers.Footballer;
import com.example.gtj.footballers.FootballerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
public class GtjApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GtjApplication.class, args);
	}

	@Autowired
	ClubRepo clubRepo;
	@Autowired
	FootballerRepo footballerRepo;


	@Override
	public void run(String... args) throws Exception {
		log.trace("cl runner");

		Footballer f1 = new Footballer();
		f1.setAge(21);
		f1.setFirstName("Angel");
		f1.setLastName("Cresco");
		f1.setHeight(190);
		f1.setMarketValue(200000);

		Footballer f2 = new Footballer();
		f2.setAge(29);
		f2.setFirstName("Christopher");
		f2.setLastName("Demendi");
		f2.setHeight(180);
		f2.setMarketValue(100000);

		Club c1 = new Club();
		c1.setName("FC CRIO");
		c1.setBudget(3000000);
		c1.addFootballer(f1);

		Club c2 = new Club();
		c2.setName("AC Milan");
		c2.setBudget(5000000);

		clubRepo.save(c1);
		clubRepo.save(c2);

		footballerRepo.save(f1);
		footballerRepo.save(f2);



	}
}
